package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.AttEnsummarymx;
import cn.ibizlab.ehr.core.att.filter.AttEnsummarymxSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEnsummarymxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEnsummarymxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤汇总明细（停用）] 服务对象接口实现
 */
@Slf4j
@Service("AttEnsummarymxServiceImpl")
public class AttEnsummarymxServiceImpl extends ServiceImpl<AttEnsummarymxMapper, AttEnsummarymx> implements IAttEnsummarymxService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(AttEnsummarymx et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancesummarymxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEnsummarymx> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(AttEnsummarymx et) {
        return (!ObjectUtils.isEmpty(et.getAttendancesummarymxid()))&&(!Objects.isNull(this.getById(et.getAttendancesummarymxid())));
    }
    @Override
    @Transactional
    public AttEnsummarymx get(String key) {
        AttEnsummarymx et = getById(key);
        if(et==null){
            et=new AttEnsummarymx();
            et.setAttendancesummarymxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public AttEnsummarymx getDraft(AttEnsummarymx et) {
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
    public boolean save(AttEnsummarymx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEnsummarymx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEnsummarymx> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEnsummarymx> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(AttEnsummarymx et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attensummarymxid",et.getAttendancesummarymxid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancesummarymxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEnsummarymx> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEnsummarymx> searchDefault(AttEnsummarymxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEnsummarymx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEnsummarymx>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

    @Override
    public List<AttEnsummarymx> getAttensummarymxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEnsummarymx> getAttensummarymxByEntities(List<AttEnsummarymx> entities) {
        List ids =new ArrayList();
        for(AttEnsummarymx entity : entities){
            Serializable id=entity.getAttendancesummarymxid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



