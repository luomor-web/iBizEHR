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
import cn.ibizlab.ehr.core.orm.domain.ORMRANK;
import cn.ibizlab.ehr.core.orm.filter.ORMRANKSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMRANKService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMRANKMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职级管理] 服务对象接口实现
 */
@Slf4j
@Service("ORMRANKServiceImpl")
public class ORMRANKServiceImpl extends ServiceImpl<ORMRANKMapper, ORMRANK> implements IORMRANKService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMZWDQGZService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMZJDYZWService pcmzjdyzwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMWORKHISTORYService pimworkhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService trmgradecadresService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ORMRANK et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormrankid",et.getOrmrankid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmrankid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMRANK> list) {
        updateBatchById(list,batchSize);
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
    public boolean save(ORMRANK et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMRANK et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMRANK> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMRANK get(String key) {
        ORMRANK et = getById(key);
        if(et==null){
            et=new ORMRANK();
            et.setOrmrankid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ORMRANK et) {
        return (!ObjectUtils.isEmpty(et.getOrmrankid()))&&(!Objects.isNull(this.getById(et.getOrmrankid())));
    }

    @Override
    public ORMRANK getDraft(ORMRANK et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(ORMRANK et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmrankid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMRANK> list) {
        saveBatch(list,batchSize);
    }



    /**
     * 查询集合 JZRANK
     */
    @Override
    public Page<ORMRANK> searchJZRANK(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchJZRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 JSRANK
     */
    @Override
    public Page<ORMRANK> searchJSRANK(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchJSRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 D级以下
     */
    @Override
    public Page<ORMRANK> searchDJYX(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchDJYX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 JSNRANK
     */
    @Override
    public Page<ORMRANK> searchJSNRANK(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchJSNRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMRANK> searchDefault(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据登录人身份判定职级显示
     */
    @Override
    public Page<ORMRANK> searchCurRank(ORMRANKSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMRANK> pages=baseMapper.searchCurRank(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMRANK>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


