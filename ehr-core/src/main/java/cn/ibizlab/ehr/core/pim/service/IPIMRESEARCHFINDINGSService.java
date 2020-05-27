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

import cn.ibizlab.ehr.core.pim.domain.PIMRESEARCHFINDINGS;
import cn.ibizlab.ehr.core.pim.filter.PIMRESEARCHFINDINGSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMRESEARCHFINDINGS] 服务对象接口
 */
public interface IPIMRESEARCHFINDINGSService extends IService<PIMRESEARCHFINDINGS>{

    boolean update(PIMRESEARCHFINDINGS et) ;
    void updateBatch(List<PIMRESEARCHFINDINGS> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMRESEARCHFINDINGS get(String key) ;
    PIMRESEARCHFINDINGS getDraft(PIMRESEARCHFINDINGS et) ;
    boolean checkKey(PIMRESEARCHFINDINGS et) ;
    boolean save(PIMRESEARCHFINDINGS et) ;
    void saveBatch(List<PIMRESEARCHFINDINGS> list) ;
    boolean create(PIMRESEARCHFINDINGS et) ;
    void createBatch(List<PIMRESEARCHFINDINGS> list) ;
    Page<PIMRESEARCHFINDINGS> searchDefault(PIMRESEARCHFINDINGSSearchContext context) ;
    Page<PIMRESEARCHFINDINGS> searchJLSSGLY(PIMRESEARCHFINDINGSSearchContext context) ;
    Page<PIMRESEARCHFINDINGS> searchJLSSGR(PIMRESEARCHFINDINGSSearchContext context) ;
    List<PIMRESEARCHFINDINGS> selectByPimpersonid(String pimpersonid) ;
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

    List<PIMRESEARCHFINDINGS> getPimresearchfindingsByIds(List<String> ids) ;
    List<PIMRESEARCHFINDINGS> getPimresearchfindingsByEntities(List<PIMRESEARCHFINDINGS> entities) ;

}


