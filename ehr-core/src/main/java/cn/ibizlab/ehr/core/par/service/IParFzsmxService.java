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

import cn.ibizlab.ehr.core.par.domain.ParFzsmx;
import cn.ibizlab.ehr.core.par.filter.ParFzsmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParFzsmx] 服务对象接口
 */
public interface IParFzsmxService extends IService<ParFzsmx>{

    ParFzsmx getDraft(ParFzsmx et) ;
    boolean update(ParFzsmx et) ;
    void updateBatch(List<ParFzsmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ParFzsmx et) ;
    void createBatch(List<ParFzsmx> list) ;
    boolean checkKey(ParFzsmx et) ;
    boolean save(ParFzsmx et) ;
    void saveBatch(List<ParFzsmx> list) ;
    ParFzsmx get(String key) ;
    Page<ParFzsmx> searchDefault(ParFzsmxSearchContext context) ;
    List<ParFzsmx> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
    List<ParFzsmx> selectByPimpersonid(String pimpersonid) ;
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

    List<ParFzsmx> getParfzsmxByIds(List<String> ids) ;
    List<ParFzsmx> getParfzsmxByEntities(List<ParFzsmx> entities) ;

}


