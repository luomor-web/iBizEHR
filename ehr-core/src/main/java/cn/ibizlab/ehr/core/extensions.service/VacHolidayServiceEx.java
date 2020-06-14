package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacHolidayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacHoliday;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[节假日管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacHolidayServiceEx")
public class VacHolidayServiceEx extends VacHolidayServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[APPOINTJZBJJR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacHoliday aPPOINTJZBJJR(VacHoliday et) {
        return super.aPPOINTJZBJJR(et);
    }
}


