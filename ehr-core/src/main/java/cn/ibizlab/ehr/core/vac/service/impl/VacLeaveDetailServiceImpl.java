package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveDetailSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacLeaveDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假明细] 服务对象接口实现
 */
@Slf4j
@Service("VacLeaveDetailServiceImpl")
public class VacLeaveDetailServiceImpl extends ServiceImpl<VacLeaveDetailMapper, VacLeaveDetail> implements IVacLeaveDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacUseNxjmxService vacusenxjmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

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
    public boolean create(VacLeaveDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VacLeaveDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavedetailid",et.getVacleavedetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public VacLeaveDetail getNianJia(VacLeaveDetail et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(VacLeaveDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacLeaveDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacLeaveDetail get(String key) {
        VacLeaveDetail et = getById(key);
        if(et==null){
            et=new VacLeaveDetail();
            et.setVacleavedetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public VacLeaveDetail calcPlanDays(VacLeaveDetail et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(VacLeaveDetail et) {
        return (!ObjectUtils.isEmpty(et.getVacleavedetailid()))&&(!Objects.isNull(this.getById(et.getVacleavedetailid())));
    }

    @Override
    public VacLeaveDetail getDraft(VacLeaveDetail et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VacLeaveDetail> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacLeaveDetail>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacLeaveDetail> searchDefault(VacLeaveDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacLeaveDetail et){
        //实体关系[DER1N_VACLEAVEDETAIL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
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
    public List<VacLeaveDetail> getVacleavedetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacLeaveDetail> getVacleavedetailByEntities(List<VacLeaveDetail> entities) {
        List ids =new ArrayList();
        for(VacLeaveDetail entity : entities){
            Serializable id=entity.getVacleavedetailid();
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


