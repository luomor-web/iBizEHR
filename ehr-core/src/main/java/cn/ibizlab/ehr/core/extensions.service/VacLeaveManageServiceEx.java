package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacLeaveManageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[请假管理] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacLeaveManageServiceEx")
public class VacLeaveManageServiceEx extends VacLeaveManageServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[UpdateQJMX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveManage updateQJMX(VacLeaveManage et) {
        return super.updateQJMX(et);
    }
    /**
     * 自定义行为[CB]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveManage cB(VacLeaveManage et) {
        return super.cB(et);
    }
    /**
     * 自定义行为[CX]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveManage cX(VacLeaveManage et) {
        return super.cX(et);
    }
    /**
     * 自定义行为[GetFJSJofPerson]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveManage getFJSJofPerson(VacLeaveManage et) {
        return super.getFJSJofPerson(et);
    }
    /**
     * 自定义行为[MobStart]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveManage mobStart(VacLeaveManage et) {
        return super.mobStart(et);
    }
}


