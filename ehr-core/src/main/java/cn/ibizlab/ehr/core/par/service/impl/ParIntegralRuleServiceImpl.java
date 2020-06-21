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
import cn.ibizlab.ehr.core.par.domain.ParIntegralRule;
import cn.ibizlab.ehr.core.par.filter.ParIntegralRuleSearchContext;
import cn.ibizlab.ehr.core.par.service.IParIntegralRuleService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParIntegralRuleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[积分规则] 服务对象接口实现
 */
@Slf4j
@Service("ParIntegralRuleServiceImpl")
public class ParIntegralRuleServiceImpl extends ServiceImpl<ParIntegralRuleMapper, ParIntegralRule> implements IParIntegralRuleService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(ParIntegralRule et) {
        return (!ObjectUtils.isEmpty(et.getParintegralruleid()))&&(!Objects.isNull(this.getById(et.getParintegralruleid())));
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
    public boolean update(ParIntegralRule et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parintegralruleid",et.getParintegralruleid())))
            return false;
        CachedBeanCopier.copy(get(et.getParintegralruleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParIntegralRule> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ParIntegralRule get(String key) {
        ParIntegralRule et = getById(key);
        if(et==null){
            et=new ParIntegralRule();
            et.setParintegralruleid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ParIntegralRule getDraft(ParIntegralRule et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParIntegralRule et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParintegralruleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParIntegralRule> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParIntegralRule et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParIntegralRule et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParIntegralRule> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParIntegralRule> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParIntegralRule> searchDefault(ParIntegralRuleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParIntegralRule> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParIntegralRule>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<ParIntegralRule> getParintegralruleByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParIntegralRule> getParintegralruleByEntities(List<ParIntegralRule> entities) {
        List ids =new ArrayList();
        for(ParIntegralRule entity : entities){
            Serializable id=entity.getParintegralruleid();
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



