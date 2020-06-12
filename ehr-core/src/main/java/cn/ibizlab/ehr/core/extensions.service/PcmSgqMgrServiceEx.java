package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmSgqMgrServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmSgqMgr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[试岗期管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmSgqMgrServiceEx")
public class PcmSgqMgrServiceEx extends PcmSgqMgrServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SGTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmSgqMgr sGTG(PcmSgqMgr et) {
        return super.sGTG(et);
    }
    /**
     * 自定义行为[SGBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmSgqMgr sGBTG(PcmSgqMgr et) {
        return super.sGBTG(et);
    }
}


