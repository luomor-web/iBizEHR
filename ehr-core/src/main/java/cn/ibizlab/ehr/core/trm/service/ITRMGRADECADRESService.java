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

import cn.ibizlab.ehr.core.trm.domain.TRMGRADECADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMGRADECADRESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMGRADECADRES] 服务对象接口
 */
public interface ITRMGRADECADRESService extends IService<TRMGRADECADRES>{

    boolean update(TRMGRADECADRES et) ;
    void updateBatch(List<TRMGRADECADRES> list) ;
    boolean checkKey(TRMGRADECADRES et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(TRMGRADECADRES et) ;
    void createBatch(List<TRMGRADECADRES> list) ;
    TRMGRADECADRES getDraft(TRMGRADECADRES et) ;
    boolean save(TRMGRADECADRES et) ;
    void saveBatch(List<TRMGRADECADRES> list) ;
    TRMGRADECADRES get(String key) ;
    Page<TRMGRADECADRES> searchDefault(TRMGRADECADRESSearchContext context) ;
    List<TRMGRADECADRES> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<TRMGRADECADRES> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TRMGRADECADRES> selectByOrmorgsectorid2(String orgsectorid) ;
    void removeByOrmorgsectorid2(String orgsectorid) ;
    List<TRMGRADECADRES> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMGRADECADRES> selectByOrmorgid2(String orgid) ;
    void removeByOrmorgid2(String orgid) ;
    List<TRMGRADECADRES> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<TRMGRADECADRES> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMGRADECADRES> selectByPimpersonid2(String pimpersonid) ;
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


