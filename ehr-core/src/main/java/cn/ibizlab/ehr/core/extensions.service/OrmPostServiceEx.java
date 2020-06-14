package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmPostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmPost;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[岗位] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmPostServiceEx")
public class OrmPostServiceEx extends OrmPostServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SetGwJb]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmPost setGwJb(OrmPost et) {
        return super.setGwJb(et);
    }
}


