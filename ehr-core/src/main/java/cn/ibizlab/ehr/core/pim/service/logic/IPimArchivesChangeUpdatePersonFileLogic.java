package cn.ibizlab.ehr.core.pim.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;

/**
 * 关系型数据实体[UpdatePersonFile] 对象
 */
public interface IPimArchivesChangeUpdatePersonFileLogic {

    void execute(PimArchivesChange pimarchiveschange ) ;

}
