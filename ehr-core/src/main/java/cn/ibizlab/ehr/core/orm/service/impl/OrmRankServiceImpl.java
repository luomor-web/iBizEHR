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
import cn.ibizlab.ehr.core.orm.domain.OrmRank;
import cn.ibizlab.ehr.core.orm.filter.OrmRankSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmRankService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmRankMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职级管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmRankServiceImpl")
public class OrmRankServiceImpl extends ServiceImpl<OrmRankMapper, OrmRank> implements IOrmRankService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmZwdqgzService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmZjdyzwService pcmzjdyzwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimWorkHistoryService pimworkhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService trmgradecadresService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(OrmRank et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormrankid",et.getOrmrankid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmrankid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmRank> list) {
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
    public boolean save(OrmRank et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmRank et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmRank> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmRank> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmRank get(String key) {
        OrmRank et = getById(key);
        if(et==null){
            et=new OrmRank();
            et.setOrmrankid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(OrmRank et) {
        return (!ObjectUtils.isEmpty(et.getOrmrankid()))&&(!Objects.isNull(this.getById(et.getOrmrankid())));
    }
    @Override
    public OrmRank getDraft(OrmRank et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmRank et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmrankid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmRank> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 JZRANK
     */
    @Override
    public Page<OrmRank> searchJZRANK(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchJZRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 JSRANK
     */
    @Override
    public Page<OrmRank> searchJSRANK(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchJSRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 D级以下
     */
    @Override
    public Page<OrmRank> searchDJYX(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchDJYX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 JSNRANK
     */
    @Override
    public Page<OrmRank> searchJSNRANK(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchJSNRANK(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmRank> searchDefault(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据登录人身份判定职级显示
     */
    @Override
    public Page<OrmRank> searchCurRank(OrmRankSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmRank> pages=baseMapper.searchCurRank(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmRank>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmRank> getOrmrankByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmRank> getOrmrankByEntities(List<OrmRank> entities) {
        List ids =new ArrayList();
        for(OrmRank entity : entities){
            Serializable id=entity.getOrmrankid();
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



