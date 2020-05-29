package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.PARJXJG;
import cn.ibizlab.ehr.core.par.filter.PARJXJGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXJG] 服务对象接口
 */
public interface IPARJXJGService extends IService<PARJXJG>{

    PARJXJG getDraft(PARJXJG et) ;
    boolean checkKey(PARJXJG et) ;
    boolean create(PARJXJG et) ;
    void createBatch(List<PARJXJG> list) ;
    boolean save(PARJXJG et) ;
    void saveBatch(List<PARJXJG> list) ;
    PARJXJG get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PARJXJG et) ;
    void updateBatch(List<PARJXJG> list) ;
    Page<PARJXJG> searchDefault(PARJXJGSearchContext context) ;
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

    List<PARJXJG> getParjxjgByIds(List<String> ids) ;
    List<PARJXJG> getParjxjgByEntities(List<PARJXJG> entities) ;

}


