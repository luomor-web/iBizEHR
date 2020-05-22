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
import cn.ibizlab.ehr.core.orm.domain.ORMORG;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMORGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMORGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织管理***] 服务对象接口实现
 */
@Slf4j
@Service("ORMORGServiceImpl")
public class ORMORGServiceImpl extends ServiceImpl<ORMORGMapper, ORMORG> implements IORMORGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IARCHIVESCENTERService archivescenterService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDTEMPService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCECALENDARService attendencecalendarService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCESETUPService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IBUDGETService budgetService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IContractSignORGService contractsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IDateRuleService dateruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGDZService ormorgdzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;

    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMQYBZWHService ormqybzwhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMQYGLService ormqyglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMUSERService ormuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMBQService ormxmbqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMZWDQGZService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJGBMPJBZService parjgbmpjbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXBZGLService parjxbzglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXKHJCSZService parjxkhjcszService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXKHMBService parjxkhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXQDSZService parjxqdszService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARXMBPJBZService parxmbpjbzService;
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
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEINITNUMBERService pcmprofileinitnumberService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILENUMBEPREFIXService pcmprofilenumbeprefixService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMSYQGZService pcmsyqgzService;
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
    private cn.ibizlab.ehr.core.pcm.service.IPCMZPMEGLService pcmzpmeglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTTYPEService pimcontracttypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMEXPACCOUNTService pimexpaccountService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMLABOURCAMPANYService pimlabourcampanyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMOUTPUTService pimoutputService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMQUALMAJORService pimqualmajorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMTITLECATALOGUEService pimtitlecatalogueService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMWorkflowService pimworkflowService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALITEMSUBService salitemsubService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPLANService salplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYBILLService salsalarybillService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSCHEMEService salschemeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDDSZNService salstddsznService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDGLService salstdglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDGWGZRATEService salstdgwgzrateService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDGWGZService salstdgwgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDGWService salstdgwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZRATEService salstdxmgzrateService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZService salstdxmgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDZCService salstdzcService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDZJService salstdzjService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDZXService salstdzxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSTDZYZGService salstdzyzgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCCOMPANYWELService soccompanywelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCSELFAREBASEService socselfarebaseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEMDEFTIONService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService trmdepartService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMEMPLOYRETIONService trmemployretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMHMATSERService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMLGBCOSTService trmlgbcostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMPLANFORMUService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMSTAFFService trmstaffService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINADDRESSService trmtrainaddressService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINBUAPPLYService trmtrainbuapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINDATAService trmtraindataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDSUMService trmtraindemandsumService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDService trmtraindemandService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService trmtrainfillinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYRULESService vacholidayrulesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACINITNXJService vacinitnxjService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMService vacleavesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACOVERALLTIONService vacoveralltionService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(ORMORG et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgid",et.getOrgid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMORG> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ORMORG synOrg(ORMORG et) {
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
    public ORMORG getDraft(ORMORG et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ORMORG get(String key) {
        ORMORG et = getById(key);
        if(et==null){
            et=new ORMORG();
            et.setOrgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ORMORG et) {
        return (!ObjectUtils.isEmpty(et.getOrgid()))&&(!Objects.isNull(this.getById(et.getOrgid())));
    }

    @Override
    @Transactional
    public boolean create(ORMORG et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMORG> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ORMORG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMORG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMORG> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<ORMORG> selectByPorgid(String orgid) {
        return baseMapper.selectByPorgid(orgid);
    }

    @Override
    public void removeByPorgid(String orgid) {
        this.remove(new QueryWrapper<ORMORG>().eq("porgid",orgid));
    }


    /**
     * 查询集合 全部法人主体
     */
    @Override
    public Page<ORMORG> searchALLSIGNORG(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchALLSIGNORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 全部二级单位（无权限）
     */
    @Override
    public Page<ORMORG> searchAllLevelTwoOrg2(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchAllLevelTwoOrg2(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前可选择组织列表（应聘者信息使用）
     */
    @Override
    public Page<ORMORG> searchOrglist_Profile(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchOrglist_Profile(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 组织分布
     */
    @Override
    public Page<HashMap> searchREP_ORG(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_ORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示组织(权限控制)
     */
    @Override
    public Page<ORMORG> searchAuthOrg(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchAuthOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（公司级岗位专用）
     */
    @Override
    public Page<ORMORG> searchGSGWZY(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchGSGWZY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示当前组织下组织
     */
    @Override
    public Page<ORMORG> searchSubSubOrg(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchSubSubOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMORG> searchDefault(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织查询
     */
    @Override
    public Page<ORMORG> searchCurChild(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchCurChild(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 三级组织及以下组织
     */
    @Override
    public Page<ORMORG> searchSJYXZZ(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchSJYXZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 组织人员总数
     */
    @Override
    public Page<HashMap> searchREP_ORGPNUM(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_ORGPNUM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（上级组织）
     */
    @Override
    public Page<ORMORG> searchKZSJZZXZ(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchKZSJZZXZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询当前登录人组织下的组织（包含当前组织）
     */
    @Override
    public Page<ORMORG> searchDanQian(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchDanQian(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 全部二级单位
     */
    @Override
    public Page<ORMORG> searchAllLevelTwoOrg(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchAllLevelTwoOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示当前组织包含所有组织
     */
    @Override
    public Page<ORMORG> searchSubOrg(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchSubOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 合同管理单位
     */
    @Override
    public Page<ORMORG> searchHTGLDW(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchHTGLDW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（当前组织）
     */
    @Override
    public Page<ORMORG> searchKZXLXZ(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchKZXLXZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 三级组织及以下组织（权限控制）
     */
    @Override
    public Page<ORMORG> searchAuthSJYXZZ(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchAuthSJYXZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 分配信息专用（组织过滤）
     */
    @Override
    public Page<ORMORG> searchUseByFP(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchUseByFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根组织查询
     */
    @Override
    public Page<ORMORG> searchCurPorg(ORMORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMORG> pages=baseMapper.searchCurPorg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMORG et){
        //实体关系[DER1N_ORMORG_ORMORG_PORGID]
        if(!ObjectUtils.isEmpty(et.getPorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG porg=et.getPorg();
            if(ObjectUtils.isEmpty(porg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getPorgid());
                et.setPorg(majorEntity);
                porg=majorEntity;
            }
            et.setPorgname(porg.getOrgname());
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


