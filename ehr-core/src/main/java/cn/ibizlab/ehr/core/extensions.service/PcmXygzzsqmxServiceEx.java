package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmXygzzsqmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsqmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[试用期员工转正申请明细（停用）] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmXygzzsqmxServiceEx")
public class PcmXygzzsqmxServiceEx extends PcmXygzzsqmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzsqmx sHBTG(PcmXygzzsqmx et) {
        return super.sHBTG(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzsqmx sHTG(PcmXygzzsqmx et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[ZZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmXygzzsqmx zZCZ(PcmXygzzsqmx et) {
        return super.zZCZ(et);
    }
}


