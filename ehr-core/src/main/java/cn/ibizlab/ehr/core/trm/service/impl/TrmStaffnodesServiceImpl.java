package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TrmStaffnodes;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffnodesSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmStaffnodesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmStaffnodesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工需求明细] 服务对象接口实现
 */
@Slf4j
@Service("TrmStaffnodesServiceImpl")
public class TrmStaffnodesServiceImpl extends ServiceImpl<TrmStaffnodesMapper, TrmStaffnodes> implements ITrmStaffnodesService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffService trmstaffService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;

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
    public TrmStaffnodes get(String key) {
        TrmStaffnodes et = getById(key);
        if(et==null){
            et=new TrmStaffnodes();
            et.setTrmstaffnodesid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TrmStaffnodes et) {
        return (!ObjectUtils.isEmpty(et.getTrmstaffnodesid()))&&(!Objects.isNull(this.getById(et.getTrmstaffnodesid())));
    }
    @Override
    @Transactional
    public boolean update(TrmStaffnodes et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmstaffnodesid",et.getTrmstaffnodesid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstaffnodesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmStaffnodes> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TrmStaffnodes et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmStaffnodes et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmStaffnodes> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmStaffnodes> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public TrmStaffnodes getDraft(TrmStaffnodes et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmStaffnodes et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstaffnodesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmStaffnodes> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<TrmStaffnodes> selectByTrmstaffid(String trmstaffid) {
        return baseMapper.selectByTrmstaffid(trmstaffid);
    }

    @Override
    public void removeByTrmstaffid(String trmstaffid) {
        this.remove(new QueryWrapper<TrmStaffnodes>().eq("trmstaffid",trmstaffid));
    }

	@Override
    public List<TrmStaffnodes> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmStaffnodes>().eq("trmtrainagencyid",trmtrainagencyid));
    }

	@Override
    public List<TrmStaffnodes> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TrmStaffnodes>().eq("trmtraincourseid",trmtraincourseid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmStaffnodes> searchDefault(TrmStaffnodesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmStaffnodes> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmStaffnodes>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmStaffnodes et){
        //实体关系[DER1N_TRMSTAFFNODES_TRMSTAFF_TRMSTAFFID]
        if(!ObjectUtils.isEmpty(et.getTrmstaffid())){
            cn.ibizlab.ehr.core.trm.domain.TrmStaff trmstaff=et.getTrmstaff();
            if(ObjectUtils.isEmpty(trmstaff)){
                cn.ibizlab.ehr.core.trm.domain.TrmStaff majorEntity=trmstaffService.get(et.getTrmstaffid());
                et.setTrmstaff(majorEntity);
                trmstaff=majorEntity;
            }
            et.setTrmstaffname(trmstaff.getTrmstaffname());
        }
        //实体关系[DER1N_TRMSTAFFNODES_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
        }
        //实体关系[DER1N_TRMSTAFFNODES_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
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
    public List<TrmStaffnodes> getTrmstaffnodesByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmStaffnodes> getTrmstaffnodesByEntities(List<TrmStaffnodes> entities) {
        List ids =new ArrayList();
        for(TrmStaffnodes entity : entities){
            Serializable id=entity.getTrmstaffnodesid();
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



