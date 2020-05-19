package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.BUDGET;
import cn.ibizlab.ehr.core.pim.filter.BUDGETSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[BUDGET] 服务对象接口
 */
public interface IBUDGETService extends IService<BUDGET>{

    boolean checkKey(BUDGET et) ;
    boolean save(BUDGET et) ;
    void saveBatch(List<BUDGET> list) ;
    boolean create(BUDGET et) ;
    void createBatch(List<BUDGET> list) ;
    BUDGET getDraft(BUDGET et) ;
    boolean update(BUDGET et) ;
    void updateBatch(List<BUDGET> list) ;
    BUDGET get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<BUDGET> searchDefault(BUDGETSearchContext context) ;
    List<BUDGET> selectByOrmorgid(String orgid) ;
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


