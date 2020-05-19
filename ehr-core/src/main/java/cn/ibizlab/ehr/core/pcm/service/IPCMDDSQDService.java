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

import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQD;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMDDSQD] 服务对象接口
 */
public interface IPCMDDSQDService extends IService<PCMDDSQD>{

    boolean create(PCMDDSQD et) ;
    void createBatch(List<PCMDDSQD> list) ;
    PCMDDSQD pDD(PCMDDSQD et) ;
    PCMDDSQD get(String key) ;
    boolean update(PCMDDSQD et) ;
    void updateBatch(List<PCMDDSQD> list) ;
    boolean checkKey(PCMDDSQD et) ;
    boolean save(PCMDDSQD et) ;
    void saveBatch(List<PCMDDSQD> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMDDSQD getDraft(PCMDDSQD et) ;
    Page<PCMDDSQD> searchDefault(PCMDDSQDSearchContext context) ;
    List<PCMDDSQD> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


