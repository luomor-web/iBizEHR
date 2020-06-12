package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmDdsqdServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[调动申请单] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmDdsqdServiceEx")
public class PcmDdsqdServiceEx extends PcmDdsqdServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[PDD]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmDdsqd pDD(PcmDdsqd et) {
        return super.pDD(et);
    }
}


