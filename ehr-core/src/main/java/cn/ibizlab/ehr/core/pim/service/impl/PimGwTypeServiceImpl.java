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
import cn.ibizlab.ehr.core.pim.domain.PimGwType;
import cn.ibizlab.ehr.core.pim.filter.PimGwTypeSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimGwTypeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimGwTypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位类型对照表] 服务对象接口实现
 */
@Slf4j
@Service("PimGwTypeServiceImpl")
public class PimGwTypeServiceImpl extends ServiceImpl<PimGwTypeMapper, PimGwType> implements IPimGwTypeService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PimGwType et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimGwType et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimGwType> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimGwType> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PimGwType getDraft(PimGwType et) {
        return et;
    }

    @Override
    @Transactional
    public PimGwType get(String key) {
        PimGwType et = getById(key);
        if(et==null){
            et=new PimGwType();
            et.setPimgwtypeid(key);
        }
        else{
        }
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
    public boolean checkKey(PimGwType et) {
        return (!ObjectUtils.isEmpty(et.getPimgwtypeid()))&&(!Objects.isNull(this.getById(et.getPimgwtypeid())));
    }
    @Override
    @Transactional
    public boolean update(PimGwType et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimgwtypeid",et.getPimgwtypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimgwtypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimGwType> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimGwType et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimgwtypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimGwType> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimGwType> searchDefault(PimGwTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimGwType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimGwType>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimGwType> getPimgwtypeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimGwType> getPimgwtypeByEntities(List<PimGwType> entities) {
        List ids =new ArrayList();
        for(PimGwType entity : entities){
            Serializable id=entity.getPimgwtypeid();
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



