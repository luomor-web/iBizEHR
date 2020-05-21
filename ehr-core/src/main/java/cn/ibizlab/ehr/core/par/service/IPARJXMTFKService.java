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

import cn.ibizlab.ehr.core.par.domain.PARJXMTFK;
import cn.ibizlab.ehr.core.par.filter.PARJXMTFKSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXMTFK] 服务对象接口
 */
public interface IPARJXMTFKService extends IService<PARJXMTFK>{

    boolean create(PARJXMTFK et) ;
    void createBatch(List<PARJXMTFK> list) ;
    boolean update(PARJXMTFK et) ;
    void updateBatch(List<PARJXMTFK> list) ;
    PARJXMTFK getDraft(PARJXMTFK et) ;
    PARJXMTFK get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PARJXMTFK et) ;
    boolean save(PARJXMTFK et) ;
    void saveBatch(List<PARJXMTFK> list) ;
    Page<PARJXMTFK> searchDefault(PARJXMTFKSearchContext context) ;
    List<PARJXMTFK> selectByPimpersonid(String pimpersonid) ;
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

}


