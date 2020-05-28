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
import cn.ibizlab.ehr.core.trm.domain.TRMZZOBM;
import cn.ibizlab.ehr.core.trm.filter.TRMZZOBMSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMZZOBMService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMZZOBMMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[单位/部门] 服务对象接口实现
 */
@Slf4j
@Service("TRMZZOBMServiceImpl")
public class TRMZZOBMServiceImpl extends ServiceImpl<TRMZZOBMMapper, TRMZZOBM> implements ITRMZZOBMService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TRMZZOBM et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmzzobmid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMZZOBM> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMZZOBM et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmzzobmid",et.getTrmzzobmid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmzzobmid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMZZOBM> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMZZOBM et) {
        return (!ObjectUtils.isEmpty(et.getTrmzzobmid()))&&(!Objects.isNull(this.getById(et.getTrmzzobmid())));
    }

    @Override
    public TRMZZOBM getDraft(TRMZZOBM et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(TRMZZOBM et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMZZOBM et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMZZOBM> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMZZOBM> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMZZOBM get(String key) {
        TRMZZOBM et = getById(key);
        if(et==null){
            et=new TRMZZOBM();
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
    public Page<TRMZZOBM> searchDefault(TRMZZOBMSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMZZOBM> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMZZOBM>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<TRMZZOBM> getTrmzzobmByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMZZOBM> getTrmzzobmByEntities(List<TRMZZOBM> entities) {
        List ids =new ArrayList();
        for(TRMZZOBM entity : entities){
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


