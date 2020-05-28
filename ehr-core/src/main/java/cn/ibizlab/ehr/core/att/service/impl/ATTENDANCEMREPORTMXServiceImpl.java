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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORTMX;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEMREPORTMXSearchContext;
import cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.ATTENDANCEMREPORTMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤月报明细] 服务对象接口实现
 */
@Slf4j
@Service("ATTENDANCEMREPORTMXServiceImpl")
public class ATTENDANCEMREPORTMXServiceImpl extends ServiceImpl<ATTENDANCEMREPORTMXMapper, ATTENDANCEMREPORTMX> implements IATTENDANCEMREPORTMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    public ATTENDANCEMREPORTMX getDraft(ATTENDANCEMREPORTMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(ATTENDANCEMREPORTMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendancemreportmxid",et.getAttendancemreportmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ATTENDANCEMREPORTMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public boolean checkKey(ATTENDANCEMREPORTMX et) {
        return (!ObjectUtils.isEmpty(et.getAttendancemreportmxid()))&&(!Objects.isNull(this.getById(et.getAttendancemreportmxid())));
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORTMX get(String key) {
        ATTENDANCEMREPORTMX et = getById(key);
        if(et==null){
            et=new ATTENDANCEMREPORTMX();
            et.setAttendancemreportmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ATTENDANCEMREPORTMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ATTENDANCEMREPORTMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ATTENDANCEMREPORTMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ATTENDANCEMREPORTMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ATTENDANCEMREPORTMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ATTENDANCEMREPORTMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORTMX export2Excel(ATTENDANCEMREPORTMX et) {
        //自定义代码
        return et;
    }


	@Override
    public List<ATTENDANCEMREPORTMX> selectByAttendancemreportid2(String attendancemreportid) {
        return baseMapper.selectByAttendancemreportid2(attendancemreportid);
    }

    @Override
    public void removeByAttendancemreportid2(String attendancemreportid) {
        this.remove(new QueryWrapper<ATTENDANCEMREPORTMX>().eq("attendancemreportid2",attendancemreportid));
    }

	@Override
    public List<ATTENDANCEMREPORTMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ATTENDANCEMREPORTMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ATTENDANCEMREPORTMX> searchDefault(ATTENDANCEMREPORTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORTMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤月报明细打印
     */
    @Override
    public Page<ATTENDANCEMREPORTMX> searchKQYBMXDY(ATTENDANCEMREPORTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORTMX> pages=baseMapper.searchKQYBMXDY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前员工考勤月报
     */
    @Override
    public Page<ATTENDANCEMREPORTMX> searchCurPerson(ATTENDANCEMREPORTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORTMX> pages=baseMapper.searchCurPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ATTENDANCEMREPORTMX et){
        //实体关系[DER1N_ATTENDANCEMREPORTMX_ATTENDANCEMREPORT_ATTENDANCEMREPORTID2]
        if(!ObjectUtils.isEmpty(et.getAttendancemreportid2())){
            cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORT attendancemreport2=et.getAttendancemreport2();
            if(ObjectUtils.isEmpty(attendancemreport2)){
                cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORT majorEntity=attendancemreportService.get(et.getAttendancemreportid2());
                et.setAttendancemreport2(majorEntity);
                attendancemreport2=majorEntity;
            }
            et.setAttendencesetupid(attendancemreport2.getAttendencesetupid());
        }
        //实体关系[DER1N_ATTENDANCEMREPORTMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setYgbh(pimperson.getYgbh());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setGw(pimperson.getGw());
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
    public List<ATTENDANCEMREPORTMX> getAttendancemreportmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ATTENDANCEMREPORTMX> getAttendancemreportmxByEntities(List<ATTENDANCEMREPORTMX> entities) {
        List ids =new ArrayList();
        for(ATTENDANCEMREPORTMX entity : entities){
            Serializable id=entity.getAttendancemreportmxid();
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


