package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmYddgmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmYddgmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[异动待岗明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmYddgmxServiceEx")
public class PcmYddgmxServiceEx extends PcmYddgmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[QXDG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmYddgmx qXDG(PcmYddgmx et) {
        return super.qXDG(et);
    }
}


