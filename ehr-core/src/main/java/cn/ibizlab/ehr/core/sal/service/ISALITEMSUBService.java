package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SALITEMSUB;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSUBSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALITEMSUB] 服务对象接口
 */
public interface ISALITEMSUBService extends IService<SALITEMSUB>{

    SALITEMSUB get(String key) ;
    boolean update(SALITEMSUB et) ;
    void updateBatch(List<SALITEMSUB> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SALITEMSUB et) ;
    boolean save(SALITEMSUB et) ;
    void saveBatch(List<SALITEMSUB> list) ;
    SALITEMSUB getDraft(SALITEMSUB et) ;
    boolean create(SALITEMSUB et) ;
    void createBatch(List<SALITEMSUB> list) ;
    Page<SALITEMSUB> searchDefault(SALITEMSUBSearchContext context) ;
    List<SALITEMSUB> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SALITEMSUB> selectBySalitemid(String salitemid) ;
    void removeBySalitemid(String salitemid) ;
    List<SALITEMSUB> selectBySalsubjectid(String salsubjectid) ;
    void removeBySalsubjectid(String salsubjectid) ;
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


