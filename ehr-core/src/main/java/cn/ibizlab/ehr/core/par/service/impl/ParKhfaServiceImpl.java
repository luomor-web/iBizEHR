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
import cn.ibizlab.ehr.core.par.domain.ParKhfa;
import cn.ibizlab.ehr.core.par.filter.ParKhfaSearchContext;
import cn.ibizlab.ehr.core.par.service.IParKhfaService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParKhfaMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考核对象] 服务对象接口实现
 */
@Slf4j
@Service("ParKhfaServiceImpl")
public class ParKhfaServiceImpl extends ServiceImpl<ParKhfaMapper, ParKhfa> implements IParKhfaService {


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
    public boolean save(ParKhfa et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParKhfa et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParKhfa> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParKhfa> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ParKhfa et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParkhfaid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParKhfa> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ParKhfa et) {
        return (!ObjectUtils.isEmpty(et.getParkhfaid()))&&(!Objects.isNull(this.getById(et.getParkhfaid())));
    }
    @Override
    public ParKhfa getDraft(ParKhfa et) {
        return et;
    }

    @Override
    @Transactional
    public ParKhfa get(String key) {
        ParKhfa et = getById(key);
        if(et==null){
            et=new ParKhfa();
            et.setParkhfaid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(ParKhfa et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parkhfaid",et.getParkhfaid())))
            return false;
        CachedBeanCopier.copy(get(et.getParkhfaid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParKhfa> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParKhfa> searchDefault(ParKhfaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParKhfa> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParKhfa>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<ParKhfa> getParkhfaByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParKhfa> getParkhfaByEntities(List<ParKhfa> entities) {
        List ids =new ArrayList();
        for(ParKhfa entity : entities){
            Serializable id=entity.getParkhfaid();
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



