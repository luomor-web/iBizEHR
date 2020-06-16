package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SocRule;
import cn.ibizlab.ehr.core.soc.filter.SocRuleSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocRuleService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocRuleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保规则] 服务对象接口实现
 */
@Slf4j
@Service("SocRuleServiceImpl")
public class SocRuleServiceImpl extends ServiceImpl<SocRuleMapper, SocRule> implements ISocRuleService {


    private int batchSize = 500;

    @Override
    @Transactional
    public SocRule get(String key) {
        SocRule et = getById(key);
        if(et==null){
            et=new SocRule();
            et.setSocruleid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SocRule getDraft(SocRule et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(SocRule et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocruleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocRule> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SocRule et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socruleid",et.getSocruleid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocruleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocRule> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SocRule et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocRule et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocRule> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocRule> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SocRule et) {
        return (!ObjectUtils.isEmpty(et.getSocruleid()))&&(!Objects.isNull(this.getById(et.getSocruleid())));
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocRule> searchDefault(SocRuleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocRule> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocRule>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<SocRule> getSocruleByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocRule> getSocruleByEntities(List<SocRule> entities) {
        List ids =new ArrayList();
        for(SocRule entity : entities){
            Serializable id=entity.getSocruleid();
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



