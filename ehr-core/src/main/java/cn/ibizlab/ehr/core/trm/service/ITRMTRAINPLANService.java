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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLAN;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINPLANSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINPLAN] 服务对象接口
 */
public interface ITRMTRAINPLANService extends IService<TRMTRAINPLAN>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(TRMTRAINPLAN et) ;
    void saveBatch(List<TRMTRAINPLAN> list) ;
    TRMTRAINPLAN getDraft(TRMTRAINPLAN et) ;
    boolean checkKey(TRMTRAINPLAN et) ;
    TRMTRAINPLAN get(String key) ;
    boolean create(TRMTRAINPLAN et) ;
    void createBatch(List<TRMTRAINPLAN> list) ;
    boolean update(TRMTRAINPLAN et) ;
    void updateBatch(List<TRMTRAINPLAN> list) ;
    Page<TRMTRAINPLAN> searchDefault(TRMTRAINPLANSearchContext context) ;
    List<TRMTRAINPLAN> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMTRAINPLAN> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMTRAINPLAN> selectByTrmdemdeftionid(String trmdemdeftionid) ;
    void removeByTrmdemdeftionid(String trmdemdeftionid) ;
    List<TRMTRAINPLAN> selectByTrmplanformuid(String trmplanformuid) ;
    void removeByTrmplanformuid(String trmplanformuid) ;
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


