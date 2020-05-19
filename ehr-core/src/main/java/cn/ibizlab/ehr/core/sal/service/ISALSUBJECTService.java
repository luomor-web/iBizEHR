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

import cn.ibizlab.ehr.core.sal.domain.SALSUBJECT;
import cn.ibizlab.ehr.core.sal.filter.SALSUBJECTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSUBJECT] 服务对象接口
 */
public interface ISALSUBJECTService extends IService<SALSUBJECT>{

    SALSUBJECT getDraft(SALSUBJECT et) ;
    boolean save(SALSUBJECT et) ;
    void saveBatch(List<SALSUBJECT> list) ;
    boolean checkKey(SALSUBJECT et) ;
    boolean update(SALSUBJECT et) ;
    void updateBatch(List<SALSUBJECT> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSUBJECT get(String key) ;
    boolean create(SALSUBJECT et) ;
    void createBatch(List<SALSUBJECT> list) ;
    Page<SALSUBJECT> searchDefault(SALSUBJECTSearchContext context) ;
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


