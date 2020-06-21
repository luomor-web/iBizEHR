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
import cn.ibizlab.ehr.core.pim.domain.PimExaminationResults;
import cn.ibizlab.ehr.core.pim.filter.PimExaminationResultsSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimExaminationResultsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimExaminationResultsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[B/Y员工转正考核结果记录] 服务对象接口实现
 */
@Slf4j
@Service("PimExaminationResultsServiceImpl")
public class PimExaminationResultsServiceImpl extends ServiceImpl<PimExaminationResultsMapper, PimExaminationResults> implements IPimExaminationResultsService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimByzzjlmxService pimbyzzjlmxService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimExaminationResults et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimexaminationresultsid",et.getPimexaminationresultsid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimexaminationresultsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimExaminationResults> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimExaminationResults et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimExaminationResults et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimExaminationResults> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimExaminationResults> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PimExaminationResults et) {
        return (!ObjectUtils.isEmpty(et.getPimexaminationresultsid()))&&(!Objects.isNull(this.getById(et.getPimexaminationresultsid())));
    }
    @Override
    @Transactional
    public boolean create(PimExaminationResults et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimexaminationresultsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimExaminationResults> list) {
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
    public PimExaminationResults getDraft(PimExaminationResults et) {
        return et;
    }

    @Override
    @Transactional
    public PimExaminationResults get(String key) {
        PimExaminationResults et = getById(key);
        if(et==null){
            et=new PimExaminationResults();
            et.setPimexaminationresultsid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimExaminationResults> searchDefault(PimExaminationResultsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExaminationResults> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExaminationResults>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimExaminationResults> getPimexaminationresultsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimExaminationResults> getPimexaminationresultsByEntities(List<PimExaminationResults> entities) {
        List ids =new ArrayList();
        for(PimExaminationResults entity : entities){
            Serializable id=entity.getPimexaminationresultsid();
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



