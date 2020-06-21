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
import cn.ibizlab.ehr.core.pim.domain.PimCity;
import cn.ibizlab.ehr.core.pim.filter.PimCitySearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimCityService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimCityMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[市] 服务对象接口实现
 */
@Slf4j
@Service("PimCityServiceImpl")
public class PimCityServiceImpl extends ServiceImpl<PimCityMapper, PimCity> implements IPimCityService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PimCity et) {
        return (!ObjectUtils.isEmpty(et.getPimcityid()))&&(!Objects.isNull(this.getById(et.getPimcityid())));
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
    public PimCity getDraft(PimCity et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimCity et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimcityid",et.getPimcityid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimcityid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimCity> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimCity et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimCity et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimCity> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimCity> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimCity get(String key) {
        PimCity et = getById(key);
        if(et==null){
            et=new PimCity();
            et.setPimcityid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimCity et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimcityid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimCity> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimCity> searchDefault(PimCitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimCity> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimCity>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimCity> getPimcityByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimCity> getPimcityByEntities(List<PimCity> entities) {
        List ids =new ArrayList();
        for(PimCity entity : entities){
            Serializable id=entity.getPimcityid();
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



