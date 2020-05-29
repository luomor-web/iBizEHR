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

import cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesCenterSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchivesCenter] 服务对象接口
 */
public interface IPimArchivesCenterService extends IService<PimArchivesCenter>{

    boolean save(PimArchivesCenter et) ;
    void saveBatch(List<PimArchivesCenter> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimArchivesCenter et) ;
    void createBatch(List<PimArchivesCenter> list) ;
    boolean checkKey(PimArchivesCenter et) ;
    PimArchivesCenter getDraft(PimArchivesCenter et) ;
    boolean update(PimArchivesCenter et) ;
    void updateBatch(List<PimArchivesCenter> list) ;
    PimArchivesCenter get(String key) ;
    Page<PimArchivesCenter> searchDefault(PimArchivesCenterSearchContext context) ;
    List<PimArchivesCenter> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<PimArchivesCenter> getPimarchivescenterByIds(List<String> ids) ;
    List<PimArchivesCenter> getPimarchivescenterByEntities(List<PimArchivesCenter> entities) ;

}


