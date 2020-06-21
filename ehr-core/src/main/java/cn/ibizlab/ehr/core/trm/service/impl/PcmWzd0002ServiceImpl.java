package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.PcmWzd0002;
import cn.ibizlab.ehr.core.trm.filter.PcmWzd0002SearchContext;
import cn.ibizlab.ehr.core.trm.service.IPcmWzd0002Service;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.PcmWzd0002Mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[干部退出（优秀年轻干部梯队）] 服务对象接口实现
 */
@Slf4j
@Service("PcmWzd0002ServiceImpl")
public class PcmWzd0002ServiceImpl extends ServiceImpl<PcmWzd0002Mapper, PcmWzd0002> implements IPcmWzd0002Service {


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
    @Transactional
    public boolean save(PcmWzd0002 et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmWzd0002 et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmWzd0002> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmWzd0002> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PcmWzd0002 getDraft(PcmWzd0002 et) {
        return et;
    }

    @Override
    public boolean checkKey(PcmWzd0002 et) {
        return (!ObjectUtils.isEmpty(et.getWzd0002id()))&&(!Objects.isNull(this.getById(et.getWzd0002id())));
    }
    @Override
    @Transactional
    public PcmWzd0002 get(String key) {
        PcmWzd0002 et = getById(key);
        if(et==null){
            et=new PcmWzd0002();
            et.setWzd0002id(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmWzd0002 et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWzd0002id()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmWzd0002> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PcmWzd0002 et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wzd0002id",et.getWzd0002id())))
            return false;
        CachedBeanCopier.copy(get(et.getWzd0002id()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmWzd0002> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmWzd0002> searchDefault(PcmWzd0002SearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmWzd0002> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmWzd0002>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmWzd0002> getPcmwzd0002ByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmWzd0002> getPcmwzd0002ByEntities(List<PcmWzd0002> entities) {
        List ids =new ArrayList();
        for(PcmWzd0002 entity : entities){
            Serializable id=entity.getWzd0002id();
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



