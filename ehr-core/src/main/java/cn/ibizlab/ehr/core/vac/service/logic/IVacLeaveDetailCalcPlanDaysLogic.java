package cn.ibizlab.ehr.core.vac.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;

/**
 * 关系型数据实体[CalcPlanDays] 对象
 */
public interface IVacLeaveDetailCalcPlanDaysLogic {

    void execute(VacLeaveDetail vacleavedetail ) ;

}
