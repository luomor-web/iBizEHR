package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.UserGroup;
import cn.ibizlab.ehr.core.common.filter.UserGroupSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserGroupService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserGroupMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户组] 服务对象接口实现
 */
@Slf4j
@Service("UserGroupServiceImpl")
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements IUserGroupService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserGroupDetailService usergroupdetailService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(UserGroup et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("usergroupid",et.getUsergroupid())))
            return false;
        CachedBeanCopier.copy(get(et.getUsergroupid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserGroup> list) {
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

    @Override
    public boolean checkKey(UserGroup et) {
        return (!ObjectUtils.isEmpty(et.getUsergroupid()))&&(!Objects.isNull(this.getById(et.getUsergroupid())));
    }

    @Override
    @Transactional
    public boolean create(UserGroup et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUsergroupid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserGroup> list) {
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserGroup et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserGroup et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserGroup> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public UserGroup get(String key) {
        UserGroup et = getById(key);
        if(et==null){
            et=new UserGroup();
            et.setUsergroupid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public UserGroup getDraft(UserGroup et) {
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserGroup> searchDefault(UserGroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserGroup> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserGroup>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


