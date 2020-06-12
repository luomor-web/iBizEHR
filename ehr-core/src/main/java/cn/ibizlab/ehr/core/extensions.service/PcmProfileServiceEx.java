package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmProfileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[应聘者基本信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmProfileServiceEx")
public class PcmProfileServiceEx extends PcmProfileServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[JSPBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile jSPBTG(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[PrintSPB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile printSPB(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[GetYPZNL]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile getYPZNL(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[ClearPersonUpdateInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile clearPersonUpdateInfo(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[Invalid2]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile invalid2(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[JLDTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile jLDTG(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[CheckYJSNF]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile checkYJSNF(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[CheckEmail]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile checkEmail(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[GetPcmprofileInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile getPcmprofileInfo(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[CheckYglxIsChanged]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile checkYglxIsChanged(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[SX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile sX(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[ClearYPZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile clearYPZ(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[CheckFP]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile checkFP(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[ClearYYDJMC]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile clearYYDJMC(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[PersonUpdateInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile personUpdateInfo(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[GSCS]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile gSCS(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[FillingYPZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile fillingYPZ(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[USEYBH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile uSEYBH(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[CheckMobieNumber]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile checkMobieNumber(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[JLDBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile jLDBTG(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[JSPTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile jSPTG(PcmProfile et) {
        return et;
    }
    /**
     * 自定义行为[SetNQDLDHTQX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmProfile setNQDLDHTQX(PcmProfile et) {
        return et;
    }
}


