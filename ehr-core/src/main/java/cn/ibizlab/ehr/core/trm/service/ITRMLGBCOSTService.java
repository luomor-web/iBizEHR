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

import cn.ibizlab.ehr.core.trm.domain.TRMLGBCOST;
import cn.ibizlab.ehr.core.trm.filter.TRMLGBCOSTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMLGBCOST] 服务对象接口
 */
public interface ITRMLGBCOSTService extends IService<TRMLGBCOST>{

    TRMLGBCOST get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMLGBCOST getDraft(TRMLGBCOST et) ;
    boolean checkKey(TRMLGBCOST et) ;
    boolean update(TRMLGBCOST et) ;
    void updateBatch(List<TRMLGBCOST> list) ;
    boolean create(TRMLGBCOST et) ;
    void createBatch(List<TRMLGBCOST> list) ;
    boolean save(TRMLGBCOST et) ;
    void saveBatch(List<TRMLGBCOST> list) ;
    Page<TRMLGBCOST> searchDefault(TRMLGBCOSTSearchContext context) ;
    List<TRMLGBCOST> selectByOrmorgid(String orgid) ;
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


