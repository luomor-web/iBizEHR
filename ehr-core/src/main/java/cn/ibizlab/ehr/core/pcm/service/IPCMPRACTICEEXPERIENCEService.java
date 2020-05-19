package cn.ibizlab.ehr.core.pcm.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alibaba.fastjson.JSONObject;

import cn.ibizlab.ehr.core.pcm.domain.PCMPRACTICEEXPERIENCE;
import cn.ibizlab.ehr.core.pcm.filter.PCMPRACTICEEXPERIENCESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMPRACTICEEXPERIENCE] 服务对象接口
 */
public interface IPCMPRACTICEEXPERIENCEService extends IService<PCMPRACTICEEXPERIENCE>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PCMPRACTICEEXPERIENCE et) ;
    void createBatch(List<PCMPRACTICEEXPERIENCE> list) ;
    boolean update(PCMPRACTICEEXPERIENCE et) ;
    void updateBatch(List<PCMPRACTICEEXPERIENCE> list) ;
    PCMPRACTICEEXPERIENCE getDraft(PCMPRACTICEEXPERIENCE et) ;
    PCMPRACTICEEXPERIENCE get(String key) ;
    boolean checkKey(PCMPRACTICEEXPERIENCE et) ;
    boolean save(PCMPRACTICEEXPERIENCE et) ;
    void saveBatch(List<PCMPRACTICEEXPERIENCE> list) ;
    Page<PCMPRACTICEEXPERIENCE> searchDefault(PCMPRACTICEEXPERIENCESearchContext context) ;
    List<PCMPRACTICEEXPERIENCE> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

}


