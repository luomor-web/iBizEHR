package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmYdbxmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[异动病休明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmYdbxmxServiceEx")
public class PcmYdbxmxServiceEx extends PcmYdbxmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[FinishBX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmYdbxmx finishBX(PcmYdbxmx et) {
        return super.finishBX(et);
    }
}


