package cn.ibizlab.ehr.core.soc.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.soc.domain.SocRule;

/**
 * 关系型数据实体[InitRuleDetail] 对象
 */
public interface ISocRuleInitRuleDetailLogic {

    void execute(SocRule socrule ) ;

}
