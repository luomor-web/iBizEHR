package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimArchivesChangeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[档案归档地变更记录] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimArchivesChangeServiceEx")
public class PimArchivesChangeServiceEx extends PimArchivesChangeServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[UpdatePersonFile]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimArchivesChange updatePersonFile(PimArchivesChange et) {
        return super.updatePersonFile(et);
    }
}


