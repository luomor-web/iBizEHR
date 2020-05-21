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

import cn.ibizlab.ehr.core.par.domain.PARJGBMPJBZ;
import cn.ibizlab.ehr.core.par.filter.PARJGBMPJBZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJGBMPJBZ] 服务对象接口
 */
public interface IPARJGBMPJBZService extends IService<PARJGBMPJBZ>{

    boolean checkKey(PARJGBMPJBZ et) ;
    PARJGBMPJBZ get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PARJGBMPJBZ et) ;
    void createBatch(List<PARJGBMPJBZ> list) ;
    boolean update(PARJGBMPJBZ et) ;
    void updateBatch(List<PARJGBMPJBZ> list) ;
    boolean save(PARJGBMPJBZ et) ;
    void saveBatch(List<PARJGBMPJBZ> list) ;
    PARJGBMPJBZ getDraft(PARJGBMPJBZ et) ;
    Page<PARJGBMPJBZ> searchDefault(PARJGBMPJBZSearchContext context) ;
    List<PARJGBMPJBZ> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PARJGBMPJBZ> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PARJGBMPJBZ> selectByPjbzid(String parjgbmpjbzid) ;
    void removeByPjbzid(String parjgbmpjbzid) ;
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

}


