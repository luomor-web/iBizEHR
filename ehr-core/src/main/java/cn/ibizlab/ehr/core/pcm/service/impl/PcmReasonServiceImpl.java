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
import cn.ibizlab.ehr.core.pcm.domain.PcmReason;
import cn.ibizlab.ehr.core.pcm.filter.PcmReasonSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmReasonService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmReasonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[配置原因代码表] 服务对象接口实现
 */
@Slf4j
@Service("PcmReasonServiceImpl")
public class PcmReasonServiceImpl extends ServiceImpl<PcmReasonMapper, PcmReason> implements IPcmReasonService {


    private int batchSize = 500;

    @Override
    public PcmReason getDraft(PcmReason et) {
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
    @Transactional
    public boolean update(PcmReason et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmreasonid",et.getPcmreasonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmreasonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmReason> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmReason get(String key) {
        PcmReason et = getById(key);
        if(et==null){
            et=new PcmReason();
            et.setPcmreasonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmReason et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmreasonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmReason> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmReason et) {
        return (!ObjectUtils.isEmpty(et.getPcmreasonid()))&&(!Objects.isNull(this.getById(et.getPcmreasonid())));
    }
    @Override
    @Transactional
    public boolean save(PcmReason et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmReason et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmReason> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmReason> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmReason> searchDefault(PcmReasonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmReason> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmReason>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmReason> getPcmreasonByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmReason> getPcmreasonByEntities(List<PcmReason> entities) {
        List ids =new ArrayList();
        for(PcmReason entity : entities){
            Serializable id=entity.getPcmreasonid();
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



