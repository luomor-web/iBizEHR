package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmYdgzmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdgzmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[异动挂职明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmYdgzmxServiceEx")
public class PcmYdgzmxServiceEx extends PcmYdgzmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[RYHG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmYdgzmx rYHG(PcmYdgzmx et) {
        return super.rYHG(et);
    }
}


