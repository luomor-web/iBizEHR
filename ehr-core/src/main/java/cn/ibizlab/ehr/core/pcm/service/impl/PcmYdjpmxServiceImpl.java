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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjpmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjpmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdjpmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmYdjpmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动解聘明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmYdjpmxServiceImpl")
public class PcmYdjpmxServiceImpl extends ServiceImpl<PcmYdjpmxMapper, PcmYdjpmx> implements IPcmYdjpmxService {


    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdjpmxSetFinishedLogic setfinishedLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmYdjpmx fillPersonInfo(PcmYdjpmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmYdjpmx et) {
        pcmydmxService.update(pcmydjpmxInheritMapping.toPcmydmx(et));
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydjpmxid",et.getPcmydjpmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjpmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmYdjpmx> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public PcmYdjpmx getDraft(PcmYdjpmx et) {
        return et;
    }

    @Override
    public boolean checkKey(PcmYdjpmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmydjpmxid()))&&(!Objects.isNull(this.getById(et.getPcmydjpmxid())));
    }
    @Override
    @Transactional
    public boolean save(PcmYdjpmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmYdjpmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmYdjpmx> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmYdjpmx> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmYdjpmx isFinished(PcmYdjpmx et) {
        setfinishedLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmYdjpmx get(String key) {
        PcmYdjpmx et = getById(key);
        if(et==null){
            et=new PcmYdjpmx();
            et.setPcmydjpmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmYdjpmx et) {
        createIndexMajorEntityData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjpmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmYdjpmx> list) {
        this.saveBatch(list,batchSize);
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
     * 查询集合 记录查询
     */
    @Override
    public Page<PcmYdjpmx> searchJLDS(PcmYdjpmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdjpmx> pages=baseMapper.searchJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdjpmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmYdjpmx> searchDefault(PcmYdjpmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdjpmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdjpmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PcmYdjpmx> searchGLDS(PcmYdjpmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdjpmx> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdjpmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }






    @Autowired
    cn.ibizlab.ehr.core.pcm.mapping.PcmYdjpmxInheritMapping pcmydjpmxInheritMapping;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;

    /**
     * 创建索引主实体数据
     * @param et
     */
    private void createIndexMajorEntityData(PcmYdjpmx et){
        if(ObjectUtils.isEmpty(et.getPcmydjpmxid()))
            et.setPcmydjpmxid((String)et.getDefaultKey(true));
        cn.ibizlab.ehr.core.pcm.domain.PcmYdmx pcmydmx =pcmydjpmxInheritMapping.toPcmydmx(et);
        pcmydmx.set("pcmydmxtype","40");
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
    public List<PcmYdjpmx> getPcmydjpmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmYdjpmx> getPcmydjpmxByEntities(List<PcmYdjpmx> entities) {
        List ids =new ArrayList();
        for(PcmYdjpmx entity : entities){
            Serializable id=entity.getPcmydjpmxid();
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



