package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimPersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[人员信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimPersonServiceEx")
public class PimPersonServiceEx extends PimPersonServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[YZSFYZFP]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson yZSFYZFP(PimPerson et) {
        return super.yZSFYZFP(et);
    }
    /**
     * 自定义行为[ToggleLeader]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson toggleLeader(PimPerson et) {
        return super.toggleLeader(et);
    }
    /**
     * 自定义行为[PersonUpdateInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson personUpdateInfo(PimPerson et) {
        return super.personUpdateInfo(et);
    }
    /**
     * 自定义行为[FillPersonType]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson fillPersonType(PimPerson et) {
        return super.fillPersonType(et);
    }
    /**
     * 自定义行为[SynPerson]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson synPerson(PimPerson et) {
        return super.synPerson(et);
    }
    /**
     * 自定义行为[QRTX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson qRTX(PimPerson et) {
        return super.qRTX(et);
    }
    /**
     * 自定义行为[GeneratePersonFile]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimPerson generatePersonFile(PimPerson et) {
        return super.generatePersonFile(et);
    }
}


