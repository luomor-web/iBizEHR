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
import cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryDetailSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalSalaryDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalSalaryDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工薪酬明细] 服务对象接口实现
 */
@Slf4j
@Service("SalSalaryDetailServiceImpl")
public class SalSalaryDetailServiceImpl extends ServiceImpl<SalSalaryDetailMapper, SalSalaryDetail> implements ISalSalaryDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalLogService sallogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService salschemeitemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(SalSalaryDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salsalarydetailid",et.getSalsalarydetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalarydetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalSalaryDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SalSalaryDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalarydetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalSalaryDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public SalSalaryDetail getDraft(SalSalaryDetail et) {
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
    public SalSalaryDetail get(String key) {
        SalSalaryDetail et = getById(key);
        if(et==null){
            et=new SalSalaryDetail();
            et.setSalsalarydetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(SalSalaryDetail et) {
        return (!ObjectUtils.isEmpty(et.getSalsalarydetailid()))&&(!Objects.isNull(this.getById(et.getSalsalarydetailid())));
    }
    @Override
    @Transactional
    public boolean save(SalSalaryDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalSalaryDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalSalaryDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalSalaryDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SalSalaryDetail> selectBySalsalaryid(String salsalaryid) {
        return baseMapper.selectBySalsalaryid(salsalaryid);
    }

    @Override
    public void removeBySalsalaryid(String salsalaryid) {
        this.remove(new QueryWrapper<SalSalaryDetail>().eq("salsalaryid",salsalaryid));
    }

	@Override
    public List<SalSalaryDetail> selectBySalschemeitemid(String salschemeitemid) {
        return baseMapper.selectBySalschemeitemid(salschemeitemid);
    }

    @Override
    public void removeBySalschemeitemid(String salschemeitemid) {
        this.remove(new QueryWrapper<SalSalaryDetail>().eq("salschemeitemid",salschemeitemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalSalaryDetail> searchDefault(SalSalaryDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalSalaryDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalSalaryDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SalSalaryDetail et){
        //实体关系[DER1N_SALSALARYDETAIL_SALSALARY_SALSALARYID]
        if(!ObjectUtils.isEmpty(et.getSalsalaryid())){
            cn.ibizlab.ehr.core.sal.domain.SalSalary salsalary=et.getSalsalary();
            if(ObjectUtils.isEmpty(salsalary)){
                cn.ibizlab.ehr.core.sal.domain.SalSalary majorEntity=salsalaryService.get(et.getSalsalaryid());
                et.setSalsalary(majorEntity);
                salsalary=majorEntity;
            }
            et.setSalsalaryname(salsalary.getSalsalaryname());
        }
        //实体关系[DER1N_SALSALARYDETAIL_SALSCHEMEITEM_SALSCHEMEITEMID]
        if(!ObjectUtils.isEmpty(et.getSalschemeitemid())){
            cn.ibizlab.ehr.core.sal.domain.SalSchemeItem salschemeitem=et.getSalschemeitem();
            if(ObjectUtils.isEmpty(salschemeitem)){
                cn.ibizlab.ehr.core.sal.domain.SalSchemeItem majorEntity=salschemeitemService.get(et.getSalschemeitemid());
                et.setSalschemeitem(majorEntity);
                salschemeitem=majorEntity;
            }
            et.setSalschemeitemname(salschemeitem.getSalschemeitemname());
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
    public List<SalSalaryDetail> getSalsalarydetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalSalaryDetail> getSalsalarydetailByEntities(List<SalSalaryDetail> entities) {
        List ids =new ArrayList();
        for(SalSalaryDetail entity : entities){
            Serializable id=entity.getSalsalarydetailid();
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



