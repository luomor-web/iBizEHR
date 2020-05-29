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

import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
import cn.ibizlab.ehr.core.pim.filter.PimArchiveSloanandreturnSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchiveSloanandreturn] 服务对象接口
 */
public interface IPimArchiveSloanandreturnService extends IService<PimArchiveSloanandreturn>{

    PimArchiveSloanandreturn get(String key) ;
    boolean update(PimArchiveSloanandreturn et) ;
    void updateBatch(List<PimArchiveSloanandreturn> list) ;
    boolean create(PimArchiveSloanandreturn et) ;
    void createBatch(List<PimArchiveSloanandreturn> list) ;
    PimArchiveSloanandreturn getDraft(PimArchiveSloanandreturn et) ;
    boolean checkKey(PimArchiveSloanandreturn et) ;
    PimArchiveSloanandreturn updateState(PimArchiveSloanandreturn et) ;
    boolean save(PimArchiveSloanandreturn et) ;
    void saveBatch(List<PimArchiveSloanandreturn> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimArchiveSloanandreturn updateArchiveState(PimArchiveSloanandreturn et) ;
    Page<PimArchiveSloanandreturn> searchDefault(PimArchiveSloanandreturnSearchContext context) ;
    List<PimArchiveSloanandreturn> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
    List<PimArchiveSloanandreturn> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PimArchiveSloanandreturn> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
    List<PimArchiveSloanandreturn> selectByPimpersonid3(String pimpersonid) ;
    void removeByPimpersonid3(String pimpersonid) ;
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

    List<PimArchiveSloanandreturn> getPimarchivesloanandreturnByIds(List<String> ids) ;
    List<PimArchiveSloanandreturn> getPimarchivesloanandreturnByEntities(List<PimArchiveSloanandreturn> entities) ;

}


