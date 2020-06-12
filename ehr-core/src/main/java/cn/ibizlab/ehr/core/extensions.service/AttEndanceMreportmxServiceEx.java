package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.att.service.impl.AttEndanceMreportmxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤月报明细] 自定义服务对象
 */
@Slf4j
@Primary
@Service("AttEndanceMreportmxServiceEx")
public class AttEndanceMreportmxServiceEx extends AttEndanceMreportmxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[Export2Excel]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreportmx export2Excel(AttEndanceMreportmx et) {
        return super.export2Excel(et);
    }
}


