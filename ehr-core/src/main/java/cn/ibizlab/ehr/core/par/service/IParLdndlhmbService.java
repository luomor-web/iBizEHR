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

import cn.ibizlab.ehr.core.par.domain.ParLdndlhmb;
import cn.ibizlab.ehr.core.par.filter.ParLdndlhmbSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParLdndlhmb] 服务对象接口
 */
public interface IParLdndlhmbService extends IService<ParLdndlhmb>{

    boolean save(ParLdndlhmb et) ;
    void saveBatch(List<ParLdndlhmb> list) ;
    ParLdndlhmb getDraft(ParLdndlhmb et) ;
    boolean checkKey(ParLdndlhmb et) ;
    ParLdndlhmb get(String key) ;
    boolean create(ParLdndlhmb et) ;
    void createBatch(List<ParLdndlhmb> list) ;
    boolean update(ParLdndlhmb et) ;
    void updateBatch(List<ParLdndlhmb> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<ParLdndlhmb> searchDefault(ParLdndlhmbSearchContext context) ;
    List<ParLdndlhmb> selectByPimpersonid(String pimpersonid) ;
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

    List<ParLdndlhmb> getParldndlhmbByIds(List<String> ids) ;
    List<ParLdndlhmb> getParldndlhmbByEntities(List<ParLdndlhmb> entities) ;

}


