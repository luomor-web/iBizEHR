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
import cn.ibizlab.ehr.core.sal.domain.SalSubject;
import cn.ibizlab.ehr.core.sal.filter.SalSubjectSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalSubjectService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalSubjectMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[财务科目] 服务对象接口实现
 */
@Slf4j
@Service("SalSubjectServiceImpl")
public class SalSubjectServiceImpl extends ServiceImpl<SalSubjectMapper, SalSubject> implements ISalSubjectService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalItemSubService salitemsubService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalItemService salitemService;

    private int batchSize = 500;

    @Override
    public SalSubject getDraft(SalSubject et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(SalSubject et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalSubject et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalSubject> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalSubject> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SalSubject et) {
        return (!ObjectUtils.isEmpty(et.getSalsubjectid()))&&(!Objects.isNull(this.getById(et.getSalsubjectid())));
    }
    @Override
    @Transactional
    public boolean update(SalSubject et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salsubjectid",et.getSalsubjectid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalsubjectid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalSubject> list) {
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
    public SalSubject get(String key) {
        SalSubject et = getById(key);
        if(et==null){
            et=new SalSubject();
            et.setSalsubjectid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(SalSubject et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalsubjectid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalSubject> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalSubject> searchDefault(SalSubjectSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalSubject> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalSubject>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<SalSubject> getSalsubjectByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalSubject> getSalsubjectByEntities(List<SalSubject> entities) {
        List ids =new ArrayList();
        for(SalSubject entity : entities){
            Serializable id=entity.getSalsubjectid();
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



