package cn.ibizlab.ehr.core.att.service;

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

import cn.ibizlab.ehr.core.att.domain.AttEnmembwes;
import cn.ibizlab.ehr.core.att.filter.AttEnmembwesSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEnmembwes] 服务对象接口
 */
public interface IAttEnmembwesService extends IService<AttEnmembwes>{

    boolean checkKey(AttEnmembwes et) ;
    AttEnmembwes get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(AttEnmembwes et) ;
    void saveBatch(List<AttEnmembwes> list) ;
    AttEnmembwes getDraft(AttEnmembwes et) ;
    boolean update(AttEnmembwes et) ;
    void updateBatch(List<AttEnmembwes> list) ;
    boolean create(AttEnmembwes et) ;
    void createBatch(List<AttEnmembwes> list) ;
    Page<AttEnmembwes> searchDefault(AttEnmembwesSearchContext context) ;
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

    List<AttEnmembwes> getAttenmembwesByIds(List<String> ids) ;
    List<AttEnmembwes> getAttenmembwesByEntities(List<AttEnmembwes> entities) ;

}


