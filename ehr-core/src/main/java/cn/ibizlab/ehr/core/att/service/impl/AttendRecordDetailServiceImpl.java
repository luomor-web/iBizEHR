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
import cn.ibizlab.ehr.core.att.domain.AttendRecordDetail;
import cn.ibizlab.ehr.core.att.filter.AttendRecordDetailSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttendRecordDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttendRecordDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤记录明细] 服务对象接口实现
 */
@Slf4j
@Service("AttendRecordDetailServiceImpl")
public class AttendRecordDetailServiceImpl extends ServiceImpl<AttendRecordDetailMapper, AttendRecordDetail> implements IAttendRecordDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService attendancerecordService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AttendRecordDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendrecorddetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttendRecordDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public AttendRecordDetail getDraft(AttendRecordDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public AttendRecordDetail get(String key) {
        AttendRecordDetail et = getById(key);
        if(et==null){
            et=new AttendRecordDetail();
            et.setAttendrecorddetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(AttendRecordDetail et) {
        return (!ObjectUtils.isEmpty(et.getAttendrecorddetailid()))&&(!Objects.isNull(this.getById(et.getAttendrecorddetailid())));
    }
    @Override
    @Transactional
    public boolean save(AttendRecordDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttendRecordDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttendRecordDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttendRecordDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(AttendRecordDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendrecorddetailid",et.getAttendrecorddetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendrecorddetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttendRecordDetail> list) {
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
    public List<AttendRecordDetail> selectByAttendancerecordid(String attendancerecordid) {
        return baseMapper.selectByAttendancerecordid(attendancerecordid);
    }

    @Override
    public void removeByAttendancerecordid(String attendancerecordid) {
        this.remove(new QueryWrapper<AttendRecordDetail>().eq("attendancerecordid",attendancerecordid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttendRecordDetail> searchDefault(AttendRecordDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttendRecordDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttendRecordDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttendRecordDetail et){
        //实体关系[DER1N_ATTENDRECORDDETAIL_ATTENDANCERECORD_ATTENDANCERECORDID]
        if(!ObjectUtils.isEmpty(et.getAttendancerecordid())){
            cn.ibizlab.ehr.core.att.domain.AttEndanceRecord attendancerecord=et.getAttendancerecord();
            if(ObjectUtils.isEmpty(attendancerecord)){
                cn.ibizlab.ehr.core.att.domain.AttEndanceRecord majorEntity=attendancerecordService.get(et.getAttendancerecordid());
                et.setAttendancerecord(majorEntity);
                attendancerecord=majorEntity;
            }
            et.setAttendancerecordname(attendancerecord.getAttendancerecordname());
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
    public List<AttendRecordDetail> getAttendrecorddetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttendRecordDetail> getAttendrecorddetailByEntities(List<AttendRecordDetail> entities) {
        List ids =new ArrayList();
        for(AttendRecordDetail entity : entities){
            Serializable id=entity.getAttendrecorddetailid();
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



