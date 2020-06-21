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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainActment;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainActmentSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainActmentService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainActmentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训活动评估] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainActmentServiceImpl")
public class TrmTrainActmentServiceImpl extends ServiceImpl<TrmTrainActmentMapper, TrmTrainActment> implements ITrmTrainActmentService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainActapplyService trmtrainactapplyService;

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
    public TrmTrainActment getDraft(TrmTrainActment et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TrmTrainActment et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainactmentid()))&&(!Objects.isNull(this.getById(et.getTrmtrainactmentid())));
    }
    @Override
    @Transactional
    public TrmTrainActment get(String key) {
        TrmTrainActment et = getById(key);
        if(et==null){
            et=new TrmTrainActment();
            et.setTrmtrainactmentid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(TrmTrainActment et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainActment et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainActment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainActment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmTrainActment et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainactmentid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainActment> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmTrainActment et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainactmentid",et.getTrmtrainactmentid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainactmentid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainActment> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<TrmTrainActment> selectByTrmtrainactapplyid(String trmtrainactapplyid) {
        return baseMapper.selectByTrmtrainactapplyid(trmtrainactapplyid);
    }

    @Override
    public void removeByTrmtrainactapplyid(String trmtrainactapplyid) {
        this.remove(new QueryWrapper<TrmTrainActment>().eq("trmtrainactapplyid",trmtrainactapplyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainActment> searchDefault(TrmTrainActmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainActment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainActment>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainActment et){
        //实体关系[DER1N_TRMTRAINACTMENT_TRMTRAINACTAPPLY_TRMTRAINACTAPPLYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainactapplyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply trmtrainactapply=et.getTrmtrainactapply();
            if(ObjectUtils.isEmpty(trmtrainactapply)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply majorEntity=trmtrainactapplyService.get(et.getTrmtrainactapplyid());
                et.setTrmtrainactapply(majorEntity);
                trmtrainactapply=majorEntity;
            }
            et.setTrmtrainactapplyname(trmtrainactapply.getTrmtrainactapplyname());
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
    public List<TrmTrainActment> getTrmtrainactmentByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainActment> getTrmtrainactmentByEntities(List<TrmTrainActment> entities) {
        List ids =new ArrayList();
        for(TrmTrainActment entity : entities){
            Serializable id=entity.getTrmtrainactmentid();
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



