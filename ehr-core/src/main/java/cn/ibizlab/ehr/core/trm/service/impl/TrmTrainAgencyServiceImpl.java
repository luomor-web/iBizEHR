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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAgencySearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainAgencyMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训机构] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainAgencyServiceImpl")
public class TrmTrainAgencyServiceImpl extends ServiceImpl<TrmTrainAgencyMapper, TrmTrainAgency> implements ITrmTrainAgencyService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmAgencyRecordService trmagencyrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCourseSystemService trmcoursesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDepartNeedsService trmdepartneedsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmEmployeeRetionService trmemployeeretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmHmatserService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmInvoiceService trminvoiceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffnodesService trmstaffnodesService;

    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDataService trmtraindataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TrmTrainAgency et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainAgency et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainAgency> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainAgency> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmTrainAgency et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainagencyid()))&&(!Objects.isNull(this.getById(et.getTrmtrainagencyid())));
    }
    @Override
    public TrmTrainAgency getDraft(TrmTrainAgency et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmTrainAgency get(String key) {
        TrmTrainAgency et = getById(key);
        if(et==null){
            et=new TrmTrainAgency();
            et.setTrmtrainagencyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TrmTrainAgency et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainagencyid",et.getTrmtrainagencyid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainagencyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainAgency> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmTrainAgency et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainagencyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainAgency> list) {
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
    public List<TrmTrainAgency> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmTrainAgency>().eq("ormorgid",orgid));
    }

	@Override
    public List<TrmTrainAgency> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TrmTrainAgency>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TrmTrainAgency> selectByTrmtrainagencyid2(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid2(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid2(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TrmTrainAgency>().eq("trmtrainagencyid2",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainAgency> searchDefault(TrmTrainAgencySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainAgency> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainAgency>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainAgency et){
        //实体关系[DER1N_TRMTRAINAGENCY_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINAGENCY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setLxdh(pimperson.getLxdh());
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMTRAINAGENCY_TRMTRAINAGENCY_TRMTRAINAGENCYID2]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid2())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency2=et.getTrmtrainagency2();
            if(ObjectUtils.isEmpty(trmtrainagency2)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid2());
                et.setTrmtrainagency2(majorEntity);
                trmtrainagency2=majorEntity;
            }
            et.setTrmtrainagencyname2(trmtrainagency2.getTrmtrainagencyname());
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
    public List<TrmTrainAgency> getTrmtrainagencyByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainAgency> getTrmtrainagencyByEntities(List<TrmTrainAgency> entities) {
        List ids =new ArrayList();
        for(TrmTrainAgency entity : entities){
            Serializable id=entity.getTrmtrainagencyid();
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



