package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmDuty;
import cn.ibizlab.ehr.core.orm.filter.OrmDutySearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmDutyService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmDutyMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职务管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmDutyServiceImpl")
public class OrmDutyServiceImpl extends ServiceImpl<OrmDutyMapper, OrmDuty> implements IOrmDutyService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmDepEstManService ormdepestmanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmZwdqgzService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmZjdyzwService pcmzjdyzwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdgwgzService salstdgwgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdXmgzService salstdxmgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdzxService salstdzxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService trmgradecadresService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(OrmDuty et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdutyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmDuty> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmDuty synOrderNum(OrmDuty et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmDuty et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormdutyid",et.getOrmdutyid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdutyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmDuty> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public OrmDuty getDraft(OrmDuty et) {
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
    public boolean checkKey(OrmDuty et) {
        return (!ObjectUtils.isEmpty(et.getOrmdutyid()))&&(!Objects.isNull(this.getById(et.getOrmdutyid())));
    }
    @Override
    @Transactional
    public OrmDuty get(String key) {
        OrmDuty et = getById(key);
        if(et==null){
            et=new OrmDuty();
            et.setOrmdutyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmDuty et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmDuty et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmDuty> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmDuty> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 根据当前部门所属组织层次过滤数据
     */
    @Override
    public Page<OrmDuty> searchBasDuty(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchBasDuty(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 CurOrgsector
     */
    @Override
    public Page<OrmDuty> searchCurOrgsector(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchCurOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前人员身份判定职务范围
     */
    @Override
    public Page<OrmDuty> searchSrfOrgData(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchSrfOrgData(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmDuty> searchDefault(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前人员身份判定职务范围
     */
    @Override
    public Page<OrmDuty> searchCurOrg(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 CurOrmorgsector
     */
    @Override
    public Page<OrmDuty> searchCurOrmorgsector(OrmDutySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDuty> pages=baseMapper.searchCurOrmorgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDuty>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<OrmDuty> getOrmdutyByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmDuty> getOrmdutyByEntities(List<OrmDuty> entities) {
        List ids =new ArrayList();
        for(OrmDuty entity : entities){
            Serializable id=entity.getOrmdutyid();
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



