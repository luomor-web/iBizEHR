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

import cn.ibizlab.ehr.core.par.domain.ParDxkhnrmx;
import cn.ibizlab.ehr.core.par.filter.ParDxkhnrmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParDxkhnrmx] 服务对象接口
 */
public interface IParDxkhnrmxService extends IService<ParDxkhnrmx>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ParDxkhnrmx et) ;
    void saveBatch(List<ParDxkhnrmx> list) ;
    boolean checkKey(ParDxkhnrmx et) ;
    boolean create(ParDxkhnrmx et) ;
    void createBatch(List<ParDxkhnrmx> list) ;
    ParDxkhnrmx getDraft(ParDxkhnrmx et) ;
    boolean update(ParDxkhnrmx et) ;
    void updateBatch(List<ParDxkhnrmx> list) ;
    ParDxkhnrmx get(String key) ;
    Page<ParDxkhnrmx> searchDefault(ParDxkhnrmxSearchContext context) ;
    List<ParDxkhnrmx> selectByParkhzcmxid(String parkhzcmxid) ;
    void removeByParkhzcmxid(String parkhzcmxid) ;
    List<ParDxkhnrmx> selectByPimpersonid(String pimpersonid) ;
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

    List<ParDxkhnrmx> getPardxkhnrmxByIds(List<String> ids) ;
    List<ParDxkhnrmx> getPardxkhnrmxByEntities(List<ParDxkhnrmx> entities) ;

}


