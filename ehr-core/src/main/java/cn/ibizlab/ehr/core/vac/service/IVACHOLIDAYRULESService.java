package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES;
import cn.ibizlab.ehr.core.vac.filter.VACHOLIDAYRULESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACHOLIDAYRULES] 服务对象接口
 */
public interface IVACHOLIDAYRULESService extends IService<VACHOLIDAYRULES>{

    VACHOLIDAYRULES copyKQGZData(VACHOLIDAYRULES et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VACHOLIDAYRULES et) ;
    boolean create(VACHOLIDAYRULES et) ;
    void createBatch(List<VACHOLIDAYRULES> list) ;
    VACHOLIDAYRULES getDraft(VACHOLIDAYRULES et) ;
    boolean update(VACHOLIDAYRULES et) ;
    void updateBatch(List<VACHOLIDAYRULES> list) ;
    VACHOLIDAYRULES get(String key) ;
    boolean save(VACHOLIDAYRULES et) ;
    void saveBatch(List<VACHOLIDAYRULES> list) ;
    Page<VACHOLIDAYRULES> searchDefault(VACHOLIDAYRULESSearchContext context) ;
    Page<VACHOLIDAYRULES> searchCurOrmorg(VACHOLIDAYRULESSearchContext context) ;
    List<VACHOLIDAYRULES> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


