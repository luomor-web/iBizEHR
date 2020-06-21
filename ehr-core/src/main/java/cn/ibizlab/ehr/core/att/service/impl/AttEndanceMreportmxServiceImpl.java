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
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportmxSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEndanceMreportmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEndanceMreportmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤月报明细] 服务对象接口实现
 */
@Slf4j
@Service("AttEndanceMreportmxServiceImpl")
public class AttEndanceMreportmxServiceImpl extends ServiceImpl<AttEndanceMreportmxMapper, AttEndanceMreportmx> implements IAttEndanceMreportmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceMreportService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public AttEndanceMreportmx getDraft(AttEndanceMreportmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(AttEndanceMreportmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendancemreportmxid",et.getAttendancemreportmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEndanceMreportmx> list) {
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
    public boolean checkKey(AttEndanceMreportmx et) {
        return (!ObjectUtils.isEmpty(et.getAttendancemreportmxid()))&&(!Objects.isNull(this.getById(et.getAttendancemreportmxid())));
    }
    @Override
    @Transactional
    public AttEndanceMreportmx get(String key) {
        AttEndanceMreportmx et = getById(key);
        if(et==null){
            et=new AttEndanceMreportmx();
            et.setAttendancemreportmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(AttEndanceMreportmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEndanceMreportmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEndanceMreportmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEndanceMreportmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(AttEndanceMreportmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEndanceMreportmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public AttEndanceMreportmx export2Excel(AttEndanceMreportmx et) {
        //自定义代码
        return et;
    }


	@Override
    public List<AttEndanceMreportmx> selectByAttendancemreportid2(String attendancemreportid) {
        return baseMapper.selectByAttendancemreportid2(attendancemreportid);
    }

    @Override
    public void removeByAttendancemreportid2(String attendancemreportid) {
        this.remove(new QueryWrapper<AttEndanceMreportmx>().eq("attendancemreportid2",attendancemreportid));
    }

	@Override
    public List<AttEndanceMreportmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<AttEndanceMreportmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEndanceMreportmx> searchDefault(AttEndanceMreportmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndanceMreportmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndanceMreportmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤月报明细打印
     */
    @Override
    public Page<AttEndanceMreportmx> searchKQYBMXDY(AttEndanceMreportmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndanceMreportmx> pages=baseMapper.searchKQYBMXDY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndanceMreportmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前员工考勤月报
     */
    @Override
    public Page<AttEndanceMreportmx> searchCurPerson(AttEndanceMreportmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndanceMreportmx> pages=baseMapper.searchCurPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndanceMreportmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttEndanceMreportmx et){
        //实体关系[DER1N_ATTENDANCEMREPORTMX_ATTENDANCEMREPORT_ATTENDANCEMREPORTID2]
        if(!ObjectUtils.isEmpty(et.getAttendancemreportid2())){
            cn.ibizlab.ehr.core.att.domain.AttEndanceMreport attendancemreport2=et.getAttendancemreport2();
            if(ObjectUtils.isEmpty(attendancemreport2)){
                cn.ibizlab.ehr.core.att.domain.AttEndanceMreport majorEntity=attendancemreportService.get(et.getAttendancemreportid2());
                et.setAttendancemreport2(majorEntity);
                attendancemreport2=majorEntity;
            }
            et.setAttendencesetupid(attendancemreport2.getAttendencesetupid());
        }
        //实体关系[DER1N_ATTENDANCEMREPORTMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
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
    public List<AttEndanceMreportmx> getAttendancemreportmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEndanceMreportmx> getAttendancemreportmxByEntities(List<AttEndanceMreportmx> entities) {
        List ids =new ArrayList();
        for(AttEndanceMreportmx entity : entities){
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



