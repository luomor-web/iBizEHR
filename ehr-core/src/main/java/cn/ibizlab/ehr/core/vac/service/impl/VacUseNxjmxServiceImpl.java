package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VacUseNxjmx;
import cn.ibizlab.ehr.core.vac.filter.VacUseNxjmxSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacUseNxjmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacUseNxjmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[假期使用明细] 服务对象接口实现
 */
@Slf4j
@Service("VacUseNxjmxServiceImpl")
public class VacUseNxjmxServiceImpl extends ServiceImpl<VacUseNxjmxMapper, VacUseNxjmx> implements IVacUseNxjmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService vacleavedetailService;

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
    public boolean checkKey(VacUseNxjmx et) {
        return (!ObjectUtils.isEmpty(et.getVacusenxjmxid()))&&(!Objects.isNull(this.getById(et.getVacusenxjmxid())));
    }
    @Override
    @Transactional
    public boolean create(VacUseNxjmx et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacusenxjmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacUseNxjmx> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VacUseNxjmx et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacusenxjmxid",et.getVacusenxjmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacusenxjmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacUseNxjmx> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(VacUseNxjmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacUseNxjmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacUseNxjmx> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacUseNxjmx> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public VacUseNxjmx getDraft(VacUseNxjmx et) {
        return et;
    }

    @Override
    @Transactional
    public VacUseNxjmx get(String key) {
        VacUseNxjmx et = getById(key);
        if(et==null){
            et=new VacUseNxjmx();
            et.setVacusenxjmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<VacUseNxjmx> selectByVacleavedetailid(String vacleavedetailid) {
        return baseMapper.selectByVacleavedetailid(vacleavedetailid);
    }

    @Override
    public void removeByVacleavedetailid(String vacleavedetailid) {
        this.remove(new QueryWrapper<VacUseNxjmx>().eq("vacleavedetailid",vacleavedetailid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacUseNxjmx> searchDefault(VacUseNxjmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacUseNxjmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacUseNxjmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<VacUseNxjmx> getVacusenxjmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacUseNxjmx> getVacusenxjmxByEntities(List<VacUseNxjmx> entities) {
        List ids =new ArrayList();
        for(VacUseNxjmx entity : entities){
            Serializable id=entity.getVacusenxjmxid();
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



