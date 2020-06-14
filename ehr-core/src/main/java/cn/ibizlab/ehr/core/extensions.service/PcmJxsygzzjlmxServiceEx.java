package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmJxsygzzjlmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[见习生员工转正记录引用明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmJxsygzzjlmxServiceEx")
public class PcmJxsygzzjlmxServiceEx extends PcmJxsygzzjlmxServiceImpl {

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
    public PcmJxsygzzjlmx sHBTG(PcmJxsygzzjlmx et) {
        return super.sHBTG(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmJxsygzzjlmx sHTG(PcmJxsygzzjlmx et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[ZZCZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmJxsygzzjlmx zZCZ(PcmJxsygzzjlmx et) {
        return super.zZCZ(et);
    }
}


