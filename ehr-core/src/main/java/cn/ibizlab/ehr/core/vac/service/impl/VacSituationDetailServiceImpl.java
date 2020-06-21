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
import cn.ibizlab.ehr.core.vac.domain.VacSituationDetail;
import cn.ibizlab.ehr.core.vac.filter.VacSituationDetailSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacSituationDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacSituationDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[休假明细] 服务对象接口实现
 */
@Slf4j
@Service("VacSituationDetailServiceImpl")
public class VacSituationDetailServiceImpl extends ServiceImpl<VacSituationDetailMapper, VacSituationDetail> implements IVacSituationDetailService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(VacSituationDetail et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacsituationdetailid",et.getVacsituationdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacsituationdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacSituationDetail> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public VacSituationDetail getDraft(VacSituationDetail et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(VacSituationDetail et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacsituationdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacSituationDetail> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacSituationDetail get(String key) {
        VacSituationDetail et = getById(key);
        if(et==null){
            et=new VacSituationDetail();
            et.setVacsituationdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VacSituationDetail et) {
        return (!ObjectUtils.isEmpty(et.getVacsituationdetailid()))&&(!Objects.isNull(this.getById(et.getVacsituationdetailid())));
    }
    @Override
    @Transactional
    public boolean save(VacSituationDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacSituationDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacSituationDetail> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacSituationDetail> list) {
        saveOrUpdateBatch(list,batchSize);
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
    public Page<VacSituationDetail> searchDefault(VacSituationDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacSituationDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacSituationDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<VacSituationDetail> getVacsituationdetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacSituationDetail> getVacsituationdetailByEntities(List<VacSituationDetail> entities) {
        List ids =new ArrayList();
        for(VacSituationDetail entity : entities){
            Serializable id=entity.getVacsituationdetailid();
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



