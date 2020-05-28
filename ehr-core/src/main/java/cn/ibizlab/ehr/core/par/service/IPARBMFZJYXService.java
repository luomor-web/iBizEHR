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

import cn.ibizlab.ehr.core.par.domain.PARBMFZJYX;
import cn.ibizlab.ehr.core.par.filter.PARBMFZJYXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARBMFZJYX] 服务对象接口
 */
public interface IPARBMFZJYXService extends IService<PARBMFZJYX>{

    boolean save(PARBMFZJYX et) ;
    void saveBatch(List<PARBMFZJYX> list) ;
    PARBMFZJYX getDraft(PARBMFZJYX et) ;
    boolean create(PARBMFZJYX et) ;
    void createBatch(List<PARBMFZJYX> list) ;
    boolean checkKey(PARBMFZJYX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PARBMFZJYX et) ;
    void updateBatch(List<PARBMFZJYX> list) ;
    PARBMFZJYX get(String key) ;
    Page<PARBMFZJYX> searchDefault(PARBMFZJYXSearchContext context) ;
    List<PARBMFZJYX> selectByPartzggid(String partzggid) ;
    void removeByPartzggid(String partzggid) ;
    List<PARBMFZJYX> selectByPimpersonid(String pimpersonid) ;
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

    List<PARBMFZJYX> getParbmfzjyxByIds(List<String> ids) ;
    List<PARBMFZJYX> getParbmfzjyxByEntities(List<PARBMFZJYX> entities) ;

}


