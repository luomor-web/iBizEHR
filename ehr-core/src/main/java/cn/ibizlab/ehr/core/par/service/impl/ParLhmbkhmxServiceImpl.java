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
import cn.ibizlab.ehr.core.par.domain.ParLhmbkhmx;
import cn.ibizlab.ehr.core.par.filter.ParLhmbkhmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParLhmbkhmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParLhmbkhmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[量化目标考核明细] 服务对象接口实现
 */
@Slf4j
@Service("ParLhmbkhmxServiceImpl")
public class ParLhmbkhmxServiceImpl extends ServiceImpl<ParLhmbkhmxMapper, ParLhmbkhmx> implements IParLhmbkhmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARNDLHMBKHService parndlhmbkhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ParLhmbkhmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parlhmbkhmxid",et.getParlhmbkhmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbkhmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParLhmbkhmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ParLhmbkhmx getDraft(ParLhmbkhmx et) {
        fillParentData(et);
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
    public boolean save(ParLhmbkhmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParLhmbkhmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParLhmbkhmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParLhmbkhmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ParLhmbkhmx et) {
        return (!ObjectUtils.isEmpty(et.getParlhmbkhmxid()))&&(!Objects.isNull(this.getById(et.getParlhmbkhmxid())));
    }

    @Override
    @Transactional
    public ParLhmbkhmx get(String key) {
        ParLhmbkhmx et = getById(key);
        if(et==null){
            et=new ParLhmbkhmx();
            et.setParlhmbkhmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParLhmbkhmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbkhmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParLhmbkhmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ParLhmbkhmx> selectByParndlhmbkhid(String parndlhmbkhid) {
        return baseMapper.selectByParndlhmbkhid(parndlhmbkhid);
    }

    @Override
    public void removeByParndlhmbkhid(String parndlhmbkhid) {
        this.remove(new QueryWrapper<ParLhmbkhmx>().eq("parndlhmbkhid",parndlhmbkhid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParLhmbkhmx> searchDefault(ParLhmbkhmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParLhmbkhmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParLhmbkhmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParLhmbkhmx et){
        //实体关系[DER1N_PARLHMBKHMX_PARNDLHMBKH_PARNDLHMBKHID]
        if(!ObjectUtils.isEmpty(et.getParndlhmbkhid())){
            cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH parndlhmbkh=et.getParndlhmbkh();
            if(ObjectUtils.isEmpty(parndlhmbkh)){
                cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH majorEntity=parndlhmbkhService.get(et.getParndlhmbkhid());
                et.setParndlhmbkh(majorEntity);
                parndlhmbkh=majorEntity;
            }
            et.setParndlhmbkhname(parndlhmbkh.getParndlhmbkhname());
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
    public List<ParLhmbkhmx> getParlhmbkhmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParLhmbkhmx> getParlhmbkhmxByEntities(List<ParLhmbkhmx> entities) {
        List ids =new ArrayList();
        for(ParLhmbkhmx entity : entities){
            Serializable id=entity.getParlhmbkhmxid();
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


