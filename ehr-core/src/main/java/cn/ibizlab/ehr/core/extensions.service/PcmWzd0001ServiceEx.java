package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pcm.service.impl.PcmWzd0001ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pcm.domain.PcmWzd0001;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[向导实体1] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PcmWzd0001ServiceEx")
public class PcmWzd0001ServiceEx extends PcmWzd0001ServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[UpdatePeopleNum]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PcmWzd0001 updatePeopleNum(PcmWzd0001 et) {
        return super.updatePeopleNum(et);
    }
}


