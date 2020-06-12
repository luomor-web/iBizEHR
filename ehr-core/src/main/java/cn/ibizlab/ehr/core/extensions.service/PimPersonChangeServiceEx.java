package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimPersonChangeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimPersonChange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[人员信息变更审核] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimPersonChangeServiceEx")
public class PimPersonChangeServiceEx extends PimPersonChangeServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[BH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPersonChange bH(PimPersonChange et) {
        return super.bH(et);
    }
    /**
     * 自定义行为[Ensure]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPersonChange ensure(PimPersonChange et) {
        return super.ensure(et);
    }
    /**
     * 自定义行为[QR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPersonChange qR(PimPersonChange et) {
        return super.qR(et);
    }
}


