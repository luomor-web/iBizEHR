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
import cn.ibizlab.ehr.core.common.domain.TSSDGroupDetail;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.ITSSDGroupDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.TSSDGroupDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务时刻策略组明细] 服务对象接口实现
 */
@Slf4j
@Service("TSSDGroupDetailServiceImpl")
public class TSSDGroupDetailServiceImpl extends ServiceImpl<TSSDGroupDetailMapper, TSSDGroupDetail> implements ITSSDGroupDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDGroupService tssdgroupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDItemService tssditemService;

    private int batchSize = 500;

    @Override
    public TSSDGroupDetail getDraft(TSSDGroupDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TSSDGroupDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTssdgroupdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TSSDGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TSSDGroupDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tssdgroupdetailid",et.getTssdgroupdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getTssdgroupdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TSSDGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TSSDGroupDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TSSDGroupDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TSSDGroupDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TSSDGroupDetail et) {
        return (!ObjectUtils.isEmpty(et.getTssdgroupdetailid()))&&(!Objects.isNull(this.getById(et.getTssdgroupdetailid())));
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
    public TSSDGroupDetail get(String key) {
        TSSDGroupDetail et = getById(key);
        if(et==null){
            et=new TSSDGroupDetail();
            et.setTssdgroupdetailid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TSSDGroupDetail> selectByTssdgroupid(String tssdgroupid) {
        return baseMapper.selectByTssdgroupid(tssdgroupid);
    }

    @Override
    public void removeByTssdgroupid(String tssdgroupid) {
        this.remove(new QueryWrapper<TSSDGroupDetail>().eq("tssdgroupid",tssdgroupid));
    }

	@Override
    public List<TSSDGroupDetail> selectByTssditemid(String tssditemid) {
        return baseMapper.selectByTssditemid(tssditemid);
    }

    @Override
    public void removeByTssditemid(String tssditemid) {
        this.remove(new QueryWrapper<TSSDGroupDetail>().eq("tssditemid",tssditemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TSSDGroupDetail> searchDefault(TSSDGroupDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TSSDGroupDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TSSDGroupDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TSSDGroupDetail et){
        //实体关系[DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID]
        if(!ObjectUtils.isEmpty(et.getTssdgroupid())){
            cn.ibizlab.ehr.core.common.domain.TSSDGroup tssdgroup=et.getTssdgroup();
            if(ObjectUtils.isEmpty(tssdgroup)){
                cn.ibizlab.ehr.core.common.domain.TSSDGroup majorEntity=tssdgroupService.get(et.getTssdgroupid());
                et.setTssdgroup(majorEntity);
                tssdgroup=majorEntity;
            }
            et.setTssdgroupname(tssdgroup.getTssdgroupname());
        }
        //实体关系[DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID]
        if(!ObjectUtils.isEmpty(et.getTssditemid())){
            cn.ibizlab.ehr.core.common.domain.TSSDItem tssditem=et.getTssditem();
            if(ObjectUtils.isEmpty(tssditem)){
                cn.ibizlab.ehr.core.common.domain.TSSDItem majorEntity=tssditemService.get(et.getTssditemid());
                et.setTssditem(majorEntity);
                tssditem=majorEntity;
            }
            et.setTssditemname(tssditem.getTssditemname());
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


