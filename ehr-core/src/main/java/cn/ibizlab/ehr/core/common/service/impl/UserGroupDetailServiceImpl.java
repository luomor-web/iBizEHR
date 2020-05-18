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
import cn.ibizlab.ehr.core.common.domain.UserGroupDetail;
import cn.ibizlab.ehr.core.common.filter.UserGroupDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserGroupDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserGroupDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户组成员] 服务对象接口实现
 */
@Slf4j
@Service("UserGroupDetailServiceImpl")
public class UserGroupDetailServiceImpl extends ServiceImpl<UserGroupDetailMapper, UserGroupDetail> implements IUserGroupDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserGroupService usergroupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserObjectService userobjectService;

    private int batchSize = 500;

    @Override
    public UserGroupDetail getDraft(UserGroupDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(UserGroupDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserGroupDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(UserGroupDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("usergroupdetailid",et.getUsergroupdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getUsergroupdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public UserGroupDetail get(String key) {
        UserGroupDetail et = getById(key);
        if(et==null){
            et=new UserGroupDetail();
            et.setUsergroupdetailid(key);
        }
        else{
        }
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
    public boolean checkKey(UserGroupDetail et) {
        return (!ObjectUtils.isEmpty(et.getUsergroupdetailid()))&&(!Objects.isNull(this.getById(et.getUsergroupdetailid())));
    }

    @Override
    @Transactional
    public boolean create(UserGroupDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUsergroupdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<UserGroupDetail> selectByUsergroupid(String usergroupid) {
        return baseMapper.selectByUsergroupid(usergroupid);
    }

    @Override
    public void removeByUsergroupid(String usergroupid) {
        this.remove(new QueryWrapper<UserGroupDetail>().eq("usergroupid",usergroupid));
    }

	@Override
    public List<UserGroupDetail> selectByUserobjectid(String userobjectid) {
        return baseMapper.selectByUserobjectid(userobjectid);
    }

    @Override
    public void removeByUserobjectid(String userobjectid) {
        this.remove(new QueryWrapper<UserGroupDetail>().eq("userobjectid",userobjectid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserGroupDetail> searchDefault(UserGroupDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserGroupDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserGroupDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserGroupDetail et){
        //实体关系[DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID]
        if(!ObjectUtils.isEmpty(et.getUsergroupid())){
            cn.ibizlab.ehr.core.common.domain.UserGroup usergroup=et.getUsergroup();
            if(ObjectUtils.isEmpty(usergroup)){
                cn.ibizlab.ehr.core.common.domain.UserGroup majorEntity=usergroupService.get(et.getUsergroupid());
                et.setUsergroup(majorEntity);
                usergroup=majorEntity;
            }
            et.setUsergroupname(usergroup.getUsergroupname());
        }
        //实体关系[DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID]
        if(!ObjectUtils.isEmpty(et.getUserobjectid())){
            cn.ibizlab.ehr.core.common.domain.UserObject userobject=et.getUserobject();
            if(ObjectUtils.isEmpty(userobject)){
                cn.ibizlab.ehr.core.common.domain.UserObject majorEntity=userobjectService.get(et.getUserobjectid());
                et.setUserobject(majorEntity);
                userobject=majorEntity;
            }
            et.setUserobjectname(userobject.getUserobjectname());
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


