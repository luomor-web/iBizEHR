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

import cn.ibizlab.ehr.core.par.domain.ParYdgzjh;
import cn.ibizlab.ehr.core.par.filter.ParYdgzjhSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParYdgzjh] 服务对象接口
 */
public interface IParYdgzjhService extends IService<ParYdgzjh>{

    ParYdgzjh getDraft(ParYdgzjh et) ;
    boolean update(ParYdgzjh et) ;
    void updateBatch(List<ParYdgzjh> list) ;
    boolean checkKey(ParYdgzjh et) ;
    boolean save(ParYdgzjh et) ;
    void saveBatch(List<ParYdgzjh> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParYdgzjh get(String key) ;
    boolean create(ParYdgzjh et) ;
    void createBatch(List<ParYdgzjh> list) ;
    Page<ParYdgzjh> searchDefault(ParYdgzjhSearchContext context) ;
    List<ParYdgzjh> selectByOrmorgsectorid(String orgsectorid) ;
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

    List<ParYdgzjh> getParydgzjhByIds(List<String> ids) ;
    List<ParYdgzjh> getParydgzjhByEntities(List<ParYdgzjh> entities) ;

}


