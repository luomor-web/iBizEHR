package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimArchiveSloanandreturnServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[档案借阅及归还记录] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimArchiveSloanandreturnServiceEx")
public class PimArchiveSloanandreturnServiceEx extends PimArchiveSloanandreturnServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[UpdateArchiveState]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimArchiveSloanandreturn updateArchiveState(PimArchiveSloanandreturn et) {
        return super.updateArchiveState(et);
    }
}


