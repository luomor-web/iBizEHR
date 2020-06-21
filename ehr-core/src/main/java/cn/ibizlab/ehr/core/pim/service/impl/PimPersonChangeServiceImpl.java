package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimPersonChange;
import cn.ibizlab.ehr.core.pim.filter.PimPersonChangeSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimPersonChangeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimPersonChangeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员信息变更审核] 服务对象接口实现
 */
@Slf4j
@Service("PimPersonChangeServiceImpl")
public class PimPersonChangeServiceImpl extends ServiceImpl<PimPersonChangeMapper, PimPersonChange> implements IPimPersonChangeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PimPersonChange et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimPersonChange et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimPersonChange> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimPersonChange> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimPersonChange bH(PimPersonChange et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimPersonChange ensure(PimPersonChange et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimPersonChange et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonchangeid",et.getPimpersonchangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonchangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimPersonChange> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimPersonChange get(String key) {
        PimPersonChange et = getById(key);
        if(et==null){
            et=new PimPersonChange();
            et.setPimpersonchangeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimPersonChange et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonchangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimPersonChange> list) {
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
    public PimPersonChange qR(PimPersonChange et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PimPersonChange et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonchangeid()))&&(!Objects.isNull(this.getById(et.getPimpersonchangeid())));
    }
    @Override
    public PimPersonChange getDraft(PimPersonChange et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PimPersonChange> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimPersonChange>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 历史审批记录
     */
    @Override
    public Page<PimPersonChange> searchHistoryRec(PimPersonChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPersonChange> pages=baseMapper.searchHistoryRec(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPersonChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 PIMCL_NOTAPPROVAL
     */
    @Override
    public Page<PimPersonChange> searchPIMCL_NOTAPPROVAL(PimPersonChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPersonChange> pages=baseMapper.searchPIMCL_NOTAPPROVAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPersonChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 总部记录
     */
    @Override
    public Page<PimPersonChange> searchHeadRed(PimPersonChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPersonChange> pages=baseMapper.searchHeadRed(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPersonChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimPersonChange> searchDefault(PimPersonChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPersonChange> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPersonChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimPersonChange et){
        //实体关系[DER1N_PIMPERSONCHANGE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
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
    public List<PimPersonChange> getPimpersonchangeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimPersonChange> getPimpersonchangeByEntities(List<PimPersonChange> entities) {
        List ids =new ArrayList();
        for(PimPersonChange entity : entities){
            Serializable id=entity.getPimpersonchangeid();
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



