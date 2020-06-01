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

import cn.ibizlab.ehr.core.par.domain.ParJxndkhjg;
import cn.ibizlab.ehr.core.par.filter.ParJxndkhjgSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParJxndkhjg] 服务对象接口
 */
public interface IParJxndkhjgService extends IService<ParJxndkhjg>{

    boolean save(ParJxndkhjg et) ;
    void saveBatch(List<ParJxndkhjg> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParJxndkhjg getDraft(ParJxndkhjg et) ;
    boolean create(ParJxndkhjg et) ;
    void createBatch(List<ParJxndkhjg> list) ;
    boolean update(ParJxndkhjg et) ;
    void updateBatch(List<ParJxndkhjg> list) ;
    ParJxndkhjg get(String key) ;
    boolean checkKey(ParJxndkhjg et) ;
    Page<ParJxndkhjg> searchDefault(ParJxndkhjgSearchContext context) ;
    Page<ParJxndkhjg> searchLastTwoYear(ParJxndkhjgSearchContext context) ;
    List<ParJxndkhjg> selectByPimpersonid(String pimpersonid) ;
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

    List<ParJxndkhjg> getParjxndkhjgByIds(List<String> ids) ;
    List<ParJxndkhjg> getParjxndkhjgByEntities(List<ParJxndkhjg> entities) ;

}


