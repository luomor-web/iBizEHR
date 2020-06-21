package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSzyjtjSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileSzyjtjService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmProfileSzyjtjMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者社招引进条件] 服务对象接口实现
 */
@Slf4j
@Service("PcmProfileSzyjtjServiceImpl")
public class PcmProfileSzyjtjServiceImpl extends ServiceImpl<PcmProfileSzyjtjMapper, PcmProfileSzyjtj> implements IPcmProfileSzyjtjService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PcmProfileSzyjtj et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmProfileSzyjtj et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmProfileSzyjtj> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmProfileSzyjtj> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmProfileSzyjtj et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileszyjtjid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmProfileSzyjtj> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PcmProfileSzyjtj getDraft(PcmProfileSzyjtj et) {
        return et;
    }

    @Override
    public boolean checkKey(PcmProfileSzyjtj et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofileszyjtjid()))&&(!Objects.isNull(this.getById(et.getPcmprofileszyjtjid())));
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
    @Transactional
    public PcmProfileSzyjtj get(String key) {
        PcmProfileSzyjtj et = getById(key);
        if(et==null){
            et=new PcmProfileSzyjtj();
            et.setPcmprofileszyjtjid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmProfileSzyjtj et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofileszyjtjid",et.getPcmprofileszyjtjid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileszyjtjid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmProfileSzyjtj> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmProfileSzyjtj> searchDefault(PcmProfileSzyjtjSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfileSzyjtj> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfileSzyjtj>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 通过申报类型过滤
     */
    @Override
    public Page<PcmProfileSzyjtj> searchYGLX(PcmProfileSzyjtjSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfileSzyjtj> pages=baseMapper.searchYGLX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfileSzyjtj>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmProfileSzyjtj> getPcmprofileszyjtjByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmProfileSzyjtj> getPcmprofileszyjtjByEntities(List<PcmProfileSzyjtj> entities) {
        List ids =new ArrayList();
        for(PcmProfileSzyjtj entity : entities){
            Serializable id=entity.getPcmprofileszyjtjid();
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



