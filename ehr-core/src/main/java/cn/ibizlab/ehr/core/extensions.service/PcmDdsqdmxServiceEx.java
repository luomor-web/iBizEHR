package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmDdsqdmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[调动申请单明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmDdsqdmxServiceEx")
public class PcmDdsqdmxServiceEx extends PcmDdsqdmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[DDUpdate]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx dDUpdate(PcmDdsqdmx et) {
        return super.dDUpdate(et);
    }
    /**
     * 自定义行为[SQBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx sQBTG(PcmDdsqdmx et) {
        return super.sQBTG(et);
    }
    /**
     * 自定义行为[JDCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx jDCZ(PcmDdsqdmx et) {
        return super.jDCZ(et);
    }
    /**
     * 自定义行为[DDCreate]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx dDCreate(PcmDdsqdmx et) {
        return super.dDCreate(et);
    }
    /**
     * 自定义行为[ZZSQ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx zZSQ(PcmDdsqdmx et) {
        return super.zZSQ(et);
    }
    /**
     * 自定义行为[DDCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx dDCZ(PcmDdsqdmx et) {
        return super.dDCZ(et);
    }
    /**
     * 自定义行为[SQTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx sQTG(PcmDdsqdmx et) {
        return super.sQTG(et);
    }
    /**
     * 自定义行为[JZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqdmx jZCZ(PcmDdsqdmx et) {
        return super.jZCZ(et);
    }
}


