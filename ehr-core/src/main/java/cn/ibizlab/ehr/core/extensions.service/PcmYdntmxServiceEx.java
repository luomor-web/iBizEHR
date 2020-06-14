package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmYdntmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdntmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[异动内退明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmYdntmxServiceEx")
public class PcmYdntmxServiceEx extends PcmYdntmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[FinishNT]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmYdntmx finishNT(PcmYdntmx et) {
        return super.finishNT(et);
    }
}


