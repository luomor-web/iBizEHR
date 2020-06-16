package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SocArchives;
import cn.ibizlab.ehr.core.soc.filter.SocArchivesSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocArchivesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocArchivesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保档案] 服务对象接口实现
 */
@Slf4j
@Service("SocArchivesServiceImpl")
public class SocArchivesServiceImpl extends ServiceImpl<SocArchivesMapper, SocArchives> implements ISocArchivesService {


    private int batchSize = 500;

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
    public SocArchives getDraft(SocArchives et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(SocArchives et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socarchivesid",et.getSocarchivesid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocarchivesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocArchives> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SocArchives get(String key) {
        SocArchives et = getById(key);
        if(et==null){
            et=new SocArchives();
            et.setSocarchivesid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(SocArchives et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocArchives et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocArchives> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocArchives> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SocArchives et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocarchivesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocArchives> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SocArchives et) {
        return (!ObjectUtils.isEmpty(et.getSocarchivesid()))&&(!Objects.isNull(this.getById(et.getSocarchivesid())));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocArchives> searchDefault(SocArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocArchives> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<SocArchives> getSocarchivesByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocArchives> getSocarchivesByEntities(List<SocArchives> entities) {
        List ids =new ArrayList();
        for(SocArchives entity : entities){
            Serializable id=entity.getSocarchivesid();
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



