package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacLeaveDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[请假明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacLeaveDetailServiceEx")
public class VacLeaveDetailServiceEx extends VacLeaveDetailServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[GetNianJia]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveDetail getNianJia(VacLeaveDetail et) {
        return super.getNianJia(et);
    }
    /**
     * 自定义行为[CalcPlanDays]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveDetail calcPlanDays(VacLeaveDetail et) {
        return super.calcPlanDays(et);
    }
}


