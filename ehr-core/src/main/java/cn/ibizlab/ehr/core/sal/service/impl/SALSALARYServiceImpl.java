package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SALSALARY;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALSALARYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALSALARYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工薪酬] 服务对象接口实现
 */
@Slf4j
@Service("SALSALARYServiceImpl")
public class SALSALARYServiceImpl extends ServiceImpl<SALSALARYMapper, SALSALARY> implements ISALSALARYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALLOGService sallogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYDETAILService salsalarydetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPLANService salplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYBILLService salsalarybillService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SALSALARY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALSALARY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SALSALARY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SALSALARY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SALSALARY et) {
        return (!ObjectUtils.isEmpty(et.getSalsalaryid()))&&(!Objects.isNull(this.getById(et.getSalsalaryid())));
    }

    @Override
    @Transactional
    public SALSALARY get(String key) {
        SALSALARY et = getById(key);
        if(et==null){
            et=new SALSALARY();
            et.setSalsalaryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SALSALARY getDraft(SALSALARY et) {
        fillParentData(et);
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
    @Transactional
    public boolean create(SALSALARY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalaryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALSALARY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SALSALARY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salsalaryid",et.getSalsalaryid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalaryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALSALARY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<SALSALARY> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<SALSALARY> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<SALSALARY> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("ormorgid",orgid));
    }

	@Override
    public List<SALSALARY> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<SALSALARY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<SALSALARY> selectBySalplanid(String salplanid) {
        return baseMapper.selectBySalplanid(salplanid);
    }

    @Override
    public void removeBySalplanid(String salplanid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("salplanid",salplanid));
    }

	@Override
    public List<SALSALARY> selectBySalsalarybillid(String salsalarybillid) {
        return baseMapper.selectBySalsalarybillid(salsalarybillid);
    }

    @Override
    public void removeBySalsalarybillid(String salsalarybillid) {
        this.remove(new QueryWrapper<SALSALARY>().eq("salsalarybillid",salsalarybillid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALSALARY> searchDefault(SALSALARYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALSALARY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALSALARY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALSALARY et){
        //实体关系[DER1N_SALSALARY_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_SALSALARY_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_SALSALARY_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_SALSALARY_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_SALSALARY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_SALSALARY_SALPLAN_SALPLANID]
        if(!ObjectUtils.isEmpty(et.getSalplanid())){
            cn.ibizlab.ehr.core.sal.domain.SALPLAN salplan=et.getSalplan();
            if(ObjectUtils.isEmpty(salplan)){
                cn.ibizlab.ehr.core.sal.domain.SALPLAN majorEntity=salplanService.get(et.getSalplanid());
                et.setSalplan(majorEntity);
                salplan=majorEntity;
            }
            et.setNyear(salplan.getNyear());
            et.setNmonth(salplan.getNmonth());
            et.setSalplanname(salplan.getSalplanname());
        }
        //实体关系[DER1N_SALSALARY_SALSALARYBILL_SALSALARYBILLID]
        if(!ObjectUtils.isEmpty(et.getSalsalarybillid())){
            cn.ibizlab.ehr.core.sal.domain.SALSALARYBILL salsalarybill=et.getSalsalarybill();
            if(ObjectUtils.isEmpty(salsalarybill)){
                cn.ibizlab.ehr.core.sal.domain.SALSALARYBILL majorEntity=salsalarybillService.get(et.getSalsalarybillid());
                et.setSalsalarybill(majorEntity);
                salsalarybill=majorEntity;
            }
            et.setSalsalarybillname(salsalarybill.getSalsalarybillname());
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
    public List<SALSALARY> getSalsalaryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SALSALARY> getSalsalaryByEntities(List<SALSALARY> entities) {
        List ids =new ArrayList();
        for(SALSALARY entity : entities){
            Serializable id=entity.getSalsalaryid();
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


