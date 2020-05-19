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
import cn.ibizlab.ehr.core.common.domain.UserRoleDatas;
import cn.ibizlab.ehr.core.common.filter.UserRoleDatasSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDatasService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDatasMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色数据能力] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDatasServiceImpl")
public class UserRoleDatasServiceImpl extends ServiceImpl<UserRoleDatasMapper, UserRoleDatas> implements IUserRoleDatasService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataService userroledataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleService userroleService;

    private int batchSize = 500;

    @Override
    @Transactional
    public UserRoleDatas get(String key) {
        UserRoleDatas et = getById(key);
        if(et==null){
            et=new UserRoleDatas();
            et.setUserroledatasid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(UserRoleDatas et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledatasid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDatas> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(UserRoleDatas et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledatasid",et.getUserroledatasid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledatasid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDatas> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserRoleDatas et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDatas et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDatas> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(UserRoleDatas et) {
        return (!ObjectUtils.isEmpty(et.getUserroledatasid()))&&(!Objects.isNull(this.getById(et.getUserroledatasid())));
    }

    @Override
    public UserRoleDatas getDraft(UserRoleDatas et) {
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
    public List<UserRoleDatas> selectByUserroledataid(String userroledataid) {
        return baseMapper.selectByUserroledataid(userroledataid);
    }

    @Override
    public void removeByUserroledataid(String userroledataid) {
        this.remove(new QueryWrapper<UserRoleDatas>().eq("userroledataid",userroledataid));
    }

	@Override
    public List<UserRoleDatas> selectByUserroleid(String userroleid) {
        return baseMapper.selectByUserroleid(userroleid);
    }

    @Override
    public void removeByUserroleid(String userroleid) {
        this.remove(new QueryWrapper<UserRoleDatas>().eq("userroleid",userroleid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDatas> searchDefault(UserRoleDatasSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDatas> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDatas>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDatas et){
        //实体关系[DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID]
        if(!ObjectUtils.isEmpty(et.getUserroledataid())){
            cn.ibizlab.ehr.core.common.domain.UserRoleData userroledata=et.getUserroledata();
            if(ObjectUtils.isEmpty(userroledata)){
                cn.ibizlab.ehr.core.common.domain.UserRoleData majorEntity=userroledataService.get(et.getUserroledataid());
                et.setUserroledata(majorEntity);
                userroledata=majorEntity;
            }
            et.setDename(userroledata.getDename());
            et.setUserroledataname(userroledata.getUserroledataname());
        }
        //实体关系[DER1N_USERROLEDATAS_USERROLE_USERROLEID]
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


