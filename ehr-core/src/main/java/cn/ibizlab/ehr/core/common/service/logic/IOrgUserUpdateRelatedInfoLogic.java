package cn.ibizlab.ehr.core.common.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.common.domain.OrgUser;

/**
 * 关系型数据实体[UpdateRelatedInfo] 对象
 */
public interface IOrgUserUpdateRelatedInfoLogic {

    void execute(OrgUser orguser ) ;

}
