package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.PARJXZGPC;
import cn.ibizlab.ehr.core.par.filter.PARJXZGPCSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXZGPCService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXZGPCMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效主观评测] 服务对象接口实现
 */
@Slf4j
@Service("PARJXZGPCServiceImpl")
public class PARJXZGPCServiceImpl extends ServiceImpl<PARJXZGPCMapper, PARJXZGPC> implements IPARJXZGPCService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXZGPCMXService parjxzgpcmxService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PARJXZGPC et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxzgpcid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXZGPC> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARJXZGPC et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXZGPC et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARJXZGPC> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARJXZGPC getDraft(PARJXZGPC et) {
        return et;
    }

    @Override
    @Transactional
    public PARJXZGPC get(String key) {
        PARJXZGPC et = getById(key);
        if(et==null){
            et=new PARJXZGPC();
            et.setParjxzgpcid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARJXZGPC et) {
        return (!ObjectUtils.isEmpty(et.getParjxzgpcid()))&&(!Objects.isNull(this.getById(et.getParjxzgpcid())));
    }

    @Override
    @Transactional
    public boolean update(PARJXZGPC et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxzgpcid",et.getParjxzgpcid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxzgpcid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXZGPC> list) {
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXZGPC> searchDefault(PARJXZGPCSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXZGPC> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXZGPC>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


