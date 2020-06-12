package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.att.service.impl.AttEndanceMreportServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[考勤月报] 自定义服务对象
 */
@Slf4j
@Primary
@Service("AttEndanceMreportServiceEx")
public class AttEndanceMreportServiceEx extends AttEndanceMreportServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[GetAttendencemanOfKQSZ]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreport getAttendencemanOfKQSZ(AttEndanceMreport et) {
        return super.getAttendencemanOfKQSZ(et);
    }
    /**
     * 自定义行为[ExportKQYB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreport exportKQYB(AttEndanceMreport et) {
        return super.exportKQYB(et);
    }
    /**
     * 自定义行为[SCKQYB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreport sCKQYB(AttEndanceMreport et) {
        return super.sCKQYB(et);
    }
    /**
     * 自定义行为[QR]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreport qR(AttEndanceMreport et) {
        return super.qR(et);
    }
    /**
     * 自定义行为[PrintKQYB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public AttEndanceMreport printKQYB(AttEndanceMreport et) {
        return super.printKQYB(et);
    }
}


