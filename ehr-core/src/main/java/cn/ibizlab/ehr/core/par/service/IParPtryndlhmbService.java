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

import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmb;
import cn.ibizlab.ehr.core.par.filter.ParPtryndlhmbSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParPtryndlhmb] 服务对象接口
 */
public interface IParPtryndlhmbService extends IService<ParPtryndlhmb>{

    ParPtryndlhmb get(String key) ;
    boolean create(ParPtryndlhmb et) ;
    void createBatch(List<ParPtryndlhmb> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ParPtryndlhmb et) ;
    void updateBatch(List<ParPtryndlhmb> list) ;
    boolean save(ParPtryndlhmb et) ;
    void saveBatch(List<ParPtryndlhmb> list) ;
    ParPtryndlhmb getDraft(ParPtryndlhmb et) ;
    boolean checkKey(ParPtryndlhmb et) ;
    Page<ParPtryndlhmb> searchDefault(ParPtryndlhmbSearchContext context) ;
    List<ParPtryndlhmb> selectByPimpersonid(String pimpersonid) ;
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

    List<ParPtryndlhmb> getParptryndlhmbByIds(List<String> ids) ;
    List<ParPtryndlhmb> getParptryndlhmbByEntities(List<ParPtryndlhmb> entities) ;

}


