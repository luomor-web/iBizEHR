package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmXmxqjhServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[项目需求计划] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmXmxqjhServiceEx")
public class OrmXmxqjhServiceEx extends OrmXmxqjhServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[TJ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmxqjh tJ(OrmXmxqjh et) {
        return super.tJ(et);
    }
    /**
     * 自定义行为[CLWC]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmxqjh cLWC(OrmXmxqjh et) {
        return super.cLWC(et);
    }
    /**
     * 自定义行为[SHBTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmxqjh sHBTG(OrmXmxqjh et) {
        return super.sHBTG(et);
    }
    /**
     * 自定义行为[Ensure]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmxqjh ensure(OrmXmxqjh et) {
        return super.ensure(et);
    }
}


