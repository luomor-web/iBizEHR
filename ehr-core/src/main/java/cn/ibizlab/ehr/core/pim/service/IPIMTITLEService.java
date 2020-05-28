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

import cn.ibizlab.ehr.core.pim.domain.PIMTITLE;
import cn.ibizlab.ehr.core.pim.filter.PIMTITLESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMTITLE] 服务对象接口
 */
public interface IPIMTITLEService extends IService<PIMTITLE>{

    boolean checkKey(PIMTITLE et) ;
    boolean update(PIMTITLE et) ;
    void updateBatch(List<PIMTITLE> list) ;
    boolean create(PIMTITLE et) ;
    void createBatch(List<PIMTITLE> list) ;
    PIMTITLE getDraft(PIMTITLE et) ;
    boolean save(PIMTITLE et) ;
    void saveBatch(List<PIMTITLE> list) ;
    PIMTITLE ensureHighestTech(PIMTITLE et) ;
    PIMTITLE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMTITLE> searchDefault(PIMTITLESearchContext context) ;
    Page<PIMTITLE> searchJLSS(PIMTITLESearchContext context) ;
    Page<PIMTITLE> searchAscriptionSys(PIMTITLESearchContext context) ;
    Page<HashMap> searchREP_TITLE(PIMTITLESearchContext context) ;
    Page<PIMTITLE> searchZIZHU(PIMTITLESearchContext context) ;
    List<PIMTITLE> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PIMTITLE> selectByPimtitlecatalogueid(String pimtitlecatalogueid) ;
    void removeByPimtitlecatalogueid(String pimtitlecatalogueid) ;
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

    List<PIMTITLE> getPimtitleByIds(List<String> ids) ;
    List<PIMTITLE> getPimtitleByEntities(List<PIMTITLE> entities) ;

}


