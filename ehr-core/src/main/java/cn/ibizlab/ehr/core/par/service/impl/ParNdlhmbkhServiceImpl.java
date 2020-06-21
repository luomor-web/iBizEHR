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
import cn.ibizlab.ehr.core.par.domain.ParNdlhmbkh;
import cn.ibizlab.ehr.core.par.filter.ParNdlhmbkhSearchContext;
import cn.ibizlab.ehr.core.par.service.IParNdlhmbkhService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParNdlhmbkhMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[量化目标考核] 服务对象接口实现
 */
@Slf4j
@Service("ParNdlhmbkhServiceImpl")
public class ParNdlhmbkhServiceImpl extends ServiceImpl<ParNdlhmbkhMapper, ParNdlhmbkh> implements IParNdlhmbkhService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParLhmbkhmxService parlhmbkhmxService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ParNdlhmbkh et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parndlhmbkhid",et.getParndlhmbkhid())))
            return false;
        CachedBeanCopier.copy(get(et.getParndlhmbkhid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParNdlhmbkh> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public ParNdlhmbkh getDraft(ParNdlhmbkh et) {
        return et;
    }

    @Override
    public boolean checkKey(ParNdlhmbkh et) {
        return (!ObjectUtils.isEmpty(et.getParndlhmbkhid()))&&(!Objects.isNull(this.getById(et.getParndlhmbkhid())));
    }
    @Override
    @Transactional
    public boolean create(ParNdlhmbkh et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParndlhmbkhid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParNdlhmbkh> list) {
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
    public boolean save(ParNdlhmbkh et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParNdlhmbkh et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParNdlhmbkh> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParNdlhmbkh> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ParNdlhmbkh get(String key) {
        ParNdlhmbkh et = getById(key);
        if(et==null){
            et=new ParNdlhmbkh();
            et.setParndlhmbkhid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParNdlhmbkh> searchDefault(ParNdlhmbkhSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParNdlhmbkh> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParNdlhmbkh>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<ParNdlhmbkh> getParndlhmbkhByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParNdlhmbkh> getParndlhmbkhByEntities(List<ParNdlhmbkh> entities) {
        List ids =new ArrayList();
        for(ParNdlhmbkh entity : entities){
            Serializable id=entity.getParndlhmbkhid();
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



