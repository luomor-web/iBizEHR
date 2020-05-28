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

import cn.ibizlab.ehr.core.par.domain.PARJXKHXHZ;
import cn.ibizlab.ehr.core.par.filter.PARJXKHXHZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXKHXHZ] 服务对象接口
 */
public interface IPARJXKHXHZService extends IService<PARJXKHXHZ>{

    PARJXKHXHZ getDraft(PARJXKHXHZ et) ;
    boolean update(PARJXKHXHZ et) ;
    void updateBatch(List<PARJXKHXHZ> list) ;
    boolean checkKey(PARJXKHXHZ et) ;
    PARJXKHXHZ get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PARJXKHXHZ et) ;
    void createBatch(List<PARJXKHXHZ> list) ;
    boolean save(PARJXKHXHZ et) ;
    void saveBatch(List<PARJXKHXHZ> list) ;
    Page<PARJXKHXHZ> searchDefault(PARJXKHXHZSearchContext context) ;
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

    List<PARJXKHXHZ> getParjxkhxhzByIds(List<String> ids) ;
    List<PARJXKHXHZ> getParjxkhxhzByEntities(List<PARJXKHXHZ> entities) ;

}


