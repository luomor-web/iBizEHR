package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.ParLhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParLhmbmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParLhmbmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParLhmbmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效量化目标明细] 服务对象接口实现
 */
@Slf4j
@Service("ParLhmbmxServiceImpl")
public class ParLhmbmxServiceImpl extends ServiceImpl<ParLhmbmxMapper, ParLhmbmx> implements IParLhmbmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxlhmbService parjxlhmbService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(ParLhmbmx et) {
        return (!ObjectUtils.isEmpty(et.getParlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParlhmbmxid())));
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
    public boolean save(ParLhmbmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParLhmbmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParLhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParLhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ParLhmbmx getDraft(ParLhmbmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ParLhmbmx get(String key) {
        ParLhmbmx et = getById(key);
        if(et==null){
            et=new ParLhmbmx();
            et.setParlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(ParLhmbmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parlhmbmxid",et.getParlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParLhmbmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ParLhmbmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParLhmbmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ParLhmbmx> selectByParjxlhmbid(String parjxlhmbid) {
        return baseMapper.selectByParjxlhmbid(parjxlhmbid);
    }

    @Override
    public void removeByParjxlhmbid(String parjxlhmbid) {
        this.remove(new QueryWrapper<ParLhmbmx>().eq("parjxlhmbid",parjxlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParLhmbmx> searchDefault(ParLhmbmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParLhmbmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParLhmbmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParLhmbmx et){
        //实体关系[DER1N_PARLHMBMX_PARJXLHMB_PARJXLHMBID]
        if(!ObjectUtils.isEmpty(et.getParjxlhmbid())){
            cn.ibizlab.ehr.core.par.domain.ParJxlhmb parjxlhmb=et.getParjxlhmb();
            if(ObjectUtils.isEmpty(parjxlhmb)){
                cn.ibizlab.ehr.core.par.domain.ParJxlhmb majorEntity=parjxlhmbService.get(et.getParjxlhmbid());
                et.setParjxlhmb(majorEntity);
                parjxlhmb=majorEntity;
            }
            et.setParjxlhmbname(parjxlhmb.getParjxlhmbname());
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
    public List<ParLhmbmx> getParlhmbmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParLhmbmx> getParlhmbmxByEntities(List<ParLhmbmx> entities) {
        List ids =new ArrayList();
        for(ParLhmbmx entity : entities){
            Serializable id=entity.getParlhmbmxid();
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



