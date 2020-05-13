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
import cn.ibizlab.ehr.core.common.domain.UserRoleRes;
import cn.ibizlab.ehr.core.common.filter.UserRoleResSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleResService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleResMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色资源能力] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleResServiceImpl")
public class UserRoleResServiceImpl extends ServiceImpl<UserRoleResMapper, UserRoleRes> implements IUserRoleResService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUniResService uniresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleService userroleService;

    private int batchSize = 500;

    @Override
    public UserRoleRes getDraft(UserRoleRes et) {
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
    public boolean checkKey(UserRoleRes et) {
        return (!ObjectUtils.isEmpty(et.getUserroleresid()))&&(!Objects.isNull(this.getById(et.getUserroleresid())));
    }

    @Override
    @Transactional
    public UserRoleRes get(String key) {
        UserRoleRes et = getById(key);
        if(et==null){
            et=new UserRoleRes();
            et.setUserroleresid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(UserRoleRes et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroleresid",et.getUserroleresid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroleresid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleRes> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserRoleRes et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleRes et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleRes> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(UserRoleRes et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroleresid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleRes> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<UserRoleRes> selectByUniresid(String uniresid) {
        return baseMapper.selectByUniresid(uniresid);
    }

    @Override
    public void removeByUniresid(String uniresid) {
        this.remove(new QueryWrapper<UserRoleRes>().eq("uniresid",uniresid));
    }

	@Override
    public List<UserRoleRes> selectByUserroleid(String userroleid) {
        return baseMapper.selectByUserroleid(userroleid);
    }

    @Override
    public void removeByUserroleid(String userroleid) {
        this.remove(new QueryWrapper<UserRoleRes>().eq("userroleid",userroleid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleRes> searchDefault(UserRoleResSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleRes> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleRes>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleRes et){
        //实体关系[DER1N_USERROLERES_UNIRES_UNIRESID]
        if(!ObjectUtils.isEmpty(et.getUniresid())){
            cn.ibizlab.ehr.core.common.domain.UniRes unires=et.getUnires();
            if(ObjectUtils.isEmpty(unires)){
                cn.ibizlab.ehr.core.common.domain.UniRes majorEntity=uniresService.get(et.getUniresid());
                et.setUnires(majorEntity);
                unires=majorEntity;
            }
            et.setUniresname(unires.getUniresname());
            et.setUnirestype(unires.getUnirestype());
        }
        //实体关系[DER1N_USERROLERES_USERROLE_USERROLEID]
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


