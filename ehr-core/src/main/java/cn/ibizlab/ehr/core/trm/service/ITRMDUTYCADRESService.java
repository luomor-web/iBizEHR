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

import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMDUTYCADRESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMDUTYCADRES] 服务对象接口
 */
public interface ITRMDUTYCADRESService extends IService<TRMDUTYCADRES>{

    boolean save(TRMDUTYCADRES et) ;
    void saveBatch(List<TRMDUTYCADRES> list) ;
    TRMDUTYCADRES setNQGBXX(TRMDUTYCADRES et) ;
    TRMDUTYCADRES sX(TRMDUTYCADRES et) ;
    boolean create(TRMDUTYCADRES et) ;
    void createBatch(List<TRMDUTYCADRES> list) ;
    TRMDUTYCADRES getDraft(TRMDUTYCADRES et) ;
    boolean checkKey(TRMDUTYCADRES et) ;
    TRMDUTYCADRES xX(TRMDUTYCADRES et) ;
    TRMDUTYCADRES get(String key) ;
    boolean update(TRMDUTYCADRES et) ;
    void updateBatch(List<TRMDUTYCADRES> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TRMDUTYCADRES> searchCurCXFW(TRMDUTYCADRESSearchContext context) ;
    Page<TRMDUTYCADRES> searchDefault(TRMDUTYCADRESSearchContext context) ;
    List<TRMDUTYCADRES> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<TRMDUTYCADRES> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<TRMDUTYCADRES> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TRMDUTYCADRES> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMDUTYCADRES> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<TRMDUTYCADRES> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<TRMDUTYCADRES> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMDUTYCADRES> selectByPimpersonid2(String pimpersonid) ;
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


