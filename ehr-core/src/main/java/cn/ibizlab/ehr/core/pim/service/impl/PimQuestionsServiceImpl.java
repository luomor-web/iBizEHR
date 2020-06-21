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
import cn.ibizlab.ehr.core.pim.domain.PimQuestions;
import cn.ibizlab.ehr.core.pim.filter.PimQuestionsSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimQuestionsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimQuestionsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[问题收集] 服务对象接口实现
 */
@Slf4j
@Service("PimQuestionsServiceImpl")
public class PimQuestionsServiceImpl extends ServiceImpl<PimQuestionsMapper, PimQuestions> implements IPimQuestionsService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PimQuestions removeTemp(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimQuestions getTemp(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimQuestions getDraftTempMajor(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimQuestions updateTemp(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimQuestions et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimQuestions et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimQuestions> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimQuestions> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimQuestions createTempMajor(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimQuestions et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("questionsid",et.getQuestionsid())))
            return false;
        CachedBeanCopier.copy(get(et.getQuestionsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimQuestions> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimQuestions get(String key) {
        PimQuestions et = getById(key);
        if(et==null){
            et=new PimQuestions();
            et.setQuestionsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PimQuestions updateTempMajor(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PimQuestions et) {
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
    public boolean create(PimQuestions et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getQuestionsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimQuestions> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimQuestions getTempMajor(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    public PimQuestions getDraft(PimQuestions et) {
        return et;
    }

    @Override
    @Transactional
    public PimQuestions createTemp(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimQuestions removeTempMajor(PimQuestions et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimQuestions getDraftTemp(PimQuestions et) {
        //自定义代码
        return et;
    }



    /**
     * 查询集合 查询当前页面问题
     */
    @Override
    public Page<PimQuestions> searchQUERYcurrentQUESTION(PimQuestionsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimQuestions> pages=baseMapper.searchQUERYcurrentQUESTION(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimQuestions>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimQuestions> searchDefault(PimQuestionsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimQuestions> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimQuestions>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimQuestions> getPimquestionsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimQuestions> getPimquestionsByEntities(List<PimQuestions> entities) {
        List ids =new ArrayList();
        for(PimQuestions entity : entities){
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



