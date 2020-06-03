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

import cn.ibizlab.ehr.core.pim.domain.PimResearchFindings;
import cn.ibizlab.ehr.core.pim.filter.PimResearchFindingsSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimResearchFindings] 服务对象接口
 */
public interface IPimResearchFindingsService extends IService<PimResearchFindings>{

    boolean update(PimResearchFindings et) ;
    void updateBatch(List<PimResearchFindings> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimResearchFindings get(String key) ;
    PimResearchFindings getDraft(PimResearchFindings et) ;
    boolean checkKey(PimResearchFindings et) ;
    boolean save(PimResearchFindings et) ;
    void saveBatch(List<PimResearchFindings> list) ;
    boolean create(PimResearchFindings et) ;
    void createBatch(List<PimResearchFindings> list) ;
    Page<PimResearchFindings> searchDefault(PimResearchFindingsSearchContext context) ;
    Page<PimResearchFindings> searchJLSSGLY(PimResearchFindingsSearchContext context) ;
    Page<PimResearchFindings> searchJLSSGR(PimResearchFindingsSearchContext context) ;
    List<PimResearchFindings> selectByPimpersonid(String pimpersonid) ;
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

    List<PimResearchFindings> getPimresearchfindingsByIds(List<String> ids) ;
    List<PimResearchFindings> getPimresearchfindingsByEntities(List<PimResearchFindings> entities) ;

}


