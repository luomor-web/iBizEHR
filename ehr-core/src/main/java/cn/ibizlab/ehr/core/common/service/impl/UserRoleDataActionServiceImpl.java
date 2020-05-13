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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataAction;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataActionSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataActionService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDataActionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色数据操作] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDataActionServiceImpl")
public class UserRoleDataActionServiceImpl extends ServiceImpl<UserRoleDataActionMapper, UserRoleDataAction> implements IUserRoleDataActionService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataService userroledataService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(UserRoleDataAction et) {
        return (!ObjectUtils.isEmpty(et.getUserroledataactionid()))&&(!Objects.isNull(this.getById(et.getUserroledataactionid())));
    }

    @Override
    public UserRoleDataAction getDraft(UserRoleDataAction et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public UserRoleDataAction get(String key) {
        UserRoleDataAction et = getById(key);
        if(et==null){
            et=new UserRoleDataAction();
            et.setUserroledataactionid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(UserRoleDataAction et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledataactionid",et.getUserroledataactionid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledataactionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDataAction> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(UserRoleDataAction et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledataactionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDataAction> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
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
    public boolean save(UserRoleDataAction et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDataAction et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDataAction> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<UserRoleDataAction> selectByUserroledataid(String userroledataid) {
        return baseMapper.selectByUserroledataid(userroledataid);
    }

    @Override
    public void removeByUserroledataid(String userroledataid) {
        this.remove(new QueryWrapper<UserRoleDataAction>().eq("userroledataid",userroledataid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDataAction> searchDefault(UserRoleDataActionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDataAction> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDataAction>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDataAction et){
        //实体关系[DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID]
        if(!ObjectUtils.isEmpty(et.getUserroledataid())){
            cn.ibizlab.ehr.core.common.domain.UserRoleData userroledata=et.getUserroledata();
            if(ObjectUtils.isEmpty(userroledata)){
                cn.ibizlab.ehr.core.common.domain.UserRoleData majorEntity=userroledataService.get(et.getUserroledataid());
                et.setUserroledata(majorEntity);
                userroledata=majorEntity;
            }
            et.setUserroledataname(userroledata.getUserroledataname());
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


