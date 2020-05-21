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

import cn.ibizlab.ehr.core.common.domain.DEDataChg;
import cn.ibizlab.ehr.core.common.filter.DEDataChgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DEDataChg] 服务对象接口
 */
public interface IDEDataChgService extends IService<DEDataChg>{

    boolean update(DEDataChg et) ;
    void updateBatch(List<DEDataChg> list) ;
    boolean save(DEDataChg et) ;
    void saveBatch(List<DEDataChg> list) ;
    DEDataChg get(String key) ;
    boolean checkKey(DEDataChg et) ;
    DEDataChg getDraft(DEDataChg et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(DEDataChg et) ;
    void createBatch(List<DEDataChg> list) ;
    Page<DEDataChg> searchDefault(DEDataChgSearchContext context) ;
    List<DEDataChg> selectByDeid(String deid) ;
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


