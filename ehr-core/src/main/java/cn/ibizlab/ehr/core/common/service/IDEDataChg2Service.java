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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.common.domain.DEDataChg2;
import cn.ibizlab.ehr.core.common.filter.DEDataChg2SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DEDataChg2] 服务对象接口
 */
public interface IDEDataChg2Service extends IService<DEDataChg2>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    DEDataChg2 get(String key) ;
    boolean update(DEDataChg2 et) ;
    void updateBatch(List<DEDataChg2> list) ;
    DEDataChg2 getDraft(DEDataChg2 et) ;
    boolean create(DEDataChg2 et) ;
    void createBatch(List<DEDataChg2> list) ;
    boolean checkKey(DEDataChg2 et) ;
    boolean save(DEDataChg2 et) ;
    void saveBatch(List<DEDataChg2> list) ;
    Page<DEDataChg2> searchDefault(DEDataChg2SearchContext context) ;
    List<DEDataChg2> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
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


