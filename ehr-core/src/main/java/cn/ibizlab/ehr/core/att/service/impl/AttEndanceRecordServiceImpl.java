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
import cn.ibizlab.ehr.core.att.domain.AttEndanceRecord;
import cn.ibizlab.ehr.core.att.filter.AttEndanceRecordSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEndanceRecordMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤记录] 服务对象接口实现
 */
@Slf4j
@Service("AttEndanceRecordServiceImpl")
public class AttEndanceRecordServiceImpl extends ServiceImpl<AttEndanceRecordMapper, AttEndanceRecord> implements IAttEndanceRecordService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttendRecordDetailService attendrecorddetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceMreportmxService attendancemreportmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmBmkqdzService ormbmkqdzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;

    private int batchSize = 500;

    @Override
    public AttEndanceRecord getDraft(AttEndanceRecord et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(AttEndanceRecord et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancerecordid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEndanceRecord> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(AttEndanceRecord et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendancerecordid",et.getAttendancerecordid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancerecordid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEndanceRecord> list) {
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
    @Transactional
    public boolean save(AttEndanceRecord et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEndanceRecord et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEndanceRecord> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEndanceRecord> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public AttEndanceRecord get(String key) {
        AttEndanceRecord et = getById(key);
        if(et==null){
            et=new AttEndanceRecord();
            et.setAttendancerecordid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public AttEndanceRecord reflushPersonInfo(AttEndanceRecord et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(AttEndanceRecord et) {
        return (!ObjectUtils.isEmpty(et.getAttendancerecordid()))&&(!Objects.isNull(this.getById(et.getAttendancerecordid())));
    }

	@Override
    public List<AttEndanceRecord> selectByAttendancemreportid(String attendancemreportmxid) {
        return baseMapper.selectByAttendancemreportid(attendancemreportmxid);
    }

    @Override
    public void removeByAttendancemreportid(String attendancemreportmxid) {
        this.remove(new QueryWrapper<AttEndanceRecord>().eq("attendancemreportmxid",attendancemreportmxid));
    }

	@Override
    public List<AttEndanceRecord> selectByOrmbmkqdzid(String ormbmkqdzid) {
        return baseMapper.selectByOrmbmkqdzid(ormbmkqdzid);
    }

    @Override
    public void removeByOrmbmkqdzid(String ormbmkqdzid) {
        this.remove(new QueryWrapper<AttEndanceRecord>().eq("ormbmkqdzid",ormbmkqdzid));
    }

	@Override
    public List<AttEndanceRecord> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<AttEndanceRecord>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<AttEndanceRecord> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<AttEndanceRecord>().eq("trmtrainplantermid",trmtrainplantermid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEndanceRecord> searchDefault(AttEndanceRecordSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndanceRecord> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndanceRecord>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttEndanceRecord et){
        //实体关系[DER1N_ATTENDANCERECORD_ATTENDANCEMREPORTMX_ATTENDANCEMREPORTMXID]
        if(!ObjectUtils.isEmpty(et.getAttendancemreportid())){
            cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx attendancemreportmx=et.getAttendancemreportmx();
            if(ObjectUtils.isEmpty(attendancemreportmx)){
                cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx majorEntity=attendancemreportmxService.get(et.getAttendancemreportid());
                et.setAttendancemreportmx(majorEntity);
                attendancemreportmx=majorEntity;
            }
            et.setAttendancemreportmxname(attendancemreportmx.getAttendancemreportname());
        }
        //实体关系[DER1N_ATTENDANCERECORD_ORMBMKQDZ_ORMBMKQDZID]
        if(!ObjectUtils.isEmpty(et.getOrmbmkqdzid())){
            cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz ormbmkqdz=et.getOrmbmkqdz();
            if(ObjectUtils.isEmpty(ormbmkqdz)){
                cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz majorEntity=ormbmkqdzService.get(et.getOrmbmkqdzid());
                et.setOrmbmkqdz(majorEntity);
                ormbmkqdz=majorEntity;
            }
            et.setOrmbmkqdzname(ormbmkqdz.getOrmbmkqdzname());
        }
        //实体关系[DER1N_ATTENDANCERECORD_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setZzdzs(pimperson.getZzdzs());
            et.setZjhm(pimperson.getZjhm());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgname(pimperson.getZzdzs());
        }
        //实体关系[DER1N_ATTENDANCERECORD_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
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
    public List<AttEndanceRecord> getAttendancerecordByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEndanceRecord> getAttendancerecordByEntities(List<AttEndanceRecord> entities) {
        List ids =new ArrayList();
        for(AttEndanceRecord entity : entities){
            Serializable id=entity.getAttendancerecordid();
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



