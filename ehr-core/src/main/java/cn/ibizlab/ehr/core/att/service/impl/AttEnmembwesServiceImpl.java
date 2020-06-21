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
import cn.ibizlab.ehr.core.att.domain.AttEnmembwes;
import cn.ibizlab.ehr.core.att.filter.AttEnmembwesSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEnmembwesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEnmembwesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤员(停用)] 服务对象接口实现
 */
@Slf4j
@Service("AttEnmembwesServiceImpl")
public class AttEnmembwesServiceImpl extends ServiceImpl<AttEnmembwesMapper, AttEnmembwes> implements IAttEnmembwesService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(AttEnmembwes et) {
        return (!ObjectUtils.isEmpty(et.getAttenmembwesid()))&&(!Objects.isNull(this.getById(et.getAttenmembwesid())));
    }
    @Override
    @Transactional
    public AttEnmembwes get(String key) {
        AttEnmembwes et = getById(key);
        if(et==null){
            et=new AttEnmembwes();
            et.setAttenmembwesid(key);
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
    public boolean save(AttEnmembwes et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEnmembwes et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEnmembwes> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEnmembwes> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public AttEnmembwes getDraft(AttEnmembwes et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(AttEnmembwes et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attenmembwesid",et.getAttenmembwesid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttenmembwesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEnmembwes> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(AttEnmembwes et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttenmembwesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEnmembwes> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEnmembwes> searchDefault(AttEnmembwesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEnmembwes> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEnmembwes>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<AttEnmembwes> getAttenmembwesByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEnmembwes> getAttenmembwesByEntities(List<AttEnmembwes> entities) {
        List ids =new ArrayList();
        for(AttEnmembwes entity : entities){
            Serializable id=entity.getAttenmembwesid();
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



