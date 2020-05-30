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

import cn.ibizlab.ehr.core.pim.domain.PimTitle;
import cn.ibizlab.ehr.core.pim.filter.PimTitleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimTitle] 服务对象接口
 */
public interface IPimTitleService extends IService<PimTitle>{

    boolean checkKey(PimTitle et) ;
    boolean update(PimTitle et) ;
    void updateBatch(List<PimTitle> list) ;
    boolean create(PimTitle et) ;
    void createBatch(List<PimTitle> list) ;
    PimTitle getDraft(PimTitle et) ;
    boolean save(PimTitle et) ;
    void saveBatch(List<PimTitle> list) ;
    PimTitle ensureHighestTech(PimTitle et) ;
    PimTitle get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimTitle> searchDefault(PimTitleSearchContext context) ;
    Page<PimTitle> searchJLSS(PimTitleSearchContext context) ;
    Page<PimTitle> searchAscriptionSys(PimTitleSearchContext context) ;
    Page<HashMap> searchREP_TITLE(PimTitleSearchContext context) ;
    Page<PimTitle> searchZIZHU(PimTitleSearchContext context) ;
    List<PimTitle> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PimTitle> selectByPimtitlecatalogueid(String pimtitlecatalogueid) ;
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

    List<PimTitle> getPimtitleByIds(List<String> ids) ;
    List<PimTitle> getPimtitleByEntities(List<PimTitle> entities) ;

}


