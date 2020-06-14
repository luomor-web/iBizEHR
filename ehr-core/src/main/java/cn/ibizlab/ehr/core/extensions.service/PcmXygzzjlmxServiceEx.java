package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmXygzzjlmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjlmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[试用期员工转正记录引用明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmXygzzjlmxServiceEx")
public class PcmXygzzjlmxServiceEx extends PcmXygzzjlmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[XYGZZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzjlmx xYGZZCZ(PcmXygzzjlmx et) {
        return super.xYGZZCZ(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzjlmx sHTG(PcmXygzzjlmx et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzjlmx sHBTG(PcmXygzzjlmx et) {
        return super.sHBTG(et);
    }
}


