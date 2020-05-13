package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SOCCOMPANYWEL;
import cn.ibizlab.ehr.core.soc.filter.SOCCOMPANYWELSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SOCCOMPANYWEL] 服务对象接口
 */
public interface ISOCCOMPANYWELService extends IService<SOCCOMPANYWEL>{

    boolean create(SOCCOMPANYWEL et) ;
    void createBatch(List<SOCCOMPANYWEL> list) ;
    boolean checkKey(SOCCOMPANYWEL et) ;
    boolean save(SOCCOMPANYWEL et) ;
    void saveBatch(List<SOCCOMPANYWEL> list) ;
    boolean update(SOCCOMPANYWEL et) ;
    void updateBatch(List<SOCCOMPANYWEL> list) ;
    SOCCOMPANYWEL get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SOCCOMPANYWEL getDraft(SOCCOMPANYWEL et) ;
    Page<SOCCOMPANYWEL> searchDefault(SOCCOMPANYWELSearchContext context) ;
    List<SOCCOMPANYWEL> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SOCCOMPANYWEL> selectBySocselfarebaseid(String socselfarebaseid) ;
    void removeBySocselfarebaseid(String socselfarebaseid) ;
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


