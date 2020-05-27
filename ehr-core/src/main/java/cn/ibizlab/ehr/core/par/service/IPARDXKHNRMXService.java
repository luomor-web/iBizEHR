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

import cn.ibizlab.ehr.core.par.domain.PARDXKHNRMX;
import cn.ibizlab.ehr.core.par.filter.PARDXKHNRMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARDXKHNRMX] 服务对象接口
 */
public interface IPARDXKHNRMXService extends IService<PARDXKHNRMX>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARDXKHNRMX et) ;
    void saveBatch(List<PARDXKHNRMX> list) ;
    boolean checkKey(PARDXKHNRMX et) ;
    boolean create(PARDXKHNRMX et) ;
    void createBatch(List<PARDXKHNRMX> list) ;
    PARDXKHNRMX getDraft(PARDXKHNRMX et) ;
    boolean update(PARDXKHNRMX et) ;
    void updateBatch(List<PARDXKHNRMX> list) ;
    PARDXKHNRMX get(String key) ;
    Page<PARDXKHNRMX> searchDefault(PARDXKHNRMXSearchContext context) ;
    List<PARDXKHNRMX> selectByParkhzcmxid(String parkhzcmxid) ;
    void removeByParkhzcmxid(String parkhzcmxid) ;
    List<PARDXKHNRMX> selectByPimpersonid(String pimpersonid) ;
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

    List<PARDXKHNRMX> getPardxkhnrmxByIds(List<String> ids) ;
    List<PARDXKHNRMX> getPardxkhnrmxByEntities(List<PARDXKHNRMX> entities) ;

}


