package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.att.service.impl.AttEndanceRecordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.att.domain.AttEndanceRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤记录] 自定义服务对象
 */
@Slf4j
@Primary
@Service("AttEndanceRecordServiceEx")
public class AttEndanceRecordServiceEx extends AttEndanceRecordServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[ReflushPersonInfo]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceRecord reflushPersonInfo(AttEndanceRecord et) {
        return super.reflushPersonInfo(et);
    }
}


