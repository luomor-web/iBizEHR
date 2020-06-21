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
import cn.ibizlab.ehr.core.orm.domain.OrmUnitedPerson;
import cn.ibizlab.ehr.core.orm.filter.OrmUnitedPersonSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmUnitedPersonService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmUnitedPersonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[统一身份库] 服务对象接口实现
 */
@Slf4j
@Service("OrmUnitedPersonServiceImpl")
public class OrmUnitedPersonServiceImpl extends ServiceImpl<OrmUnitedPersonMapper, OrmUnitedPerson> implements IOrmUnitedPersonService {


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
    public boolean save(OrmUnitedPerson et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmUnitedPerson et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmUnitedPerson> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmUnitedPerson> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmUnitedPerson getUnitedUser(OrmUnitedPerson et) {
        //自定义代码
        return et;
    }

    @Override
    public OrmUnitedPerson getDraft(OrmUnitedPerson et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmUnitedPerson et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUnitedpersonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmUnitedPerson> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(OrmUnitedPerson et) {
        return (!ObjectUtils.isEmpty(et.getUnitedpersonid()))&&(!Objects.isNull(this.getById(et.getUnitedpersonid())));
    }
    @Override
    @Transactional
    public OrmUnitedPerson get(String key) {
        OrmUnitedPerson et = getById(key);
        if(et==null){
            et=new OrmUnitedPerson();
            et.setUnitedpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmUnitedPerson et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("unitedpersonid",et.getUnitedpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getUnitedpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmUnitedPerson> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmUnitedPerson> searchDefault(OrmUnitedPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmUnitedPerson> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmUnitedPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询可用的OID用户
     */
    @Override
    public Page<OrmUnitedPerson> searchCXYH(OrmUnitedPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmUnitedPerson> pages=baseMapper.searchCXYH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmUnitedPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 新建用户
     */
    @Override
    public Page<OrmUnitedPerson> searchCurFQXJYH(OrmUnitedPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmUnitedPerson> pages=baseMapper.searchCurFQXJYH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmUnitedPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmUnitedPerson> getOrmunitedpersonByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmUnitedPerson> getOrmunitedpersonByEntities(List<OrmUnitedPerson> entities) {
        List ids =new ArrayList();
        for(OrmUnitedPerson entity : entities){
            Serializable id=entity.getUnitedpersonid();
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



