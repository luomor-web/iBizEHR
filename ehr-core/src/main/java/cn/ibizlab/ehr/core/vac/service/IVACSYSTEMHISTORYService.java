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

import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMHISTORY;
import cn.ibizlab.ehr.core.vac.filter.VACSYSTEMHISTORYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACSYSTEMHISTORY] 服务对象接口
 */
public interface IVACSYSTEMHISTORYService extends IService<VACSYSTEMHISTORY>{

    boolean update(VACSYSTEMHISTORY et) ;
    void updateBatch(List<VACSYSTEMHISTORY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(VACSYSTEMHISTORY et) ;
    void saveBatch(List<VACSYSTEMHISTORY> list) ;
    VACSYSTEMHISTORY get(String key) ;
    boolean checkKey(VACSYSTEMHISTORY et) ;
    boolean create(VACSYSTEMHISTORY et) ;
    void createBatch(List<VACSYSTEMHISTORY> list) ;
    VACSYSTEMHISTORY getDraft(VACSYSTEMHISTORY et) ;
    Page<VACSYSTEMHISTORY> searchDefault(VACSYSTEMHISTORYSearchContext context) ;
    List<VACSYSTEMHISTORY> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<VACSYSTEMHISTORY> selectByVacleavesystemid(String vacleavesystemid) ;
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


