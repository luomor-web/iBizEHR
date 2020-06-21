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
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParZnbmndlhmbmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（职能部门级 ）] 服务对象接口实现
 */
@Slf4j
@Service("ParZnbmndlhmbmxServiceImpl")
public class ParZnbmndlhmbmxServiceImpl extends ServiceImpl<ParZnbmndlhmbmxMapper, ParZnbmndlhmbmx> implements IParZnbmndlhmbmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbService parznbmndlhmbService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ParZnbmndlhmbmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParZnbmndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParZnbmndlhmbmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parznbmndlhmbmxid",et.getParznbmndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParZnbmndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ParZnbmndlhmbmx getDraft(ParZnbmndlhmbmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ParZnbmndlhmbmx get(String key) {
        ParZnbmndlhmbmx et = getById(key);
        if(et==null){
            et=new ParZnbmndlhmbmx();
            et.setParznbmndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ParZnbmndlhmbmx et) {
        return (!ObjectUtils.isEmpty(et.getParznbmndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParznbmndlhmbmxid())));
    }
    @Override
    @Transactional
    public boolean save(ParZnbmndlhmbmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParZnbmndlhmbmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParZnbmndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParZnbmndlhmbmx> list) {
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
    public List<ParZnbmndlhmbmx> selectByParznbmndlhmbid(String parznbmndlhmbid) {
        return baseMapper.selectByParznbmndlhmbid(parznbmndlhmbid);
    }

    @Override
    public void removeByParznbmndlhmbid(String parznbmndlhmbid) {
        this.remove(new QueryWrapper<ParZnbmndlhmbmx>().eq("parznbmndlhmbid",parznbmndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParZnbmndlhmbmx> searchDefault(ParZnbmndlhmbmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParZnbmndlhmbmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParZnbmndlhmbmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParZnbmndlhmbmx et){
        //实体关系[DER1N_PARZNBMNDLHMBMX_PARZNBMNDLHMB_PARZNBMNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParznbmndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb parznbmndlhmb=et.getParznbmndlhmb();
            if(ObjectUtils.isEmpty(parznbmndlhmb)){
                cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb majorEntity=parznbmndlhmbService.get(et.getParznbmndlhmbid());
                et.setParznbmndlhmb(majorEntity);
                parznbmndlhmb=majorEntity;
            }
            et.setParznbmndlhmbname(parznbmndlhmb.getParznbmndlhmbname());
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
    public List<ParZnbmndlhmbmx> getParznbmndlhmbmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParZnbmndlhmbmx> getParznbmndlhmbmxByEntities(List<ParZnbmndlhmbmx> entities) {
        List ids =new ArrayList();
        for(ParZnbmndlhmbmx entity : entities){
            Serializable id=entity.getParznbmndlhmbmxid();
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



