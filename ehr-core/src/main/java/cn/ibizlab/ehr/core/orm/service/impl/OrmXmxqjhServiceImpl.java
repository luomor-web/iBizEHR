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
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqjhSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmXmxqjhService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmXmxqjhMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目需求计划] 服务对象接口实现
 */
@Slf4j
@Service("OrmXmxqjhServiceImpl")
public class OrmXmxqjhServiceImpl extends ServiceImpl<OrmXmxqjhMapper, OrmXmxqjh> implements IOrmXmxqjhService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmglService ormxmglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public OrmXmxqjh get(String key) {
        OrmXmxqjh et = getById(key);
        if(et==null){
            et=new OrmXmxqjh();
            et.setOrmxmxqjhid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public OrmXmxqjh getDraft(OrmXmxqjh et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmXmxqjh et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmXmxqjh et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmXmxqjh> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmXmxqjh> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmXmxqjh tJ(OrmXmxqjh et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmxqjh cLWC(OrmXmxqjh et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmXmxqjh et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmxqjhid",et.getOrmxmxqjhid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqjhid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmXmxqjh> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(OrmXmxqjh et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqjhid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmXmxqjh> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmXmxqjh sHBTG(OrmXmxqjh et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(OrmXmxqjh et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmxqjhid()))&&(!Objects.isNull(this.getById(et.getOrmxmxqjhid())));
    }
    @Override
    @Transactional
    public OrmXmxqjh ensure(OrmXmxqjh et) {
        //自定义代码
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
    public List<OrmXmxqjh> selectByOrmxmglid(String ormxmglid) {
        return baseMapper.selectByOrmxmglid(ormxmglid);
    }

    @Override
    public void removeByOrmxmglid(String ormxmglid) {
        this.remove(new QueryWrapper<OrmXmxqjh>().eq("ormxmglid",ormxmglid));
    }

	@Override
    public List<OrmXmxqjh> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmXmxqjh>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 项目人力需求（项目负责人）
     */
    @Override
    public Page<OrmXmxqjh> searchBaseInfo(OrmXmxqjhSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqjh> pages=baseMapper.searchBaseInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqjh>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力需求（保存、提交权限）
     */
    @Override
    public Page<OrmXmxqjh> searchXMTJQX(OrmXmxqjhSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqjh> pages=baseMapper.searchXMTJQX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqjh>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmXmxqjh> searchDefault(OrmXmxqjhSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqjh> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqjh>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力需求（人力审核）
     */
    @Override
    public Page<OrmXmxqjh> searchRsshInfo(OrmXmxqjhSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmxqjh> pages=baseMapper.searchRsshInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmxqjh>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmXmxqjh et){
        //实体关系[DER1N_ORMXMXQJH_ORMXMGL_ORMXMGLID]
        if(!ObjectUtils.isEmpty(et.getOrmxmglid())){
            cn.ibizlab.ehr.core.orm.domain.OrmXmgl ormxmgl=et.getOrmxmgl();
            if(ObjectUtils.isEmpty(ormxmgl)){
                cn.ibizlab.ehr.core.orm.domain.OrmXmgl majorEntity=ormxmglService.get(et.getOrmxmglid());
                et.setOrmxmgl(majorEntity);
                ormxmgl=majorEntity;
            }
            et.setOrmxmglname(ormxmgl.getProjectName());
            et.setXmbh(ormxmgl.getProjectNumber());
        }
        //实体关系[DER1N_ORMXMXQJH_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
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
    public List<OrmXmxqjh> getOrmxmxqjhByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmXmxqjh> getOrmxmxqjhByEntities(List<OrmXmxqjh> entities) {
        List ids =new ArrayList();
        for(OrmXmxqjh entity : entities){
            Serializable id=entity.getOrmxmxqjhid();
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



