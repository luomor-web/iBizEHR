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
import cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord;
import cn.ibizlab.ehr.core.trm.filter.TrmAgencyRecordSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmAgencyRecordService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmAgencyRecordMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[机构培训记录] 服务对象接口实现
 */
@Slf4j
@Service("TrmAgencyRecordServiceImpl")
public class TrmAgencyRecordServiceImpl extends ServiceImpl<TrmAgencyRecordMapper, TrmAgencyRecord> implements ITrmAgencyRecordService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;

    private int batchSize = 500;

    @Override
    public TrmAgencyRecord getDraft(TrmAgencyRecord et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmAgencyRecord get(String key) {
        TrmAgencyRecord et = getById(key);
        if(et==null){
            et=new TrmAgencyRecord();
            et.setTrmagencyrecordid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TrmAgencyRecord et) {
        return (!ObjectUtils.isEmpty(et.getTrmagencyrecordid()))&&(!Objects.isNull(this.getById(et.getTrmagencyrecordid())));
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
    public boolean save(TrmAgencyRecord et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmAgencyRecord et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmAgencyRecord> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmAgencyRecord> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmAgencyRecord et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmagencyrecordid",et.getTrmagencyrecordid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmagencyrecordid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmAgencyRecord> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmAgencyRecord et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmagencyrecordid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmAgencyRecord> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<TrmAgencyRecord> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmAgencyRecord>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmAgencyRecord> searchDefault(TrmAgencyRecordSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmAgencyRecord> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmAgencyRecord>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmAgencyRecord et){
        //实体关系[DER1N_TRMAGENCYRECORD_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
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
    public List<TrmAgencyRecord> getTrmagencyrecordByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmAgencyRecord> getTrmagencyrecordByEntities(List<TrmAgencyRecord> entities) {
        List ids =new ArrayList();
        for(TrmAgencyRecord entity : entities){
            Serializable id=entity.getTrmagencyrecordid();
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



