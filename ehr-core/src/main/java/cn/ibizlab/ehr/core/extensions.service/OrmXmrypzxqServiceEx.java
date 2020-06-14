package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.orm.service.impl.OrmXmrypzxqServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[项目人员需求] 自定义服务对象
 */
@Slf4j
@Primary
@Service("OrmXmrypzxqServiceEx")
public class OrmXmrypzxqServiceEx extends OrmXmrypzxqServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[SynTJ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq synTJ(OrmXmrypzxq et) {
        return super.synTJ(et);
    }
    /**
     * 自定义行为[MODSPTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq mODSPTG(OrmXmrypzxq et) {
        return super.mODSPTG(et);
    }
    /**
     * 自定义行为[SFBH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq sFBH(OrmXmrypzxq et) {
        return super.sFBH(et);
    }
    /**
     * 自定义行为[Ensure]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq ensure(OrmXmrypzxq et) {
        return super.ensure(et);
    }
    /**
     * 自定义行为[SynDeployInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq synDeployInfo(OrmXmrypzxq et) {
        return super.synDeployInfo(et);
    }
    /**
     * 自定义行为[MODBH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq mODBH(OrmXmrypzxq et) {
        return super.mODBH(et);
    }
    /**
     * 自定义行为[SFQR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq sFQR(OrmXmrypzxq et) {
        return super.sFQR(et);
    }
    /**
     * 自定义行为[SynPersonInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq synPersonInfo(OrmXmrypzxq et) {
        return super.synPersonInfo(et);
    }
    /**
     * 自定义行为[SynRelease]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq synRelease(OrmXmrypzxq et) {
        return super.synRelease(et);
    }
    /**
     * 自定义行为[SHTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq sHTG(OrmXmrypzxq et) {
        return super.sHTG(et);
    }
    /**
     * 自定义行为[TPSPTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq tPSPTG(OrmXmrypzxq et) {
        return super.tPSPTG(et);
    }
    /**
     * 自定义行为[BH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq bH(OrmXmrypzxq et) {
        return super.bH(et);
    }
    /**
     * 自定义行为[SFSPTG]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq sFSPTG(OrmXmrypzxq et) {
        return super.sFSPTG(et);
    }
    /**
     * 自定义行为[TPBH]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq tPBH(OrmXmrypzxq et) {
        return super.tPBH(et);
    }
    /**
     * 自定义行为[TPQR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public OrmXmrypzxq tPQR(OrmXmrypzxq et) {
        return super.tPQR(et);
    }
}


