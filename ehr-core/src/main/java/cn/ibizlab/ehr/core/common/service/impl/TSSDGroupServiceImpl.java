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
import cn.ibizlab.ehr.core.common.domain.TSSDGroup;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupSearchContext;
import cn.ibizlab.ehr.core.common.service.ITSSDGroupService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.TSSDGroupMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务时刻策略组] 服务对象接口实现
 */
@Slf4j
@Service("TSSDGroupServiceImpl")
public class TSSDGroupServiceImpl extends ServiceImpl<TSSDGroupMapper, TSSDGroup> implements ITSSDGroupService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDGroupDetailService tssdgroupdetailService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(TSSDGroup et) {
        return (!ObjectUtils.isEmpty(et.getTssdgroupid()))&&(!Objects.isNull(this.getById(et.getTssdgroupid())));
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
    public TSSDGroup getDraft(TSSDGroup et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(TSSDGroup et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tssdgroupid",et.getTssdgroupid())))
            return false;
        CachedBeanCopier.copy(get(et.getTssdgroupid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TSSDGroup> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public TSSDGroup get(String key) {
        TSSDGroup et = getById(key);
        if(et==null){
            et=new TSSDGroup();
            et.setTssdgroupid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(TSSDGroup et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TSSDGroup et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TSSDGroup> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TSSDGroup et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTssdgroupid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TSSDGroup> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TSSDGroup> searchDefault(TSSDGroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TSSDGroup> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TSSDGroup>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


