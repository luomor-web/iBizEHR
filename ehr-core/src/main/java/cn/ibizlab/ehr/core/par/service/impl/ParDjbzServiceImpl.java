package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.ParDjbz;
import cn.ibizlab.ehr.core.par.filter.ParDjbzSearchContext;
import cn.ibizlab.ehr.core.par.service.IParDjbzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParDjbzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[定级规则] 服务对象接口实现
 */
@Slf4j
@Service("ParDjbzServiceImpl")
public class ParDjbzServiceImpl extends ServiceImpl<ParDjbzMapper, ParDjbz> implements IParDjbzService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ParDjbz et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPardjbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParDjbz> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ParDjbz get(String key) {
        ParDjbz et = getById(key);
        if(et==null){
            et=new ParDjbz();
            et.setPardjbzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ParDjbz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParDjbz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParDjbz> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParDjbz> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ParDjbz getDraft(ParDjbz et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(ParDjbz et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pardjbzid",et.getPardjbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getPardjbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParDjbz> list) {
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
    public boolean checkKey(ParDjbz et) {
        return (!ObjectUtils.isEmpty(et.getPardjbzid()))&&(!Objects.isNull(this.getById(et.getPardjbzid())));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParDjbz> searchDefault(ParDjbzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParDjbz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParDjbz>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<ParDjbz> getPardjbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParDjbz> getPardjbzByEntities(List<ParDjbz> entities) {
        List ids =new ArrayList();
        for(ParDjbz entity : entities){
            Serializable id=entity.getPardjbzid();
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



