package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.soc.service.impl.SocWelfareInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[个人社保福利] 自定义服务对象
 */
@Slf4j
@Primary
@Service("SocWelfareInfoServiceEx")
public class SocWelfareInfoServiceEx extends SocWelfareInfoServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[GetFJSJofPerson]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public SocWelfareInfo getFJSJofPerson(SocWelfareInfo et) {
        return super.getFJSJofPerson(et);
    }
    /**
     * 自定义行为[GetCBDofSOCCOMPANYWEL]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public SocWelfareInfo getCBDofSOCCOMPANYWEL(SocWelfareInfo et) {
        return super.getCBDofSOCCOMPANYWEL(et);
    }
}


