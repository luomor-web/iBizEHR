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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxbz;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxbzSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmTxbzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmTxbzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[退休标准管理] 服务对象接口实现
 */
@Slf4j
@Service("PcmTxbzServiceImpl")
public class PcmTxbzServiceImpl extends ServiceImpl<PcmTxbzMapper, PcmTxbz> implements IPcmTxbzService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(PcmTxbz et) {
        return (!ObjectUtils.isEmpty(et.getPcmtxbzid()))&&(!Objects.isNull(this.getById(et.getPcmtxbzid())));
    }
    @Override
    @Transactional
    public PcmTxbz get(String key) {
        PcmTxbz et = getById(key);
        if(et==null){
            et=new PcmTxbz();
            et.setPcmtxbzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PcmTxbz getDraft(PcmTxbz et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmTxbz et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmtxbzid",et.getPcmtxbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmTxbz> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmTxbz et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmTxbz> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmTxbz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmTxbz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmTxbz> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmTxbz> list) {
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmTxbz> searchDefault(PcmTxbzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmTxbz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmTxbz>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmTxbz> getPcmtxbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmTxbz> getPcmtxbzByEntities(List<PcmTxbz> entities) {
        List ids =new ArrayList();
        for(PcmTxbz entity : entities){
            Serializable id=entity.getPcmtxbzid();
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



