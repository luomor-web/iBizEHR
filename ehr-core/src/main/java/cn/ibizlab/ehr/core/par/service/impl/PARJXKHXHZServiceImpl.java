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
import cn.ibizlab.ehr.core.par.domain.PARJXKHXHZ;
import cn.ibizlab.ehr.core.par.filter.PARJXKHXHZSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXKHXHZService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXKHXHZMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考核内容评分汇总] 服务对象接口实现
 */
@Slf4j
@Service("PARJXKHXHZServiceImpl")
public class PARJXKHXHZServiceImpl extends ServiceImpl<PARJXKHXHZMapper, PARJXKHXHZ> implements IPARJXKHXHZService {


    private int batchSize = 500;

    @Override
    public PARJXKHXHZ getDraft(PARJXKHXHZ et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PARJXKHXHZ et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxkhxhzid",et.getParjxkhxhzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhxhzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXKHXHZ> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PARJXKHXHZ et) {
        return (!ObjectUtils.isEmpty(et.getParjxkhxhzid()))&&(!Objects.isNull(this.getById(et.getParjxkhxhzid())));
    }

    @Override
    @Transactional
    public PARJXKHXHZ get(String key) {
        PARJXKHXHZ et = getById(key);
        if(et==null){
            et=new PARJXKHXHZ();
            et.setParjxkhxhzid(key);
        }
        else{
        }
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
    public boolean create(PARJXKHXHZ et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhxhzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXKHXHZ> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARJXKHXHZ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXKHXHZ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARJXKHXHZ> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARJXKHXHZ> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXKHXHZ> searchDefault(PARJXKHXHZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXKHXHZ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXKHXHZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


