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
import cn.ibizlab.ehr.core.vac.domain.VacHolidayRules;
import cn.ibizlab.ehr.core.vac.filter.VacHolidayRulesSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacHolidayRulesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacHolidayRulesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤规则] 服务对象接口实现
 */
@Slf4j
@Service("VacHolidayRulesServiceImpl")
public class VacHolidayRulesServiceImpl extends ServiceImpl<VacHolidayRulesMapper, VacHolidayRules> implements IVacHolidayRulesService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYService vacholidayService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVETIPSService vacleavetipsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VacHolidayRules copyKQGZData(VacHolidayRules et) {
        //自定义代码
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
    public boolean checkKey(VacHolidayRules et) {
        return (!ObjectUtils.isEmpty(et.getVacholidayrulesid()))&&(!Objects.isNull(this.getById(et.getVacholidayrulesid())));
    }

    @Override
    @Transactional
    public boolean create(VacHolidayRules et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacholidayrulesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacHolidayRules> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public VacHolidayRules getDraft(VacHolidayRules et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(VacHolidayRules et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacholidayrulesid",et.getVacholidayrulesid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacholidayrulesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacHolidayRules> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public VacHolidayRules get(String key) {
        VacHolidayRules et = getById(key);
        if(et==null){
            et=new VacHolidayRules();
            et.setVacholidayrulesid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(VacHolidayRules et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacHolidayRules et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacHolidayRules> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacHolidayRules> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<VacHolidayRules> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<VacHolidayRules>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacHolidayRules> searchDefault(VacHolidayRulesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacHolidayRules> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacHolidayRules>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下的假期规则
     */
    @Override
    public Page<VacHolidayRules> searchCurOrmorg(VacHolidayRulesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacHolidayRules> pages=baseMapper.searchCurOrmorg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacHolidayRules>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacHolidayRules et){
        //实体关系[DER1N_VACHOLIDAYRULES_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrgcode(ormorg.getOrgcode());
            et.setOrmorgname(ormorg.getZzdzs());
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
    public List<VacHolidayRules> getVacholidayrulesByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacHolidayRules> getVacholidayrulesByEntities(List<VacHolidayRules> entities) {
        List ids =new ArrayList();
        for(VacHolidayRules entity : entities){
            Serializable id=entity.getVacholidayrulesid();
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


