package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacHolidayRulesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacHolidayRules;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤规则] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacHolidayRulesServiceEx")
public class VacHolidayRulesServiceEx extends VacHolidayRulesServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CopyKQGZData]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacHolidayRules copyKQGZData(VacHolidayRules et) {
        return super.copyKQGZData(et);
    }
}


