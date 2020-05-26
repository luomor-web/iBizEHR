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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEDETAILSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVEDETAILService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACLEAVEDETAILMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假明细] 服务对象接口实现
 */
@Slf4j
@Service("VACLEAVEDETAILServiceImpl")
public class VACLEAVEDETAILServiceImpl extends ServiceImpl<VACLEAVEDETAILMapper, VACLEAVEDETAIL> implements IVACLEAVEDETAILService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACUSENXJMXService vacusenxjmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVEMANAGEService vacleavemanageService;

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
    public VACLEAVEDETAIL calcSJQJTS(VACLEAVEDETAIL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(VACLEAVEDETAIL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACLEAVEDETAIL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VACLEAVEDETAIL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavedetailid",et.getVacleavedetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACLEAVEDETAIL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public VACLEAVEDETAIL getNianJia(VACLEAVEDETAIL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(VACLEAVEDETAIL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACLEAVEDETAIL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VACLEAVEDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VACLEAVEDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VACLEAVEDETAIL calcJHQJTS(VACLEAVEDETAIL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public VACLEAVEDETAIL get(String key) {
        VACLEAVEDETAIL et = getById(key);
        if(et==null){
            et=new VACLEAVEDETAIL();
            et.setVacleavedetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VACLEAVEDETAIL et) {
        return (!ObjectUtils.isEmpty(et.getVacleavedetailid()))&&(!Objects.isNull(this.getById(et.getVacleavedetailid())));
    }

    @Override
    public VACLEAVEDETAIL getDraft(VACLEAVEDETAIL et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VACLEAVEDETAIL> selectByVacleavemanageid(String vacleavemanageid) {
        return baseMapper.selectByVacleavemanageid(vacleavemanageid);
    }

    @Override
    public void removeByVacleavemanageid(String vacleavemanageid) {
        this.remove(new QueryWrapper<VACLEAVEDETAIL>().eq("vacleavemanageid",vacleavemanageid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACLEAVEDETAIL> searchDefault(VACLEAVEDETAILSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEDETAIL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEDETAIL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACLEAVEDETAIL et){
        //实体关系[DER1N_VACLEAVEDETAIL_VACLEAVEMANAGE_VACLEAVEMANAGEID]
        if(!ObjectUtils.isEmpty(et.getVacleavemanageid())){
            cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE vacleavemanage=et.getVacleavemanage();
            if(ObjectUtils.isEmpty(vacleavemanage)){
                cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE majorEntity=vacleavemanageService.get(et.getVacleavemanageid());
                et.setVacleavemanage(majorEntity);
                vacleavemanage=majorEntity;
            }
            et.setOrmorgsectorid(vacleavemanage.getOrmorgsectorid());
            et.setOrmorgid(vacleavemanage.getOrmorgid());
            et.setPimpersonid(vacleavemanage.getPimpersonid());
            et.setPimpersonname(vacleavemanage.getPimpersonname());
            et.setVacleavemanagename(vacleavemanage.getVacleavemanagename());
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


