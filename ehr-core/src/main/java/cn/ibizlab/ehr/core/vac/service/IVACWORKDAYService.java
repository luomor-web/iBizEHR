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

import cn.ibizlab.ehr.core.vac.domain.VACWORKDAY;
import cn.ibizlab.ehr.core.vac.filter.VACWORKDAYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACWORKDAY] 服务对象接口
 */
public interface IVACWORKDAYService extends IService<VACWORKDAY>{

    boolean checkKey(VACWORKDAY et) ;
    boolean save(VACWORKDAY et) ;
    void saveBatch(List<VACWORKDAY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(VACWORKDAY et) ;
    void createBatch(List<VACWORKDAY> list) ;
    boolean update(VACWORKDAY et) ;
    void updateBatch(List<VACWORKDAY> list) ;
    VACWORKDAY get(String key) ;
    VACWORKDAY getDraft(VACWORKDAY et) ;
    Page<VACWORKDAY> searchDefault(VACWORKDAYSearchContext context) ;
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


