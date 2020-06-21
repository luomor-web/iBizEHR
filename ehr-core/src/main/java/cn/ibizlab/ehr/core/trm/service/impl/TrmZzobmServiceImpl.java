package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TrmZzobm;
import cn.ibizlab.ehr.core.trm.filter.TrmZzobmSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmZzobmService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmZzobmMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[单位/部门] 服务对象接口实现
 */
@Slf4j
@Service("TrmZzobmServiceImpl")
public class TrmZzobmServiceImpl extends ServiceImpl<TrmZzobmMapper, TrmZzobm> implements ITrmZzobmService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TrmZzobm et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmzzobmid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmZzobm> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmZzobm et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmzzobmid",et.getTrmzzobmid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmzzobmid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmZzobm> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmZzobm et) {
        return (!ObjectUtils.isEmpty(et.getTrmzzobmid()))&&(!Objects.isNull(this.getById(et.getTrmzzobmid())));
    }
    @Override
    public TrmZzobm getDraft(TrmZzobm et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(TrmZzobm et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmZzobm et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmZzobm> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmZzobm> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TrmZzobm get(String key) {
        TrmZzobm et = getById(key);
        if(et==null){
            et=new TrmZzobm();
            et.setTrmzzobmid(key);
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmZzobm> searchDefault(TrmZzobmSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmZzobm> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmZzobm>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<TrmZzobm> getTrmzzobmByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmZzobm> getTrmzzobmByEntities(List<TrmZzobm> entities) {
        List ids =new ArrayList();
        for(TrmZzobm entity : entities){
            Serializable id=entity.getTrmzzobmid();
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



