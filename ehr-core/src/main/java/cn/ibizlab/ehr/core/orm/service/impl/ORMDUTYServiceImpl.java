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
import cn.ibizlab.ehr.core.orm.domain.ORMDUTY;
import cn.ibizlab.ehr.core.orm.filter.ORMDUTYSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMDUTYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMDUTYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职务管理] 服务对象接口实现
 */
@Slf4j
@Service("ORMDUTYServiceImpl")
public class ORMDUTYServiceImpl extends ServiceImpl<ORMDUTYMapper, ORMDUTY> implements IORMDUTYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDepEstManService ormdepestmanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMZWDQGZService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJZMXService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMZJDYZWService pcmzjdyzwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDGWGZService salstdgwgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZService salstdxmgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDZXService salstdzxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService trmgradecadresService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ORMDUTY et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdutyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMDUTY> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMDUTY synOrderNum(ORMDUTY et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMDUTY et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormdutyid",et.getOrmdutyid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdutyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMDUTY> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public ORMDUTY getDraft(ORMDUTY et) {
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
    public boolean checkKey(ORMDUTY et) {
        return (!ObjectUtils.isEmpty(et.getOrmdutyid()))&&(!Objects.isNull(this.getById(et.getOrmdutyid())));
    }

    @Override
    @Transactional
    public ORMDUTY get(String key) {
        ORMDUTY et = getById(key);
        if(et==null){
            et=new ORMDUTY();
            et.setOrmdutyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMDUTY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMDUTY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMDUTY> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 根据当前部门所属组织层次过滤数据
     */
    @Override
    public Page<ORMDUTY> searchBasDuty(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchBasDuty(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 CurOrgsector
     */
    @Override
    public Page<ORMDUTY> searchCurOrgsector(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchCurOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前人员身份判定职务范围
     */
    @Override
    public Page<ORMDUTY> searchSrfOrgData(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchSrfOrgData(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMDUTY> searchDefault(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根据当前人员身份判定职务范围
     */
    @Override
    public Page<ORMDUTY> searchCurOrg(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 CurOrmorgsector
     */
    @Override
    public Page<ORMDUTY> searchCurOrmorgsector(ORMDUTYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDUTY> pages=baseMapper.searchCurOrmorgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDUTY>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


