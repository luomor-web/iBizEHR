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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainCourseSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainCourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训课程] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainCourseServiceImpl")
public class TrmTrainCourseServiceImpl extends ServiceImpl<TrmTrainCourseMapper, TrmTrainCourse> implements ITrmTrainCourseService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDemdeftionService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDepartNeedsService trmdepartneedsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffnodesService trmstaffnodesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTeacherTrainService trmteachertrainService;
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
    public TrmTrainCourse get(String key) {
        TrmTrainCourse et = getById(key);
        if(et==null){
            et=new TrmTrainCourse();
            et.setTrmtraincourseid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TrmTrainCourse et) {
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
    public TrmTrainCourse getDraft(TrmTrainCourse et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmTrainCourse et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraincourseid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainCourse> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmTrainCourse et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtraincourseid",et.getTrmtraincourseid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraincourseid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainCourse> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TrmTrainCourse et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainCourse et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainCourse> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainCourse> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<TrmTrainCourse> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmTrainCourse>().eq("ormorgid",orgid));
    }

	@Override
    public List<TrmTrainCourse> selectByTrmcoursesystemid(String trmcoursesystemid) {
        return baseMapper.selectByTrmcoursesystemid(trmcoursesystemid);
    }

    @Override
    public void removeByTrmcoursesystemid(String trmcoursesystemid) {
        this.remove(new QueryWrapper<TrmTrainCourse>().eq("trmcoursesystemid",trmcoursesystemid));
    }

	@Override
    public List<TrmTrainCourse> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmTrainCourse>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainCourse> searchDefault(TrmTrainCourseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainCourse> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainCourse>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainCourse et){
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
    public List<TrmTrainCourse> getTrmtraincourseByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainCourse> getTrmtraincourseByEntities(List<TrmTrainCourse> entities) {
        List ids =new ArrayList();
        for(TrmTrainCourse entity : entities){
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



