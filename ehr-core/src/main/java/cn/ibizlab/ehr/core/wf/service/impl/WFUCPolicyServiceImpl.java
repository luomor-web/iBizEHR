package cn.ibizlab.ehr.core.wf.service.impl;

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
import cn.ibizlab.ehr.core.wf.domain.WFUCPolicy;
import cn.ibizlab.ehr.core.wf.filter.WFUCPolicySearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUCPolicyService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUCPolicyMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流候选用户策略] 服务对象接口实现
 */
@Slf4j
@Service("WFUCPolicyServiceImpl")
public class WFUCPolicyServiceImpl extends ServiceImpl<WFUCPolicyMapper, WFUCPolicy> implements IWFUCPolicyService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

    private int batchSize = 500;

    @Override
    @Transactional
    public WFUCPolicy get(String key) {
        WFUCPolicy et = getById(key);
        if(et==null){
            et=new WFUCPolicy();
            et.setWfucpolicyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public WFUCPolicy disablePolicy(WFUCPolicy et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFUCPolicy et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUCPolicy et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUCPolicy> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFUCPolicy et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfucpolicyid",et.getWfucpolicyid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfucpolicyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUCPolicy> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFUCPolicy et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfucpolicyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUCPolicy> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFUCPolicy enablePolicy(WFUCPolicy et) {
        //自定义代码
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
    public boolean checkKey(WFUCPolicy et) {
        return (!ObjectUtils.isEmpty(et.getWfucpolicyid()))&&(!Objects.isNull(this.getById(et.getWfucpolicyid())));
    }

    @Override
    public WFUCPolicy getDraft(WFUCPolicy et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<WFUCPolicy> selectByMajorwfuserid(String wfuserid) {
        return baseMapper.selectByMajorwfuserid(wfuserid);
    }

    @Override
    public void removeByMajorwfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUCPolicy>().eq("majorwfuserid",wfuserid));
    }

	@Override
    public List<WFUCPolicy> selectByMinorwfuserid(String wfuserid) {
        return baseMapper.selectByMinorwfuserid(wfuserid);
    }

    @Override
    public void removeByMinorwfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUCPolicy>().eq("minorwfuserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUCPolicy> searchDefault(WFUCPolicySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUCPolicy> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUCPolicy>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFUCPolicy et){
        //实体关系[DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID]
        if(!ObjectUtils.isEmpty(et.getMajorwfuserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser majorwfuser=et.getMajorwfuser();
            if(ObjectUtils.isEmpty(majorwfuser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getMajorwfuserid());
                et.setMajorwfuser(majorEntity);
                majorwfuser=majorEntity;
            }
            et.setMajorwfusername(majorwfuser.getWfusername());
        }
        //实体关系[DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID]
        if(!ObjectUtils.isEmpty(et.getMinorwfuserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser minorwfuser=et.getMinorwfuser();
            if(ObjectUtils.isEmpty(minorwfuser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getMinorwfuserid());
                et.setMinorwfuser(majorEntity);
                minorwfuser=majorEntity;
            }
            et.setMinorwfusername(minorwfuser.getWfusername());
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


