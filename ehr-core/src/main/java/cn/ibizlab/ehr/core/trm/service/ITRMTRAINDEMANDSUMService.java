package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMANDSUM;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDEMANDSUMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINDEMANDSUM] 服务对象接口
 */
public interface ITRMTRAINDEMANDSUMService extends IService<TRMTRAINDEMANDSUM>{

    boolean save(TRMTRAINDEMANDSUM et) ;
    void saveBatch(List<TRMTRAINDEMANDSUM> list) ;
    TRMTRAINDEMANDSUM get(String key) ;
    boolean create(TRMTRAINDEMANDSUM et) ;
    void createBatch(List<TRMTRAINDEMANDSUM> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINDEMANDSUM getDraft(TRMTRAINDEMANDSUM et) ;
    boolean update(TRMTRAINDEMANDSUM et) ;
    void updateBatch(List<TRMTRAINDEMANDSUM> list) ;
    boolean checkKey(TRMTRAINDEMANDSUM et) ;
    Page<TRMTRAINDEMANDSUM> searchDefault(TRMTRAINDEMANDSUMSearchContext context) ;
    List<TRMTRAINDEMANDSUM> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINDEMANDSUM> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TRMTRAINDEMANDSUM> selectByTrmtraindemandid(String trmtraindemandid) ;
    void removeByTrmtraindemandid(String trmtraindemandid) ;
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


