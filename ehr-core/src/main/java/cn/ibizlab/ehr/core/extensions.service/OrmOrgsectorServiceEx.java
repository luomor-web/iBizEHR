package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmOrgsectorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[部门管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmOrgsectorServiceEx")
public class OrmOrgsectorServiceEx extends OrmOrgsectorServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ChangeEdition]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector changeEdition(OrmOrgsector et) {
        return super.changeEdition(et);
    }
    /**
     * 自定义行为[SynOrgSectPro]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector synOrgSectPro(OrmOrgsector et) {
        return super.synOrgSectPro(et);
    }
    /**
     * 自定义行为[CLWC]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector cLWC(OrmOrgsector et) {
        return super.cLWC(et);
    }
    /**
     * 自定义行为[TJ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector tJ(OrmOrgsector et) {
        return super.tJ(et);
    }
    /**
     * 自定义行为[SynOrgSectOderNum]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector synOrgSectOderNum(OrmOrgsector et) {
        return super.synOrgSectOderNum(et);
    }
    /**
     * 自定义行为[SynOrgSec]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmOrgsector synOrgSec(OrmOrgsector et) {
        return super.synOrgSec(et);
    }
}


