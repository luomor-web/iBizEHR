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

import cn.ibizlab.ehr.core.par.domain.ParJxkhxhz;
import cn.ibizlab.ehr.core.par.filter.ParJxkhxhzSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxkhxhz] 服务对象接口
 */
public interface IParJxkhxhzService extends IService<ParJxkhxhz>{

    ParJxkhxhz getDraft(ParJxkhxhz et) ;
    boolean update(ParJxkhxhz et) ;
    void updateBatch(List<ParJxkhxhz> list) ;
    boolean checkKey(ParJxkhxhz et) ;
    ParJxkhxhz get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParJxkhxhz et) ;
    void createBatch(List<ParJxkhxhz> list) ;
    boolean save(ParJxkhxhz et) ;
    void saveBatch(List<ParJxkhxhz> list) ;
    Page<ParJxkhxhz> searchDefault(ParJxkhxhzSearchContext context) ;
    List<ParJxkhxhz> selectByParassesstemplateid(String parassesstemplateid) ;
    void removeByParassesstemplateid(String parassesstemplateid) ;
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

    List<ParJxkhxhz> getParjxkhxhzByIds(List<String> ids) ;
    List<ParJxkhxhz> getParjxkhxhzByEntities(List<ParJxkhxhz> entities) ;

}


