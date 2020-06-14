package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimExitandentryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimExitandentry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[出入境管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimExitandentryServiceEx")
public class PimExitandentryServiceEx extends PimExitandentryServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimExitandentry cX(PimExitandentry et) {
        return super.cX(et);
    }
    /**
     * 自定义行为[MobStart]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimExitandentry mobStart(PimExitandentry et) {
        return super.mobStart(et);
    }
    /**
     * 自定义行为[CB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimExitandentry cB(PimExitandentry et) {
        return super.cB(et);
    }
    /**
     * 自定义行为[Start]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimExitandentry start(PimExitandentry et) {
        return super.start(et);
    }
}


