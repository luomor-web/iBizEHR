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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainResment;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainResmentSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainResmentService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainResmentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训资源评估] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainResmentServiceImpl")
public class TrmTrainResmentServiceImpl extends ServiceImpl<TrmTrainResmentMapper, TrmTrainResment> implements ITrmTrainResmentService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(TrmTrainResment et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainresmentid",et.getTrmtrainresmentid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainresmentid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainResment> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public TrmTrainResment getDraft(TrmTrainResment et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(TrmTrainResment et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainResment et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainResment> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainResment> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmTrainResment et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainresmentid()))&&(!Objects.isNull(this.getById(et.getTrmtrainresmentid())));
    }
    @Override
    @Transactional
    public boolean create(TrmTrainResment et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainresmentid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainResment> list) {
        this.saveBatch(list,batchSize);
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
    public TrmTrainResment get(String key) {
        TrmTrainResment et = getById(key);
        if(et==null){
            et=new TrmTrainResment();
            et.setTrmtrainresmentid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainResment> searchDefault(TrmTrainResmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainResment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainResment>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<TrmTrainResment> getTrmtrainresmentByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainResment> getTrmtrainresmentByEntities(List<TrmTrainResment> entities) {
        List ids =new ArrayList();
        for(TrmTrainResment entity : entities){
            Serializable id=entity.getTrmtrainresmentid();
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



