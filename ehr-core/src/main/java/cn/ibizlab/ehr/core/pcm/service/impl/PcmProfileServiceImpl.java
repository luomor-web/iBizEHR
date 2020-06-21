package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmProfileMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者基本信息] 服务对象接口实现
 */
@Slf4j
@Service("PcmProfileServiceImpl")
public class PcmProfileServiceImpl extends ServiceImpl<PcmProfileMapper, PcmProfile> implements IPcmProfileService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmAwardsWonsService pcmawardswonsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmCertofregService pcmcertofregService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmEducationExperienceService pcmeducationexperienceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmPracticeExperienceService pcmpracticeexperienceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileApprovalService pcmprofileapprovalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmSchoolOfficeService pcmschoolofficeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService pcmtxfpsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmWorkResumeService pcmworkresumeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmTdzwxxService pcmtdzwxxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmTestResultService pcmtestresultService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmDutyService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileGroupConfirmLogic groupconfirmLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileForwardLogic forwardLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileCheckInLogic checkinLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileCompanyConfirmLogic companyconfirmLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileInvalidLogic invalidLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileCompanyRejectLogic companyrejectLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileGroupRejectLogic grouprejectLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfilePreCheckInLogic precheckinLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileSubmitLogic submitLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmProfileUnCheckInLogic uncheckinLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmProfile jZBTG(PcmProfile et) {
        groupconfirmLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile sBJZB(PcmProfile et) {
        forwardLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile jSPBTG(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile printSPB(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile getYPZNL(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile clearPersonUpdateInfo(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmProfile et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmProfile et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmProfile> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmProfile> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmProfile invalid2(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile bD(PcmProfile et) {
        checkinLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile jLDTG(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile checkYJSNF(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile gSSP(PcmProfile et) {
        companyconfirmLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile checkEmail(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile getPcmprofileInfo(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmProfile et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmProfile> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PcmProfile et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofileid",et.getPcmprofileid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmProfile> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmProfile returnYPZ(PcmProfile et) {
        invalidLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile get(String key) {
        PcmProfile et = getById(key);
        if(et==null){
            et=new PcmProfile();
            et.setPcmprofileid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmProfile checkYglxIsChanged(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile sX(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmProfile et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofileid()))&&(!Objects.isNull(this.getById(et.getPcmprofileid())));
    }
    @Override
    @Transactional
    public PcmProfile invalid(PcmProfile et) {
        companyrejectLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile jZBBTG(PcmProfile et) {
        grouprejectLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile clearYPZ(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile checkFP(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile sCBH(PcmProfile et) {
        precheckinLogic.execute(et);
         return et ;
    }

    @Override
    public PcmProfile getDraft(PcmProfile et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmProfile clearYYDJMC(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile submit(PcmProfile et) {
        submitLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile personUpdateInfo(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile gSCS(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile fillingYPZ(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile yQWBD(PcmProfile et) {
        uncheckinLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmProfile uSEYBH(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile checkMobieNumber(PcmProfile et) {
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
    public PcmProfile jLDBTG(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile jSPTG(PcmProfile et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmProfile setNQDLDHTQX(PcmProfile et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PcmProfile> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PcmProfile>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PcmProfile> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PcmProfile>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PcmProfile> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PcmProfile>().eq("ormorgid",orgid));
    }

	@Override
    public List<PcmProfile> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PcmProfile>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PcmProfile> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmProfile>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 用人单位董事长审批（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchYRDWSH_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchYRDWSH_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审核（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchJLDSP(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchJLDSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 报到（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchBD_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchBD_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 应聘者审批表（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchYPZSPB_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchYPZSPB_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用人单位初审（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchZPDWSH(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchZPDWSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 报到（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchBD(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchBD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 编号审批（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchBHSP(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchBHSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 录入（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchLR(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchLR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人力上报（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchRLSB(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchRLSB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 FormType
     */
    @Override
    public Page<PcmProfile> searchFormType(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchHTRY_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchHTRY_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmProfile> searchDefault(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审批（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchJZBSP(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchJZBSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部初审（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchRZSP_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchRZSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审核（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchJLDSP_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchJLDSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 编号审批（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchBHSP_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchBHSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 录入（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchLR_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchLR_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 应聘者查询
     */
    @Override
    public Page<PcmProfile> searchYPZBB_READ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchYPZBB_READ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchHTRY(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchHTRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部初审（校园招聘）
     */
    @Override
    public Page<PcmProfile> searchRZSP(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchRZSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用人单位初审（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchYRDWCS_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchYRDWCS_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审批（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchJZBSP_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchJZBSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人力上报（成熟人才引进）
     */
    @Override
    public Page<PcmProfile> searchRLSB_CSRCYJ(PcmProfileSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmProfile> pages=baseMapper.searchRLSB_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmProfile>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmProfile et){
        //实体关系[DER1N_PCMPROFILE_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.OrmDuty majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMPROFILE_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMPROFILE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMPROFILE_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PCMPROFILE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
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
    public List<PcmProfile> getPcmprofileByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmProfile> getPcmprofileByEntities(List<PcmProfile> entities) {
        List ids =new ArrayList();
        for(PcmProfile entity : entities){
            Serializable id=entity.getPcmprofileid();
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



