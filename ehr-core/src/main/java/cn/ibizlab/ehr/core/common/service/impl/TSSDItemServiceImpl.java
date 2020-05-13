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
import cn.ibizlab.ehr.core.common.domain.TSSDItem;
import cn.ibizlab.ehr.core.common.filter.TSSDItemSearchContext;
import cn.ibizlab.ehr.core.common.service.ITSSDItemService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.TSSDItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务时刻策略项] 服务对象接口实现
 */
@Slf4j
@Service("TSSDItemServiceImpl")
public class TSSDItemServiceImpl extends ServiceImpl<TSSDItemMapper, TSSDItem> implements ITSSDItemService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDGroupDetailService tssdgroupdetailService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TSSDItem et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTssditemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TSSDItem> list) {
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
    public boolean checkKey(TSSDItem et) {
        return (!ObjectUtils.isEmpty(et.getTssditemid()))&&(!Objects.isNull(this.getById(et.getTssditemid())));
    }

    @Override
    public TSSDItem getDraft(TSSDItem et) {
        return et;
    }

    @Override
    @Transactional
    public TSSDItem get(String key) {
        TSSDItem et = getById(key);
        if(et==null){
            et=new TSSDItem();
            et.setTssditemid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TSSDItem et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tssditemid",et.getTssditemid())))
            return false;
        CachedBeanCopier.copy(get(et.getTssditemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TSSDItem> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TSSDItem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TSSDItem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TSSDItem> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TSSDItem> searchDefault(TSSDItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TSSDItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TSSDItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


