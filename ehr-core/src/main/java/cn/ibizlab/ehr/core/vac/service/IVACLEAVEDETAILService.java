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

import cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEAVEDETAIL] 服务对象接口
 */
public interface IVACLEAVEDETAILService extends IService<VACLEAVEDETAIL>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VACLEAVEDETAIL calcSJQJTS(VACLEAVEDETAIL et) ;
    boolean create(VACLEAVEDETAIL et) ;
    void createBatch(List<VACLEAVEDETAIL> list) ;
    boolean update(VACLEAVEDETAIL et) ;
    void updateBatch(List<VACLEAVEDETAIL> list) ;
    VACLEAVEDETAIL getNianJia(VACLEAVEDETAIL et) ;
    boolean save(VACLEAVEDETAIL et) ;
    void saveBatch(List<VACLEAVEDETAIL> list) ;
    VACLEAVEDETAIL calcJHQJTS(VACLEAVEDETAIL et) ;
    VACLEAVEDETAIL get(String key) ;
    boolean checkKey(VACLEAVEDETAIL et) ;
    VACLEAVEDETAIL getDraft(VACLEAVEDETAIL et) ;
    Page<VACLEAVEDETAIL> searchDefault(VACLEAVEDETAILSearchContext context) ;
    List<VACLEAVEDETAIL> selectByVacleavemanageid(String vacleavemanageid) ;
    void removeByVacleavemanageid(String vacleavemanageid) ;
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


