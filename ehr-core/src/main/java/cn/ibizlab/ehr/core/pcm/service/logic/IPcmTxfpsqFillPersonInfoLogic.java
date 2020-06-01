package cn.ibizlab.ehr.core.pcm.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;

/**
 * 关系型数据实体[FillPersonInfo] 对象
 */
public interface IPcmTxfpsqFillPersonInfoLogic {

    void execute(PcmTxfpsq pcmtxfpsq ) ;

}
