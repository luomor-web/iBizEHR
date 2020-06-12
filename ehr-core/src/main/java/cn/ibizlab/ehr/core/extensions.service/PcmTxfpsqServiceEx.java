package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmTxfpsqServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[退休返聘申请] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmTxfpsqServiceEx")
public class PcmTxfpsqServiceEx extends PcmTxfpsqServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[FPCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmTxfpsq fPCZ(PcmTxfpsq et) {
        return super.fPCZ(et);
    }
    /**
     * 自定义行为[FinishFP]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmTxfpsq finishFP(PcmTxfpsq et) {
        return super.finishFP(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmTxfpsq sHTG(PcmTxfpsq et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmTxfpsq sHBTG(PcmTxfpsq et) {
        return super.sHBTG(et);
    }
}


