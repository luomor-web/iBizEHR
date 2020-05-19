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
import cn.ibizlab.ehr.core.wf.domain.WFDynamicUser;
import cn.ibizlab.ehr.core.wf.filter.WFDynamicUserSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFDynamicUserService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFDynamicUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流动态用户] 服务对象接口实现
 */
@Slf4j
@Service("WFDynamicUserServiceImpl")
public class WFDynamicUserServiceImpl extends ServiceImpl<WFDynamicUserMapper, WFDynamicUser> implements IWFDynamicUserService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFDynamicUser et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfdynamicuserid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFDynamicUser> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFDynamicUser get(String key) {
        WFDynamicUser et = getById(key);
        if(et==null){
            et=new WFDynamicUser();
            et.setWfdynamicuserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFDynamicUser et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFDynamicUser et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFDynamicUser> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WFDynamicUser et) {
        return (!ObjectUtils.isEmpty(et.getWfdynamicuserid()))&&(!Objects.isNull(this.getById(et.getWfdynamicuserid())));
    }

    @Override
    public WFDynamicUser getDraft(WFDynamicUser et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFDynamicUser et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfdynamicuserid",et.getWfdynamicuserid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfdynamicuserid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFDynamicUser> list) {
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
    public Page<WFDynamicUser> searchDefault(WFDynamicUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFDynamicUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFDynamicUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


