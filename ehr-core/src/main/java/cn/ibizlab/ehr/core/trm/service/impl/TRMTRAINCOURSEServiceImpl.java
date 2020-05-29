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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINCOURSESearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINCOURSEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训课程] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINCOURSEServiceImpl")
public class TRMTRAINCOURSEServiceImpl extends ServiceImpl<TRMTRAINCOURSEMapper, TRMTRAINCOURSE> implements ITRMTRAINCOURSEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDemdeftionService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDepartNeedsService trmdepartneedsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMSTAFFNODESService trmstaffnodesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTEACHERTRAINService trmteachertrainService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandSumService trmtraindemandsumService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCourseSystemService trmcoursesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;

    private int batchSize = 500;

    @Override
    @Transactional
    public TRMTRAINCOURSE get(String key) {
        TRMTRAINCOURSE et = getById(key);
        if(et==null){
            et=new TRMTRAINCOURSE();
            et.setTrmtraincourseid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TRMTRAINCOURSE et) {
        return (!ObjectUtils.isEmpty(et.getTrmtraincourseid()))&&(!Objects.isNull(this.getById(et.getTrmtraincourseid())));
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
    public TRMTRAINCOURSE getDraft(TRMTRAINCOURSE et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINCOURSE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraincourseid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINCOURSE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINCOURSE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtraincourseid",et.getTrmtraincourseid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraincourseid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINCOURSE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TRMTRAINCOURSE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINCOURSE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINCOURSE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINCOURSE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<TRMTRAINCOURSE> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINCOURSE>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINCOURSE> selectByTrmcoursesystemid(String trmcoursesystemid) {
        return baseMapper.selectByTrmcoursesystemid(trmcoursesystemid);
    }

    @Override
    public void removeByTrmcoursesystemid(String trmcoursesystemid) {
        this.remove(new QueryWrapper<TRMTRAINCOURSE>().eq("trmcoursesystemid",trmcoursesystemid));
    }

	@Override
    public List<TRMTRAINCOURSE> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMTRAINCOURSE>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINCOURSE> searchDefault(TRMTRAINCOURSESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINCOURSE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINCOURSE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINCOURSE et){
        //实体关系[DER1N_TRMTRAINCOURSE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINCOURSE_TRMCOURSESYSTEM_TRMCOURSESYSTEMID]
        if(!ObjectUtils.isEmpty(et.getTrmcoursesystemid())){
            cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem trmcoursesystem=et.getTrmcoursesystem();
            if(ObjectUtils.isEmpty(trmcoursesystem)){
                cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem majorEntity=trmcoursesystemService.get(et.getTrmcoursesystemid());
                et.setTrmcoursesystem(majorEntity);
                trmcoursesystem=majorEntity;
            }
            et.setNr(trmcoursesystem.getNr());
            et.setTrmcoursesystemname(trmcoursesystem.getTrmcoursesystemname());
        }
        //实体关系[DER1N_TRMTRAINCOURSE_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
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
    public List<TRMTRAINCOURSE> getTrmtraincourseByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMTRAINCOURSE> getTrmtraincourseByEntities(List<TRMTRAINCOURSE> entities) {
        List ids =new ArrayList();
        for(TRMTRAINCOURSE entity : entities){
            Serializable id=entity.getTrmtraincourseid();
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


