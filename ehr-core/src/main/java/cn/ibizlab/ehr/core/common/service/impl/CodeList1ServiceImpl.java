package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.CodeList1;
import cn.ibizlab.ehr.core.common.filter.CodeList1SearchContext;
import cn.ibizlab.ehr.core.common.service.ICodeList1Service;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.CodeList1Mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[代码表] 服务对象接口实现
 */
@Slf4j
@Service("CodeList1ServiceImpl")
public class CodeList1ServiceImpl extends ServiceImpl<CodeList1Mapper, CodeList1> implements ICodeList1Service {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ICodeItemService codeitemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public CodeList1 get(String key) {
        CodeList1 et = getById(key);
        if(et==null){
            et=new CodeList1();
            et.setCodelistid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public CodeList1 getDraft(CodeList1 et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(CodeList1 et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("codelistid",et.getCodelistid())))
            return false;
        CachedBeanCopier.copy(get(et.getCodelistid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<CodeList1> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public CodeList1 refreshModel(CodeList1 et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(CodeList1 et) {
        return (!ObjectUtils.isEmpty(et.getCodelistid()))&&(!Objects.isNull(this.getById(et.getCodelistid())));
    }
    @Override
    @Transactional
    public boolean create(CodeList1 et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getCodelistid()),et);
        return true;
    }

    @Override
    public void createBatch(List<CodeList1> list) {
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
    public boolean save(CodeList1 et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(CodeList1 et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<CodeList1> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<CodeList1> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 用户使用
     */
    @Override
    public Page<CodeList1> searchPersonUse(CodeList1SearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CodeList1> pages=baseMapper.searchPersonUse(context.getPages(),context,context.getSelectCond());
        return new PageImpl<CodeList1>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<CodeList1> searchDefault(CodeList1SearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CodeList1> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<CodeList1>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<CodeList1> getCodelist1ByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<CodeList1> getCodelist1ByEntities(List<CodeList1> entities) {
        List ids =new ArrayList();
        for(CodeList1 entity : entities){
            Serializable id=entity.getCodelistid();
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



