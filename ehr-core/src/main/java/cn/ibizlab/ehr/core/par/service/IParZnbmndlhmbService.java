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

import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParZnbmndlhmb] 服务对象接口
 */
public interface IParZnbmndlhmbService extends IService<ParZnbmndlhmb>{

    boolean checkKey(ParZnbmndlhmb et) ;
    boolean save(ParZnbmndlhmb et) ;
    void saveBatch(List<ParZnbmndlhmb> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ParZnbmndlhmb et) ;
    void updateBatch(List<ParZnbmndlhmb> list) ;
    ParZnbmndlhmb getDraft(ParZnbmndlhmb et) ;
    ParZnbmndlhmb get(String key) ;
    boolean create(ParZnbmndlhmb et) ;
    void createBatch(List<ParZnbmndlhmb> list) ;
    Page<ParZnbmndlhmb> searchDefault(ParZnbmndlhmbSearchContext context) ;
    List<ParZnbmndlhmb> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<ParZnbmndlhmb> getParznbmndlhmbByIds(List<String> ids) ;
    List<ParZnbmndlhmb> getParznbmndlhmbByEntities(List<ParZnbmndlhmb> entities) ;

}


