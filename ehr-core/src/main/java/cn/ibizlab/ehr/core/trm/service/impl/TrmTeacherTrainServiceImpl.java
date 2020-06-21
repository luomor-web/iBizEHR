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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherTrain;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherTrainSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTeacherTrainService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTeacherTrainMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[讲师授课记录] 服务对象接口实现
 */
@Slf4j
@Service("TrmTeacherTrainServiceImpl")
public class TrmTeacherTrainServiceImpl extends ServiceImpl<TrmTeacherTrainMapper, TrmTeacherTrain> implements ITrmTeacherTrainService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService trmtrainaddressService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TrmTeacherTrain et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTeacherTrain et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTeacherTrain> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTeacherTrain> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public TrmTeacherTrain getDraft(TrmTeacherTrain et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmTeacherTrain et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmteachertrainid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTeacherTrain> list) {
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
    public TrmTeacherTrain get(String key) {
        TrmTeacherTrain et = getById(key);
        if(et==null){
            et=new TrmTeacherTrain();
            et.setTrmteachertrainid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TrmTeacherTrain et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmteachertrainid",et.getTrmteachertrainid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmteachertrainid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTeacherTrain> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmTeacherTrain et) {
        return (!ObjectUtils.isEmpty(et.getTrmteachertrainid()))&&(!Objects.isNull(this.getById(et.getTrmteachertrainid())));
    }

	@Override
    public List<TrmTeacherTrain> selectByTrmtrainaddressid(String trmtrainaddressid) {
        return baseMapper.selectByTrmtrainaddressid(trmtrainaddressid);
    }

    @Override
    public void removeByTrmtrainaddressid(String trmtrainaddressid) {
        this.remove(new QueryWrapper<TrmTeacherTrain>().eq("trmtrainaddressid",trmtrainaddressid));
    }

	@Override
    public List<TrmTeacherTrain> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TrmTeacherTrain>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TrmTeacherTrain> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<TrmTeacherTrain>().eq("trmtrainplantermid",trmtrainplantermid));
    }

	@Override
    public List<TrmTeacherTrain> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TrmTeacherTrain>().eq("trmtrainteacherid",trmtrainteacherid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTeacherTrain> searchDefault(TrmTeacherTrainSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTeacherTrain> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTeacherTrain>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTeacherTrain et){
        //实体关系[DER1N_TRMTEACHERTRAIN_TRMTRAINADDRESS_TRMTRAINADDRESSID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainaddressid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress=et.getTrmtrainaddress();
            if(ObjectUtils.isEmpty(trmtrainaddress)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress majorEntity=trmtrainaddressService.get(et.getTrmtrainaddressid());
                et.setTrmtrainaddress(majorEntity);
                trmtrainaddress=majorEntity;
            }
            et.setTrmtrainaddressname(trmtrainaddress.getTrmtrainaddressname());
        }
        //实体关系[DER1N_TRMTEACHERTRAIN_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMTEACHERTRAIN_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
            et.setPxjssj(trmtrainplanterm.getPxjssj());
            et.setPxsc(trmtrainplanterm.getPxsc());
            et.setPxkssj(trmtrainplanterm.getPxkssj());
        }
        //实体关系[DER1N_TRMTEACHERTRAIN_TRMTRAINTEACHER_TRMTRAINTEACHERID]
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
    public List<TrmTeacherTrain> getTrmteachertrainByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTeacherTrain> getTrmteachertrainByEntities(List<TrmTeacherTrain> entities) {
        List ids =new ArrayList();
        for(TrmTeacherTrain entity : entities){
            Serializable id=entity.getTrmteachertrainid();
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



