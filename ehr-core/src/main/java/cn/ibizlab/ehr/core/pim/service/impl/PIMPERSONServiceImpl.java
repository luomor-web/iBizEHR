package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMPERSONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMPERSONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMPERSONServiceImpl")
public class PIMPERSONServiceImpl extends ServiceImpl<PIMPERSONMapper, PIMPERSON> implements IPIMPERSONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTMXService attendancemreportmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDTEMPService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCESETTINGSService attendancesettingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCESETUPService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENSUMMARYService attensummaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMBMXService ormxmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMXQJHService ormxmxqjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARBMFZJYXService parbmfzjyxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARDXKHNRMXService pardxkhnrmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARFZSMXService parfzsmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXBZGLMXService parjxbzglmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXLHMBService parjxlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXMTFKService parjxmtfkService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXNDKHJGService parjxndkhjgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJZSZPSJGService parjzszpsjgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARLDNDLHMBService parldndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBService parptryndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDService pcmbdsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDService pcmddsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSBDJLService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZJLMXService pcmjxsygzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZSQMXService pcmjxsygzzsqmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMLOGService pcmlogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMSgqMgrService pcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMTXFPSQService pcmtxfpsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZJLMXService pcmxygzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQMXService pcmxygzzsqmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDLZMXService pcmydlzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDMXService pcmydmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMACHIEVEMENTSService pimachievementsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService pimarchivesloanandreturnService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARMYCADRESService pimarmycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService pimbyzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCORRECTIONAPPLYService pimcorrectionapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService pimeducationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService pimenclosureService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMEXITANDENTRYService pimexitandentryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService pimfaminfoService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMLABOURCAMPANYService pimlabourcampanyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMLANGUAGEABILITYService pimlanguageabilityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPAPERService pimpaperService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPATENTService pimpatentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPersonAbilityService pimpersonabilityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONCHANGEService pimpersonchangeService;

    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMRESEARCHFINDINGSService pimresearchfindingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMREWARDPUNISHMENTService pimrewardpunishmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMSOCIALSECURITYService pimsocialsecurityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMTITLEService pimtitleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMVACATIONService pimvacationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMWORKHISTORYService pimworkhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.ISGQMgrService sgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOService socwelfareinfoService;
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
    private cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMHMATSERService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMLGBDETAILService trmlgbdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMPLANFORMUService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMSTAFFService trmstaffService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINOUTAPPLYService trmtrainoutapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRIANPERSONService trmtrianpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVEMANAGEService vacleavemanageService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACOVERALLTIONService vacoveralltionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACSITUATIONService vacsituationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACSYNJCXService vacsynjcxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACSYSTEMAPPLICATIONService vacsystemapplicationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACSYSTEMHISTORYService vacsystemhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMRCXLService pcmrcxlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCITYService pimcityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMMAJORSETYPEService pimmajorsetypeService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMPERSONGenratePersonFileLogic genratepersonfileLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMPERSONGetJTLXRDHLogic getjtlxrdhLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PIMPERSON et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonid",et.getPimpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMPERSON> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PIMPERSON yZSFYZFP(PIMPERSON et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMPERSON toggleLeader(PIMPERSON et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMPERSON get(String key) {
        PIMPERSON et = getById(key);
        if(et==null){
            et=new PIMPERSON();
            et.setPimpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PIMPERSON personUpdateInfo(PIMPERSON et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMPERSON fillPersonType(PIMPERSON et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMPERSON et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        genratepersonfileLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<PIMPERSON> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PIMPERSON et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMPERSON et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMPERSON> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMPERSON getJTLXRDH(PIMPERSON et) {
        getjtlxrdhLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PIMPERSON synPerson(PIMPERSON et) {
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
    public boolean checkKey(PIMPERSON et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonid()))&&(!Objects.isNull(this.getById(et.getPimpersonid())));
    }

    @Override
    @Transactional
    public PIMPERSON qRTX(PIMPERSON et) {
        //自定义代码
        return et;
    }

    @Override
    public PIMPERSON getDraft(PIMPERSON et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PIMPERSON generatePersonFile(PIMPERSON et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PIMPERSON> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PIMPERSON> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMPERSON> selectByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) {
        return baseMapper.selectByPcmjxsygzzjlmxid(pcmjxsygzzjlmxid);
    }

    @Override
    public void removeByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pcmjxsygzzjlmxid",pcmjxsygzzjlmxid));
    }

	@Override
    public List<PIMPERSON> selectByPcmrcxlid(String pcmrcxlid) {
        return baseMapper.selectByPcmrcxlid(pcmrcxlid);
    }

    @Override
    public void removeByPcmrcxlid(String pcmrcxlid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pcmrcxlid",pcmrcxlid));
    }

	@Override
    public List<PIMPERSON> selectByPimcityid(String pimcityid) {
        return baseMapper.selectByPimcityid(pimcityid);
    }

    @Override
    public void removeByPimcityid(String pimcityid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pimcityid",pimcityid));
    }

	@Override
    public List<PIMPERSON> selectByPimmajorsetypeid(String pimmajorsetypeid) {
        return baseMapper.selectByPimmajorsetypeid(pimmajorsetypeid);
    }

    @Override
    public void removeByPimmajorsetypeid(String pimmajorsetypeid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pimmajorsetypeid",pimmajorsetypeid));
    }

	@Override
    public List<PIMPERSON> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pimpersonid2",pimpersonid));
    }

	@Override
    public List<PIMPERSON> selectByPimpersonid3(String pimpersonid) {
        return baseMapper.selectByPimpersonid3(pimpersonid);
    }

    @Override
    public void removeByPimpersonid3(String pimpersonid) {
        this.remove(new QueryWrapper<PIMPERSON>().eq("pimpersonid3",pimpersonid));
    }


    /**
     * 查询集合 可返聘人员
     */
    @Override
    public Page<PIMPERSON> searchKFPRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKFPRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工信息（管理员）
     */
    @Override
    public Page<PIMPERSON> searchYGXXGLY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchYGXXGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目部人员查询
     */
    @Override
    public Page<PIMPERSON> searchXMBRYCX(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchXMBRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织实际可选人员
     */
    @Override
    public Page<PIMPERSON> searchCurOrgPerson(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchCurOrgPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PIMPERSON> searchJLSSGR(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 部门负责人选择范围
     */
    @Override
    public Page<PIMPERSON> searchCurLeader(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchCurLeader(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 是否黑名单
     */
    @Override
    public Page<PIMPERSON> searchSFHMD(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchSFHMD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人员信息树视图
     */
    @Override
    public Page<PIMPERSON> searchSSTRERSONINFO(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchSSTRERSONINFO(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织可选计划人员
     */
    @Override
    public Page<PIMPERSON> searchCurJHRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchCurJHRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可退休人员
     */
    @Override
    public Page<PIMPERSON> searchKTXYG(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKTXYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非A类员工
     */
    @Override
    public Page<PIMPERSON> searchBYLYG(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchBYLYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 干部花名册
     */
    @Override
    public Page<PIMPERSON> searchGBHMC(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchGBHMC(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职到期管理
     */
    @Override
    public Page<PIMPERSON> searchGZDQGL(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchGZDQGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可请假员工查询
     */
    @Override
    public Page<PIMPERSON> searchKQJRYCX(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKQJRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离（退）休员工
     */
    @Override
    public Page<PIMPERSON> searchLTXSTAFF(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchLTXSTAFF(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 机关 项目人员分布
     */
    @Override
    public Page<HashMap> searchREP_PERSONORGTYPE(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_PERSONORGTYPE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示人员（权限控制）
     */
    @Override
    public Page<PIMPERSON> searchAuthPerson(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchAuthPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMPERSON> searchDefault(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可挂职人员
     */
    @Override
    public Page<PIMPERSON> searchKGZRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKGZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工自助登录人员ID
     */
    @Override
    public Page<PIMPERSON> searchSELFHELPID(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchSELFHELPID(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 试用期员工查询
     */
    @Override
    public Page<PIMPERSON> searchSYQYGCX(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchSYQYGCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职人员花名册
     */
    @Override
    public Page<PIMPERSON> searchLZRYHMC(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchLZRYHMC(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 头衔专用
     */
    @Override
    public Page<PIMPERSON> searchTitleUse(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchTitleUse(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习期员工查询
     */
    @Override
    public Page<PIMPERSON> searchJXQYGCX(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchJXQYGCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 存在有效分配的主分配的人员
     */
    @Override
    public Page<PIMPERSON> searchYXZFPRYDS(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchYXZFPRYDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 在职人员
     */
    @Override
    public Page<PIMPERSON> searchRYZT_30(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchRYZT_30(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待退休人员
     */
    @Override
    public Page<PIMPERSON> searchDTXYG(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchDTXYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 新增考勤人员（考勤设置）
     */
    @Override
    public Page<PIMPERSON> searchXZKQRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchXZKQRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 年龄分布
     */
    @Override
    public Page<HashMap> searchREP_PERSONAGE(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_PERSONAGE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 试用期可转正人员
     */
    @Override
    public Page<PIMPERSON> searchSYQKZZRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchSYQKZZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习期可转正人员
     */
    @Override
    public Page<PIMPERSON> searchJXQKZZRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchJXQKZZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休干部
     */
    @Override
    public Page<PIMPERSON> searchTXGB(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchTXGB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可进行职级变动的人员
     */
    @Override
    public Page<PIMPERSON> searchKZJBDRY(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKZJBDRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下人员
     */
    @Override
    public Page<PIMPERSON> searchCurOrgPimperson(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchCurOrgPimperson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休员工查询
     */
    @Override
    public Page<PIMPERSON> searchTXRYCX(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchTXRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 申请单可选择试用期可转正人员
     */
    @Override
    public Page<PIMPERSON> searchKXZSYQKZZRYDS(PIMPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSON> pages=baseMapper.searchKXZSYQKZZRYDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMPERSON et){
        //实体关系[DER1N_PIMPERSON_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrdervalue(ormorgsector.getOrdervalue());
            et.setOrmorgsectorname(ormorgsector.getShortname());
            et.setOrgtype(ormorgsector.getOrgtype());
        }
        //实体关系[DER1N_PIMPERSON_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PIMPERSON_PCMRCXL_PCMRCXLID]
        if(!ObjectUtils.isEmpty(et.getPcmrcxlid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMRCXL pcmrcxl=et.getPcmrcxl();
            if(ObjectUtils.isEmpty(pcmrcxl)){
                cn.ibizlab.ehr.core.pcm.domain.PCMRCXL majorEntity=pcmrcxlService.get(et.getPcmrcxlid());
                et.setPcmrcxl(majorEntity);
                pcmrcxl=majorEntity;
            }
            et.setPcmrcxlname(pcmrcxl.getPcmrcxlname());
        }
        //实体关系[DER1N_PIMPERSON_PIMCITY_PIMCITYID]
        if(!ObjectUtils.isEmpty(et.getPimcityid())){
            cn.ibizlab.ehr.core.pim.domain.PIMCITY pimcity=et.getPimcity();
            if(ObjectUtils.isEmpty(pimcity)){
                cn.ibizlab.ehr.core.pim.domain.PIMCITY majorEntity=pimcityService.get(et.getPimcityid());
                et.setPimcity(majorEntity);
                pimcity=majorEntity;
            }
            et.setPimcityname(pimcity.getPimcityname());
        }
        //实体关系[DER1N_PIMPERSON_PIMMAJORSETYPE_PIMMAJORSETYPEID]
        if(!ObjectUtils.isEmpty(et.getPimmajorsetypeid())){
            cn.ibizlab.ehr.core.pim.domain.PIMMAJORSETYPE pimmajorsetype=et.getPimmajorsetype();
            if(ObjectUtils.isEmpty(pimmajorsetype)){
                cn.ibizlab.ehr.core.pim.domain.PIMMAJORSETYPE majorEntity=pimmajorsetypeService.get(et.getPimmajorsetypeid());
                et.setPimmajorsetype(majorEntity);
                pimmajorsetype=majorEntity;
            }
            et.setPimmajorsetypename(pimmajorsetype.getPimmajorsetypename());
        }
        //实体关系[DER1N_PIMPERSON_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
        }
        //实体关系[DER1N_PIMPERSON_PIMPERSON_PIMPERSONID3]
        if(!ObjectUtils.isEmpty(et.getPimpersonid3())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson3=et.getPimperson3();
            if(ObjectUtils.isEmpty(pimperson3)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid3());
                et.setPimperson3(majorEntity);
                pimperson3=majorEntity;
            }
            et.setPimpersonname3(pimperson3.getPimpersonname());
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


