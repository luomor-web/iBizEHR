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
import cn.ibizlab.ehr.core.pim.domain.PimPerson;
import cn.ibizlab.ehr.core.pim.filter.PimPersonSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimPersonService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimPersonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员信息] 服务对象接口实现
 */
@Slf4j
@Service("PimPersonServiceImpl")
public class PimPersonServiceImpl extends ServiceImpl<PimPersonMapper, PimPerson> implements IPimPersonService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceMreportmxService attendancemreportmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordTempService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceSettingsService attendancesettingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEnsummaryService attensummaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmbmxService ormxmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmxqjhService ormxmxqjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParBmfzjyxService parbmfzjyxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParDxkhnrmxService pardxkhnrmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParFzsmxService parfzsmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxbzglmxService parjxbzglmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxlhmbService parjxlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxmtfkService parjxmtfkService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxndkhjgService parjxndkhjgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJzszpsjgService parjzszpsjgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParLdndlhmbService parldndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParPtryndlhmbService parptryndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdService pcmbdsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdService pcmddsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsbdjlService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzjlmxService pcmjxsygzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqmxService pcmjxsygzzsqmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmLogService pcmlogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmSgqMgrService pcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService pcmtxfpsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXygzzjlmxService pcmxygzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqmxService pcmxygzzsqmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdlzmxService pcmydlzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimAchievementsService pimachievementsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesChangeService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService pimarchivesloanandreturnService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArmycadresService pimarmycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimByzzjlmxService pimbyzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimCorrectionApplyService pimcorrectionapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimEducationService pimeducationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimEnclosureService pimenclosureService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimExitandentryService pimexitandentryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimFaminfoService pimfaminfoService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimLabourcampanyService pimlabourcampanyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimLanguageAbilityService pimlanguageabilityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPaperService pimpaperService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPatentService pimpatentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonAbilityService pimpersonabilityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonChangeService pimpersonchangeService;

    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimResearchFindingsService pimresearchfindingsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimRewardPunishmentService pimrewardpunishmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimSocialSecurityService pimsocialsecurityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimTitleService pimtitleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVacationService pimvacationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimWorkHistoryService pimworkhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmPcmSgqMgrService pcmpcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocArchivesService socarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDemdeftionService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDepartService trmdepartService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmHmatserService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmLgbDetailService trmlgbdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmPlanFormuService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffService trmstaffService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainOutApplyService trmtrainoutapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPersonService trmtrainpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService vacleavedetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveManageService vacleavemanageService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacOveralltionService vacoveralltionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacSituationService vacsituationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacSynjcxService vacsynjcxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacSystemApplicationService vacsystemapplicationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacSystemHistoryService vacsystemhistoryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmRcxlService pcmrcxlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimCityService pimcityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimMajorSetypeService pimmajorsetypeService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimPersonGetJTLXRDHLogic getjtlxrdhLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimPersonGenratePersonFileLogic genratepersonfileLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimPerson et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonid",et.getPimpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimPerson> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimPerson yZSFYZFP(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimPerson toggleLeader(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimPerson get(String key) {
        PimPerson et = getById(key);
        if(et==null){
            et=new PimPerson();
            et.setPimpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PimPerson personUpdateInfo(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimPerson fillPersonType(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimPerson et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimPerson> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimPerson et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimPerson et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimPerson> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimPerson> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimPerson getJTLXRDH(PimPerson et) {
        getjtlxrdhLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PimPerson synPerson(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        PimPerson et=new PimPerson();
        et.set("pimpersonid",key);
        boolean result=removeById(key);
        genratepersonfileLogic.execute(et);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    public boolean checkKey(PimPerson et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonid()))&&(!Objects.isNull(this.getById(et.getPimpersonid())));
    }
    @Override
    @Transactional
    public PimPerson qRTX(PimPerson et) {
        //自定义代码
        return et;
    }

    @Override
    public PimPerson getDraft(PimPerson et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PimPerson generatePersonFile(PimPerson et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PimPerson> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PimPerson>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PimPerson> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimPerson>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimPerson> selectByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) {
        return baseMapper.selectByPcmjxsygzzjlmxid(pcmjxsygzzjlmxid);
    }

    @Override
    public void removeByPcmjxsygzzjlmxid(String pcmjxsygzzjlmxid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pcmjxsygzzjlmxid",pcmjxsygzzjlmxid));
    }

	@Override
    public List<PimPerson> selectByPcmrcxlid(String pcmrcxlid) {
        return baseMapper.selectByPcmrcxlid(pcmrcxlid);
    }

    @Override
    public void removeByPcmrcxlid(String pcmrcxlid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pcmrcxlid",pcmrcxlid));
    }

	@Override
    public List<PimPerson> selectByPimcityid(String pimcityid) {
        return baseMapper.selectByPimcityid(pimcityid);
    }

    @Override
    public void removeByPimcityid(String pimcityid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pimcityid",pimcityid));
    }

	@Override
    public List<PimPerson> selectByPimmajorsetypeid(String pimmajorsetypeid) {
        return baseMapper.selectByPimmajorsetypeid(pimmajorsetypeid);
    }

    @Override
    public void removeByPimmajorsetypeid(String pimmajorsetypeid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pimmajorsetypeid",pimmajorsetypeid));
    }

	@Override
    public List<PimPerson> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pimpersonid2",pimpersonid));
    }

	@Override
    public List<PimPerson> selectByPimpersonid3(String pimpersonid) {
        return baseMapper.selectByPimpersonid3(pimpersonid);
    }

    @Override
    public void removeByPimpersonid3(String pimpersonid) {
        this.remove(new QueryWrapper<PimPerson>().eq("pimpersonid3",pimpersonid));
    }


    /**
     * 查询集合 可返聘人员
     */
    @Override
    public Page<PimPerson> searchKFPRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKFPRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待设置考勤人员
     */
    @Override
    public Page<PimPerson> searchSetAttRules(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSetAttRules(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待设置社保档案人员
     */
    @Override
    public Page<PimPerson> searchSetSocArchives(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSetSocArchives(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工信息（管理员）
     */
    @Override
    public Page<PimPerson> searchYGXXGLY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchYGXXGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目部人员查询
     */
    @Override
    public Page<PimPerson> searchXMBRYCX(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchXMBRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织实际可选人员
     */
    @Override
    public Page<PimPerson> searchCurOrgPerson(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchCurOrgPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimPerson> searchJLSSGR(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 部门负责人选择范围
     */
    @Override
    public Page<PimPerson> searchCurLeader(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchCurLeader(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 是否黑名单
     */
    @Override
    public Page<PimPerson> searchSFHMD(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSFHMD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人员信息树视图
     */
    @Override
    public Page<PimPerson> searchSSTRERSONINFO(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSSTRERSONINFO(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织可选计划人员
     */
    @Override
    public Page<PimPerson> searchCurJHRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchCurJHRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可退休人员
     */
    @Override
    public Page<PimPerson> searchKTXYG(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKTXYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非A类员工
     */
    @Override
    public Page<PimPerson> searchBYLYG(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchBYLYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 干部花名册
     */
    @Override
    public Page<PimPerson> searchGBHMC(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchGBHMC(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职到期管理
     */
    @Override
    public Page<PimPerson> searchGZDQGL(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchGZDQGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可请假员工查询
     */
    @Override
    public Page<PimPerson> searchKQJRYCX(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKQJRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离（退）休员工
     */
    @Override
    public Page<PimPerson> searchLTXSTAFF(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchLTXSTAFF(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 机关 项目人员分布
     */
    @Override
    public Page<HashMap> searchREP_PERSONORGTYPE(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_PERSONORGTYPE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示人员（权限控制）
     */
    @Override
    public Page<PimPerson> searchAuthPerson(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchAuthPerson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimPerson> searchDefault(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可挂职人员
     */
    @Override
    public Page<PimPerson> searchKGZRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKGZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工自助登录人员ID
     */
    @Override
    public Page<PimPerson> searchSELFHELPID(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSELFHELPID(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 试用期员工查询
     */
    @Override
    public Page<PimPerson> searchSYQYGCX(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSYQYGCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职人员花名册
     */
    @Override
    public Page<PimPerson> searchLZRYHMC(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchLZRYHMC(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 头衔专用
     */
    @Override
    public Page<PimPerson> searchTitleUse(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchTitleUse(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习期员工查询
     */
    @Override
    public Page<PimPerson> searchJXQYGCX(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchJXQYGCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 存在有效分配的主分配的人员
     */
    @Override
    public Page<PimPerson> searchYXZFPRYDS(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchYXZFPRYDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 在职人员
     */
    @Override
    public Page<PimPerson> searchRYZT_30(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchRYZT_30(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待退休人员
     */
    @Override
    public Page<PimPerson> searchDTXYG(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchDTXYG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 新增考勤人员（考勤设置）
     */
    @Override
    public Page<PimPerson> searchXZKQRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchXZKQRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 年龄分布
     */
    @Override
    public Page<HashMap> searchREP_PERSONAGE(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_PERSONAGE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 试用期可转正人员
     */
    @Override
    public Page<PimPerson> searchSYQKZZRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchSYQKZZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习期可转正人员
     */
    @Override
    public Page<PimPerson> searchJXQKZZRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchJXQKZZRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休干部
     */
    @Override
    public Page<PimPerson> searchTXGB(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchTXGB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可进行职级变动的人员
     */
    @Override
    public Page<PimPerson> searchKZJBDRY(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKZJBDRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下人员
     */
    @Override
    public Page<PimPerson> searchCurOrgPimperson(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchCurOrgPimperson(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休员工查询
     */
    @Override
    public Page<PimPerson> searchTXRYCX(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchTXRYCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 申请单可选择试用期可转正人员
     */
    @Override
    public Page<PimPerson> searchKXZSYQKZZRYDS(PimPersonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPerson> pages=baseMapper.searchKXZSYQKZZRYDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPerson>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimPerson et){
        //实体关系[DER1N_PIMPERSON_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrdervalue(ormorgsector.getOrdervalue());
            et.setOrmorgsectorname(ormorgsector.getShortname());
            et.setOrgtype(ormorgsector.getOrgtype());
        }
        //实体关系[DER1N_PIMPERSON_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PIMPERSON_PCMRCXL_PCMRCXLID]
        if(!ObjectUtils.isEmpty(et.getPcmrcxlid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmRcxl pcmrcxl=et.getPcmrcxl();
            if(ObjectUtils.isEmpty(pcmrcxl)){
                cn.ibizlab.ehr.core.pcm.domain.PcmRcxl majorEntity=pcmrcxlService.get(et.getPcmrcxlid());
                et.setPcmrcxl(majorEntity);
                pcmrcxl=majorEntity;
            }
            et.setPcmrcxlname(pcmrcxl.getPcmrcxlname());
        }
        //实体关系[DER1N_PIMPERSON_PIMCITY_PIMCITYID]
        if(!ObjectUtils.isEmpty(et.getPimcityid())){
            cn.ibizlab.ehr.core.pim.domain.PimCity pimcity=et.getPimcity();
            if(ObjectUtils.isEmpty(pimcity)){
                cn.ibizlab.ehr.core.pim.domain.PimCity majorEntity=pimcityService.get(et.getPimcityid());
                et.setPimcity(majorEntity);
                pimcity=majorEntity;
            }
            et.setPimcityname(pimcity.getPimcityname());
        }
        //实体关系[DER1N_PIMPERSON_PIMMAJORSETYPE_PIMMAJORSETYPEID]
        if(!ObjectUtils.isEmpty(et.getPimmajorsetypeid())){
            cn.ibizlab.ehr.core.pim.domain.PimMajorSetype pimmajorsetype=et.getPimmajorsetype();
            if(ObjectUtils.isEmpty(pimmajorsetype)){
                cn.ibizlab.ehr.core.pim.domain.PimMajorSetype majorEntity=pimmajorsetypeService.get(et.getPimmajorsetypeid());
                et.setPimmajorsetype(majorEntity);
                pimmajorsetype=majorEntity;
            }
            et.setPimmajorsetypename(pimmajorsetype.getPimmajorsetypename());
        }
        //实体关系[DER1N_PIMPERSON_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
        }
        //实体关系[DER1N_PIMPERSON_PIMPERSON_PIMPERSONID3]
        if(!ObjectUtils.isEmpty(et.getPimpersonid3())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson3=et.getPimperson3();
            if(ObjectUtils.isEmpty(pimperson3)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid3());
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

    @Override
    public List<PimPerson> getPimpersonByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimPerson> getPimpersonByEntities(List<PimPerson> entities) {
        List ids =new ArrayList();
        for(PimPerson entity : entities){
            Serializable id=entity.getPimpersonid();
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



