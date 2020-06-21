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
import cn.ibizlab.ehr.core.par.domain.ParBmfzjyx;
import cn.ibizlab.ehr.core.par.filter.ParBmfzjyxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParBmfzjyxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParBmfzjyxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[通知选择部门副职及以下] 服务对象接口实现
 */
@Slf4j
@Service("ParBmfzjyxServiceImpl")
public class ParBmfzjyxServiceImpl extends ServiceImpl<ParBmfzjyxMapper, ParBmfzjyx> implements IParBmfzjyxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParTzggService partzggService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(ParBmfzjyx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParBmfzjyx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParBmfzjyx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParBmfzjyx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ParBmfzjyx getDraft(ParBmfzjyx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParBmfzjyx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParbmfzjyxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParBmfzjyx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ParBmfzjyx et) {
        return (!ObjectUtils.isEmpty(et.getParbmfzjyxid()))&&(!Objects.isNull(this.getById(et.getParbmfzjyxid())));
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
    public boolean update(ParBmfzjyx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parbmfzjyxid",et.getParbmfzjyxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParbmfzjyxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParBmfzjyx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ParBmfzjyx get(String key) {
        ParBmfzjyx et = getById(key);
        if(et==null){
            et=new ParBmfzjyx();
            et.setParbmfzjyxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<ParBmfzjyx> selectByPartzggid(String partzggid) {
        return baseMapper.selectByPartzggid(partzggid);
    }

    @Override
    public void removeByPartzggid(String partzggid) {
        this.remove(new QueryWrapper<ParBmfzjyx>().eq("partzggid",partzggid));
    }

	@Override
    public List<ParBmfzjyx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ParBmfzjyx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParBmfzjyx> searchDefault(ParBmfzjyxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParBmfzjyx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParBmfzjyx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParBmfzjyx et){
        //实体关系[DER1N_PARBMFZJYX_PARTZGG_PARTZGGID]
        if(!ObjectUtils.isEmpty(et.getPartzggid())){
            cn.ibizlab.ehr.core.par.domain.ParTzgg partzgg=et.getPartzgg();
            if(ObjectUtils.isEmpty(partzgg)){
                cn.ibizlab.ehr.core.par.domain.ParTzgg majorEntity=partzggService.get(et.getPartzggid());
                et.setPartzgg(majorEntity);
                partzgg=majorEntity;
            }
            et.setPartzggname(partzgg.getPartzggname());
        }
        //实体关系[DER1N_PARBMFZJYX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setSsbm(pimperson.getOrmorgsectorname());
            et.setSszz(pimperson.getOrmorgname());
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
    public List<ParBmfzjyx> getParbmfzjyxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParBmfzjyx> getParbmfzjyxByEntities(List<ParBmfzjyx> entities) {
        List ids =new ArrayList();
        for(ParBmfzjyx entity : entities){
            Serializable id=entity.getParbmfzjyxid();
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



