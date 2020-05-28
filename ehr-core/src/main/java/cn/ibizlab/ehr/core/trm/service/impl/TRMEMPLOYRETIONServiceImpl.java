package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
import cn.ibizlab.ehr.core.trm.filter.TRMEMPLOYRETIONSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMEMPLOYRETIONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMEMPLOYRETIONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工培训报名] 服务对象接口实现
 */
@Slf4j
@Service("TRMEMPLOYRETIONServiceImpl")
public class TRMEMPLOYRETIONServiceImpl extends ServiceImpl<TRMEMPLOYRETIONMapper, TRMEMPLOYRETION> implements ITRMEMPLOYRETIONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINACTAPPLYService trmtrainactapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;

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
    public TRMEMPLOYRETION getDraft(TRMEMPLOYRETION et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMEMPLOYRETION et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmemployeeretionid",et.getTrmemployretionid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmemployretionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMEMPLOYRETION> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TRMEMPLOYRETION et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMEMPLOYRETION et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMEMPLOYRETION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMEMPLOYRETION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMEMPLOYRETION et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmemployretionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMEMPLOYRETION> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMEMPLOYRETION et) {
        return (!ObjectUtils.isEmpty(et.getTrmemployretionid()))&&(!Objects.isNull(this.getById(et.getTrmemployretionid())));
    }

    @Override
    @Transactional
    public TRMEMPLOYRETION get(String key) {
        TRMEMPLOYRETION et = getById(key);
        if(et==null){
            et=new TRMEMPLOYRETION();
            et.setTrmemployretionid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TRMEMPLOYRETION> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMEMPLOYRETION>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMEMPLOYRETION> selectByTrmcouarrangeid(String trmcouarrangeid) {
        return baseMapper.selectByTrmcouarrangeid(trmcouarrangeid);
    }

    @Override
    public void removeByTrmcouarrangeid(String trmcouarrangeid) {
        this.remove(new QueryWrapper<TRMEMPLOYRETION>().eq("trmcouarrangeid",trmcouarrangeid));
    }

	@Override
    public List<TRMEMPLOYRETION> selectByTrmtrainactapplyid(String trmtrainactapplyid) {
        return baseMapper.selectByTrmtrainactapplyid(trmtrainactapplyid);
    }

    @Override
    public void removeByTrmtrainactapplyid(String trmtrainactapplyid) {
        this.remove(new QueryWrapper<TRMEMPLOYRETION>().eq("trmtrainactapplyid",trmtrainactapplyid));
    }

	@Override
    public List<TRMEMPLOYRETION> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMEMPLOYRETION>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMEMPLOYRETION> searchDefault(TRMEMPLOYRETIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMEMPLOYRETION> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMEMPLOYRETION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMEMPLOYRETION et){
        //实体关系[DER1N_TRMEMPLOYEERETION_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMEMPLOYEERETION_TRMCOUARRANGE_TRMCOUARRANGEID]
        if(!ObjectUtils.isEmpty(et.getTrmcouarrangeid())){
            cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE trmcouarrange=et.getTrmcouarrange();
            if(ObjectUtils.isEmpty(trmcouarrange)){
                cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE majorEntity=trmcouarrangeService.get(et.getTrmcouarrangeid());
                et.setTrmcouarrange(majorEntity);
                trmcouarrange=majorEntity;
            }
            et.setSkksrq(trmcouarrange.getSkksrq());
            et.setTrmcouarrangename(trmcouarrange.getTrmcouarrangename());
            et.setSkjssj(trmcouarrange.getSkjssj());
            et.setKcxs(trmcouarrange.getKcxs());
        }
        //实体关系[DER1N_TRMEMPLOYEERETION_TRMTRAINACTAPPLY_TRMTRAINACTAPPLYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainactapplyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY trmtrainactapply=et.getTrmtrainactapply();
            if(ObjectUtils.isEmpty(trmtrainactapply)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY majorEntity=trmtrainactapplyService.get(et.getTrmtrainactapplyid());
                et.setTrmtrainactapply(majorEntity);
                trmtrainactapply=majorEntity;
            }
            et.setPxhdbm(trmtrainactapply.getPxhdbm());
            et.setTrmtrainactapplyname(trmtrainactapply.getTrmtrainactapplyname());
        }
        //实体关系[DER1N_TRMEMPLOYEERETION_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
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
    public List<TRMEMPLOYRETION> getTrmemployretionByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMEMPLOYRETION> getTrmemployretionByEntities(List<TRMEMPLOYRETION> entities) {
        List ids =new ArrayList();
        for(TRMEMPLOYRETION entity : entities){
            Serializable id=entity.getTrmemployretionid();
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


