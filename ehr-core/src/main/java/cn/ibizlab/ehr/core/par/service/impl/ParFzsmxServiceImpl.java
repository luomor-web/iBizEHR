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
import cn.ibizlab.ehr.core.par.domain.ParFzsmx;
import cn.ibizlab.ehr.core.par.filter.ParFzsmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParFzsmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParFzsmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[通知选择助总领导明细] 服务对象接口实现
 */
@Slf4j
@Service("ParFzsmxServiceImpl")
public class ParFzsmxServiceImpl extends ServiceImpl<ParFzsmxMapper, ParFzsmx> implements IParFzsmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParTzggService partzggService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public ParFzsmx getDraft(ParFzsmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(ParFzsmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parfzsmxid",et.getParfzsmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParfzsmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParFzsmx> list) {
        list.forEach(item->fillParentData(item));
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
    public boolean create(ParFzsmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParfzsmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParFzsmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ParFzsmx et) {
        return (!ObjectUtils.isEmpty(et.getParfzsmxid()))&&(!Objects.isNull(this.getById(et.getParfzsmxid())));
    }
    @Override
    @Transactional
    public boolean save(ParFzsmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParFzsmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParFzsmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParFzsmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ParFzsmx get(String key) {
        ParFzsmx et = getById(key);
        if(et==null){
            et=new ParFzsmx();
            et.setParfzsmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<ParFzsmx> selectByPartzggid(String partzggid) {
        return baseMapper.selectByPartzggid(partzggid);
    }

    @Override
    public void removeByPartzggid(String partzggid) {
        this.remove(new QueryWrapper<ParFzsmx>().eq("partzggid",partzggid));
    }

	@Override
    public List<ParFzsmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ParFzsmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParFzsmx> searchDefault(ParFzsmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParFzsmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParFzsmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParFzsmx et){
        //实体关系[DER1N_PARFZSMX_PARTZGG_PARTZGGID]
        if(!ObjectUtils.isEmpty(et.getPartzggid())){
            cn.ibizlab.ehr.core.par.domain.ParTzgg partzgg=et.getPartzgg();
            if(ObjectUtils.isEmpty(partzgg)){
                cn.ibizlab.ehr.core.par.domain.ParTzgg majorEntity=partzggService.get(et.getPartzggid());
                et.setPartzgg(majorEntity);
                partzgg=majorEntity;
            }
            et.setPartzggname(partzgg.getPartzggname());
        }
        //实体关系[DER1N_PARFZSMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setSszz(pimperson.getOrmorgname());
            et.setSsbm(pimperson.getOrmorgsectorname());
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
    public List<ParFzsmx> getParfzsmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParFzsmx> getParfzsmxByEntities(List<ParFzsmx> entities) {
        List ids =new ArrayList();
        for(ParFzsmx entity : entities){
            Serializable id=entity.getParfzsmxid();
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



