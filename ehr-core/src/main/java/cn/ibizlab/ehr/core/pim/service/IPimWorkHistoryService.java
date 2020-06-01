package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PimWorkHistory;
import cn.ibizlab.ehr.core.pim.filter.PimWorkHistorySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimWorkHistory] 服务对象接口
 */
public interface IPimWorkHistoryService extends IService<PimWorkHistory>{

    PimWorkHistory get(String key) ;
    boolean create(PimWorkHistory et) ;
    void createBatch(List<PimWorkHistory> list) ;
    boolean save(PimWorkHistory et) ;
    void saveBatch(List<PimWorkHistory> list) ;
    boolean update(PimWorkHistory et) ;
    void updateBatch(List<PimWorkHistory> list) ;
    boolean checkKey(PimWorkHistory et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimWorkHistory getDraft(PimWorkHistory et) ;
    Page<PimWorkHistory> searchDefault(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchIsMain(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchJLSSGLY(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchZIZHU(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchJLSS(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchFAZZSY(PimWorkHistorySearchContext context) ;
    Page<PimWorkHistory> searchJLSSGR(PimWorkHistorySearchContext context) ;
    List<PimWorkHistory> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
    List<PimWorkHistory> selectByPimpersonid(String pimpersonid) ;
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

    List<PimWorkHistory> getPimworkhistoryByIds(List<String> ids) ;
    List<PimWorkHistory> getPimworkhistoryByEntities(List<PimWorkHistory> entities) ;

}


