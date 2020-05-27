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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMPROFILEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者基本信息] 服务对象接口实现
 */
@Slf4j
@Service("PCMPROFILEServiceImpl")
public class PCMPROFILEServiceImpl extends ServiceImpl<PCMPROFILEMapper, PCMPROFILE> implements IPCMPROFILEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMAWARDSWONSService pcmawardswonsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMCERTOFREGService pcmcertofregService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMEducationExperienceService pcmeducationexperienceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPRACTICEEXPERIENCEService pcmpracticeexperienceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEAPPROVALService pcmprofileapprovalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMSCHOOLOFFICEService pcmschoolofficeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMTXFPSQService pcmtxfpsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMWORKRESUMEService pcmworkresumeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.ITDZWXXService tdzwxxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.ITestResultService testresultService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEGroupConfirmLogic groupconfirmLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEForwardLogic forwardLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILECheckInLogic checkinLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILECompanyConfirmLogic companyconfirmLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEInvalidLogic invalidLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILECompanyRejectLogic companyrejectLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEGroupRejectLogic grouprejectLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEPreCheckInLogic precheckinLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILESubmitLogic submitLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMPROFILEUnCheckInLogic uncheckinLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMPROFILE jZBTG(PCMPROFILE et) {
        groupconfirmLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE sBJZB(PCMPROFILE et) {
        forwardLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE jSPBTG(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE printSPB(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE getYPZNL(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE clearPersonUpdateInfo(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMPROFILE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMPROFILE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMPROFILE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMPROFILE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMPROFILE invalid2(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE bD(PCMPROFILE et) {
        checkinLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE jLDTG(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE checkYJSNF(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE gSSP(PCMPROFILE et) {
        companyconfirmLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE checkEmail(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE getPcmprofileInfo(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMPROFILE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMPROFILE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMPROFILE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofileid",et.getPcmprofileid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMPROFILE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMPROFILE returnYPZ(PCMPROFILE et) {
        invalidLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE get(String key) {
        PCMPROFILE et = getById(key);
        if(et==null){
            et=new PCMPROFILE();
            et.setPcmprofileid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE checkYglxIsChanged(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE sX(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMPROFILE et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofileid()))&&(!Objects.isNull(this.getById(et.getPcmprofileid())));
    }

    @Override
    @Transactional
    public PCMPROFILE invalid(PCMPROFILE et) {
        companyrejectLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE jZBBTG(PCMPROFILE et) {
        grouprejectLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE clearYPZ(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE checkFP(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE sCBH(PCMPROFILE et) {
        precheckinLogic.execute(et);
         return et ;
    }

    @Override
    public PCMPROFILE getDraft(PCMPROFILE et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE clearYYDJMC(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE submit(PCMPROFILE et) {
        submitLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE personUpdateInfo(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE gSCS(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE fillingYPZ(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE yQWBD(PCMPROFILE et) {
        uncheckinLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMPROFILE uSEYBH(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE checkMobieNumber(PCMPROFILE et) {
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
    public PCMPROFILE jLDBTG(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE jSPTG(PCMPROFILE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMPROFILE setNQDLDHTQX(PCMPROFILE et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PCMPROFILE> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PCMPROFILE>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PCMPROFILE> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMPROFILE>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMPROFILE> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMPROFILE>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMPROFILE> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PCMPROFILE>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PCMPROFILE> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMPROFILE>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 用人单位董事长审批（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchYRDWSH_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchYRDWSH_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审核（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchJLDSP(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchJLDSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 报到（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchBD_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchBD_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 应聘者审批表（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchYPZSPB_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchYPZSPB_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用人单位初审（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchZPDWSH(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchZPDWSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 报到（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchBD(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchBD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 编号审批（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchBHSP(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchBHSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 录入（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchLR(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchLR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人力上报（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchRLSB(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchRLSB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 FormType
     */
    @Override
    public Page<PCMPROFILE> searchFormType(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchHTRY_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchHTRY_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMPROFILE> searchDefault(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审批（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchJZBSP(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchJZBSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部初审（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchRZSP_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchRZSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审核（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchJLDSP_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchJLDSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 编号审批（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchBHSP_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchBHSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 录入（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchLR_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchLR_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 应聘者查询
     */
    @Override
    public Page<PCMPROFILE> searchYPZBB_READ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchYPZBB_READ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchHTRY(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchHTRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部初审（校园招聘）
     */
    @Override
    public Page<PCMPROFILE> searchRZSP(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchRZSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用人单位初审（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchYRDWCS_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchYRDWCS_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局总部审批（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchJZBSP_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchJZBSP_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人力上报（成熟人才引进）
     */
    @Override
    public Page<PCMPROFILE> searchRLSB_CSRCYJ(PCMPROFILESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILE> pages=baseMapper.searchRLSB_CSRCYJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMPROFILE et){
        //实体关系[DER1N_PCMPROFILE_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMPROFILE_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMPROFILE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMPROFILE_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PCMPROFILE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


