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

import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARZNBMNDLHMB] 服务对象接口
 */
public interface IPARZNBMNDLHMBService extends IService<PARZNBMNDLHMB>{

    boolean checkKey(PARZNBMNDLHMB et) ;
    boolean save(PARZNBMNDLHMB et) ;
    void saveBatch(List<PARZNBMNDLHMB> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PARZNBMNDLHMB et) ;
    void updateBatch(List<PARZNBMNDLHMB> list) ;
    PARZNBMNDLHMB getDraft(PARZNBMNDLHMB et) ;
    PARZNBMNDLHMB get(String key) ;
    boolean create(PARZNBMNDLHMB et) ;
    void createBatch(List<PARZNBMNDLHMB> list) ;
    Page<PARZNBMNDLHMB> searchDefault(PARZNBMNDLHMBSearchContext context) ;
    List<PARZNBMNDLHMB> selectByOrmorgsectorid(String orgsectorid) ;
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

    List<PARZNBMNDLHMB> getParznbmndlhmbByIds(List<String> ids) ;
    List<PARZNBMNDLHMB> getParznbmndlhmbByEntities(List<PARZNBMNDLHMB> entities) ;

}


