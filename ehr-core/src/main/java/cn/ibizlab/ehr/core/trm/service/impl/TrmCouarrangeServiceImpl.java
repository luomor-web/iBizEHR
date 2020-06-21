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
import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
import cn.ibizlab.ehr.core.trm.filter.TrmCouarrangeSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmCouarrangeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训记录] 服务对象接口实现
 */
@Slf4j
@Service("TrmCouarrangeServiceImpl")
public class TrmCouarrangeServiceImpl extends ServiceImpl<TrmCouarrangeMapper, TrmCouarrange> implements ITrmCouarrangeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmEmployeeRetionService trmemployeeretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmAgencyRecordService trmagencyrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCourseSystemService trmcoursesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainActapplyService trmtrainactapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService trmtrainaddressService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainFaciesService trmtrainfaciesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPersonService trmtrainpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TrmCouarrange et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmcouarrangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmCouarrange> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TrmCouarrange get(String key) {
        TrmCouarrange et = getById(key);
        if(et==null){
            et=new TrmCouarrange();
            et.setTrmcouarrangeid(key);
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
    public TrmCouarrange getDraft(TrmCouarrange et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TrmCouarrange et) {
        return (!ObjectUtils.isEmpty(et.getTrmcouarrangeid()))&&(!Objects.isNull(this.getById(et.getTrmcouarrangeid())));
    }
    @Override
    @Transactional
    public boolean save(TrmCouarrange et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmCouarrange et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmCouarrange> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmCouarrange> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmCouarrange et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmcouarrangeid",et.getTrmcouarrangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmcouarrangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmCouarrange> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<TrmCouarrange> selectByTrmagencyrecordid(String trmagencyrecordid) {
        return baseMapper.selectByTrmagencyrecordid(trmagencyrecordid);
    }

    @Override
    public void removeByTrmagencyrecordid(String trmagencyrecordid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmagencyrecordid",trmagencyrecordid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmcoursesystemid(String trmcoursesystemid) {
        return baseMapper.selectByTrmcoursesystemid(trmcoursesystemid);
    }

    @Override
    public void removeByTrmcoursesystemid(String trmcoursesystemid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmcoursesystemid",trmcoursesystemid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainactapplyid(String trmtrainactapplyid) {
        return baseMapper.selectByTrmtrainactapplyid(trmtrainactapplyid);
    }

    @Override
    public void removeByTrmtrainactapplyid(String trmtrainactapplyid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainactapplyid",trmtrainactapplyid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainaddressid(String trmtrainaddressid) {
        return baseMapper.selectByTrmtrainaddressid(trmtrainaddressid);
    }

    @Override
    public void removeByTrmtrainaddressid(String trmtrainaddressid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainaddressid",trmtrainaddressid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainagencyid",trmtrainagencyid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainfaciesid(String trmtrainfaciesid) {
        return baseMapper.selectByTrmtrainfaciesid(trmtrainfaciesid);
    }

    @Override
    public void removeByTrmtrainfaciesid(String trmtrainfaciesid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainfaciesid",trmtrainfaciesid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainplantermid",trmtrainplantermid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrainteacherid",trmtrainteacherid));
    }

	@Override
    public List<TrmCouarrange> selectByTrmtrianpersonid(String trmtrianpersonid) {
        return baseMapper.selectByTrmtrianpersonid(trmtrianpersonid);
    }

    @Override
    public void removeByTrmtrianpersonid(String trmtrianpersonid) {
        this.remove(new QueryWrapper<TrmCouarrange>().eq("trmtrianpersonid",trmtrianpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmCouarrange> searchDefault(TrmCouarrangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmCouarrange> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmCouarrange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmCouarrange et){
        //实体关系[DER1N_TRMCOUARRANGE_TRMAGENCYRECORD_TRMAGENCYRECORDID]
        if(!ObjectUtils.isEmpty(et.getTrmagencyrecordid())){
            cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord trmagencyrecord=et.getTrmagencyrecord();
            if(ObjectUtils.isEmpty(trmagencyrecord)){
                cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord majorEntity=trmagencyrecordService.get(et.getTrmagencyrecordid());
                et.setTrmagencyrecord(majorEntity);
                trmagencyrecord=majorEntity;
            }
            et.setTrmagencyrecordname(trmagencyrecord.getTrmagencyrecordname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMCOURSESYSTEM_TRMCOURSESYSTEMID]
        if(!ObjectUtils.isEmpty(et.getTrmcoursesystemid())){
            cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem trmcoursesystem=et.getTrmcoursesystem();
            if(ObjectUtils.isEmpty(trmcoursesystem)){
                cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem majorEntity=trmcoursesystemService.get(et.getTrmcoursesystemid());
                et.setTrmcoursesystem(majorEntity);
                trmcoursesystem=majorEntity;
            }
            et.setTrmcoursesystemname(trmcoursesystem.getTrmcoursesystemname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINACTAPPLY_TRMTRAINACTAPPLYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainactapplyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply trmtrainactapply=et.getTrmtrainactapply();
            if(ObjectUtils.isEmpty(trmtrainactapply)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply majorEntity=trmtrainactapplyService.get(et.getTrmtrainactapplyid());
                et.setTrmtrainactapply(majorEntity);
                trmtrainactapply=majorEntity;
            }
            et.setTrmtrainactapplyname(trmtrainactapply.getTrmtrainactapplyname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINADDRESS_TRMTRAINADDRESSID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainaddressid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress=et.getTrmtrainaddress();
            if(ObjectUtils.isEmpty(trmtrainaddress)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress majorEntity=trmtrainaddressService.get(et.getTrmtrainaddressid());
                et.setTrmtrainaddress(majorEntity);
                trmtrainaddress=majorEntity;
            }
            et.setTrmtrainaddressname(trmtrainaddress.getTrmtrainaddressname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINFACIES_TRMTRAINFACIESID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainfaciesid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainFacies trmtrainfacies=et.getTrmtrainfacies();
            if(ObjectUtils.isEmpty(trmtrainfacies)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainFacies majorEntity=trmtrainfaciesService.get(et.getTrmtrainfaciesid());
                et.setTrmtrainfacies(majorEntity);
                trmtrainfacies=majorEntity;
            }
            et.setTrmtrainfaciesname(trmtrainfacies.getTrmtrainfaciesname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINTEACHER_TRMTRAINTEACHERID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainteacherid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher trmtrainteacher=et.getTrmtrainteacher();
            if(ObjectUtils.isEmpty(trmtrainteacher)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher majorEntity=trmtrainteacherService.get(et.getTrmtrainteacherid());
                et.setTrmtrainteacher(majorEntity);
                trmtrainteacher=majorEntity;
            }
            et.setTrmtrainteachername(trmtrainteacher.getTrmtrainteachername());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRIANPERSON_TRMTRIANPERSONID]
        if(!ObjectUtils.isEmpty(et.getTrmtrianpersonid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson trmtrianperson=et.getTrmtrianperson();
            if(ObjectUtils.isEmpty(trmtrianperson)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson majorEntity=trmtrainpersonService.get(et.getTrmtrianpersonid());
                et.setTrmtrianperson(majorEntity);
                trmtrianperson=majorEntity;
            }
            et.setTrmtrianpersonname(trmtrianperson.getTrmtrianpersonname());
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
    public List<TrmCouarrange> getTrmcouarrangeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmCouarrange> getTrmcouarrangeByEntities(List<TrmCouarrange> entities) {
        List ids =new ArrayList();
        for(TrmCouarrange entity : entities){
            Serializable id=entity.getTrmcouarrangeid();
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



