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
import cn.ibizlab.ehr.core.pcm.domain.PcmMonth;
import cn.ibizlab.ehr.core.pcm.filter.PcmMonthSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmMonthService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmMonthMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[月份参考表] 服务对象接口实现
 */
@Slf4j
@Service("PcmMonthServiceImpl")
public class PcmMonthServiceImpl extends ServiceImpl<PcmMonthMapper, PcmMonth> implements IPcmMonthService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PcmMonth et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmmonthid",et.getPcmmonthid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmmonthid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmMonth> list) {
        updateBatchById(list,batchSize);
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
    public boolean save(PcmMonth et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmMonth et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmMonth> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmMonth> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmMonth et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmmonthid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmMonth> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmMonth et) {
        return (!ObjectUtils.isEmpty(et.getPcmmonthid()))&&(!Objects.isNull(this.getById(et.getPcmmonthid())));
    }
    @Override
    @Transactional
    public PcmMonth get(String key) {
        PcmMonth et = getById(key);
        if(et==null){
            et=new PcmMonth();
            et.setPcmmonthid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PcmMonth getDraft(PcmMonth et) {
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmMonth> searchDefault(PcmMonthSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmMonth> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmMonth>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmMonth> getPcmmonthByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmMonth> getPcmmonthByEntities(List<PcmMonth> entities) {
        List ids =new ArrayList();
        for(PcmMonth entity : entities){
            Serializable id=entity.getPcmmonthid();
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



