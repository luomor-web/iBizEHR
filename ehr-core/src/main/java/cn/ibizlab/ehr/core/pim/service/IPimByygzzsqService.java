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

import cn.ibizlab.ehr.core.pim.domain.PimByygzzsq;
import cn.ibizlab.ehr.core.pim.filter.PimByygzzsqSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimByygzzsq] 服务对象接口
 */
public interface IPimByygzzsqService extends IService<PimByygzzsq>{

    PimByygzzsq get(String key) ;
    boolean update(PimByygzzsq et) ;
    void updateBatch(List<PimByygzzsq> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PimByygzzsq et) ;
    void saveBatch(List<PimByygzzsq> list) ;
    PimByygzzsq getDraft(PimByygzzsq et) ;
    boolean create(PimByygzzsq et) ;
    void createBatch(List<PimByygzzsq> list) ;
    boolean checkKey(PimByygzzsq et) ;
    Page<PimByygzzsq> searchDefault(PimByygzzsqSearchContext context) ;
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

    List<PimByygzzsq> getPimbyygzzsqByIds(List<String> ids) ;
    List<PimByygzzsq> getPimbyygzzsqByEntities(List<PimByygzzsq> entities) ;

}


