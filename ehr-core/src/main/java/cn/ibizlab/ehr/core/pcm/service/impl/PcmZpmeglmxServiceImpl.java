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
import cn.ibizlab.ehr.core.pcm.domain.PcmZpmeglmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmZpmeglmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmZpmeglmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmZpmeglmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[招聘名额管理明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmZpmeglmxServiceImpl")
public class PcmZpmeglmxServiceImpl extends ServiceImpl<PcmZpmeglmxMapper, PcmZpmeglmx> implements IPcmZpmeglmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmZpmeglService pcmzpmeglService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PcmZpmeglmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmzpmeglmxid()))&&(!Objects.isNull(this.getById(et.getPcmzpmeglmxid())));
    }
    @Override
    @Transactional
    public boolean create(PcmZpmeglmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmzpmeglmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmZpmeglmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmZpmeglmx get(String key) {
        PcmZpmeglmx et = getById(key);
        if(et==null){
            et=new PcmZpmeglmx();
            et.setPcmzpmeglmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PcmZpmeglmx getDraft(PcmZpmeglmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmZpmeglmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmzpmeglmxid",et.getPcmzpmeglmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmzpmeglmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmZpmeglmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmZpmeglmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmZpmeglmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmZpmeglmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmZpmeglmx> list) {
        list.forEach(item->fillParentData(item));
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
    public List<PcmZpmeglmx> selectByPcmzpmeglid(String pcmzpmeglid) {
        return baseMapper.selectByPcmzpmeglid(pcmzpmeglid);
    }

    @Override
    public void removeByPcmzpmeglid(String pcmzpmeglid) {
        this.remove(new QueryWrapper<PcmZpmeglmx>().eq("pcmzpmeglid",pcmzpmeglid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmZpmeglmx> searchDefault(PcmZpmeglmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmZpmeglmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmZpmeglmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmZpmeglmx et){
        //实体关系[DER1N_PCMZPMEGLMX_PCMZPMEGL_PCMZPMEGLID]
        if(!ObjectUtils.isEmpty(et.getPcmzpmeglid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmZpmegl pcmzpmegl=et.getPcmzpmegl();
            if(ObjectUtils.isEmpty(pcmzpmegl)){
                cn.ibizlab.ehr.core.pcm.domain.PcmZpmegl majorEntity=pcmzpmeglService.get(et.getPcmzpmeglid());
                et.setPcmzpmegl(majorEntity);
                pcmzpmegl=majorEntity;
            }
            et.setPcmzpmeglname(pcmzpmegl.getPcmzpmeglname());
        }
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
    public List<PcmZpmeglmx> getPcmzpmeglmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmZpmeglmx> getPcmzpmeglmxByEntities(List<PcmZpmeglmx> entities) {
        List ids =new ArrayList();
        for(PcmZpmeglmx entity : entities){
            Serializable id=entity.getPcmzpmeglmxid();
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



