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

import cn.ibizlab.ehr.core.pcm.domain.PCMSCHOOLOFFICE;
import cn.ibizlab.ehr.core.pcm.filter.PCMSCHOOLOFFICESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMSCHOOLOFFICE] 服务对象接口
 */
public interface IPCMSCHOOLOFFICEService extends IService<PCMSCHOOLOFFICE>{

    PCMSCHOOLOFFICE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMSCHOOLOFFICE et) ;
    PCMSCHOOLOFFICE getDraft(PCMSCHOOLOFFICE et) ;
    boolean update(PCMSCHOOLOFFICE et) ;
    void updateBatch(List<PCMSCHOOLOFFICE> list) ;
    boolean save(PCMSCHOOLOFFICE et) ;
    void saveBatch(List<PCMSCHOOLOFFICE> list) ;
    boolean create(PCMSCHOOLOFFICE et) ;
    void createBatch(List<PCMSCHOOLOFFICE> list) ;
    Page<PCMSCHOOLOFFICE> searchDefault(PCMSCHOOLOFFICESearchContext context) ;
    List<PCMSCHOOLOFFICE> selectByPcmprofileid(String pcmprofileid) ;
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

