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
import cn.ibizlab.ehr.core.sal.domain.SALSALARYDETAIL;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYDETAILSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALSALARYDETAILService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALSALARYDETAILMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工薪酬明细] 服务对象接口实现
 */
@Slf4j
@Service("SALSALARYDETAILServiceImpl")
public class SALSALARYDETAILServiceImpl extends ServiceImpl<SALSALARYDETAILMapper, SALSALARYDETAIL> implements ISALSALARYDETAILService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALLOGService sallogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSCHEMEITEMService salschemeitemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(SALSALARYDETAIL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salsalarydetailid",et.getSalsalarydetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalarydetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALSALARYDETAIL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SALSALARYDETAIL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalsalarydetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALSALARYDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public SALSALARYDETAIL getDraft(SALSALARYDETAIL et) {
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
    public SALSALARYDETAIL get(String key) {
        SALSALARYDETAIL et = getById(key);
        if(et==null){
            et=new SALSALARYDETAIL();
            et.setSalsalarydetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(SALSALARYDETAIL et) {
        return (!ObjectUtils.isEmpty(et.getSalsalarydetailid()))&&(!Objects.isNull(this.getById(et.getSalsalarydetailid())));
    }

    @Override
    @Transactional
    public boolean save(SALSALARYDETAIL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALSALARYDETAIL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALSALARYDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SALSALARYDETAIL> selectBySalsalaryid(String salsalaryid) {
        return baseMapper.selectBySalsalaryid(salsalaryid);
    }

    @Override
    public void removeBySalsalaryid(String salsalaryid) {
        this.remove(new QueryWrapper<SALSALARYDETAIL>().eq("salsalaryid",salsalaryid));
    }

	@Override
    public List<SALSALARYDETAIL> selectBySalschemeitemid(String salschemeitemid) {
        return baseMapper.selectBySalschemeitemid(salschemeitemid);
    }

    @Override
    public void removeBySalschemeitemid(String salschemeitemid) {
        this.remove(new QueryWrapper<SALSALARYDETAIL>().eq("salschemeitemid",salschemeitemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALSALARYDETAIL> searchDefault(SALSALARYDETAILSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALSALARYDETAIL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALSALARYDETAIL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALSALARYDETAIL et){
        //实体关系[DER1N_SALSALARYDETAIL_SALSALARY_SALSALARYID]
        if(!ObjectUtils.isEmpty(et.getSalsalaryid())){
            cn.ibizlab.ehr.core.sal.domain.SALSALARY salsalary=et.getSalsalary();
            if(ObjectUtils.isEmpty(salsalary)){
                cn.ibizlab.ehr.core.sal.domain.SALSALARY majorEntity=salsalaryService.get(et.getSalsalaryid());
                et.setSalsalary(majorEntity);
                salsalary=majorEntity;
            }
            et.setSalsalaryname(salsalary.getSalsalaryname());
        }
        //实体关系[DER1N_SALSALARYDETAIL_SALSCHEMEITEM_SALSCHEMEITEMID]
        if(!ObjectUtils.isEmpty(et.getSalschemeitemid())){
            cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM salschemeitem=et.getSalschemeitem();
            if(ObjectUtils.isEmpty(salschemeitem)){
                cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM majorEntity=salschemeitemService.get(et.getSalschemeitemid());
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

}


