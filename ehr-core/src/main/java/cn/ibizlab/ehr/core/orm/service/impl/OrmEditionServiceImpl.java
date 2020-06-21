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
import cn.ibizlab.ehr.core.orm.domain.OrmEdition;
import cn.ibizlab.ehr.core.orm.filter.OrmEditionSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmEditionService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmEditionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[版本对照表] 服务对象接口实现
 */
@Slf4j
@Service("OrmEditionServiceImpl")
public class OrmEditionServiceImpl extends ServiceImpl<OrmEditionMapper, OrmEdition> implements IOrmEditionService {


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
    public boolean create(OrmEdition et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmeditionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmEdition> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrmEdition et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmEdition et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmEdition> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmEdition> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public OrmEdition getDraft(OrmEdition et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmEdition et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormeditionid",et.getOrmeditionid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmeditionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmEdition> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(OrmEdition et) {
        return (!ObjectUtils.isEmpty(et.getOrmeditionid()))&&(!Objects.isNull(this.getById(et.getOrmeditionid())));
    }
    @Override
    @Transactional
    public OrmEdition get(String key) {
        OrmEdition et = getById(key);
        if(et==null){
            et=new OrmEdition();
            et.setOrmeditionid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmEdition> searchDefault(OrmEditionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmEdition> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmEdition>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmEdition> getOrmeditionByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmEdition> getOrmeditionByEntities(List<OrmEdition> entities) {
        List ids =new ArrayList();
        for(OrmEdition entity : entities){
            Serializable id=entity.getOrmeditionid();
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



