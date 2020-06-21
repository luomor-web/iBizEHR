package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SALPERSONSTDDETAIL;
import cn.ibizlab.ehr.core.sal.filter.SALPERSONSTDDETAILSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDDETAILService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALPERSONSTDDETAILMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工薪酬标准明细] 服务对象接口实现
 */
@Slf4j
@Service("SALPERSONSTDDETAILServiceImpl")
public class SALPERSONSTDDETAILServiceImpl extends ServiceImpl<SALPERSONSTDDETAILMapper, SALPERSONSTDDETAIL> implements ISALPERSONSTDDETAILService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService salschemeitemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SALPERSONSTDDETAIL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALPERSONSTDDETAIL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SALPERSONSTDDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SALPERSONSTDDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SALPERSONSTDDETAIL et) {
        return (!ObjectUtils.isEmpty(et.getSalpersonstddetailid()))&&(!Objects.isNull(this.getById(et.getSalpersonstddetailid())));
    }
    @Override
    @Transactional
    public boolean create(SALPERSONSTDDETAIL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalpersonstddetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALPERSONSTDDETAIL> list) {
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
    @Transactional
    public SALPERSONSTDDETAIL get(String key) {
        SALPERSONSTDDETAIL et = getById(key);
        if(et==null){
            et=new SALPERSONSTDDETAIL();
            et.setSalpersonstddetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SALPERSONSTDDETAIL getDraft(SALPERSONSTDDETAIL et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(SALPERSONSTDDETAIL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salpersonstddetailid",et.getSalpersonstddetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalpersonstddetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALPERSONSTDDETAIL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<SALPERSONSTDDETAIL> selectBySalpersonstdid(String salpersonstdid) {
        return baseMapper.selectBySalpersonstdid(salpersonstdid);
    }

    @Override
    public void removeBySalpersonstdid(String salpersonstdid) {
        this.remove(new QueryWrapper<SALPERSONSTDDETAIL>().eq("salpersonstdid",salpersonstdid));
    }

	@Override
    public List<SALPERSONSTDDETAIL> selectBySalschemeitemid(String salschemeitemid) {
        return baseMapper.selectBySalschemeitemid(salschemeitemid);
    }

    @Override
    public void removeBySalschemeitemid(String salschemeitemid) {
        this.remove(new QueryWrapper<SALPERSONSTDDETAIL>().eq("salschemeitemid",salschemeitemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALPERSONSTDDETAIL> searchDefault(SALPERSONSTDDETAILSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALPERSONSTDDETAIL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALPERSONSTDDETAIL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALPERSONSTDDETAIL et){
        //实体关系[DER1N_SALPERSONSTDDETAIL_SALPERSONSTD_SALPERSONSTDID]
        if(!ObjectUtils.isEmpty(et.getSalpersonstdid())){
            cn.ibizlab.ehr.core.sal.domain.SalPersonStd salpersonstd=et.getSalpersonstd();
            if(ObjectUtils.isEmpty(salpersonstd)){
                cn.ibizlab.ehr.core.sal.domain.SalPersonStd majorEntity=salpersonstdService.get(et.getSalpersonstdid());
                et.setSalpersonstd(majorEntity);
                salpersonstd=majorEntity;
            }
            et.setSalpersonstdname(salpersonstd.getSalpersonstdname());
        }
        //实体关系[DER1N_SALPERSONSTDDETAIL_SALSCHEMEITEM_SALSCHEMEITEMID]
        if(!ObjectUtils.isEmpty(et.getSalschemeitemid())){
            cn.ibizlab.ehr.core.sal.domain.SalSchemeItem salschemeitem=et.getSalschemeitem();
            if(ObjectUtils.isEmpty(salschemeitem)){
                cn.ibizlab.ehr.core.sal.domain.SalSchemeItem majorEntity=salschemeitemService.get(et.getSalschemeitemid());
                et.setSalschemeitem(majorEntity);
                salschemeitem=majorEntity;
            }
            et.setSalschemeitemname(salschemeitem.getSalschemeitemname());
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
    public List<SALPERSONSTDDETAIL> getSalpersonstddetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SALPERSONSTDDETAIL> getSalpersonstddetailByEntities(List<SALPERSONSTDDETAIL> entities) {
        List ids =new ArrayList();
        for(SALPERSONSTDDETAIL entity : entities){
            Serializable id=entity.getSalpersonstddetailid();
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



