package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimPersonAbilityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimPersonAbility;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[员工能力] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimPersonAbilityServiceEx")
public class PimPersonAbilityServiceEx extends PimPersonAbilityServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[InitData]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPersonAbility initData(PimPersonAbility et) {
        return super.initData(et);
    }
}


