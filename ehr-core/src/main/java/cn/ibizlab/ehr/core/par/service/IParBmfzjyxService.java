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

import cn.ibizlab.ehr.core.par.domain.ParBmfzjyx;
import cn.ibizlab.ehr.core.par.filter.ParBmfzjyxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParBmfzjyx] 服务对象接口
 */
public interface IParBmfzjyxService extends IService<ParBmfzjyx>{

    boolean save(ParBmfzjyx et) ;
    void saveBatch(List<ParBmfzjyx> list) ;
    ParBmfzjyx getDraft(ParBmfzjyx et) ;
    boolean create(ParBmfzjyx et) ;
    void createBatch(List<ParBmfzjyx> list) ;
    boolean checkKey(ParBmfzjyx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ParBmfzjyx et) ;
    void updateBatch(List<ParBmfzjyx> list) ;
    ParBmfzjyx get(String key) ;
    Page<ParBmfzjyx> searchDefault(ParBmfzjyxSearchContext context) ;
    List<ParBmfzjyx> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
    List<ParBmfzjyx> selectByPimpersonid(String pimpersonid) ;
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

    List<ParBmfzjyx> getParbmfzjyxByIds(List<String> ids) ;
    List<ParBmfzjyx> getParbmfzjyxByEntities(List<ParBmfzjyx> entities) ;

}


