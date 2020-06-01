package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SalStdgw;
import cn.ibizlab.ehr.core.sal.filter.SalStdgwSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdgw] 服务对象接口
 */
public interface ISalStdgwService extends IService<SalStdgw>{

    boolean create(SalStdgw et) ;
    void createBatch(List<SalStdgw> list) ;
    boolean checkKey(SalStdgw et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SalStdgw get(String key) ;
    SalStdgw getDraft(SalStdgw et) ;
    boolean save(SalStdgw et) ;
    void saveBatch(List<SalStdgw> list) ;
    boolean update(SalStdgw et) ;
    void updateBatch(List<SalStdgw> list) ;
    Page<SalStdgw> searchDefault(SalStdgwSearchContext context) ;
    List<SalStdgw> selectByOrmorgid(String orgid) ;
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

    List<SalStdgw> getSalstdgwByIds(List<String> ids) ;
    List<SalStdgw> getSalstdgwByEntities(List<SalStdgw> entities) ;

}


