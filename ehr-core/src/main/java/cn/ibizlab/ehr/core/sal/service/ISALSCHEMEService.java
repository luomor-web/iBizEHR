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

import cn.ibizlab.ehr.core.sal.domain.SALSCHEME;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSCHEME] 服务对象接口
 */
public interface ISALSCHEMEService extends IService<SALSCHEME>{

    boolean create(SALSCHEME et) ;
    void createBatch(List<SALSCHEME> list) ;
    boolean update(SALSCHEME et) ;
    void updateBatch(List<SALSCHEME> list) ;
    SALSCHEME getDraft(SALSCHEME et) ;
    boolean save(SALSCHEME et) ;
    void saveBatch(List<SALSCHEME> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSCHEME get(String key) ;
    boolean checkKey(SALSCHEME et) ;
    Page<SALSCHEME> searchDefault(SALSCHEMESearchContext context) ;
    List<SALSCHEME> selectByOrmorgid(String orgid) ;
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

    List<SALSCHEME> getSalschemeByIds(List<String> ids) ;
    List<SALSCHEME> getSalschemeByEntities(List<SALSCHEME> entities) ;

}


