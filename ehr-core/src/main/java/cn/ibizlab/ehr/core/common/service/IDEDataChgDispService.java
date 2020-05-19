package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.DEDataChgDisp;
import cn.ibizlab.ehr.core.common.filter.DEDataChgDispSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DEDataChgDisp] 服务对象接口
 */
public interface IDEDataChgDispService extends IService<DEDataChgDisp>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(DEDataChgDisp et) ;
    boolean update(DEDataChgDisp et) ;
    void updateBatch(List<DEDataChgDisp> list) ;
    boolean create(DEDataChgDisp et) ;
    void createBatch(List<DEDataChgDisp> list) ;
    boolean save(DEDataChgDisp et) ;
    void saveBatch(List<DEDataChgDisp> list) ;
    DEDataChgDisp get(String key) ;
    DEDataChgDisp getDraft(DEDataChgDisp et) ;
    Page<DEDataChgDisp> searchDefault(DEDataChgDispSearchContext context) ;
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


