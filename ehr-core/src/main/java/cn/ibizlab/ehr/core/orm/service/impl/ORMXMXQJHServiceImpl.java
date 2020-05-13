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
import cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH;
import cn.ibizlab.ehr.core.orm.filter.ORMXMXQJHSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMXMXQJHService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMXMXQJHMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目需求计划] 服务对象接口实现
 */
@Slf4j
@Service("ORMXMXQJHServiceImpl")
public class ORMXMXQJHServiceImpl extends ServiceImpl<ORMXMXQJHMapper, ORMXMXQJH> implements IORMXMXQJHService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMGLService ormxmglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ORMXMXQJH get(String key) {
        ORMXMXQJH et = getById(key);
        if(et==null){
            et=new ORMXMXQJH();
            et.setOrmxmxqjhid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ORMXMXQJH getDraft(ORMXMXQJH et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMXMXQJH et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMXMXQJH et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMXMXQJH> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMXMXQJH tJ(ORMXMXQJH et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMXQJH cLWC(ORMXMXQJH et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMXMXQJH et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmxqjhid",et.getOrmxmxqjhid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqjhid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMXMXQJH> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ORMXMXQJH et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmxqjhid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMXMXQJH> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMXMXQJH sHBTG(ORMXMXQJH et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(ORMXMXQJH et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmxqjhid()))&&(!Objects.isNull(this.getById(et.getOrmxmxqjhid())));
    }

    @Override
    @Transactional
    public ORMXMXQJH ensure(ORMXMXQJH et) {
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
    public List<ORMXMXQJH> selectByOrmxmglid(String ormxmglid) {
        return baseMapper.selectByOrmxmglid(ormxmglid);
    }

    @Override
    public void removeByOrmxmglid(String ormxmglid) {
        this.remove(new QueryWrapper<ORMXMXQJH>().eq("ormxmglid",ormxmglid));
    }

	@Override
    public List<ORMXMXQJH> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMXMXQJH>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 项目人力需求（项目负责人）
     */
    @Override
    public Page<ORMXMXQJH> searchBaseInfo(ORMXMXQJHSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMXQJH> pages=baseMapper.searchBaseInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMXQJH>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力需求（保存、提交权限）
     */
    @Override
    public Page<ORMXMXQJH> searchXMTJQX(ORMXMXQJHSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMXQJH> pages=baseMapper.searchXMTJQX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMXQJH>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMXMXQJH> searchDefault(ORMXMXQJHSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMXQJH> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMXQJH>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力需求（人力审核）
     */
    @Override
    public Page<ORMXMXQJH> searchRsshInfo(ORMXMXQJHSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMXQJH> pages=baseMapper.searchRsshInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMXQJH>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMXMXQJH et){
        //实体关系[DER1N_ORMXMXQJH_ORMXMGL_ORMXMGLID]
        if(!ObjectUtils.isEmpty(et.getOrmxmglid())){
            cn.ibizlab.ehr.core.orm.domain.ORMXMGL ormxmgl=et.getOrmxmgl();
            if(ObjectUtils.isEmpty(ormxmgl)){
                cn.ibizlab.ehr.core.orm.domain.ORMXMGL majorEntity=ormxmglService.get(et.getOrmxmglid());
                et.setOrmxmgl(majorEntity);
                ormxmgl=majorEntity;
            }
            et.setOrmxmglname(ormxmgl.getProjectName());
            et.setXmbh(ormxmgl.getProjectNumber());
        }
        //实体关系[DER1N_ORMXMXQJH_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


