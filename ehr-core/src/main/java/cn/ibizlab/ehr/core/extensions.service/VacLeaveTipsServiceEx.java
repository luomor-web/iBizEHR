package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacLeaveTipsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveTips;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[请假提示] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacLeaveTipsServiceEx")
public class VacLeaveTipsServiceEx extends VacLeaveTipsServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CheckQJZL]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveTips checkQJZL(VacLeaveTips et) {
        return super.checkQJZL(et);
    }
    /**
     * 自定义行为[CheckRepeat]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveTips checkRepeat(VacLeaveTips et) {
        return super.checkRepeat(et);
    }
}


