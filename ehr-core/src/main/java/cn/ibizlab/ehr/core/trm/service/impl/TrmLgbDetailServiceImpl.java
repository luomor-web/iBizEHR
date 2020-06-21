package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TrmLgbDetail;
import cn.ibizlab.ehr.core.trm.filter.TrmLgbDetailSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmLgbDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmLgbDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[老干部明细] 服务对象接口实现
 */
@Slf4j
@Service("TrmLgbDetailServiceImpl")
public class TrmLgbDetailServiceImpl extends ServiceImpl<TrmLgbDetailMapper, TrmLgbDetail> implements ITrmLgbDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmLgbCostService trmlgbcostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(TrmLgbDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmlgbdetailid",et.getTrmlgbdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmlgbdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmLgbDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public TrmLgbDetail get(String key) {
        TrmLgbDetail et = getById(key);
        if(et==null){
            et=new TrmLgbDetail();
            et.setTrmlgbdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(TrmLgbDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmLgbDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmLgbDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmLgbDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmLgbDetail et) {
        return (!ObjectUtils.isEmpty(et.getTrmlgbdetailid()))&&(!Objects.isNull(this.getById(et.getTrmlgbdetailid())));
    }
    @Override
    public TrmLgbDetail getDraft(TrmLgbDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmLgbDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmlgbdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmLgbDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public List<TrmLgbDetail> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TrmLgbDetail>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TrmLgbDetail> selectByTrmlgbcostid(String trmlgbcostid) {
        return baseMapper.selectByTrmlgbcostid(trmlgbcostid);
    }

    @Override
    public void removeByTrmlgbcostid(String trmlgbcostid) {
        this.remove(new QueryWrapper<TrmLgbDetail>().eq("trmlgbcostid",trmlgbcostid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmLgbDetail> searchDefault(TrmLgbDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmLgbDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmLgbDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmLgbDetail et){
        //实体关系[DER1N_TRMLGBDETAIL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setZjhm(pimperson.getZjhm());
        }
        //实体关系[DER1N_TRMLGBDETAIL_TRMLGBCOST_TRMLGBCOSTID]
        if(!ObjectUtils.isEmpty(et.getTrmlgbcostid())){
            cn.ibizlab.ehr.core.trm.domain.TrmLgbCost trmlgbcost=et.getTrmlgbcost();
            if(ObjectUtils.isEmpty(trmlgbcost)){
                cn.ibizlab.ehr.core.trm.domain.TrmLgbCost majorEntity=trmlgbcostService.get(et.getTrmlgbcostid());
                et.setTrmlgbcost(majorEntity);
                trmlgbcost=majorEntity;
            }
            et.setTrmlgbcostname(trmlgbcost.getTrmlgbcostname());
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
    public List<TrmLgbDetail> getTrmlgbdetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmLgbDetail> getTrmlgbdetailByEntities(List<TrmLgbDetail> entities) {
        List ids =new ArrayList();
        for(TrmLgbDetail entity : entities){
            Serializable id=entity.getTrmlgbdetailid();
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



