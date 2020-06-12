package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmJxsygzzsqmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsqmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[见习生员工转正申请明细（停用）] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmJxsygzzsqmxServiceEx")
public class PcmJxsygzzsqmxServiceEx extends PcmJxsygzzsqmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ZZAction]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmJxsygzzsqmx zZAction(PcmJxsygzzsqmx et) {
        return super.zZAction(et);
    }
}


