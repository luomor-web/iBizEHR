package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimByzzjlmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[B/Y类员工转正记录引用明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimByzzjlmxServiceEx")
public class PimByzzjlmxServiceEx extends PimByzzjlmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx sHTG(PimByzzjlmx et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[ReturnYPZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx returnYPZ(PimByzzjlmx et) {
        return super.returnYPZ(et);
    }
    /**
     * 自定义行为[JSPTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jSPTG(PimByzzjlmx et) {
        return super.jSPTG(et);
    }
    /**
     * 自定义行为[JSHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jSHTG(PimByzzjlmx et) {
        return super.jSHTG(et);
    }
    /**
     * 自定义行为[JSHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jSHBTG(PimByzzjlmx et) {
        return super.jSHBTG(et);
    }
    /**
     * 自定义行为[Ensure]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx ensure(PimByzzjlmx et) {
        return super.ensure(et);
    }
    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx sHBTG(PimByzzjlmx et) {
        return super.sHBTG(et);
    }
    /**
     * 自定义行为[GSDSZSP]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx gSDSZSP(PimByzzjlmx et) {
        return super.gSDSZSP(et);
    }
    /**
     * 自定义行为[ZZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx zZCZ(PimByzzjlmx et) {
        return super.zZCZ(et);
    }
    /**
     * 自定义行为[DSB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx dSB(PimByzzjlmx et) {
        return super.dSB(et);
    }
    /**
     * 自定义行为[JZBSHQR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jZBSHQR(PimByzzjlmx et) {
        return super.jZBSHQR(et);
    }
    /**
     * 自定义行为[GSDSZSPBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx gSDSZSPBTG(PimByzzjlmx et) {
        return super.gSDSZSPBTG(et);
    }
    /**
     * 自定义行为[GSCSBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx gSCSBTG(PimByzzjlmx et) {
        return super.gSCSBTG(et);
    }
    /**
     * 自定义行为[JSPBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jSPBTG(PimByzzjlmx et) {
        return super.jSPBTG(et);
    }
    /**
     * 自定义行为[GSCS]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx gSCS(PimByzzjlmx et) {
        return super.gSCS(et);
    }
    /**
     * 自定义行为[UpdatePeopleNum]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx updatePeopleNum(PimByzzjlmx et) {
        return super.updatePeopleNum(et);
    }
    /**
     * 自定义行为[JZBSPQR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimByzzjlmx jZBSPQR(PimByzzjlmx et) {
        return super.jZBSPQR(et);
    }
}


