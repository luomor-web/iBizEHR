package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmYdjzmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[异动兼职明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmYdjzmxServiceEx")
public class PcmYdjzmxServiceEx extends PcmYdjzmxServiceImpl {

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
    public PcmYdjzmx rYHG(PcmYdjzmx et) {
        return super.rYHG(et);
    }
}


