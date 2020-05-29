package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.PARZNBMMX;
import cn.ibizlab.ehr.core.par.filter.PARZNBMMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARZNBMMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARZNBMMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[通知选择职能部门明细] 服务对象接口实现
 */
@Slf4j
@Service("PARZNBMMXServiceImpl")
public class PARZNBMMXServiceImpl extends ServiceImpl<PARZNBMMXMapper, PARZNBMMX> implements IPARZNBMMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParTzggService partzggService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PARZNBMMX et) {
        return (!ObjectUtils.isEmpty(et.getParznbmmxid()))&&(!Objects.isNull(this.getById(et.getParznbmmxid())));
    }

    @Override
    @Transactional
    public boolean update(PARZNBMMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parznbmmxid",et.getParznbmmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARZNBMMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PARZNBMMX getDraft(PARZNBMMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARZNBMMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARZNBMMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public boolean save(PARZNBMMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARZNBMMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARZNBMMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARZNBMMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PARZNBMMX get(String key) {
        PARZNBMMX et = getById(key);
        if(et==null){
            et=new PARZNBMMX();
            et.setParznbmmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PARZNBMMX> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PARZNBMMX>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PARZNBMMX> selectByPartzggid(String partzggid) {
        return baseMapper.selectByPartzggid(partzggid);
    }

    @Override
    public void removeByPartzggid(String partzggid) {
        this.remove(new QueryWrapper<PARZNBMMX>().eq("partzggid",partzggid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARZNBMMX> searchDefault(PARZNBMMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARZNBMMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARZNBMMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARZNBMMX et){
        //实体关系[DER1N_PARZNBMMX_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setSszz(ormorgsector.getOrgname());
            et.setOrdervalue(ormorgsector.getOrdervalue());
        }
        //实体关系[DER1N_PARZNBMMX_PARTZGG_PARTZGGID]
        if(!ObjectUtils.isEmpty(et.getPartzggid())){
            cn.ibizlab.ehr.core.par.domain.ParTzgg partzgg=et.getPartzgg();
            if(ObjectUtils.isEmpty(partzgg)){
                cn.ibizlab.ehr.core.par.domain.ParTzgg majorEntity=partzggService.get(et.getPartzggid());
                et.setPartzgg(majorEntity);
                partzgg=majorEntity;
            }
            et.setPartzggname(partzgg.getPartzggname());
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
    public List<PARZNBMMX> getParznbmmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PARZNBMMX> getParznbmmxByEntities(List<PARZNBMMX> entities) {
        List ids =new ArrayList();
        for(PARZNBMMX entity : entities){
            Serializable id=entity.getParznbmmxid();
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


