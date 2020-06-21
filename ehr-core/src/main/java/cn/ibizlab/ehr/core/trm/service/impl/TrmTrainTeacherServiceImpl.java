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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainTeacherSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainTeacherMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训讲师] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainTeacherServiceImpl")
public class TrmTrainTeacherServiceImpl extends ServiceImpl<TrmTrainTeacherMapper, TrmTrainTeacher> implements ITrmTrainTeacherService {

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
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;

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
    @Transactional
    public boolean update(TrmTrainTeacher et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainteacherid",et.getTrmtrainteacherid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainteacherid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainTeacher> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public TrmTrainTeacher getDraft(TrmTrainTeacher et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmTrainTeacher get(String key) {
        TrmTrainTeacher et = getById(key);
        if(et==null){
            et=new TrmTrainTeacher();
            et.setTrmtrainteacherid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TrmTrainTeacher et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainteacherid()))&&(!Objects.isNull(this.getById(et.getTrmtrainteacherid())));
    }
    @Override
    @Transactional
    public boolean save(TrmTrainTeacher et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainTeacher et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainTeacher> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainTeacher> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmTrainTeacher et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainteacherid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainTeacher> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<TrmTrainTeacher> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmTrainTeacher>().eq("ormorgid",orgid));
    }

	@Override
    public List<TrmTrainTeacher> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TrmTrainTeacher>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TrmTrainTeacher> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmTrainTeacher>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 内部讲师
     */
    @Override
    public Page<TrmTrainTeacher> searchNBJS(TrmTrainTeacherSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainTeacher> pages=baseMapper.searchNBJS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainTeacher>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 外部讲师
     */
    @Override
    public Page<TrmTrainTeacher> searchWBJS(TrmTrainTeacherSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainTeacher> pages=baseMapper.searchWBJS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainTeacher>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainTeacher> searchDefault(TrmTrainTeacherSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainTeacher> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainTeacher>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainTeacher et){
        //实体关系[DER1N_TRMTRAINTEACHER_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_TRMTRAINTEACHER_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setNl(pimperson.getNl());
            et.setXb(pimperson.getXb());
            et.setZjhm(pimperson.getZjhm());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setLxdh(pimperson.getLxdh());
            et.setZw(pimperson.getZw());
            et.setAhtc(pimperson.getAhtc());
            et.setDzyx(pimperson.getDzyx());
        }
        //实体关系[DER1N_TRMTRAINTEACHER_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
            et.setJglb(trmtrainagency.getJglb());
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
    public List<TrmTrainTeacher> getTrmtrainteacherByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainTeacher> getTrmtrainteacherByEntities(List<TrmTrainTeacher> entities) {
        List ids =new ArrayList();
        for(TrmTrainTeacher entity : entities){
            Serializable id=entity.getTrmtrainteacherid();
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



