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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEFieldes;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldesSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDEFieldesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色相关实体属性访问控制] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDEFieldesServiceImpl")
public class UserRoleDEFieldesServiceImpl extends ServiceImpl<UserRoleDEFieldesMapper, UserRoleDEFieldes> implements IUserRoleDEFieldesService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldService userroledefieldService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleService userroleService;

    private int batchSize = 500;

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
    public boolean update(UserRoleDEFieldes et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledefieldsid",et.getUserroledefieldsid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledefieldsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDEFieldes> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(UserRoleDEFieldes et) {
        return (!ObjectUtils.isEmpty(et.getUserroledefieldsid()))&&(!Objects.isNull(this.getById(et.getUserroledefieldsid())));
    }

    @Override
    @Transactional
    public boolean create(UserRoleDEFieldes et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledefieldsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDEFieldes> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public UserRoleDEFieldes get(String key) {
        UserRoleDEFieldes et = getById(key);
        if(et==null){
            et=new UserRoleDEFieldes();
            et.setUserroledefieldsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(UserRoleDEFieldes et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDEFieldes et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDEFieldes> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public UserRoleDEFieldes getDraft(UserRoleDEFieldes et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<UserRoleDEFieldes> selectByUserroledefieldid(String userroledefieldid) {
        return baseMapper.selectByUserroledefieldid(userroledefieldid);
    }

    @Override
    public void removeByUserroledefieldid(String userroledefieldid) {
        this.remove(new QueryWrapper<UserRoleDEFieldes>().eq("userroledefieldid",userroledefieldid));
    }

	@Override
    public List<UserRoleDEFieldes> selectByUserroleid(String userroleid) {
        return baseMapper.selectByUserroleid(userroleid);
    }

    @Override
    public void removeByUserroleid(String userroleid) {
        this.remove(new QueryWrapper<UserRoleDEFieldes>().eq("userroleid",userroleid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDEFieldes> searchDefault(UserRoleDEFieldesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDEFieldes> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDEFieldes>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDEFieldes et){
        //实体关系[DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID]
        if(!ObjectUtils.isEmpty(et.getUserroledefieldid())){
            cn.ibizlab.ehr.core.common.domain.UserRoleDEField userroledefield=et.getUserroledefield();
            if(ObjectUtils.isEmpty(userroledefield)){
                cn.ibizlab.ehr.core.common.domain.UserRoleDEField majorEntity=userroledefieldService.get(et.getUserroledefieldid());
                et.setUserroledefield(majorEntity);
                userroledefield=majorEntity;
            }
            et.setUserroledefieldname(userroledefield.getUserroledefieldname());
        }
        //实体关系[DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID]
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


