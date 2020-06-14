package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmEducationExperienceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmEducationExperience;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[教育背景] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmEducationExperienceServiceEx")
public class PcmEducationExperienceServiceEx extends PcmEducationExperienceServiceImpl {

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
    public PcmEducationExperience checkHighestEdu(PcmEducationExperience et) {
        return super.checkHighestEdu(et);
    }
    /**
     * 自定义行为[CheckRepeatXL]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmEducationExperience checkRepeatXL(PcmEducationExperience et) {
        return super.checkRepeatXL(et);
    }
    /**
     * 自定义行为[CheckTime]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmEducationExperience checkTime(PcmEducationExperience et) {
        return super.checkTime(et);
    }
}


