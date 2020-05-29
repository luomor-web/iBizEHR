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

import cn.ibizlab.ehr.core.pim.domain.PimArchivesRecord;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesRecordSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchivesRecord] 服务对象接口
 */
public interface IPimArchivesRecordService extends IService<PimArchivesRecord>{

    boolean create(PimArchivesRecord et) ;
    void createBatch(List<PimArchivesRecord> list) ;
    boolean save(PimArchivesRecord et) ;
    void saveBatch(List<PimArchivesRecord> list) ;
    boolean update(PimArchivesRecord et) ;
    void updateBatch(List<PimArchivesRecord> list) ;
    boolean checkKey(PimArchivesRecord et) ;
    PimArchivesRecord get(String key) ;
    PimArchivesRecord getDraft(PimArchivesRecord et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimArchivesRecord> searchDefault(PimArchivesRecordSearchContext context) ;
    List<PimArchivesRecord> selectByArchivalcatalogueid(String archivalcatalogueid) ;
    void removeByArchivalcatalogueid(String archivalcatalogueid) ;
    List<PimArchivesRecord> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
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

    List<PimArchivesRecord> getPimarchivesrecordByIds(List<String> ids) ;
    List<PimArchivesRecord> getPimarchivesrecordByEntities(List<PimArchivesRecord> entities) ;

}


