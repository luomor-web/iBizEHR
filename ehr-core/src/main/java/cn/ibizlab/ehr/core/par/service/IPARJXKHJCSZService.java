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

import cn.ibizlab.ehr.core.par.domain.PARJXKHJCSZ;
import cn.ibizlab.ehr.core.par.filter.PARJXKHJCSZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXKHJCSZ] 服务对象接口
 */
public interface IPARJXKHJCSZService extends IService<PARJXKHJCSZ>{

    boolean update(PARJXKHJCSZ et) ;
    void updateBatch(List<PARJXKHJCSZ> list) ;
    PARJXKHJCSZ getDraft(PARJXKHJCSZ et) ;
    boolean checkKey(PARJXKHJCSZ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PARJXKHJCSZ et) ;
    void saveBatch(List<PARJXKHJCSZ> list) ;
    boolean create(PARJXKHJCSZ et) ;
    void createBatch(List<PARJXKHJCSZ> list) ;
    PARJXKHJCSZ get(String key) ;
    Page<PARJXKHJCSZ> searchDefault(PARJXKHJCSZSearchContext context) ;
    List<PARJXKHJCSZ> selectByOrmorgid(String orgid) ;
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

}


