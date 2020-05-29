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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDNTMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDNTMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDNTMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDNTMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动内退明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDNTMXServiceImpl")
public class PCMYDNTMXServiceImpl extends ServiceImpl<PCMYDNTMXMapper, PCMYDNTMX> implements IPCMYDNTMXService {


    private int batchSize = 500;

    @Override
    public PCMYDNTMX getDraft(PCMYDNTMX et) {
        return et;
    }

    @Override
    public boolean checkKey(PCMYDNTMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydntmxid()))&&(!Objects.isNull(this.getById(et.getPcmydntmxid())));
    }

    @Override
    @Transactional
    public PCMYDNTMX get(String key) {
        PCMYDNTMX et = getById(key);
        if(et==null){
            et=new PCMYDNTMX();
            et.setPcmydntmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMYDNTMX et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydntmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDNTMX> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMYDNTMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDNTMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMYDNTMX> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMYDNTMX> list) {
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

    @Override
    @Transactional
    public PCMYDNTMX fillPersonInfo(PCMYDNTMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDNTMX et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydntmxid",et.getPcmydntmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydntmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDNTMX> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDNTMX finishNT(PCMYDNTMX et) {
        //自定义代码
        return et;
    }



    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PCMYDNTMX> searchJLDS(PCMYDNTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDNTMX> pages=baseMapper.searchJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDNTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDNTMX> searchDefault(PCMYDNTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDNTMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDNTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PCMYDNTMX> searchGLDS(PCMYDNTMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDNTMX> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDNTMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PCMYDNTMX> getPcmydntmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMYDNTMX> getPcmydntmxByEntities(List<PCMYDNTMX> entities) {
        List ids =new ArrayList();
        for(PCMYDNTMX entity : entities){
            Serializable id=entity.getPcmydntmxid();
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


