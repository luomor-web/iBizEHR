package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmBdsqdmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[职级变动明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmBdsqdmxServiceEx")
public class PcmBdsqdmxServiceEx extends PcmBdsqdmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CQBXCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx cQBXCZ(PcmBdsqdmx et) {
        return super.cQBXCZ(et);
    }
    /**
     * 自定义行为[PDZJ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx pDZJ(PcmBdsqdmx et) {
        return super.pDZJ(et);
    }
    /**
     * 自定义行为[ZZSQ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx zZSQ(PcmBdsqdmx et) {
        return super.zZSQ(et);
    }
    /**
     * 自定义行为[DGCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx dGCZ(PcmBdsqdmx et) {
        return super.dGCZ(et);
    }
    /**
     * 自定义行为[GZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx gZCZ(PcmBdsqdmx et) {
        return super.gZCZ(et);
    }
    /**
     * 自定义行为[JPCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx jPCZ(PcmBdsqdmx et) {
        return super.jPCZ(et);
    }
    /**
     * 自定义行为[LZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx lZCZ(PcmBdsqdmx et) {
        return super.lZCZ(et);
    }
    /**
     * 自定义行为[NTCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx nTCZ(PcmBdsqdmx et) {
        return super.nTCZ(et);
    }
    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx sHBTG(PcmBdsqdmx et) {
        return super.sHBTG(et);
    }
    /**
     * 自定义行为[ZJBDCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx zJBDCZ(PcmBdsqdmx et) {
        return super.zJBDCZ(et);
    }
    /**
     * 自定义行为[TXCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx tXCZ(PcmBdsqdmx et) {
        return super.tXCZ(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmBdsqdmx sHTG(PcmBdsqdmx et) {
        return super.sHTG(et);
    }
}


