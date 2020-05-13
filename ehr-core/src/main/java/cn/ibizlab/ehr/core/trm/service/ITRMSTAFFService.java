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

import cn.ibizlab.ehr.core.trm.domain.TRMSTAFF;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAFFSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMSTAFF] 服务对象接口
 */
public interface ITRMSTAFFService extends IService<TRMSTAFF>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TRMSTAFF et) ;
    boolean update(TRMSTAFF et) ;
    void updateBatch(List<TRMSTAFF> list) ;
    boolean create(TRMSTAFF et) ;
    void createBatch(List<TRMSTAFF> list) ;
    TRMSTAFF getDraft(TRMSTAFF et) ;
    TRMSTAFF get(String key) ;
    boolean save(TRMSTAFF et) ;
    void saveBatch(List<TRMSTAFF> list) ;
    Page<TRMSTAFF> searchDefault(TRMSTAFFSearchContext context) ;
    List<TRMSTAFF> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMSTAFF> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMSTAFF> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
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


