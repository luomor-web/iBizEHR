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

import cn.ibizlab.ehr.core.par.domain.ParNdlhmbkh;
import cn.ibizlab.ehr.core.par.filter.ParNdlhmbkhSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParNdlhmbkh] 服务对象接口
 */
public interface IParNdlhmbkhService extends IService<ParNdlhmbkh>{

    boolean update(ParNdlhmbkh et) ;
    void updateBatch(List<ParNdlhmbkh> list) ;
    ParNdlhmbkh getDraft(ParNdlhmbkh et) ;
    boolean checkKey(ParNdlhmbkh et) ;
    boolean create(ParNdlhmbkh et) ;
    void createBatch(List<ParNdlhmbkh> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParNdlhmbkh et) ;
    void saveBatch(List<ParNdlhmbkh> list) ;
    ParNdlhmbkh get(String key) ;
    Page<ParNdlhmbkh> searchDefault(ParNdlhmbkhSearchContext context) ;
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

    List<ParNdlhmbkh> getParndlhmbkhByIds(List<String> ids) ;
    List<ParNdlhmbkh> getParndlhmbkhByEntities(List<ParNdlhmbkh> entities) ;

}


