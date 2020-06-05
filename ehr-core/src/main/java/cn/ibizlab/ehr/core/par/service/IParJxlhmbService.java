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

import cn.ibizlab.ehr.core.par.domain.ParJxlhmb;
import cn.ibizlab.ehr.core.par.filter.ParJxlhmbSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxlhmb] 服务对象接口
 */
public interface IParJxlhmbService extends IService<ParJxlhmb>{

    boolean save(ParJxlhmb et) ;
    void saveBatch(List<ParJxlhmb> list) ;
    ParJxlhmb getDraft(ParJxlhmb et) ;
    boolean checkKey(ParJxlhmb et) ;
    ParJxlhmb get(String key) ;
    boolean update(ParJxlhmb et) ;
    void updateBatch(List<ParJxlhmb> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParJxlhmb et) ;
    void createBatch(List<ParJxlhmb> list) ;
    Page<ParJxlhmb> searchDefault(ParJxlhmbSearchContext context) ;
    List<ParJxlhmb> selectByPimpersonid(String pimpersonid) ;
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

    List<ParJxlhmb> getParjxlhmbByIds(List<String> ids) ;
    List<ParJxlhmb> getParjxlhmbByEntities(List<ParJxlhmb> entities) ;

}


