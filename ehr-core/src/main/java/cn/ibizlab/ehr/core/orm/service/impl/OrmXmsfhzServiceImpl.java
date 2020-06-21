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
import cn.ibizlab.ehr.core.orm.domain.OrmXmsfhz;
import cn.ibizlab.ehr.core.orm.filter.OrmXmsfhzSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmXmsfhzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmXmsfhzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目人员缺口情况] 服务对象接口实现
 */
@Slf4j
@Service("OrmXmsfhzServiceImpl")
public class OrmXmsfhzServiceImpl extends ServiceImpl<OrmXmsfhzMapper, OrmXmsfhz> implements IOrmXmsfhzService {


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
    public boolean create(OrmXmsfhz et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmsfhzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmXmsfhz> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(OrmXmsfhz et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmsfhzid",et.getOrmxmsfhzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmsfhzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmXmsfhz> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public OrmXmsfhz getDraft(OrmXmsfhz et) {
        return et;
    }

    @Override
    public boolean checkKey(OrmXmsfhz et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmsfhzid()))&&(!Objects.isNull(this.getById(et.getOrmxmsfhzid())));
    }
    @Override
    @Transactional
    public OrmXmsfhz get(String key) {
        OrmXmsfhz et = getById(key);
        if(et==null){
            et=new OrmXmsfhz();
            et.setOrmxmsfhzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmXmsfhz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmXmsfhz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmXmsfhz> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmXmsfhz> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 根据组织定位查询
     */
    @Override
    public Page<OrmXmsfhz> searchAccOrg(OrmXmsfhzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmsfhz> pages=baseMapper.searchAccOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmsfhz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmXmsfhz> searchDefault(OrmXmsfhzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmsfhz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmsfhz>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmXmsfhz> getOrmxmsfhzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmXmsfhz> getOrmxmsfhzByEntities(List<OrmXmsfhz> entities) {
        List ids =new ArrayList();
        for(OrmXmsfhz entity : entities){
            Serializable id=entity.getOrmxmsfhzid();
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



