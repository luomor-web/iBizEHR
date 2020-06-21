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
import cn.ibizlab.ehr.core.orm.domain.OrmXmgl;
import cn.ibizlab.ehr.core.orm.filter.OrmXmglSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmXmglService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmXmglMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmXmglServiceImpl")
public class OrmXmglServiceImpl extends ServiceImpl<OrmXmglMapper, OrmXmgl> implements IOrmXmglService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmxqjhService ormxmxqjhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public OrmXmgl get(String key) {
        OrmXmgl et = getById(key);
        if(et==null){
            et=new OrmXmgl();
            et.setOrmxmglid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(OrmXmgl et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmglid()))&&(!Objects.isNull(this.getById(et.getOrmxmglid())));
    }
    @Override
    public OrmXmgl getDraft(OrmXmgl et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmXmgl et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmglid",et.getOrmxmglid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmglid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmXmgl> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(OrmXmgl et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmglid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmXmgl> list) {
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
    public OrmXmgl synchro(OrmXmgl et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmXmgl et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmXmgl et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmXmgl> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmXmgl> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmXmgl> searchDefault(OrmXmglSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmgl> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmgl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 有效项目
     */
    @Override
    public Page<OrmXmgl> searchValidPro(OrmXmglSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmgl> pages=baseMapper.searchValidPro(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmgl>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmXmgl> getOrmxmglByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmXmgl> getOrmxmglByEntities(List<OrmXmgl> entities) {
        List ids =new ArrayList();
        for(OrmXmgl entity : entities){
            Serializable id=entity.getOrmxmglid();
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



