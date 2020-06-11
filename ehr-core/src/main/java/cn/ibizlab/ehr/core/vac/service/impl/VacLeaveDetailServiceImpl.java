package cn.ibizlab.ehr.core.vac.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveDetailSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacLeaveDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假明细] 服务对象接口实现
 */
@Slf4j
@Service("VacLeaveDetailServiceImpl")
public class VacLeaveDetailServiceImpl extends ServiceImpl<VacLeaveDetailMapper, VacLeaveDetail> implements IVacLeaveDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacUseNxjmxService vacusenxjmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.logic.IVacLeaveDetailCalcPlanDaysLogic calcplandaysLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public VacLeaveDetail calcSJQJTS(VacLeaveDetail et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(VacLeaveDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VacLeaveDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavedetailid",et.getVacleavedetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.impl.AttEndenceSetupServiceImpl attEndenceSetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.impl.AttEndanceSettingsServiceImpl attEndenceSettingService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.impl.VacLeaveTipsServiceImpl vacLeaveTipsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.impl.VacLeaceTypeServiceImpl vacLeaceTypeService;
    
    @Override
    @Transactional
    public VacLeaveDetail getNianJia(VacLeaveDetail et) {
    	//获取请假人员id  
    	String pimpersonid = et.getPimpersonid();
//    	if(StringUtils.isEmpty(pimpersonid)) {
//    		throw new Exception("请添加请假人员!");
//    	}
    	PimPerson pimPerson = pimpersonService.get(pimpersonid);
//    	if(pimPerson == null) {
//    		throw new Exception("EHR系统中不存在该请假人员!");
//    	}
    	//温馨提示
    	String tips = null;
    	//获取上年度和本年度和明年
    	Calendar calendar = Calendar.getInstance();
    	int lastyear = calendar.get(Calendar.YEAR) - 1;
    	int curyear = calendar.get(Calendar.YEAR);
    	int nextyear = calendar.get(Calendar.YEAR) + 1;
    	//获取上年度和本年度总天数,假期使用情况
    	Double lastsumSyts = 0d;
    	Double cursumSyts = 0d;
    	String njsy = "";
    	//探亲回显信息
    	if(et.getQjzl().equals("TQ")) {
    		et.setHyzk(pimPerson.getHyzk());
    		if(pimPerson.getHyzk().equals("20")) {
    			et.setTqlx("20");
    		}else {
    			et.setTqlx("10");
    		}
    	}
    	//获取温馨提示(用人员信息标识查考勤人员和考勤设置，将考勤设置标识相同的考勤规则标识提取，去查请假提示)
    	String sql = "SELECT s.* FROM T_VACLEAVETIPS s WHERE s.vacholidayrulesid in("
				+ " SELECT b.vacholidayrulesid FROM T_ATTENDANCESETTINGS a INNER JOIN T_ATTENDENCESETUP b ON a.attendencesetupid=b.attendencesetupid"
				+ " WHERE a.pimpersonid=#{et.pimpersonid})";
    	Map<String, String> param = new HashMap<>();
    	param.put("pimpersonid", pimpersonid);
		List<JSONObject> jsonVacLeaveTipsList = this.select(sql, param);
    	if(jsonVacLeaveTipsList.size() > 0) {
    		for (JSONObject jsonVacLeaveTips : jsonVacLeaveTipsList) {
				VacLeaveTips vacLeaveTips = JSON.toJavaObject(jsonVacLeaveTips, VacLeaveTips.class);
				if(et.getQjzl().equals(vacLeaveTips.getQjzl())) {
					tips = vacLeaveTips.getTips();
				}
			}
    	}
    	//查询请假种类所表示的请假名称
    	String leaveName = vacLeaceTypeService.get(et.getQjzl()).getVacleacetypename();
    	//查询该请假人员当前请假种类上年度和本年度情况(用员工信息标识查询上个年度和本年度的计划天数和)
    	List<VacLeaveDetail> vacLeaveDetailList = this.selectByPimpersonid(pimpersonid);
    	if(vacLeaveDetailList.size() > 0) {
    		for (VacLeaveDetail vacLeaveDetail : vacLeaveDetailList) {
    			if(et.getQjzl().equals(vacLeaveDetail.getQjzl())) {
    				String jhkssj = vacLeaveDetail.getJhkssj().toString().substring(0, 4);
    				if(String.valueOf(lastyear).equals(jhkssj)) {
    					lastsumSyts += vacLeaveDetail.getJhts();
    				}else if(String.valueOf(curyear).equals(jhkssj)) {
    					cursumSyts += vacLeaveDetail.getJhts();
    				}
    			}
    		}
    	}
    	njsy +=  lastyear + "年已请" + leaveName + lastsumSyts + " 天;\n " 
    		   + curyear  + "年已请" + leaveName + cursumSyts  + " 天; ";
    	//如果是年休假，拼接年休假使用情况
    	if(et.getQjzl().equals("NX")) {
    		sql = "select * from T_VACSYNJCX where pimpersonId=#{et.pimpersonId}  and nd in (#{et.curyear},#{et.nextyear}) order by nd ASC";
    		param.put("curyear", String.valueOf(curyear));
    		param.put("nextyear", String.valueOf(nextyear));
    		List<JSONObject> jsonVacSynjcxList = this.select(sql, param);
    		if(jsonVacSynjcxList.size() > 0) {
    			for (JSONObject jsonVacSynjcx : jsonVacSynjcxList) {
    				VacSynjcx vacSynjcx = JSON.toJavaObject(jsonVacSynjcx,VacSynjcx.class);
    				//年度，实休天数，剩余天数，开始有效时间，结束有效时间
    				String nd = vacSynjcx.getNd();
    				String sjbnts = vacSynjcx.getSjbnts().toString();
    				String synjts = vacSynjcx.getSynjts().toString();
    				String ksyxsj = vacSynjcx.getKsyxsj().toString();
    				String jsyxsj = vacSynjcx.getJsyxsj().toString();
    				njsy += nd + "年假:共 " + sjbnts + "天;剩余: " + synjts + "天;有效期: " + ksyxsj + " 至 " + jsyxsj + ";\n";
				}
    		} else {
    			njsy = "暂未查询到您的年假使用情况！！！";
    		}
    	}
    	et.setNjsy(njsy);
    	et.setTips(tips);
    	//计算计划请假天数
    	this.calcJHQJTS(et);
        return et;
    }
    @Override
    @Transactional
    public boolean save(VacLeaveDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacLeaveDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacLeaveDetail calcJHQJTS(VacLeaveDetail et) {
        calcplandaysLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public VacLeaveDetail get(String key) {
        VacLeaveDetail et = getById(key);
        if(et==null){
            et=new VacLeaveDetail();
            et.setVacleavedetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public VacLeaveDetail calcPlanDays(VacLeaveDetail et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(VacLeaveDetail et) {
        return (!ObjectUtils.isEmpty(et.getVacleavedetailid()))&&(!Objects.isNull(this.getById(et.getVacleavedetailid())));
    }

    @Override
    public VacLeaveDetail getDraft(VacLeaveDetail et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VacLeaveDetail> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacLeaveDetail>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacLeaveDetail> searchDefault(VacLeaveDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacLeaveDetail et){
        //实体关系[DER1N_VACLEAVEDETAIL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
        }
    }


    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    public List<VacLeaveDetail> getVacleavedetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacLeaveDetail> getVacleavedetailByEntities(List<VacLeaveDetail> entities) {
        List ids =new ArrayList();
        for(VacLeaveDetail entity : entities){
            Serializable id=entity.getVacleavedetailid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}


