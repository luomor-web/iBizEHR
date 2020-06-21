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
import cn.ibizlab.ehr.core.par.domain.ParYdgzjhmx;
import cn.ibizlab.ehr.core.par.filter.ParYdgzjhmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParYdgzjhmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParYdgzjhmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[月度工作计划明细] 服务对象接口实现
 */
@Slf4j
@Service("ParYdgzjhmxServiceImpl")
public class ParYdgzjhmxServiceImpl extends ServiceImpl<ParYdgzjhmxMapper, ParYdgzjhmx> implements IParYdgzjhmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParYdgzjhService parydgzjhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ParYdgzjhmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parydgzjhmxid",et.getParydgzjhmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParydgzjhmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParYdgzjhmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParYdgzjhmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParYdgzjhmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParYdgzjhmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParYdgzjhmx> list) {
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
    @Transactional
    public ParYdgzjhmx get(String key) {
        ParYdgzjhmx et = getById(key);
        if(et==null){
            et=new ParYdgzjhmx();
            et.setParydgzjhmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ParYdgzjhmx et) {
        return (!ObjectUtils.isEmpty(et.getParydgzjhmxid()))&&(!Objects.isNull(this.getById(et.getParydgzjhmxid())));
    }
    @Override
    public ParYdgzjhmx getDraft(ParYdgzjhmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParYdgzjhmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParydgzjhmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParYdgzjhmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ParYdgzjhmx> selectByParydgzjhid(String parydgzjhid) {
        return baseMapper.selectByParydgzjhid(parydgzjhid);
    }

    @Override
    public void removeByParydgzjhid(String parydgzjhid) {
        this.remove(new QueryWrapper<ParYdgzjhmx>().eq("parydgzjhid",parydgzjhid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParYdgzjhmx> searchDefault(ParYdgzjhmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParYdgzjhmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParYdgzjhmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParYdgzjhmx et){
        //实体关系[DER1N_PARYDGZJHMX_PARYDGZJH_PARYDGZJHID]
        if(!ObjectUtils.isEmpty(et.getParydgzjhid())){
            cn.ibizlab.ehr.core.par.domain.ParYdgzjh parydgzjh=et.getParydgzjh();
            if(ObjectUtils.isEmpty(parydgzjh)){
                cn.ibizlab.ehr.core.par.domain.ParYdgzjh majorEntity=parydgzjhService.get(et.getParydgzjhid());
                et.setParydgzjh(majorEntity);
                parydgzjh=majorEntity;
            }
            et.setParydgzjhname(parydgzjh.getParydgzjhname());
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
    public List<ParYdgzjhmx> getParydgzjhmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParYdgzjhmx> getParydgzjhmxByEntities(List<ParYdgzjhmx> entities) {
        List ids =new ArrayList();
        for(ParYdgzjhmx entity : entities){
            Serializable id=entity.getParydgzjhmxid();
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



