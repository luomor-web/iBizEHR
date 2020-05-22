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
import cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSECTORSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMORGSECTORMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门管理***] 服务对象接口实现
 */
@Slf4j
@Service("ORMORGSECTORServiceImpl")
public class ORMORGSECTORServiceImpl extends ServiceImpl<ORMORGSECTORMapper, ORMORGSECTOR> implements IORMORGSECTORService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDTEMPService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCEORMORGSECTORService attendenceormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMBMGWBZService ormbmgwbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMBMKQDZService ormbmkqdzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDepEstManService ormdepestmanService;

    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMUSERService ormuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMBMXService ormxmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJGBMPJBZService parjgbmpjbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARYDGZJHService parydgzjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARZNBMMXService parznbmmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBService parznbmndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPCMDETAILService pcmdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSBDJLService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDDGMXService pcmyddgmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJZMXService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDMXService pcmydmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYBILLService salsalarybillService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService trmdepartService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMPLANFORMUService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINACTAPPLYService trmtrainactapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService trmtrainfillinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACSYSTEMAPPLICATIONService vacsystemapplicationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMGLService ormxmglService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ORMORGSECTOR changeEdition(ORMORGSECTOR et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(ORMORGSECTOR et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMORGSECTOR> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMORGSECTOR synOrgSectPro(ORMORGSECTOR et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMORGSECTOR cLWC(ORMORGSECTOR et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(ORMORGSECTOR et) {
        return (!ObjectUtils.isEmpty(et.getOrgsectorid()))&&(!Objects.isNull(this.getById(et.getOrgsectorid())));
    }

    @Override
    @Transactional
    public boolean save(ORMORGSECTOR et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMORGSECTOR et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMORGSECTOR> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ORMORGSECTOR getDraft(ORMORGSECTOR et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ORMORGSECTOR tJ(ORMORGSECTOR et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMORGSECTOR et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgsectorid",et.getOrgsectorid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMORGSECTOR> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ORMORGSECTOR get(String key) {
        ORMORGSECTOR et = getById(key);
        if(et==null){
            et=new ORMORGSECTOR();
            et.setOrgsectorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public ORMORGSECTOR synOrgSectOderNum(ORMORGSECTOR et) {
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
    @Transactional
    public ORMORGSECTOR synOrgSec(ORMORGSECTOR et) {
        //自定义代码
        return et;
    }


	@Override
    public List<ORMORGSECTOR> selectByPorgsectorid(String orgsectorid) {
        return baseMapper.selectByPorgsectorid(orgsectorid);
    }

    @Override
    public void removeByPorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("porgsectorid",orgsectorid));
    }

	@Override
    public List<ORMORGSECTOR> selectByProdepid(String orgsectorid) {
        return baseMapper.selectByProdepid(orgsectorid);
    }

    @Override
    public void removeByProdepid(String orgsectorid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("prodepid",orgsectorid));
    }

	@Override
    public List<ORMORGSECTOR> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("orgid",orgid));
    }

	@Override
    public List<ORMORGSECTOR> selectByOrmxmglid(String ormxmglid) {
        return baseMapper.selectByOrmxmglid(ormxmglid);
    }

    @Override
    public void removeByOrmxmglid(String ormxmglid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("ormxmglid",ormxmglid));
    }

	@Override
    public List<ORMORGSECTOR> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<ORMORGSECTOR> selectByProleaderid(String pimpersonid) {
        return baseMapper.selectByProleaderid(pimpersonid);
    }

    @Override
    public void removeByProleaderid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMORGSECTOR>().eq("proleaderid",pimpersonid));
    }


    /**
     * 查询集合 通过当前组织过滤部门(ORMORGID)
     */
    @Override
    public Page<ORMORGSECTOR> searchCURORMORG(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchCURORMORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目部编制管理
     */
    @Override
    public Page<ORMORGSECTOR> searchXMBBZGL(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchXMBBZGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局所有项目部选择（第一版规则）
     */
    @Override
    public Page<ORMORGSECTOR> searchJSYXMB(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchJSYXMB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下的部门
     */
    @Override
    public Page<ORMORGSECTOR> searchCurZZBM(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchCurZZBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织部门（考勤设置）
     */
    @Override
    public Page<ORMORGSECTOR> searchCurZZBM_KQSZ(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchCurZZBM_KQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 通过当前组织过滤部门
     */
    @Override
    public Page<ORMORGSECTOR> searchCURORG(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchCURORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前部门
     */
    @Override
    public Page<ORMORGSECTOR> searchCurOrgSector(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchCurOrgSector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMORGSECTOR> searchDefault(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人员需求
     */
    @Override
    public Page<ORMORGSECTOR> searchBaseInfo(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchBaseInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织（及下级组织）下部门
     */
    @Override
    public Page<ORMORGSECTOR> searchDQZZXBM(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchDQZZXBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 设置项目负责人
     */
    @Override
    public Page<ORMORGSECTOR> searchRsshInfo(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchRsshInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门/项目部（组织专用）
     */
    @Override
    public Page<ORMORGSECTOR> searchSubOrgsector(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchSubOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门/项目部（人员信息专用）
     */
    @Override
    public Page<ORMORGSECTOR> searchPimpersonInfoOrgsector(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchPimpersonInfoOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人员需求（历史版本）
     */
    @Override
    public Page<ORMORGSECTOR> searchHisInfo(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchHisInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门
     */
    @Override
    public Page<ORMORGSECTOR> searchSubZZBM(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchSubZZBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目拓展信息
     */
    @Override
    public Page<ORMORGSECTOR> searchProExpandInfo(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchProExpandInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 部门编制管理
     */
    @Override
    public Page<ORMORGSECTOR> searchBMBZGL(ORMORGSECTORSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORGSECTOR> pages=baseMapper.searchBMBZGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORGSECTOR>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMORGSECTOR et){
        //实体关系[DER1N_ORMORGSECTOR_ORMORGSECTOR_PORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getPorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR porgsector=et.getPorgsector();
            if(ObjectUtils.isEmpty(porgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getPorgsectorid());
                et.setPorgsector(majorEntity);
                porgsector=majorEntity;
            }
            et.setPorgsectorname(porgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMORGSECTOR_PRODEPID]
        if(!ObjectUtils.isEmpty(et.getProdepid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR prodep=et.getProdep();
            if(ObjectUtils.isEmpty(prodep)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getProdepid());
                et.setProdep(majorEntity);
                prodep=majorEntity;
            }
            et.setProdepname(prodep.getOrgsectorname());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgname(org.getOrgname());
            et.setZzdzs(org.getZzdzs());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMXMGL_ORMXMGLID]
        if(!ObjectUtils.isEmpty(et.getOrmxmglid())){
            cn.ibizlab.ehr.core.orm.domain.ORMXMGL ormxmgl=et.getOrmxmgl();
            if(ObjectUtils.isEmpty(ormxmgl)){
                cn.ibizlab.ehr.core.orm.domain.ORMXMGL majorEntity=ormxmglService.get(et.getOrmxmglid());
                et.setOrmxmgl(majorEntity);
                ormxmgl=majorEntity;
            }
            et.setEngineeringscale(ormxmgl.getEngineeringscale());
            et.setOrmxmglname(ormxmgl.getProjectName());
            et.setXmbh(ormxmgl.getProjectNumber());
        }
        //实体关系[DER1N_ORMORGSECTOR_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_ORMORGSECTOR_PIMPERSON_PROLEADERID]
        if(!ObjectUtils.isEmpty(et.getProleaderid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON proleader=et.getProleader();
            if(ObjectUtils.isEmpty(proleader)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getProleaderid());
                et.setProleader(majorEntity);
                proleader=majorEntity;
            }
            et.setProleadername(proleader.getPimpersonname());
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


