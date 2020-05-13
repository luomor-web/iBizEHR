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
import cn.ibizlab.ehr.core.wf.domain.WFUserGroup;
import cn.ibizlab.ehr.core.wf.filter.WFUserGroupSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUserGroupService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUserGroupMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流用户组] 服务对象接口实现
 */
@Slf4j
@Service("WFUserGroupServiceImpl")
public class WFUserGroupServiceImpl extends ServiceImpl<WFUserGroupMapper, WFUserGroup> implements IWFUserGroupService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserGroupDetailService wfusergroupdetailService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(WFUserGroup et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUserGroup et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUserGroup> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFUserGroup et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfusergroupid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUserGroup> list) {
        saveBatch(list,batchSize);
    }

    @Override
    public WFUserGroup getDraft(WFUserGroup et) {
        return et;
    }

    @Override
    @Transactional
    public WFUserGroup get(String key) {
        WFUserGroup et = getById(key);
        if(et==null){
            et=new WFUserGroup();
            et.setWfusergroupid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(WFUserGroup et) {
        return (!ObjectUtils.isEmpty(et.getWfusergroupid()))&&(!Objects.isNull(this.getById(et.getWfusergroupid())));
    }

    @Override
    @Transactional
    public boolean update(WFUserGroup et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfusergroupid",et.getWfusergroupid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfusergroupid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUserGroup> list) {
        updateBatchById(list,batchSize);
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
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUserGroup> searchDefault(WFUserGroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUserGroup> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUserGroup>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


