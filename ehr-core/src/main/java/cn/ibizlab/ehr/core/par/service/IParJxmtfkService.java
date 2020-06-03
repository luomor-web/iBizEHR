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

import cn.ibizlab.ehr.core.par.domain.ParJxmtfk;
import cn.ibizlab.ehr.core.par.filter.ParJxmtfkSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxmtfk] 服务对象接口
 */
public interface IParJxmtfkService extends IService<ParJxmtfk>{

    boolean create(ParJxmtfk et) ;
    void createBatch(List<ParJxmtfk> list) ;
    boolean update(ParJxmtfk et) ;
    void updateBatch(List<ParJxmtfk> list) ;
    ParJxmtfk getDraft(ParJxmtfk et) ;
    ParJxmtfk get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(ParJxmtfk et) ;
    boolean save(ParJxmtfk et) ;
    void saveBatch(List<ParJxmtfk> list) ;
    Page<ParJxmtfk> searchDefault(ParJxmtfkSearchContext context) ;
    List<ParJxmtfk> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<ParJxmtfk> getParjxmtfkByIds(List<String> ids) ;
    List<ParJxmtfk> getParjxmtfkByEntities(List<ParJxmtfk> entities) ;

}


