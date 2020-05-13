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

import cn.ibizlab.ehr.core.par.domain.PARJXQDSZ;
import cn.ibizlab.ehr.core.par.filter.PARJXQDSZSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXQDSZ] 服务对象接口
 */
public interface IPARJXQDSZService extends IService<PARJXQDSZ>{

    boolean update(PARJXQDSZ et) ;
    void updateBatch(List<PARJXQDSZ> list) ;
    PARJXQDSZ get(String key) ;
    boolean save(PARJXQDSZ et) ;
    void saveBatch(List<PARJXQDSZ> list) ;
    boolean checkKey(PARJXQDSZ et) ;
    PARJXQDSZ getDraft(PARJXQDSZ et) ;
    boolean create(PARJXQDSZ et) ;
    void createBatch(List<PARJXQDSZ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PARJXQDSZ> searchDefault(PARJXQDSZSearchContext context) ;
    List<PARJXQDSZ> selectByOrmorgid(String orgid) ;
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

