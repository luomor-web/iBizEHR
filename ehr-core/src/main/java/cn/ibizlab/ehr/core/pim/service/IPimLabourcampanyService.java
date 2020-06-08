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

import cn.ibizlab.ehr.core.pim.domain.PimLabourcampany;
import cn.ibizlab.ehr.core.pim.filter.PimLabourcampanySearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimLabourcampany] 服务对象接口
 */
public interface IPimLabourcampanyService extends IService<PimLabourcampany>{

    boolean save(PimLabourcampany et) ;
    void saveBatch(List<PimLabourcampany> list) ;
    boolean checkKey(PimLabourcampany et) ;
    boolean update(PimLabourcampany et) ;
    void updateBatch(List<PimLabourcampany> list) ;
    boolean create(PimLabourcampany et) ;
    void createBatch(List<PimLabourcampany> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimLabourcampany get(String key) ;
    PimLabourcampany getDraft(PimLabourcampany et) ;
    Page<PimLabourcampany> searchAuthLab(PimLabourcampanySearchContext context) ;
    Page<PimLabourcampany> searchDefault(PimLabourcampanySearchContext context) ;
    List<PimLabourcampany> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimLabourcampany> selectByPimpersonid(String pimpersonid) ;
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

    List<PimLabourcampany> getPimlabourcampanyByIds(List<String> ids) ;
    List<PimLabourcampany> getPimlabourcampanyByEntities(List<PimLabourcampany> entities) ;

}


