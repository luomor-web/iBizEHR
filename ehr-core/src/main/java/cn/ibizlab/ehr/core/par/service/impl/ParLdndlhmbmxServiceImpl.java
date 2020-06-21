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
import cn.ibizlab.ehr.core.par.domain.ParLdndlhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParLdndlhmbmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParLdndlhmbmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParLdndlhmbmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（公司领导类 ）] 服务对象接口实现
 */
@Slf4j
@Service("ParLdndlhmbmxServiceImpl")
public class ParLdndlhmbmxServiceImpl extends ServiceImpl<ParLdndlhmbmxMapper, ParLdndlhmbmx> implements IParLdndlhmbmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParLdndlhmbService parldndlhmbService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ParLdndlhmbmx get(String key) {
        ParLdndlhmbmx et = getById(key);
        if(et==null){
            et=new ParLdndlhmbmx();
            et.setParldndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ParLdndlhmbmx getDraft(ParLdndlhmbmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParLdndlhmbmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParldndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParLdndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParLdndlhmbmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParLdndlhmbmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParLdndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParLdndlhmbmx> list) {
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
    public boolean checkKey(ParLdndlhmbmx et) {
        return (!ObjectUtils.isEmpty(et.getParldndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParldndlhmbmxid())));
    }
    @Override
    @Transactional
    public boolean update(ParLdndlhmbmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parldndlhmbmxid",et.getParldndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParldndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParLdndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<ParLdndlhmbmx> selectByParldndlhmbid(String parldndlhmbid) {
        return baseMapper.selectByParldndlhmbid(parldndlhmbid);
    }

    @Override
    public void removeByParldndlhmbid(String parldndlhmbid) {
        this.remove(new QueryWrapper<ParLdndlhmbmx>().eq("parldndlhmbid",parldndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParLdndlhmbmx> searchDefault(ParLdndlhmbmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParLdndlhmbmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParLdndlhmbmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParLdndlhmbmx et){
        //实体关系[DER1N_PARLDNDLHMBMX_PARLDNDLHMB_PARLDNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParldndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.ParLdndlhmb parldndlhmb=et.getParldndlhmb();
            if(ObjectUtils.isEmpty(parldndlhmb)){
                cn.ibizlab.ehr.core.par.domain.ParLdndlhmb majorEntity=parldndlhmbService.get(et.getParldndlhmbid());
                et.setParldndlhmb(majorEntity);
                parldndlhmb=majorEntity;
            }
            et.setParldndlhmbname(parldndlhmb.getParldndlhmbname());
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
    public List<ParLdndlhmbmx> getParldndlhmbmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParLdndlhmbmx> getParldndlhmbmxByEntities(List<ParLdndlhmbmx> entities) {
        List ids =new ArrayList();
        for(ParLdndlhmbmx entity : entities){
            Serializable id=entity.getParldndlhmbmxid();
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



