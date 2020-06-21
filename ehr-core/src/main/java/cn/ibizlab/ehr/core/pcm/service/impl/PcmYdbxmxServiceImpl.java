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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdbxmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdbxmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmYdbxmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动病休明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmYdbxmxServiceImpl")
public class PcmYdbxmxServiceImpl extends ServiceImpl<PcmYdbxmxMapper, PcmYdbxmx> implements IPcmYdbxmxService {


    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdbxmxSetFinishedLogic setfinishedLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmYdbxmx get(String key) {
        PcmYdbxmx et = getById(key);
        if(et==null){
            et=new PcmYdbxmx();
            et.setPcmydbxmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmYdbxmx fillPersonInfo(PcmYdbxmx et) {
        //自定义代码
        return et;
    }

    @Override
    public PcmYdbxmx getDraft(PcmYdbxmx et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmYdbxmx et) {
        setfinishedLogic.execute(et);
        pcmydmxService.update(pcmydbxmxInheritMapping.toPcmydmx(et));
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydbxmxid",et.getPcmydbxmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydbxmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmYdbxmx> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmYdbxmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmydbxmxid()))&&(!Objects.isNull(this.getById(et.getPcmydbxmxid())));
    }
    @Override
    @Transactional
    public boolean save(PcmYdbxmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmYdbxmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmYdbxmx> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmYdbxmx> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmYdbxmx finishBX(PcmYdbxmx et) {
        //自定义代码
        return et;
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

    @Override
    @Transactional
    public boolean create(PcmYdbxmx et) {
        createIndexMajorEntityData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydbxmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmYdbxmx> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PcmYdbxmx> searchGLDS(PcmYdbxmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdbxmx> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdbxmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmYdbxmx> searchDefault(PcmYdbxmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdbxmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdbxmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PcmYdbxmx> searchJLDS(PcmYdbxmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdbxmx> pages=baseMapper.searchJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdbxmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }






    @Autowired
    cn.ibizlab.ehr.core.pcm.mapping.PcmYdbxmxInheritMapping pcmydbxmxInheritMapping;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;

    /**
     * 创建索引主实体数据
     * @param et
     */
    private void createIndexMajorEntityData(PcmYdbxmx et){
        if(ObjectUtils.isEmpty(et.getPcmydbxmxid()))
            et.setPcmydbxmxid((String)et.getDefaultKey(true));
        cn.ibizlab.ehr.core.pcm.domain.PcmYdmx pcmydmx =pcmydbxmxInheritMapping.toPcmydmx(et);
        pcmydmx.set("pcmydmxtype","80");
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
    public List<PcmYdbxmx> getPcmydbxmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmYdbxmx> getPcmydbxmxByEntities(List<PcmYdbxmx> entities) {
        List ids =new ArrayList();
        for(PcmYdbxmx entity : entities){
            Serializable id=entity.getPcmydbxmxid();
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



