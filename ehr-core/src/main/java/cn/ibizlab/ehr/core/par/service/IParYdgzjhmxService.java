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

import cn.ibizlab.ehr.core.par.domain.ParYdgzjhmx;
import cn.ibizlab.ehr.core.par.filter.ParYdgzjhmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParYdgzjhmx] 服务对象接口
 */
public interface IParYdgzjhmxService extends IService<ParYdgzjhmx>{

    boolean update(ParYdgzjhmx et) ;
    void updateBatch(List<ParYdgzjhmx> list) ;
    boolean save(ParYdgzjhmx et) ;
    void saveBatch(List<ParYdgzjhmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParYdgzjhmx get(String key) ;
    boolean checkKey(ParYdgzjhmx et) ;
    ParYdgzjhmx getDraft(ParYdgzjhmx et) ;
    boolean create(ParYdgzjhmx et) ;
    void createBatch(List<ParYdgzjhmx> list) ;
    Page<ParYdgzjhmx> searchDefault(ParYdgzjhmxSearchContext context) ;
    List<ParYdgzjhmx> selectByParydgzjhid(String parydgzjhid) ;
    void removeByParydgzjhid(String parydgzjhid) ;
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

    List<ParYdgzjhmx> getParydgzjhmxByIds(List<String> ids) ;
    List<ParYdgzjhmx> getParydgzjhmxByEntities(List<ParYdgzjhmx> entities) ;

}


