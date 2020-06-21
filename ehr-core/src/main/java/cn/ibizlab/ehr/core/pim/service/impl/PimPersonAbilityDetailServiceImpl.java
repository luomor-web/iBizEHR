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
import cn.ibizlab.ehr.core.pim.domain.PimPersonAbilityDetail;
import cn.ibizlab.ehr.core.pim.filter.PimPersonAbilityDetailSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimPersonAbilityDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimPersonAbilityDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工能力明细] 服务对象接口实现
 */
@Slf4j
@Service("PimPersonAbilityDetailServiceImpl")
public class PimPersonAbilityDetailServiceImpl extends ServiceImpl<PimPersonAbilityDetailMapper, PimPersonAbilityDetail> implements IPimPersonAbilityDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonAbilityService pimpersonabilityService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PimPersonAbilityDetail et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonabilitydetailid()))&&(!Objects.isNull(this.getById(et.getPimpersonabilitydetailid())));
    }
    @Override
    @Transactional
    public boolean create(PimPersonAbilityDetail et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonabilitydetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimPersonAbilityDetail> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimPersonAbilityDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimPersonAbilityDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimPersonAbilityDetail> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimPersonAbilityDetail> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PimPersonAbilityDetail et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonabilitydetailid",et.getPimpersonabilitydetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonabilitydetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimPersonAbilityDetail> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimPersonAbilityDetail get(String key) {
        PimPersonAbilityDetail et = getById(key);
        if(et==null){
            et=new PimPersonAbilityDetail();
            et.setPimpersonabilitydetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimPersonAbilityDetail getDraft(PimPersonAbilityDetail et) {
        return et;
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
    public List<PimPersonAbilityDetail> selectByPimpersonabilityid(String pimpersonabilityid) {
        return baseMapper.selectByPimpersonabilityid(pimpersonabilityid);
    }

    @Override
    public void removeByPimpersonabilityid(String pimpersonabilityid) {
        this.remove(new QueryWrapper<PimPersonAbilityDetail>().eq("pimpersonabilityid",pimpersonabilityid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimPersonAbilityDetail> searchDefault(PimPersonAbilityDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPersonAbilityDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPersonAbilityDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimPersonAbilityDetail> getPimpersonabilitydetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimPersonAbilityDetail> getPimpersonabilitydetailByEntities(List<PimPersonAbilityDetail> entities) {
        List ids =new ArrayList();
        for(PimPersonAbilityDetail entity : entities){
            Serializable id=entity.getPimpersonabilitydetailid();
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



