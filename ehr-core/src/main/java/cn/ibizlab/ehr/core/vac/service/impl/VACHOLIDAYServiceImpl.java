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
import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAY;
import cn.ibizlab.ehr.core.vac.filter.VACHOLIDAYSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACHOLIDAYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[节假日管理] 服务对象接口实现
 */
@Slf4j
@Service("VACHOLIDAYServiceImpl")
public class VACHOLIDAYServiceImpl extends ServiceImpl<VACHOLIDAYMapper, VACHOLIDAY> implements IVACHOLIDAYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCECALENDARService attendencecalendarService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYRULESService vacholidayrulesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VACHOLIDAY aPPOINTJZBJJR(VACHOLIDAY et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(VACHOLIDAY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacholidayid",et.getVacholidayid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacholidayid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACHOLIDAY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public boolean checkKey(VACHOLIDAY et) {
        return (!ObjectUtils.isEmpty(et.getVacholidayid()))&&(!Objects.isNull(this.getById(et.getVacholidayid())));
    }

    @Override
    public VACHOLIDAY getDraft(VACHOLIDAY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public VACHOLIDAY get(String key) {
        VACHOLIDAY et = getById(key);
        if(et==null){
            et=new VACHOLIDAY();
            et.setVacholidayid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(VACHOLIDAY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACHOLIDAY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VACHOLIDAY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VACHOLIDAY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(VACHOLIDAY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacholidayid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACHOLIDAY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VACHOLIDAY checkTime(VACHOLIDAY et) {
        //自定义代码
        return et;
    }


	@Override
    public List<VACHOLIDAY> selectByVacholidayrulesid(String vacholidayrulesid) {
        return baseMapper.selectByVacholidayrulesid(vacholidayrulesid);
    }

    @Override
    public void removeByVacholidayrulesid(String vacholidayrulesid) {
        this.remove(new QueryWrapper<VACHOLIDAY>().eq("vacholidayrulesid",vacholidayrulesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACHOLIDAY> searchDefault(VACHOLIDAYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACHOLIDAY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACHOLIDAY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACHOLIDAY et){
        //实体关系[DER1N_VACHOLIDAY_VACHOLIDAYRULES_VACHOLIDAYRULESID]
        if(!ObjectUtils.isEmpty(et.getVacholidayrulesid())){
            cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES vacholidayrules=et.getVacholidayrules();
            if(ObjectUtils.isEmpty(vacholidayrules)){
                cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES majorEntity=vacholidayrulesService.get(et.getVacholidayrulesid());
                et.setVacholidayrules(majorEntity);
                vacholidayrules=majorEntity;
            }
            et.setOrmorgname(vacholidayrules.getOrmorgname());
            et.setVacholidayrulesname(vacholidayrules.getVacholidayrulesname());
            et.setOrmorgid(vacholidayrules.getOrmorgid());
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
    public List<VACHOLIDAY> getVacholidayByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VACHOLIDAY> getVacholidayByEntities(List<VACHOLIDAY> entities) {
        List ids =new ArrayList();
        for(VACHOLIDAY entity : entities){
            Serializable id=entity.getVacholidayid();
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


