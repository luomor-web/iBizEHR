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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlantermSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainPlantermMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训立项] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainPlantermServiceImpl")
public class TrmTrainPlantermServiceImpl extends ServiceImpl<TrmTrainPlantermMapper, TrmTrainPlanterm> implements ITrmTrainPlantermService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTeacherChargeService trmteacherchargeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTeacherTrainService trmteachertrainService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainBuapplyService trmtrainbuapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPersonService trmtrainpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlantermKBLogic kbLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlantermQXLogic qxLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlantermLXLogic lxLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public TrmTrainPlanterm get(String key) {
        TrmTrainPlanterm et = getById(key);
        if(et==null){
            et=new TrmTrainPlanterm();
            et.setTrmtrainplantermid(key);
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
    public boolean checkKey(TrmTrainPlanterm et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainplantermid()))&&(!Objects.isNull(this.getById(et.getTrmtrainplantermid())));
    }
    @Override
    @Transactional
    public boolean update(TrmTrainPlanterm et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainplantermid",et.getTrmtrainplantermid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplantermid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainPlanterm> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TrmTrainPlanterm et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainPlanterm et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainPlanterm> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainPlanterm> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public TrmTrainPlanterm getDraft(TrmTrainPlanterm et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmTrainPlanterm kB(TrmTrainPlanterm et) {
        kbLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(TrmTrainPlanterm et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplantermid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainPlanterm> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TrmTrainPlanterm qX(TrmTrainPlanterm et) {
        qxLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TrmTrainPlanterm lX(TrmTrainPlanterm et) {
        lxLogic.execute(et);
         return et ;
    }


	@Override
    public List<TrmTrainPlanterm> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmTrainPlanterm>().eq("trmtrainagencyid",trmtrainagencyid));
    }

	@Override
    public List<TrmTrainPlanterm> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TrmTrainPlanterm>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TrmTrainPlanterm> selectByTrmtrainplanid(String trmtrainplanid) {
        return baseMapper.selectByTrmtrainplanid(trmtrainplanid);
    }

    @Override
    public void removeByTrmtrainplanid(String trmtrainplanid) {
        this.remove(new QueryWrapper<TrmTrainPlanterm>().eq("trmtrainplanid",trmtrainplanid));
    }

	@Override
    public List<TrmTrainPlanterm> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TrmTrainPlanterm>().eq("trmtrainteacherid",trmtrainteacherid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainPlanterm> searchDefault(TrmTrainPlantermSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainPlanterm> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainPlanterm>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainPlanterm et){
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINPLAN_TRMTRAINPLANID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplanid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan trmtrainplan=et.getTrmtrainplan();
            if(ObjectUtils.isEmpty(trmtrainplan)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan majorEntity=trmtrainplanService.get(et.getTrmtrainplanid());
                et.setTrmtrainplan(majorEntity);
                trmtrainplan=majorEntity;
            }
            et.setTrmdemdeftionname(trmtrainplan.getTrmdemdeftionname());
            et.setNd(trmtrainplan.getJhnd());
            et.setPxdd(trmtrainplan.getPxdd());
            et.setPxkssj(trmtrainplan.getPxkssj());
            et.setPxjssj(trmtrainplan.getPxjssj());
            et.setTrmtrainplanname(trmtrainplan.getTrmtrainplanname());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINTEACHER_TRMTRAINTEACHERID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainteacherid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher=et.getTrmtrainteacher();
            if(ObjectUtils.isEmpty(trmtrainteacher)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher majorEntity=trmtrainteacherService.get(et.getTrmtrainteacherid());
                et.setTrmtrainteacher(majorEntity);
                trmtrainteacher=majorEntity;
            }
            et.setTrmtrainteachername(trmtrainteacher.getTrmtrainteachername());
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
    public List<TrmTrainPlanterm> getTrmtrainplantermByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainPlanterm> getTrmtrainplantermByEntities(List<TrmTrainPlanterm> entities) {
        List ids =new ArrayList();
        for(TrmTrainPlanterm entity : entities){
            Serializable id=entity.getTrmtrainplantermid();
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



