package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.QUESTIONS;
import cn.ibizlab.ehr.core.pim.filter.QUESTIONSSearchContext;
import cn.ibizlab.ehr.core.pim.service.IQUESTIONSService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.QUESTIONSMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[问题收集] 服务对象接口实现
 */
@Slf4j
@Service("QUESTIONSServiceImpl")
public class QUESTIONSServiceImpl extends ServiceImpl<QUESTIONSMapper, QUESTIONS> implements IQUESTIONSService {


    private int batchSize = 500;

    @Override
    @Transactional
    public QUESTIONS removeTemp(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS getTemp(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS getDraftTempMajor(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS updateTemp(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(QUESTIONS et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(QUESTIONS et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<QUESTIONS> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<QUESTIONS> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public QUESTIONS createTempMajor(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(QUESTIONS et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("questionsid",et.getQuestionsid())))
            return false;
        CachedBeanCopier.copy(get(et.getQuestionsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<QUESTIONS> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public QUESTIONS get(String key) {
        QUESTIONS et = getById(key);
        if(et==null){
            et=new QUESTIONS();
            et.setQuestionsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS updateTempMajor(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(QUESTIONS et) {
        return (!ObjectUtils.isEmpty(et.getQuestionsid()))&&(!Objects.isNull(this.getById(et.getQuestionsid())));
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
    public boolean create(QUESTIONS et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getQuestionsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<QUESTIONS> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public QUESTIONS getTempMajor(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    public QUESTIONS getDraft(QUESTIONS et) {
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS createTemp(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS removeTempMajor(QUESTIONS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public QUESTIONS getDraftTemp(QUESTIONS et) {
        //自定义代码
        return et;
    }



    /**
     * 查询集合 查询当前页面问题
     */
    @Override
    public Page<QUESTIONS> searchQUERYcurrentQUESTION(QUESTIONSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<QUESTIONS> pages=baseMapper.searchQUERYcurrentQUESTION(context.getPages(),context,context.getSelectCond());
        return new PageImpl<QUESTIONS>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<QUESTIONS> searchDefault(QUESTIONSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<QUESTIONS> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<QUESTIONS>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<QUESTIONS> getQuestionsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<QUESTIONS> getQuestionsByEntities(List<QUESTIONS> entities) {
        List ids =new ArrayList();
        for(QUESTIONS entity : entities){
            Serializable id=entity.getQuestionsid();
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


