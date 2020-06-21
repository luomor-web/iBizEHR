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
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqhz;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqhzSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmXmxqhzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmXmxqhzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目人员需求汇总] 服务对象接口实现
 */
@Slf4j
@Service("OrmXmxqhzServiceImpl")
public class OrmXmxqhzServiceImpl extends ServiceImpl<OrmXmxqhzMapper, OrmXmxqhz> implements IOrmXmxqhzService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(OrmXmxqhz et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmxqhzid",et.getOrmxmxqhzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqhzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmXmxqhz> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrmXmxqhz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmXmxqhz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmXmxqhz> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmXmxqhz> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public OrmXmxqhz getDraft(OrmXmxqhz et) {
        return et;
    }

    @Override
    public boolean checkKey(OrmXmxqhz et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmxqhzid()))&&(!Objects.isNull(this.getById(et.getOrmxmxqhzid())));
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
    public OrmXmxqhz get(String key) {
        OrmXmxqhz et = getById(key);
        if(et==null){
            et=new OrmXmxqhz();
            et.setOrmxmxqhzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmXmxqhz et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqhzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmXmxqhz> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 项目人员缺口明细
     */
    @Override
    public Page<OrmXmxqhz> searchXMRYQKMX(OrmXmxqhzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqhz> pages=baseMapper.searchXMRYQKMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqhz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmXmxqhz> searchDefault(OrmXmxqhzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqhz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqhz>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmXmxqhz> getOrmxmxqhzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmXmxqhz> getOrmxmxqhzByEntities(List<OrmXmxqhz> entities) {
        List ids =new ArrayList();
        for(OrmXmxqhz entity : entities){
            Serializable id=entity.getOrmxmxqhzid();
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



