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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileYjtjTemp;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileYjtjTempSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileYjtjTempService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmProfileYjtjTempMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者引进条件中间表（停用）] 服务对象接口实现
 */
@Slf4j
@Service("PcmProfileYjtjTempServiceImpl")
public class PcmProfileYjtjTempServiceImpl extends ServiceImpl<PcmProfileYjtjTempMapper, PcmProfileYjtjTemp> implements IPcmProfileYjtjTempService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PcmProfileYjtjTemp et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofileyjtjtempid",et.getPcmprofileyjtjtempid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileyjtjtempid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmProfileYjtjTemp> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public PcmProfileYjtjTemp getDraft(PcmProfileYjtjTemp et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmProfileYjtjTemp et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileyjtjtempid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmProfileYjtjTemp> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmProfileYjtjTemp et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofileyjtjtempid()))&&(!Objects.isNull(this.getById(et.getPcmprofileyjtjtempid())));
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
    public boolean save(PcmProfileYjtjTemp et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmProfileYjtjTemp et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmProfileYjtjTemp> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmProfileYjtjTemp> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmProfileYjtjTemp get(String key) {
        PcmProfileYjtjTemp et = getById(key);
        if(et==null){
            et=new PcmProfileYjtjTemp();
            et.setPcmprofileyjtjtempid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmProfileYjtjTemp> searchDefault(PcmProfileYjtjTempSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfileYjtjTemp> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfileYjtjTemp>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmProfileYjtjTemp> getPcmprofileyjtjtempByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmProfileYjtjTemp> getPcmprofileyjtjtempByEntities(List<PcmProfileYjtjTemp> entities) {
        List ids =new ArrayList();
        for(PcmProfileYjtjTemp entity : entities){
            Serializable id=entity.getPcmprofileyjtjtempid();
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



