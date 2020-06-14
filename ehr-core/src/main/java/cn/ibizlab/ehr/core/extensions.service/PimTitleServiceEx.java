package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimTitleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimTitle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[职称信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimTitleServiceEx")
public class PimTitleServiceEx extends PimTitleServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[EnsureHighestTech]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimTitle ensureHighestTech(PimTitle et) {
        return super.ensureHighestTech(et);
    }
}


