package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimLanguageAbilityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimLanguageAbility;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[语言能力] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimLanguageAbilityServiceEx")
public class PimLanguageAbilityServiceEx extends PimLanguageAbilityServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CustRemove]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimLanguageAbility custRemove(PimLanguageAbility et) {
        return super.custRemove(et);
    }
}


