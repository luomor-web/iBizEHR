package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParKhzcmx;
import cn.ibizlab.ehr.core.par.filter.ParKhzcmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParKhzcmx] 服务对象接口
 */
public interface IParKhzcmxService extends IService<ParKhzcmx>{

    boolean create(ParKhzcmx et) ;
    void createBatch(List<ParKhzcmx> list) ;
    boolean save(ParKhzcmx et) ;
    void saveBatch(List<ParKhzcmx> list) ;
    ParKhzcmx get(String key) ;
    ParKhzcmx getDraft(ParKhzcmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParKhzcmx et) ;
    boolean update(ParKhzcmx et) ;
    void updateBatch(List<ParKhzcmx> list) ;
    Page<ParKhzcmx> searchDefault(ParKhzcmxSearchContext context) ;
    List<ParKhzcmx> selectByParassesstemplateid(String parassesstemplateid) ;
    void removeByParassesstemplateid(String parassesstemplateid) ;
    List<ParKhzcmx> selectByParjxkhjcszid(String parjxkhjcszid) ;
    void removeByParjxkhjcszid(String parjxkhjcszid) ;
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

    List<ParKhzcmx> getParkhzcmxByIds(List<String> ids) ;
    List<ParKhzcmx> getParkhzcmxByEntities(List<ParKhzcmx> entities) ;

}


