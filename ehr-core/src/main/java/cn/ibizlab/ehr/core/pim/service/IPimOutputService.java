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

import cn.ibizlab.ehr.core.pim.domain.PimOutput;
import cn.ibizlab.ehr.core.pim.filter.PimOutputSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimOutput] 服务对象接口
 */
public interface IPimOutputService extends IService<PimOutput>{

    boolean update(PimOutput et) ;
    void updateBatch(List<PimOutput> list) ;
    PimOutput get(String key) ;
    boolean create(PimOutput et) ;
    void createBatch(List<PimOutput> list) ;
    boolean checkKey(PimOutput et) ;
    PimOutput getDraft(PimOutput et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PimOutput et) ;
    void saveBatch(List<PimOutput> list) ;
    Page<PimOutput> searchCurOrg(PimOutputSearchContext context) ;
    Page<PimOutput> searchDefault(PimOutputSearchContext context) ;
    Page<HashMap> searchREP_OUTPUT(PimOutputSearchContext context) ;
    List<PimOutput> selectByOrmorgid(String orgid) ;
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

    List<PimOutput> getPimoutputByIds(List<String> ids) ;
    List<PimOutput> getPimoutputByEntities(List<PimOutput> entities) ;

}


