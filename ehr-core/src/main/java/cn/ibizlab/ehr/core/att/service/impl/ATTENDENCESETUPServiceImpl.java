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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCESETUPSearchContext;
import cn.ibizlab.ehr.core.att.service.IATTENDENCESETUPService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.ATTENDENCESETUPMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤设置] 服务对象接口实现
 */
@Slf4j
@Service("ATTENDENCESETUPServiceImpl")
public class ATTENDENCESETUPServiceImpl extends ServiceImpl<ATTENDENCESETUPMapper, ATTENDENCESETUP> implements IATTENDENCESETUPService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCESETTINGSService attendancesettingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCEORMORGSECTORService attendenceormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYRULESService vacholidayrulesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ATTENDENCESETUP et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendencesetupid",et.getAttendencesetupid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencesetupid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ATTENDENCESETUP> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ATTENDENCESETUP et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ATTENDENCESETUP et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ATTENDENCESETUP> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ATTENDENCESETUP reflushUpdatedate(ATTENDENCESETUP et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ATTENDENCESETUP get(String key) {
        ATTENDENCESETUP et = getById(key);
        if(et==null){
            et=new ATTENDENCESETUP();
            et.setAttendencesetupid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ATTENDENCESETUP getDraft(ATTENDENCESETUP et) {
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
    public boolean create(ATTENDENCESETUP et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencesetupid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ATTENDENCESETUP> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ATTENDENCESETUP et) {
        return (!ObjectUtils.isEmpty(et.getAttendencesetupid()))&&(!Objects.isNull(this.getById(et.getAttendencesetupid())));
    }


	@Override
    public List<ATTENDENCESETUP> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ATTENDENCESETUP>().eq("ormorgid",orgid));
    }

	@Override
    public List<ATTENDENCESETUP> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ATTENDENCESETUP>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<ATTENDENCESETUP> selectByVacholidayrulesid(String vacholidayrulesid) {
        return baseMapper.selectByVacholidayrulesid(vacholidayrulesid);
    }

    @Override
    public void removeByVacholidayrulesid(String vacholidayrulesid) {
        this.remove(new QueryWrapper<ATTENDENCESETUP>().eq("vacholidayrulesid",vacholidayrulesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ATTENDENCESETUP> searchDefault(ATTENDENCESETUPSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDENCESETUP> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDENCESETUP>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下的考勤设置
     */
    @Override
    public Page<ATTENDENCESETUP> searchCurOrgKQSZ(ATTENDENCESETUPSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDENCESETUP> pages=baseMapper.searchCurOrgKQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDENCESETUP>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤月报中选考勤表
     */
    @Override
    public Page<ATTENDENCESETUP> searchKQYBXKQB(ATTENDENCESETUPSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDENCESETUP> pages=baseMapper.searchKQYBXKQB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDENCESETUP>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤员操作考勤设置
     */
    @Override
    public Page<ATTENDENCESETUP> searchKQYCZKQSZ(ATTENDENCESETUPSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDENCESETUP> pages=baseMapper.searchKQYCZKQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDENCESETUP>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ATTENDENCESETUP et){
        //实体关系[DER1N_ATTENDENCESETUP_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setPorgid(ormorg.getPorgid());
            et.setOrmorgname(ormorg.getZzdzs());
        }
        //实体关系[DER1N_ATTENDENCESETUP_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_ATTENDENCESETUP_VACHOLIDAYRULES_VACHOLIDAYRULESID]
        if(!ObjectUtils.isEmpty(et.getVacholidayrulesid())){
            cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES vacholidayrules=et.getVacholidayrules();
            if(ObjectUtils.isEmpty(vacholidayrules)){
                cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES majorEntity=vacholidayrulesService.get(et.getVacholidayrulesid());
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

}


