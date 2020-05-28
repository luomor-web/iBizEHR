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
import cn.ibizlab.ehr.core.orm.domain.ORMORGInfo;
import cn.ibizlab.ehr.core.orm.filter.ORMORGInfoSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMORGInfoService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMORGInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织信息] 服务对象接口实现
 */
@Slf4j
@Service("ORMORGInfoServiceImpl")
public class ORMORGInfoServiceImpl extends ServiceImpl<ORMORGInfoMapper, ORMORGInfo> implements IORMORGInfoService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(ORMORGInfo et) {
        return (!ObjectUtils.isEmpty(et.getOrmorginfoid()))&&(!Objects.isNull(this.getById(et.getOrmorginfoid())));
    }

    @Override
    @Transactional
    public boolean save(ORMORGInfo et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMORGInfo et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMORGInfo> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMORGInfo> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ORMORGInfo getDraft(ORMORGInfo et) {
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
    public ORMORGInfo get(String key) {
        ORMORGInfo et = getById(key);
        if(et==null){
            et=new ORMORGInfo();
            et.setOrmorginfoid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(ORMORGInfo et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmorginfoid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMORGInfo> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ORMORGInfo et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormorginfoid",et.getOrmorginfoid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmorginfoid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMORGInfo> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 子部门查询
     */
    @Override
    public Page<ORMORGInfo> searchSubOrgsector(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchSubOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自定义查询
     */
    @Override
    public Page<ORMORGInfo> searchCX(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 部门/项目部查询
     */
    @Override
    public Page<ORMORGInfo> searchCurOrgsector(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchCurOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织查询
     */
    @Override
    public Page<ORMORGInfo> searchCurChild(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchCurChild(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根组织查询
     */
    @Override
    public Page<ORMORGInfo> searchCurPorg(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchCurPorg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前部门/项目部人员清单
     */
    @Override
    public Page<ORMORGInfo> searchSubPerson(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchSubPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMORGInfo> searchDefault(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织所包含的直接下级组织查询
     */
    @Override
    public Page<ORMORGInfo> searchSuborg(ORMORGInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGInfo> pages=baseMapper.searchSuborg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<ORMORGInfo> getOrmorginfoByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ORMORGInfo> getOrmorginfoByEntities(List<ORMORGInfo> entities) {
        List ids =new ArrayList();
        for(ORMORGInfo entity : entities){
            Serializable id=entity.getOrmorginfoid();
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


