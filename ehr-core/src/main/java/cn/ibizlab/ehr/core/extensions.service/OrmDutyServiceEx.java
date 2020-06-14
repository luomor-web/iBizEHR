package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmDutyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmDuty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[职务管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmDutyServiceEx")
public class OrmDutyServiceEx extends OrmDutyServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SynOrderNum]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmDuty synOrderNum(OrmDuty et) {
        return super.synOrderNum(et);
    }
}


