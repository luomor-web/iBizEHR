package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmXmglServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmXmgl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[项目管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmXmglServiceEx")
public class OrmXmglServiceEx extends OrmXmglServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[Synchro]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmgl synchro(OrmXmgl et) {
        return super.synchro(et);
    }
}


