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
import cn.ibizlab.ehr.core.orm.domain.OrmOrg;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmOrgMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmOrgServiceImpl")
public class OrmOrgServiceImpl extends ServiceImpl<OrmOrgMapper, OrmOrg> implements IOrmOrgService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesCenterService pimarchivescenterService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceMreportService attendancemreportService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordTempService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceCalendarService attendencecalendarService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimBudgetService pimbudgetService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractSignOrgService pimcontractsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDateRuleService pimdateruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgdzService ormorgdzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;

    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmQybzwhService ormqybzwhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmQyglService ormqyglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmUserService ormuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmbqService ormxmbqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmZwdqgzService ormzwdqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJgbmpjbzService parjgbmpjbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxbzglService parjxbzglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxkhjcszService parjxkhjcszService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxkhmbService parjxkhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxqdszService parjxqdszService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParXmbpjbzService parxmbpjbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPcmDetailService pcmdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsbdjlService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileInitNumberService pcmprofileinitnumberService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileNumBeprefixService pcmprofilenumbeprefixService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmSyqgzService pcmsyqgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmZpmeglService pcmzpmeglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesChangeService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractTypeService pimcontracttypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimExpaccountService pimexpaccountService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimLabourcampanyService pimlabourcampanyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimOutputService pimoutputService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimQualMajorService pimqualmajorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimTitleCatalogueService pimtitlecatalogueService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimWorkflowService pimworkflowService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalItemSubService salitemsubService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPlanService salplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryBillService salsalarybillService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeService salschemeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStddsznService salstddsznService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdglService salstdglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdGwGzrateService salstdgwgzrateService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdgwgzService salstdgwgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdgwService salstdgwService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdXmgzRateService salstdxmgzrateService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdXmgzService salstdxmgzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdzcService salstdzcService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdzjService salstdzjService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdzxService salstdzxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalStdzyzgService salstdzyzgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocAccountService socaccountService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocAreaService socareaService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocRuleService socruleService;
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
    private cn.ibizlab.ehr.core.trm.service.ITrmEmployeeRetionService trmemployeeretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmHmatserService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmLgbCostService trmlgbcostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmPlanFormuService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffService trmstaffService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService trmtrainaddressService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainBuapplyService trmtrainbuapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDataService trmtraindataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandSumService trmtraindemandsumService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandService trmtraindemandService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainFillinService trmtrainfillinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacHolidayRulesService vacholidayrulesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacInitnxjService vacinitnxjService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveSystemService vacleavesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacOveralltionService vacoveralltionService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(OrmOrg et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgid",et.getOrgid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmOrg> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public OrmOrg synOrg(OrmOrg et) {
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
    public OrmOrg getDraft(OrmOrg et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public OrmOrg get(String key) {
        OrmOrg et = getById(key);
        if(et==null){
            et=new OrmOrg();
            et.setOrgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(OrmOrg et) {
        return (!ObjectUtils.isEmpty(et.getOrgid()))&&(!Objects.isNull(this.getById(et.getOrgid())));
    }
    @Override
    @Transactional
    public boolean create(OrmOrg et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmOrg> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrmOrg et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmOrg et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmOrg> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmOrg> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<OrmOrg> selectByPorgid(String orgid) {
        return baseMapper.selectByPorgid(orgid);
    }

    @Override
    public void removeByPorgid(String orgid) {
        this.remove(new QueryWrapper<OrmOrg>().eq("porgid",orgid));
    }


    /**
     * 查询集合 全部法人主体
     */
    @Override
    public Page<OrmOrg> searchALLSIGNORG(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchALLSIGNORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 全部二级单位（无权限）
     */
    @Override
    public Page<OrmOrg> searchAllLevelTwoOrg2(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchAllLevelTwoOrg2(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前可选择组织列表（应聘者信息使用）
     */
    @Override
    public Page<OrmOrg> searchOrglist_Profile(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchOrglist_Profile(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 组织分布
     */
    @Override
    public Page<HashMap> searchREP_ORG(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_ORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示组织(权限控制)
     */
    @Override
    public Page<OrmOrg> searchAuthOrg(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchAuthOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（公司级岗位专用）
     */
    @Override
    public Page<OrmOrg> searchGSGWZY(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchGSGWZY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示当前组织下组织
     */
    @Override
    public Page<OrmOrg> searchSubSubOrg(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchSubSubOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmOrg> searchDefault(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织查询
     */
    @Override
    public Page<OrmOrg> searchCurChild(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchCurChild(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 三级组织及以下组织
     */
    @Override
    public Page<OrmOrg> searchSJYXZZ(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchSJYXZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 组织人员总数
     */
    @Override
    public Page<HashMap> searchREP_ORGPNUM(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_ORGPNUM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（上级组织）
     */
    @Override
    public Page<OrmOrg> searchKZSJZZXZ(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchKZSJZZXZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询当前登录人组织下的组织（包含当前组织）
     */
    @Override
    public Page<OrmOrg> searchDanQian(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchDanQian(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 全部二级单位
     */
    @Override
    public Page<OrmOrg> searchAllLevelTwoOrg(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchAllLevelTwoOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 显示当前组织包含所有组织
     */
    @Override
    public Page<OrmOrg> searchSubOrg(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchSubOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 合同管理单位
     */
    @Override
    public Page<OrmOrg> searchHTGLDW(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchHTGLDW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用于控制当前用户选择视图下拉显示（当前组织）
     */
    @Override
    public Page<OrmOrg> searchKZXLXZ(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchKZXLXZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 三级组织及以下组织（权限控制）
     */
    @Override
    public Page<OrmOrg> searchAuthSJYXZZ(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchAuthSJYXZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 分配信息专用（组织过滤）
     */
    @Override
    public Page<OrmOrg> searchUseByFP(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchUseByFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根组织查询
     */
    @Override
    public Page<OrmOrg> searchCurPorg(OrmOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrg> pages=baseMapper.searchCurPorg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmOrg et){
        //实体关系[DER1N_ORMORG_ORMORG_PORGID]
        if(!ObjectUtils.isEmpty(et.getPorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg porg=et.getPorg();
            if(ObjectUtils.isEmpty(porg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getPorgid());
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

    @Override
    public List<OrmOrg> getOrmorgByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmOrg> getOrmorgByEntities(List<OrmOrg> entities) {
        List ids =new ArrayList();
        for(OrmOrg entity : entities){
            Serializable id=entity.getOrgid();
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



