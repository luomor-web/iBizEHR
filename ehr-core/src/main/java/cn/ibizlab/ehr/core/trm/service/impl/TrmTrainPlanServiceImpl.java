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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlanSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainPlanMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训计划] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainPlanServiceImpl")
public class TrmTrainPlanServiceImpl extends ServiceImpl<TrmTrainPlanMapper, TrmTrainPlan> implements ITrmTrainPlanService {

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
    private cn.ibizlab.ehr.core.trm.service.ITrmDemdeftionService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmPlanFormuService trmplanformuService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlanSetYfbZtLogic setyfbztLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlanSetDfbZtLogic setdfbztLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlanSetApprovalStatusLogic setapprovalstatusLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITrmTrainPlanSetRejectStatusLogic setrejectstatusLogic;

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
    public boolean save(TrmTrainPlan et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainPlan et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainPlan> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainPlan> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TrmTrainPlan setYfbZt(TrmTrainPlan et) {
        setyfbztLogic.execute(et);
         return et ;
    }

    @Override
    public TrmTrainPlan getDraft(TrmTrainPlan et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TrmTrainPlan et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainplanid()))&&(!Objects.isNull(this.getById(et.getTrmtrainplanid())));
    }
    @Override
    @Transactional
    public TrmTrainPlan setDfbZt(TrmTrainPlan et) {
        setdfbztLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TrmTrainPlan setApprovalStatus(TrmTrainPlan et) {
        setapprovalstatusLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TrmTrainPlan get(String key) {
        TrmTrainPlan et = getById(key);
        if(et==null){
            et=new TrmTrainPlan();
            et.setTrmtrainplanid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmTrainPlan et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplanid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainPlan> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TrmTrainPlan setRejectStatus(TrmTrainPlan et) {
        setrejectstatusLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean update(TrmTrainPlan et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainplanid",et.getTrmtrainplanid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplanid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainPlan> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<TrmTrainPlan> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmTrainPlan>().eq("ormorgid",orgid));
    }

	@Override
    public List<TrmTrainPlan> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TrmTrainPlan>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TrmTrainPlan> selectByTrmdemdeftionid(String trmdemdeftionid) {
        return baseMapper.selectByTrmdemdeftionid(trmdemdeftionid);
    }

    @Override
    public void removeByTrmdemdeftionid(String trmdemdeftionid) {
        this.remove(new QueryWrapper<TrmTrainPlan>().eq("trmdemdeftionid",trmdemdeftionid));
    }

	@Override
    public List<TrmTrainPlan> selectByTrmplanformuid(String trmplanformuid) {
        return baseMapper.selectByTrmplanformuid(trmplanformuid);
    }

    @Override
    public void removeByTrmplanformuid(String trmplanformuid) {
        this.remove(new QueryWrapper<TrmTrainPlan>().eq("trmplanformuid",trmplanformuid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainPlan> searchDefault(TrmTrainPlanSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainPlan> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainPlan>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainPlan et){
        //实体关系[DER1N_TRMTRAINPLAN_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINPLAN_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMTRAINPLAN_TRMDEMDEFTION_TRMDEMDEFTIONID]
        if(!ObjectUtils.isEmpty(et.getTrmdemdeftionid())){
            cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion trmdemdeftion=et.getTrmdemdeftion();
            if(ObjectUtils.isEmpty(trmdemdeftion)){
                cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion majorEntity=trmdemdeftionService.get(et.getTrmdemdeftionid());
                et.setTrmdemdeftion(majorEntity);
                trmdemdeftion=majorEntity;
            }
            et.setPxdx(trmdemdeftion.getPxdx());
            et.setTrmdemdeftionname(trmdemdeftion.getTrmdemdeftionname());
            et.setPxrs(trmdemdeftion.getPxrs());
            et.setPxzynr(trmdemdeftion.getPxzynr());
            et.setPxkssj(trmdemdeftion.getPxkssj());
            et.setPxdd(trmdemdeftion.getPxdd());
            et.setPxjssj(trmdemdeftion.getPxjssj());
        }
        //实体关系[DER1N_TRMTRAINPLAN_TRMPLANFORMU_TRMPLANFORMUID]
        if(!ObjectUtils.isEmpty(et.getTrmplanformuid())){
            cn.ibizlab.ehr.core.trm.domain.TrmPlanFormu trmplanformu=et.getTrmplanformu();
            if(ObjectUtils.isEmpty(trmplanformu)){
                cn.ibizlab.ehr.core.trm.domain.TrmPlanFormu majorEntity=trmplanformuService.get(et.getTrmplanformuid());
                et.setTrmplanformu(majorEntity);
                trmplanformu=majorEntity;
            }
            et.setTrmplanformuname(trmplanformu.getTrmplanformuname());
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
    public List<TrmTrainPlan> getTrmtrainplanByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainPlan> getTrmtrainplanByEntities(List<TrmTrainPlan> entities) {
        List ids =new ArrayList();
        for(TrmTrainPlan entity : entities){
            Serializable id=entity.getTrmtrainplanid();
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



