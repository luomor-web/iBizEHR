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

import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMAPPLICATION;
import cn.ibizlab.ehr.core.vac.filter.VACSYSTEMAPPLICATIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACSYSTEMAPPLICATION] 服务对象接口
 */
public interface IVACSYSTEMAPPLICATIONService extends IService<VACSYSTEMAPPLICATION>{

    boolean create(VACSYSTEMAPPLICATION et) ;
    void createBatch(List<VACSYSTEMAPPLICATION> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(VACSYSTEMAPPLICATION et) ;
    void updateBatch(List<VACSYSTEMAPPLICATION> list) ;
    VACSYSTEMAPPLICATION get(String key) ;
    boolean save(VACSYSTEMAPPLICATION et) ;
    void saveBatch(List<VACSYSTEMAPPLICATION> list) ;
    VACSYSTEMAPPLICATION getDraft(VACSYSTEMAPPLICATION et) ;
    boolean checkKey(VACSYSTEMAPPLICATION et) ;
    Page<VACSYSTEMAPPLICATION> searchDefault(VACSYSTEMAPPLICATIONSearchContext context) ;
    List<VACSYSTEMAPPLICATION> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<VACSYSTEMAPPLICATION> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<VACSYSTEMAPPLICATION> selectByVacleavesystemid(String vacleavesystemid) ;
    void removeByVacleavesystemid(String vacleavesystemid) ;
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


