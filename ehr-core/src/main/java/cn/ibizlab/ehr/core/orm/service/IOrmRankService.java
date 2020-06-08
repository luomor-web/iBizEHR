package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.OrmRank;
import cn.ibizlab.ehr.core.orm.filter.OrmRankSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmRank] 服务对象接口
 */
public interface IOrmRankService extends IService<OrmRank>{

    boolean update(OrmRank et) ;
    void updateBatch(List<OrmRank> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(OrmRank et) ;
    void saveBatch(List<OrmRank> list) ;
    OrmRank get(String key) ;
    boolean checkKey(OrmRank et) ;
    OrmRank getDraft(OrmRank et) ;
    boolean create(OrmRank et) ;
    void createBatch(List<OrmRank> list) ;
    Page<OrmRank> searchJZRANK(OrmRankSearchContext context) ;
    Page<OrmRank> searchJSRANK(OrmRankSearchContext context) ;
    Page<OrmRank> searchDJYX(OrmRankSearchContext context) ;
    Page<OrmRank> searchJSNRANK(OrmRankSearchContext context) ;
    Page<OrmRank> searchDefault(OrmRankSearchContext context) ;
    Page<OrmRank> searchCurRank(OrmRankSearchContext context) ;
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

    List<OrmRank> getOrmrankByIds(List<String> ids) ;
    List<OrmRank> getOrmrankByEntities(List<OrmRank> entities) ;

}


