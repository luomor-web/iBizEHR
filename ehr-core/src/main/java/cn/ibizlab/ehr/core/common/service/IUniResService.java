package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.UniRes;
import cn.ibizlab.ehr.core.common.filter.UniResSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[UniRes] 服务对象接口
 */
public interface IUniResService extends IService<UniRes>{

    boolean update(UniRes et) ;
    void updateBatch(List<UniRes> list) ;
    boolean checkKey(UniRes et) ;
    UniRes get(String key) ;
    boolean save(UniRes et) ;
    void saveBatch(List<UniRes> list) ;
    UniRes getDraft(UniRes et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(UniRes et) ;
    void createBatch(List<UniRes> list) ;
    Page<UniRes> searchDefault(UniResSearchContext context) ;
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


