package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmTitle;
import cn.ibizlab.ehr.core.orm.filter.OrmTitleSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmTitleService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmTitleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[头衔管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmTitleServiceImpl")
public class OrmTitleServiceImpl extends ServiceImpl<OrmTitleMapper, OrmTitle> implements IOrmTitleService {


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
    @Transactional
    public boolean update(OrmTitle et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormtitleid",et.getOrmtitleid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmtitleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmTitle> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public OrmTitle getDraft(OrmTitle et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmTitle et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmTitle et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmTitle> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmTitle> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(OrmTitle et) {
        return (!ObjectUtils.isEmpty(et.getOrmtitleid()))&&(!Objects.isNull(this.getById(et.getOrmtitleid())));
    }
    @Override
    @Transactional
    public OrmTitle get(String key) {
        OrmTitle et = getById(key);
        if(et==null){
            et=new OrmTitle();
            et.setOrmtitleid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmTitle et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmtitleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmTitle> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmTitle> searchDefault(OrmTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmTitle> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmTitle>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmTitle> getOrmtitleByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmTitle> getOrmtitleByEntities(List<OrmTitle> entities) {
        List ids =new ArrayList();
        for(OrmTitle entity : entities){
            Serializable id=entity.getOrmtitleid();
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



