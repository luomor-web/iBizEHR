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
import cn.ibizlab.ehr.core.par.domain.ParJxbzglmx;
import cn.ibizlab.ehr.core.par.filter.ParJxbzglmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParJxbzglmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParJxbzglmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效标准管理明细] 服务对象接口实现
 */
@Slf4j
@Service("ParJxbzglmxServiceImpl")
public class ParJxbzglmxServiceImpl extends ServiceImpl<ParJxbzglmxMapper, ParJxbzglmx> implements IParJxbzglmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxbzglService parjxbzglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ParJxbzglmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxbzglmxid",et.getParjxbzglmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxbzglmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParJxbzglmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParJxbzglmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParJxbzglmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParJxbzglmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParJxbzglmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ParJxbzglmx get(String key) {
        ParJxbzglmx et = getById(key);
        if(et==null){
            et=new ParJxbzglmx();
            et.setParjxbzglmxid(key);
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
    public boolean create(ParJxbzglmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxbzglmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParJxbzglmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public ParJxbzglmx getDraft(ParJxbzglmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(ParJxbzglmx et) {
        return (!ObjectUtils.isEmpty(et.getParjxbzglmxid()))&&(!Objects.isNull(this.getById(et.getParjxbzglmxid())));
    }

	@Override
    public List<ParJxbzglmx> selectByParjxbzglid(String parjxbzglid) {
        return baseMapper.selectByParjxbzglid(parjxbzglid);
    }

    @Override
    public void removeByParjxbzglid(String parjxbzglid) {
        this.remove(new QueryWrapper<ParJxbzglmx>().eq("parjxbzglid",parjxbzglid));
    }

	@Override
    public List<ParJxbzglmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ParJxbzglmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParJxbzglmx> searchDefault(ParJxbzglmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParJxbzglmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParJxbzglmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParJxbzglmx et){
        //实体关系[DER1N_PARJXBZGLMX_PARJXBZGL_PARJXBZGLID]
        if(!ObjectUtils.isEmpty(et.getParjxbzglid())){
            cn.ibizlab.ehr.core.par.domain.ParJxbzgl parjxbzgl=et.getParjxbzgl();
            if(ObjectUtils.isEmpty(parjxbzgl)){
                cn.ibizlab.ehr.core.par.domain.ParJxbzgl majorEntity=parjxbzglService.get(et.getParjxbzglid());
                et.setParjxbzgl(majorEntity);
                parjxbzgl=majorEntity;
            }
            et.setParjxbzglname(parjxbzgl.getParjxbzglname());
        }
        //实体关系[DER1N_PARJXBZGLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
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
    public List<ParJxbzglmx> getParjxbzglmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParJxbzglmx> getParjxbzglmxByEntities(List<ParJxbzglmx> entities) {
        List ids =new ArrayList();
        for(ParJxbzglmx entity : entities){
            Serializable id=entity.getParjxbzglmxid();
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



