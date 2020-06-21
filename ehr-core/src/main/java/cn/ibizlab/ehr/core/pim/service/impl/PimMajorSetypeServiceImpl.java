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
import cn.ibizlab.ehr.core.pim.domain.PimMajorSetype;
import cn.ibizlab.ehr.core.pim.filter.PimMajorSetypeSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimMajorSetypeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimMajorSetypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[专业序列类型] 服务对象接口实现
 */
@Slf4j
@Service("PimMajorSetypeServiceImpl")
public class PimMajorSetypeServiceImpl extends ServiceImpl<PimMajorSetypeMapper, PimMajorSetype> implements IPimMajorSetypeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

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
    public boolean checkKey(PimMajorSetype et) {
        return (!ObjectUtils.isEmpty(et.getPimmajorsetypeid()))&&(!Objects.isNull(this.getById(et.getPimmajorsetypeid())));
    }
    @Override
    @Transactional
    public PimMajorSetype get(String key) {
        PimMajorSetype et = getById(key);
        if(et==null){
            et=new PimMajorSetype();
            et.setPimmajorsetypeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimMajorSetype et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimMajorSetype et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimMajorSetype> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimMajorSetype> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimMajorSetype et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimmajorsetypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimMajorSetype> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimMajorSetype getDraft(PimMajorSetype et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimMajorSetype et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimmajorsetypeid",et.getPimmajorsetypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimmajorsetypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimMajorSetype> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimMajorSetype> searchDefault(PimMajorSetypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimMajorSetype> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimMajorSetype>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimMajorSetype> getPimmajorsetypeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimMajorSetype> getPimmajorsetypeByEntities(List<PimMajorSetype> entities) {
        List ids =new ArrayList();
        for(PimMajorSetype entity : entities){
            Serializable id=entity.getPimmajorsetypeid();
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



