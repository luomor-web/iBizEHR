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
import cn.ibizlab.ehr.core.wf.domain.WFUserGroupDetail;
import cn.ibizlab.ehr.core.wf.filter.WFUserGroupDetailSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUserGroupDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUserGroupDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流用户组成员] 服务对象接口实现
 */
@Slf4j
@Service("WFUserGroupDetailServiceImpl")
public class WFUserGroupDetailServiceImpl extends ServiceImpl<WFUserGroupDetailMapper, WFUserGroupDetail> implements IWFUserGroupDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserGroupService wfusergroupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFUserGroupDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfusergroupdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public WFUserGroupDetail getDraft(WFUserGroupDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public WFUserGroupDetail get(String key) {
        WFUserGroupDetail et = getById(key);
        if(et==null){
            et=new WFUserGroupDetail();
            et.setWfusergroupdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFUserGroupDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUserGroupDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFUserGroupDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfusergroupdetailid",et.getWfusergroupdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfusergroupdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUserGroupDetail> list) {
        list.forEach(item->fillParentData(item));
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
    public boolean checkKey(WFUserGroupDetail et) {
        return (!ObjectUtils.isEmpty(et.getWfusergroupdetailid()))&&(!Objects.isNull(this.getById(et.getWfusergroupdetailid())));
    }


	@Override
    public List<WFUserGroupDetail> selectByWfusergroupid(String wfusergroupid) {
        return baseMapper.selectByWfusergroupid(wfusergroupid);
    }

    @Override
    public void removeByWfusergroupid(String wfusergroupid) {
        this.remove(new QueryWrapper<WFUserGroupDetail>().eq("wfusergroupid",wfusergroupid));
    }

	@Override
    public List<WFUserGroupDetail> selectByWfuserid(String wfuserid) {
        return baseMapper.selectByWfuserid(wfuserid);
    }

    @Override
    public void removeByWfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUserGroupDetail>().eq("wfuserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUserGroupDetail> searchDefault(WFUserGroupDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUserGroupDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUserGroupDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFUserGroupDetail et){
        //实体关系[DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID]
        if(!ObjectUtils.isEmpty(et.getWfusergroupid())){
            cn.ibizlab.ehr.core.wf.domain.WFUserGroup wfusergroup=et.getWfusergroup();
            if(ObjectUtils.isEmpty(wfusergroup)){
                cn.ibizlab.ehr.core.wf.domain.WFUserGroup majorEntity=wfusergroupService.get(et.getWfusergroupid());
                et.setWfusergroup(majorEntity);
                wfusergroup=majorEntity;
            }
            et.setWfusergroupname(wfusergroup.getWfusergroupname());
        }
        //实体关系[DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID]
        if(!ObjectUtils.isEmpty(et.getWfuserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfuser=et.getWfuser();
            if(ObjectUtils.isEmpty(wfuser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfuserid());
                et.setWfuser(majorEntity);
                wfuser=majorEntity;
            }
            et.setWfusername(wfuser.getWfusername());
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


