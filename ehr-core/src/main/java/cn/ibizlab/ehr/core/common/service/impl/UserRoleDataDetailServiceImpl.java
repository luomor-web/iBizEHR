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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataDetail;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDataDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[数据对象能力明细] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDataDetailServiceImpl")
public class UserRoleDataDetailServiceImpl extends ServiceImpl<UserRoleDataDetailMapper, UserRoleDataDetail> implements IUserRoleDataDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IQueryModelService querymodelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataService userroledataService;

    private int batchSize = 500;

    @Override
    public UserRoleDataDetail getDraft(UserRoleDataDetail et) {
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
    public boolean checkKey(UserRoleDataDetail et) {
        return (!ObjectUtils.isEmpty(et.getUserroledatadetailid()))&&(!Objects.isNull(this.getById(et.getUserroledatadetailid())));
    }

    @Override
    @Transactional
    public boolean create(UserRoleDataDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledatadetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDataDetail> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserRoleDataDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDataDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDataDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(UserRoleDataDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledatadetailid",et.getUserroledatadetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledatadetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDataDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public UserRoleDataDetail get(String key) {
        UserRoleDataDetail et = getById(key);
        if(et==null){
            et=new UserRoleDataDetail();
            et.setUserroledatadetailid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<UserRoleDataDetail> selectByQuerymodelid(String querymodelid) {
        return baseMapper.selectByQuerymodelid(querymodelid);
    }

    @Override
    public void removeByQuerymodelid(String querymodelid) {
        this.remove(new QueryWrapper<UserRoleDataDetail>().eq("querymodelid",querymodelid));
    }

	@Override
    public List<UserRoleDataDetail> selectByUserroledataid(String userroledataid) {
        return baseMapper.selectByUserroledataid(userroledataid);
    }

    @Override
    public void removeByUserroledataid(String userroledataid) {
        this.remove(new QueryWrapper<UserRoleDataDetail>().eq("userroledataid",userroledataid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDataDetail> searchDefault(UserRoleDataDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDataDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDataDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDataDetail et){
        //实体关系[DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID]
        if(!ObjectUtils.isEmpty(et.getQuerymodelid())){
            cn.ibizlab.ehr.core.demodel.domain.QueryModel querymodel=et.getQuerymodel();
            if(ObjectUtils.isEmpty(querymodel)){
                cn.ibizlab.ehr.core.demodel.domain.QueryModel majorEntity=querymodelService.get(et.getQuerymodelid());
                et.setQuerymodel(majorEntity);
                querymodel=majorEntity;
            }
            et.setQuerymodelname(querymodel.getQuerymodelname());
        }
        //实体关系[DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID]
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


