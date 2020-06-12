package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimContractServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimContract;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[合同信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimContractServiceEx")
public class PimContractServiceEx extends PimContractServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[CalContractTime]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimContract calContractTime(PimContract et) {
        return super.calContractTime(et);
    }
    /**
     * 自定义行为[StopContract]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimContract stopContract(PimContract et) {
        return super.stopContract(et);
    }
}


