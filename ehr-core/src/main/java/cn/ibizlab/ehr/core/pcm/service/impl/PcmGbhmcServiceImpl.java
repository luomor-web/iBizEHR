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
import cn.ibizlab.ehr.core.pcm.domain.PcmGbhmc;
import cn.ibizlab.ehr.core.pcm.filter.PcmGbhmcSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmGbhmcService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmGbhmcMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[干部花名册] 服务对象接口实现
 */
@Slf4j
@Service("PcmGbhmcServiceImpl")
public class PcmGbhmcServiceImpl extends ServiceImpl<PcmGbhmcMapper, PcmGbhmc> implements IPcmGbhmcService {


    private int batchSize = 500;

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
    public PcmGbhmc get(String key) {
        PcmGbhmc et = getById(key);
        if(et==null){
            et=new PcmGbhmc();
            et.setPimpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmGbhmc toggleLeader(PcmGbhmc et) {
        //自定义代码
        return et;
    }

    @Override
    public PcmGbhmc getDraft(PcmGbhmc et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmGbhmc et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmGbhmc> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PcmGbhmc et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonid",et.getPimpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmGbhmc> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmGbhmc et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmGbhmc et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmGbhmc> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmGbhmc> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmGbhmc sGTG(PcmGbhmc et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmGbhmc et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonid()))&&(!Objects.isNull(this.getById(et.getPimpersonid())));
    }
    @Override
    @Transactional
    public PcmGbhmc sGBTG(PcmGbhmc et) {
        //自定义代码
        return et;
    }



    /**
     * 查询集合 树视图的干部花名册（新）
     */
    @Override
    public Page<PcmGbhmc> searchGBHMCNewTree(PcmGbhmcSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmGbhmc> pages=baseMapper.searchGBHMCNewTree(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmGbhmc>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 树视图的干部花名册
     */
    @Override
    public Page<PcmGbhmc> searchGBHMCTree(PcmGbhmcSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmGbhmc> pages=baseMapper.searchGBHMCTree(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmGbhmc>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmGbhmc> searchDefault(PcmGbhmcSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmGbhmc> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmGbhmc>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 ZJPD
     */
    @Override
    public Page<PcmGbhmc> searchZJPD(PcmGbhmcSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmGbhmc> pages=baseMapper.searchZJPD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmGbhmc>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmGbhmc> getPcmgbhmcByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmGbhmc> getPcmgbhmcByEntities(List<PcmGbhmc> entities) {
        List ids =new ArrayList();
        for(PcmGbhmc entity : entities){
            Serializable id=entity.getPimpersonid();
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



