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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveTips;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveTipsSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveTipsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacLeaveTipsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假提示] 服务对象接口实现
 */
@Slf4j
@Service("VacLeaveTipsServiceImpl")
public class VacLeaveTipsServiceImpl extends ServiceImpl<VacLeaveTipsMapper, VacLeaveTips> implements IVacLeaveTipsService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacHolidayRulesService vacholidayrulesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VacLeaveTips checkQJZL(VacLeaveTips et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(VacLeaveTips et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavetipsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacLeaveTips> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public VacLeaveTips getDraft(VacLeaveTips et) {
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
    public boolean checkKey(VacLeaveTips et) {
        return (!ObjectUtils.isEmpty(et.getVacleavetipsid()))&&(!Objects.isNull(this.getById(et.getVacleavetipsid())));
    }
    @Override
    @Transactional
    public VacLeaveTips checkRepeat(VacLeaveTips et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public VacLeaveTips get(String key) {
        VacLeaveTips et = getById(key);
        if(et==null){
            et=new VacLeaveTips();
            et.setVacleavetipsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(VacLeaveTips et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavetipsid",et.getVacleavetipsid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavetipsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacLeaveTips> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(VacLeaveTips et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacLeaveTips et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacLeaveTips> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacLeaveTips> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<VacLeaveTips> selectByVacholidayrulesid(String vacholidayrulesid) {
        return baseMapper.selectByVacholidayrulesid(vacholidayrulesid);
    }

    @Override
    public void removeByVacholidayrulesid(String vacholidayrulesid) {
        this.remove(new QueryWrapper<VacLeaveTips>().eq("vacholidayrulesid",vacholidayrulesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacLeaveTips> searchDefault(VacLeaveTipsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveTips> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveTips>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacLeaveTips et){
        //实体关系[DER1N_VACLEAVETIPS_VACHOLIDAYRULES_VACHOLIDAYRULESID]
        if(!ObjectUtils.isEmpty(et.getVacholidayrulesid())){
            cn.ibizlab.ehr.core.vac.domain.VacHolidayRules vacholidayrules=et.getVacholidayrules();
            if(ObjectUtils.isEmpty(vacholidayrules)){
                cn.ibizlab.ehr.core.vac.domain.VacHolidayRules majorEntity=vacholidayrulesService.get(et.getVacholidayrulesid());
                et.setVacholidayrules(majorEntity);
                vacholidayrules=majorEntity;
            }
            et.setVacholidayrulesname(vacholidayrules.getVacholidayrulesname());
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
    public List<VacLeaveTips> getVacleavetipsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacLeaveTips> getVacleavetipsByEntities(List<VacLeaveTips> entities) {
        List ids =new ArrayList();
        for(VacLeaveTips entity : entities){
            Serializable id=entity.getVacleavetipsid();
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



