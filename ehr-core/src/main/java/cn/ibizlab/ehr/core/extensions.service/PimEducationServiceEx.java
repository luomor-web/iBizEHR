package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimEducationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimEducation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[教育信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimEducationServiceEx")
public class PimEducationServiceEx extends PimEducationServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CheckHighestEdu]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimEducation checkHighestEdu(PimEducation et) {
        return super.checkHighestEdu(et);
    }
}


