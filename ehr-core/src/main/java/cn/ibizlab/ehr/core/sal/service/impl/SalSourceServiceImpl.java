package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SalSource;
import cn.ibizlab.ehr.core.sal.filter.SalSourceSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalSourceService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalSourceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬计算源] 服务对象接口实现
 */
@Slf4j
@Service("SalSourceServiceImpl")
public class SalSourceServiceImpl extends ServiceImpl<SalSourceMapper, SalSource> implements ISalSourceService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalParamService salparamService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SalSource get(String key) {
        SalSource et = getById(key);
        if(et==null){
            et=new SalSource();
            et.setSalsourceid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(SalSource et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalSource et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalSource> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalSource> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SalSource et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salsourceid",et.getSalsourceid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalsourceid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalSource> list) {
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
    public boolean create(SalSource et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalsourceid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalSource> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SalSource et) {
        return (!ObjectUtils.isEmpty(et.getSalsourceid()))&&(!Objects.isNull(this.getById(et.getSalsourceid())));
    }
    @Override
    public SalSource getDraft(SalSource et) {
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalSource> searchDefault(SalSourceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalSource> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalSource>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<SalSource> getSalsourceByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalSource> getSalsourceByEntities(List<SalSource> entities) {
        List ids =new ArrayList();
        for(SalSource entity : entities){
            Serializable id=entity.getSalsourceid();
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



