package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.WFQJ;
import cn.ibizlab.ehr.core.vac.filter.WFQJSearchContext;
import cn.ibizlab.ehr.core.vac.service.IWFQJService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.WFQJMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假（WF）] 服务对象接口实现
 */
@Slf4j
@Service("WFQJServiceImpl")
public class WFQJServiceImpl extends ServiceImpl<WFQJMapper, WFQJ> implements IWFQJService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(WFQJ et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfqjid",et.getWfqjid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfqjid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFQJ> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(WFQJ et) {
        return (!ObjectUtils.isEmpty(et.getWfqjid()))&&(!Objects.isNull(this.getById(et.getWfqjid())));
    }

    @Override
    @Transactional
    public boolean create(WFQJ et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfqjid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFQJ> list) {
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFQJ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFQJ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFQJ> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WFQJ getDraft(WFQJ et) {
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
    public WFQJ get(String key) {
        WFQJ et = getById(key);
        if(et==null){
            et=new WFQJ();
            et.setWfqjid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFQJ> searchDefault(WFQJSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFQJ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFQJ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(WFQJSearchContext context){

        if(!StringUtils.isEmpty(context.getUserTaskId()) && !StringUtils.isEmpty(context.getProcessDefinitionKey())){
            List<String> businessKeys= ibzwfFeignClient.getbusinesskeysByUserId("ehr", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser().getUserid(),"wfqjs",context.getProcessDefinitionKey(),context.getUserTaskId());
            if(businessKeys.size()>0){
                context.getSelectCond().in("wfqjid",businessKeys);
            }
            else{
                context.getSelectCond().apply("1<>1");
            }
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

}


