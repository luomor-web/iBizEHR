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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdgzmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdgzmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdgzmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmYdgzmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动挂职明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmYdgzmxServiceImpl")
public class PcmYdgzmxServiceImpl extends ServiceImpl<PcmYdgzmxMapper, PcmYdgzmx> implements IPcmYdgzmxService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PcmYdgzmx rYHG(PcmYdgzmx et) {
        //自定义代码
        return et;
    }

    @Override
    public PcmYdgzmx getDraft(PcmYdgzmx et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmYdgzmx et) {
        pcmydmxService.update(pcmydgzmxInheritMapping.toPcmydmx(et));
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydgzmxid",et.getPcmydgzmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydgzmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmYdgzmx> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmYdgzmx get(String key) {
        PcmYdgzmx et = getById(key);
        if(et==null){
            et=new PcmYdgzmx();
            et.setPcmydgzmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmYdgzmx fillPersonInfo(PcmYdgzmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmYdgzmx et) {
        createIndexMajorEntityData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydgzmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmYdgzmx> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmYdgzmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmYdgzmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmYdgzmx> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmYdgzmx> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmYdgzmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmydgzmxid()))&&(!Objects.isNull(this.getById(et.getPcmydgzmxid())));
    }
    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        pcmydmxService.remove(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }



    /**
     * 查询集合 挂职出人员查询
     */
    @Override
    public Page<PcmYdgzmx> searchGZCRYDQ(PcmYdgzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdgzmx> pages=baseMapper.searchGZCRYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdgzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职进历史记录查询
     */
    @Override
    public Page<PcmYdgzmx> searchGZJLSJLDQ(PcmYdgzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdgzmx> pages=baseMapper.searchGZJLSJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdgzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职进人员
     */
    @Override
    public Page<PcmYdgzmx> searchGZJRY(PcmYdgzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdgzmx> pages=baseMapper.searchGZJRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdgzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmYdgzmx> searchDefault(PcmYdgzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdgzmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdgzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职出历史记录查询
     */
    @Override
    public Page<PcmYdgzmx> searchGZCLSJLDQ(PcmYdgzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdgzmx> pages=baseMapper.searchGZCLSJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdgzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }






    @Autowired
    cn.ibizlab.ehr.core.pcm.mapping.PcmYdgzmxInheritMapping pcmydgzmxInheritMapping;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;

    /**
     * 创建索引主实体数据
     * @param et
     */
    private void createIndexMajorEntityData(PcmYdgzmx et){
        if(ObjectUtils.isEmpty(et.getPcmydgzmxid()))
            et.setPcmydgzmxid((String)et.getDefaultKey(true));
        cn.ibizlab.ehr.core.pcm.domain.PcmYdmx pcmydmx =pcmydgzmxInheritMapping.toPcmydmx(et);
        pcmydmx.set("pcmydmxtype","20");
        pcmydmxService.create(pcmydmx);
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
    public List<PcmYdgzmx> getPcmydgzmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmYdgzmx> getPcmydgzmxByEntities(List<PcmYdgzmx> entities) {
        List ids =new ArrayList();
        for(PcmYdgzmx entity : entities){
            Serializable id=entity.getPcmydgzmxid();
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



