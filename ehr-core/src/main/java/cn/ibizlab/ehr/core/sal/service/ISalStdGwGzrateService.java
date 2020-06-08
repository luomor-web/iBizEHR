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

import cn.ibizlab.ehr.core.sal.domain.SalStdGwGzrate;
import cn.ibizlab.ehr.core.sal.filter.SalStdGwGzrateSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SalStdGwGzrate] 服务对象接口
 */
public interface ISalStdGwGzrateService extends IService<SalStdGwGzrate>{

    boolean checkKey(SalStdGwGzrate et) ;
    SalStdGwGzrate get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SalStdGwGzrate et) ;
    void createBatch(List<SalStdGwGzrate> list) ;
    boolean save(SalStdGwGzrate et) ;
    void saveBatch(List<SalStdGwGzrate> list) ;
    boolean update(SalStdGwGzrate et) ;
    void updateBatch(List<SalStdGwGzrate> list) ;
    SalStdGwGzrate getDraft(SalStdGwGzrate et) ;
    Page<SalStdGwGzrate> searchDefault(SalStdGwGzrateSearchContext context) ;
    List<SalStdGwGzrate> selectByOrmorgid(String orgid) ;
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

    List<SalStdGwGzrate> getSalstdgwgzrateByIds(List<String> ids) ;
    List<SalStdGwGzrate> getSalstdgwgzrateByEntities(List<SalStdGwGzrate> entities) ;

}


