package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmUnitedPersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmUnitedPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[统一身份库] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmUnitedPersonServiceEx")
public class OrmUnitedPersonServiceEx extends OrmUnitedPersonServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[GetUnitedUser]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmUnitedPerson getUnitedUser(OrmUnitedPerson et) {
        return super.getUnitedUser(et);
    }
}


