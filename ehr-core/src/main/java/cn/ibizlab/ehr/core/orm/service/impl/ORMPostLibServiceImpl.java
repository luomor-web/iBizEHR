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
import cn.ibizlab.ehr.core.orm.domain.ORMPostLib;
import cn.ibizlab.ehr.core.orm.filter.ORMPostLibSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMPostLibService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMPostLibMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位库] 服务对象接口实现
 */
@Slf4j
@Service("ORMPostLibServiceImpl")
public class ORMPostLibServiceImpl extends ServiceImpl<ORMPostLibMapper, ORMPostLib> implements IORMPostLibService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPostDetailsService ormpostdetailsService;

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
    public boolean save(ORMPostLib et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMPostLib et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMPostLib> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMPostLib> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ORMPostLib et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormpostlibid",et.getOrmpostlibid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostlibid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMPostLib> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ORMPostLib et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostlibid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMPostLib> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public ORMPostLib getDraft(ORMPostLib et) {
        return et;
    }

    @Override
    @Transactional
    public ORMPostLib get(String key) {
        ORMPostLib et = getById(key);
        if(et==null){
            et=new ORMPostLib();
            et.setOrmpostlibid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ORMPostLib et) {
        return (!ObjectUtils.isEmpty(et.getOrmpostlibid()))&&(!Objects.isNull(this.getById(et.getOrmpostlibid())));
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMPostLib> searchDefault(ORMPostLibSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPostLib> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPostLib>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


