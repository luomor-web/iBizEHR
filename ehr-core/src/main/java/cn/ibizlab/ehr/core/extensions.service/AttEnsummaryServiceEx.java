package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.att.service.impl.AttEnsummaryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.att.domain.AttEnsummary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤汇总] 自定义服务对象
 */
@Slf4j
@Primary
@Service("AttEnsummaryServiceEx")
public class AttEnsummaryServiceEx extends AttEnsummaryServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ExportKQHZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEnsummary exportKQHZ(AttEnsummary et) {
        return super.exportKQHZ(et);
    }
}


