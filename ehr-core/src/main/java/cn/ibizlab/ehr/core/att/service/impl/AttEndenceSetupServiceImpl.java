package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.AttEndenceSetup;
import cn.ibizlab.ehr.core.att.filter.AttEndenceSetupSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEndenceSetupMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤设置] 服务对象接口实现
 */
@Slf4j
@Service("AttEndenceSetupServiceImpl")
public class AttEndenceSetupServiceImpl extends ServiceImpl<AttEndenceSetupMapper, AttEndenceSetup> implements IAttEndenceSetupService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceMreportService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceSettingsService attendancesettingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceOrmorgscetorService attendenceormorgscetorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacHolidayRulesService vacholidayrulesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(AttEndenceSetup et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendencesetupid",et.getAttendencesetupid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencesetupid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEndenceSetup> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(AttEndenceSetup et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEndenceSetup et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEndenceSetup> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEndenceSetup> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public AttEndenceSetup reflushUpdatedate(AttEndenceSetup et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public AttEndenceSetup get(String key) {
        AttEndenceSetup et = getById(key);
        if(et==null){
            et=new AttEndenceSetup();
            et.setAttendencesetupid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public AttEndenceSetup getDraft(AttEndenceSetup et) {
        fillParentData(et);
        return et;
    }

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
    public boolean create(AttEndenceSetup et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencesetupid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEndenceSetup> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(AttEndenceSetup et) {
        return (!ObjectUtils.isEmpty(et.getAttendencesetupid()))&&(!Objects.isNull(this.getById(et.getAttendencesetupid())));
    }

	@Override
    public List<AttEndenceSetup> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<AttEndenceSetup>().eq("ormorgid",orgid));
    }

	@Override
    public List<AttEndenceSetup> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<AttEndenceSetup>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<AttEndenceSetup> selectByVacholidayrulesid(String vacholidayrulesid) {
        return baseMapper.selectByVacholidayrulesid(vacholidayrulesid);
    }

    @Override
    public void removeByVacholidayrulesid(String vacholidayrulesid) {
        this.remove(new QueryWrapper<AttEndenceSetup>().eq("vacholidayrulesid",vacholidayrulesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEndenceSetup> searchDefault(AttEndenceSetupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndenceSetup> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndenceSetup>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下的考勤设置
     */
    @Override
    public Page<AttEndenceSetup> searchCurOrgKQSZ(AttEndenceSetupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndenceSetup> pages=baseMapper.searchCurOrgKQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndenceSetup>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤月报中选考勤表
     */
    @Override
    public Page<AttEndenceSetup> searchKQYBXKQB(AttEndenceSetupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndenceSetup> pages=baseMapper.searchKQYBXKQB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndenceSetup>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤员操作考勤设置
     */
    @Override
    public Page<AttEndenceSetup> searchKQYCZKQSZ(AttEndenceSetupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndenceSetup> pages=baseMapper.searchKQYCZKQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndenceSetup>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttEndenceSetup et){
        //实体关系[DER1N_ATTENDENCESETUP_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setPorgid(ormorg.getPorgid());
            et.setOrmorgname(ormorg.getZzdzs());
        }
        //实体关系[DER1N_ATTENDENCESETUP_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_ATTENDENCESETUP_VACHOLIDAYRULES_VACHOLIDAYRULESID]
        if(!ObjectUtils.isEmpty(et.getVacholidayrulesid())){
            cn.ibizlab.ehr.core.vac.domain.VacHolidayRules vacholidayrules=et.getVacholidayrules();
            if(ObjectUtils.isEmpty(vacholidayrules)){
                cn.ibizlab.ehr.core.vac.domain.VacHolidayRules majorEntity=vacholidayrulesService.get(et.getVacholidayrulesid());
                et.setVacholidayrules(majorEntity);
                vacholidayrules=majorEntity;
            }
            et.setVacholidayrulesname(vacholidayrules.getVacholidayrulesname());
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
    public List<AttEndenceSetup> getAttendencesetupByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEndenceSetup> getAttendencesetupByEntities(List<AttEndenceSetup> entities) {
        List ids =new ArrayList();
        for(AttEndenceSetup entity : entities){
            Serializable id=entity.getAttendencesetupid();
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



