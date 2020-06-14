package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmErporgServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmErporg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[ERP组织中间表] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmErporgServiceEx")
public class OrmErporgServiceEx extends OrmErporgServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SynOrg]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmErporg synOrg(OrmErporg et) {
        return super.synOrg(et);
    }
}


