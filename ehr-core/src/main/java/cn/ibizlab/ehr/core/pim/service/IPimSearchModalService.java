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

import cn.ibizlab.ehr.core.pim.domain.PimSearchModal;
import cn.ibizlab.ehr.core.pim.filter.PimSearchModalSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimSearchModal] 服务对象接口
 */
public interface IPimSearchModalService extends IService<PimSearchModal>{

    PimSearchModal getDraft(PimSearchModal et) ;
    boolean update(PimSearchModal et) ;
    void updateBatch(List<PimSearchModal> list) ;
    PimSearchModal get(String key) ;
    boolean create(PimSearchModal et) ;
    void createBatch(List<PimSearchModal> list) ;
    boolean checkKey(PimSearchModal et) ;
    boolean save(PimSearchModal et) ;
    void saveBatch(List<PimSearchModal> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PimSearchModal> searchDefault(PimSearchModalSearchContext context) ;
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

    List<PimSearchModal> getPimsearchmodalByIds(List<String> ids) ;
    List<PimSearchModal> getPimsearchmodalByEntities(List<PimSearchModal> entities) ;

}


