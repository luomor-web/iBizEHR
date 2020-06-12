package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmGbhmcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmGbhmc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[干部花名册] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmGbhmcServiceEx")
public class PcmGbhmcServiceEx extends PcmGbhmcServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ToggleLeader]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmGbhmc toggleLeader(PcmGbhmc et) {
        return super.toggleLeader(et);
    }
    /**
     * 自定义行为[SGTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmGbhmc sGTG(PcmGbhmc et) {
        return super.sGTG(et);
    }
    /**
     * 自定义行为[SGBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmGbhmc sGBTG(PcmGbhmc et) {
        return super.sGBTG(et);
    }
}


