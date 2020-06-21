package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmRelation;
import cn.ibizlab.ehr.core.orm.filter.OrmRelationSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmRelationService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmRelationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织管理关系表] 服务对象接口实现
 */
@Slf4j
@Service("OrmRelationServiceImpl")
public class OrmRelationServiceImpl extends ServiceImpl<OrmRelationMapper, OrmRelation> implements IOrmRelationService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(OrmRelation et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmorgrelationid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmRelation> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(OrmRelation et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormrelationid",et.getOrmorgrelationid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmorgrelationid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmRelation> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public OrmRelation get(String key) {
        OrmRelation et = getById(key);
        if(et==null){
            et=new OrmRelation();
            et.setOrmorgrelationid(key);
        }
        else{
        }
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
    public OrmRelation getDraft(OrmRelation et) {
        return et;
    }

    @Override
    public boolean checkKey(OrmRelation et) {
        return (!ObjectUtils.isEmpty(et.getOrmorgrelationid()))&&(!Objects.isNull(this.getById(et.getOrmorgrelationid())));
    }
    @Override
    @Transactional
    public boolean save(OrmRelation et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmRelation et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmRelation> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmRelation> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmRelation> searchDefault(OrmRelationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRelation> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRelation>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmRelation> getOrmrelationByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmRelation> getOrmrelationByEntities(List<OrmRelation> entities) {
        List ids =new ArrayList();
        for(OrmRelation entity : entities){
            Serializable id=entity.getOrmorgrelationid();
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



