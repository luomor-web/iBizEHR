package cn.ibizlab.ehr.core.trm.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;

/**
 * 关系型数据实体[SetApprovalStatus] 对象
 */
public interface ITrmTrainPlanSetApprovalStatusLogic {

    void execute(TrmTrainPlan trmtrainplan ) ;

}
