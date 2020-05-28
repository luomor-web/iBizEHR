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
import cn.ibizlab.ehr.core.par.domain.PARTZGG;
import cn.ibizlab.ehr.core.par.filter.PARTZGGSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARTZGGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARTZGGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[通知发布] 服务对象接口实现
 */
@Slf4j
@Service("PARTZGGServiceImpl")
public class PARTZGGServiceImpl extends ServiceImpl<PARTZGGMapper, PARTZGG> implements IPARTZGGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARBMFZJYXService parbmfzjyxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARFZSMXService parfzsmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARZNBMMXService parznbmmxService;

    private int batchSize = 500;

    @Override
    public PARTZGG getDraft(PARTZGG et) {
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
    @Transactional
    public boolean save(PARTZGG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARTZGG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARTZGG> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARTZGG> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PARTZGG et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPartzggid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARTZGG> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PARTZGG get(String key) {
        PARTZGG et = getById(key);
        if(et==null){
            et=new PARTZGG();
            et.setPartzggid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARTZGG et) {
        return (!ObjectUtils.isEmpty(et.getPartzggid()))&&(!Objects.isNull(this.getById(et.getPartzggid())));
    }

    @Override
    @Transactional
    public boolean update(PARTZGG et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("partzggid",et.getPartzggid())))
            return false;
        CachedBeanCopier.copy(get(et.getPartzggid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARTZGG> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARTZGG> searchDefault(PARTZGGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARTZGG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARTZGG>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PARTZGG> getPartzggByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PARTZGG> getPartzggByEntities(List<PARTZGG> entities) {
        List ids =new ArrayList();
        for(PARTZGG entity : entities){
            Serializable id=entity.getPartzggid();
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


