package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmSignOrg;
import cn.ibizlab.ehr.core.orm.filter.OrmSignOrgSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmSignOrgMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[法人主体] 服务对象接口实现
 */
@Slf4j
@Service("OrmSignOrgServiceImpl")
public class OrmSignOrgServiceImpl extends ServiceImpl<OrmSignOrgMapper, OrmSignOrg> implements IOrmSignOrgService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractSignOrgService pimcontractsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(OrmSignOrg et) {
        return (!ObjectUtils.isEmpty(et.getOrmsignorgid()))&&(!Objects.isNull(this.getById(et.getOrmsignorgid())));
    }
    @Override
    @Transactional
    public boolean update(OrmSignOrg et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormsignorgid",et.getOrmsignorgid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmsignorgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmSignOrg> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrmSignOrg et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmSignOrg et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmSignOrg> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmSignOrg> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public OrmSignOrg getDraft(OrmSignOrg et) {
        return et;
    }

    @Override
    @Transactional
    public OrmSignOrg get(String key) {
        OrmSignOrg et = getById(key);
        if(et==null){
            et=new OrmSignOrg();
            et.setOrmsignorgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmSignOrg et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmsignorgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmSignOrg> list) {
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



    /**
     * 查询集合 合同签订单位
     */
    @Override
    public Page<OrmSignOrg> searchHTQDDW(OrmSignOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmSignOrg> pages=baseMapper.searchHTQDDW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmSignOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmSignOrg> searchDefault(OrmSignOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmSignOrg> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmSignOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 证书注册单位
     */
    @Override
    public Page<OrmSignOrg> searchCKBDWDFRZT(OrmSignOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmSignOrg> pages=baseMapper.searchCKBDWDFRZT(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmSignOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmSignOrg> getOrmsignorgByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmSignOrg> getOrmsignorgByEntities(List<OrmSignOrg> entities) {
        List ids =new ArrayList();
        for(OrmSignOrg entity : entities){
            Serializable id=entity.getOrmsignorgid();
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



