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
import cn.ibizlab.ehr.core.common.domain.UserRoleDetail;
import cn.ibizlab.ehr.core.common.filter.UserRoleDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色成员] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDetailServiceImpl")
public class UserRoleDetailServiceImpl extends ServiceImpl<UserRoleDetailMapper, UserRoleDetail> implements IUserRoleDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserObjectService userobjectService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleService userroleService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(UserRoleDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledetailid",et.getUserroledetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(UserRoleDetail et) {
        return (!ObjectUtils.isEmpty(et.getUserroledetailid()))&&(!Objects.isNull(this.getById(et.getUserroledetailid())));
    }

    @Override
    @Transactional
    public boolean create(UserRoleDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDetail> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserRoleDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public UserRoleDetail getDraft(UserRoleDetail et) {
        fillParentData(et);
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
    public UserRoleDetail get(String key) {
        UserRoleDetail et = getById(key);
        if(et==null){
            et=new UserRoleDetail();
            et.setUserroledetailid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<UserRoleDetail> selectByUserobjectid(String userobjectid) {
        return baseMapper.selectByUserobjectid(userobjectid);
    }

    @Override
    public void removeByUserobjectid(String userobjectid) {
        this.remove(new QueryWrapper<UserRoleDetail>().eq("userobjectid",userobjectid));
    }

	@Override
    public List<UserRoleDetail> selectByUserroleid(String userroleid) {
        return baseMapper.selectByUserroleid(userroleid);
    }

    @Override
    public void removeByUserroleid(String userroleid) {
        this.remove(new QueryWrapper<UserRoleDetail>().eq("userroleid",userroleid));
    }


    /**
     * 查询集合 当前公司角色成员
     */
    @Override
    public Page<UserRoleDetail> searchCurrentCompany(UserRoleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDetail> pages=baseMapper.searchCurrentCompany(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据用户查询角色
     */
    @Override
    public Page<UserRoleDetail> searchOrderByUserCX(UserRoleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDetail> pages=baseMapper.searchOrderByUserCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDetail> searchDefault(UserRoleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 系统管理员
     */
    @Override
    public Page<UserRoleDetail> searchSysManager(UserRoleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDetail> pages=baseMapper.searchSysManager(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDetail et){
        //实体关系[DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID]
        if(!ObjectUtils.isEmpty(et.getUserobjectid())){
            cn.ibizlab.ehr.core.common.domain.UserObject userobject=et.getUserobject();
            if(ObjectUtils.isEmpty(userobject)){
                cn.ibizlab.ehr.core.common.domain.UserObject majorEntity=userobjectService.get(et.getUserobjectid());
                et.setUserobject(majorEntity);
                userobject=majorEntity;
            }
            et.setUserobjectname(userobject.getUserobjectname());
        }
        //实体关系[DER1N_USERROLEDETAIL_USERROLE_USERROLEID]
        if(!ObjectUtils.isEmpty(et.getUserroleid())){
            cn.ibizlab.ehr.core.common.domain.UserRole userrole=et.getUserrole();
            if(ObjectUtils.isEmpty(userrole)){
                cn.ibizlab.ehr.core.common.domain.UserRole majorEntity=userroleService.get(et.getUserroleid());
                et.setUserrole(majorEntity);
                userrole=majorEntity;
            }
            et.setUserrolename(userrole.getUserrolename());
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


