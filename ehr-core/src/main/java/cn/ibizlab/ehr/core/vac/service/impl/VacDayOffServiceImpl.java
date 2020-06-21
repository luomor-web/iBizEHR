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
import cn.ibizlab.ehr.core.vac.domain.VacDayOff;
import cn.ibizlab.ehr.core.vac.filter.VacDayOffSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacDayOffService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacDayOffMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[调休日管理（停用）] 服务对象接口实现
 */
@Slf4j
@Service("VacDayOffServiceImpl")
public class VacDayOffServiceImpl extends ServiceImpl<VacDayOffMapper, VacDayOff> implements IVacDayOffService {


    private int batchSize = 500;

    @Override
    @Transactional
    public VacDayOff get(String key) {
        VacDayOff et = getById(key);
        if(et==null){
            et=new VacDayOff();
            et.setVacdayoffid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public VacDayOff getDraft(VacDayOff et) {
        return et;
    }

    @Override
    public boolean checkKey(VacDayOff et) {
        return (!ObjectUtils.isEmpty(et.getVacdayoffid()))&&(!Objects.isNull(this.getById(et.getVacdayoffid())));
    }
    @Override
    @Transactional
    public boolean save(VacDayOff et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacDayOff et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacDayOff> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacDayOff> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(VacDayOff et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacdayoffid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacDayOff> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VacDayOff et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacdayoffid",et.getVacdayoffid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacdayoffid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacDayOff> list) {
        updateBatchById(list,batchSize);
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
    public Page<VacDayOff> searchDefault(VacDayOffSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacDayOff> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacDayOff>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<VacDayOff> getVacdayoffByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacDayOff> getVacdayoffByEntities(List<VacDayOff> entities) {
        List ids =new ArrayList();
        for(VacDayOff entity : entities){
            Serializable id=entity.getVacdayoffid();
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



