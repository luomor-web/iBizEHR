package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalCatalogSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimVocationalCatalogService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimVocationalCatalogMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[执（职）业资格管理] 服务对象接口实现
 */
@Slf4j
@Service("PimVocationalCatalogServiceImpl")
public class PimVocationalCatalogServiceImpl extends ServiceImpl<PimVocationalCatalogMapper, PimVocationalCatalog> implements IPimVocationalCatalogService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PimVocationalCatalog et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimVocationalCatalog et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimVocationalCatalog> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimVocationalCatalog> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PimVocationalCatalog getDraft(PimVocationalCatalog et) {
        return et;
    }

    @Override
    @Transactional
    public PimVocationalCatalog get(String key) {
        PimVocationalCatalog et = getById(key);
        if(et==null){
            et=new PimVocationalCatalog();
            et.setPimvocationalcatalogid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PimVocationalCatalog et) {
        return (!ObjectUtils.isEmpty(et.getPimvocationalcatalogid()))&&(!Objects.isNull(this.getById(et.getPimvocationalcatalogid())));
    }
    @Override
    @Transactional
    public boolean update(PimVocationalCatalog et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimvocationalcatalogid",et.getPimvocationalcatalogid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalcatalogid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimVocationalCatalog> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimVocationalCatalog et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalcatalogid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimVocationalCatalog> list) {
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimVocationalCatalog> searchDefault(PimVocationalCatalogSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimVocationalCatalog> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimVocationalCatalog>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimVocationalCatalog> getPimvocationalcatalogByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimVocationalCatalog> getPimvocationalcatalogByEntities(List<PimVocationalCatalog> entities) {
        List ids =new ArrayList();
        for(PimVocationalCatalog entity : entities){
            Serializable id=entity.getPimvocationalcatalogid();
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



