package cn.ibizlab.ehr.core.pcm.service.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;

/**
 * 关系型数据实体[Submit] 对象
 */
public interface IPcmProfileSubmitLogic {

    void execute(PcmProfile pcmprofile ) ;

}
