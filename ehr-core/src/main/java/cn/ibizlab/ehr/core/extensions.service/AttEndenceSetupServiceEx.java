package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.att.service.impl.AttEndenceSetupServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.att.domain.AttEndenceSetup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤设置] 自定义服务对象
 */
@Slf4j
@Primary
@Service("AttEndenceSetupServiceEx")
public class AttEndenceSetupServiceEx extends AttEndenceSetupServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ReflushUpdatedate]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndenceSetup reflushUpdatedate(AttEndenceSetup et) {
        return super.reflushUpdatedate(et);
    }
}


