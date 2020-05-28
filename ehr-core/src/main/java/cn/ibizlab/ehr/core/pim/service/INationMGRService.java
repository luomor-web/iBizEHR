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

import cn.ibizlab.ehr.core.pim.domain.NationMGR;
import cn.ibizlab.ehr.core.pim.filter.NationMGRSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[NationMGR] 服务对象接口
 */
public interface INationMGRService extends IService<NationMGR>{

    boolean save(NationMGR et) ;
    void saveBatch(List<NationMGR> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    NationMGR getDraft(NationMGR et) ;
    boolean checkKey(NationMGR et) ;
    boolean create(NationMGR et) ;
    void createBatch(List<NationMGR> list) ;
    NationMGR get(String key) ;
    boolean update(NationMGR et) ;
    void updateBatch(List<NationMGR> list) ;
    Page<NationMGR> searchDefault(NationMGRSearchContext context) ;
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

    List<NationMGR> getNationmgrByIds(List<String> ids) ;
    List<NationMGR> getNationmgrByEntities(List<NationMGR> entities) ;

}


