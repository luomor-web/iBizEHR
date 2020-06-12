package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimFaminfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[家庭情况] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimFaminfoServiceEx")
public class PimFaminfoServiceEx extends PimFaminfoServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[UpdateInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimFaminfo updateInfo(PimFaminfo et) {
        return super.updateInfo(et);
    }
    /**
     * 自定义行为[UpdateContact]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimFaminfo updateContact(PimFaminfo et) {
        return super.updateContact(et);
    }
}


