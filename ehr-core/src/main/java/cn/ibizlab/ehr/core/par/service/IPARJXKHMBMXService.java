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

import cn.ibizlab.ehr.core.par.domain.PARJXKHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARJXKHMBMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJXKHMBMX] 服务对象接口
 */
public interface IPARJXKHMBMXService extends IService<PARJXKHMBMX>{

    boolean create(PARJXKHMBMX et) ;
    void createBatch(List<PARJXKHMBMX> list) ;
    boolean checkKey(PARJXKHMBMX et) ;
    PARJXKHMBMX getDraft(PARJXKHMBMX et) ;
    boolean update(PARJXKHMBMX et) ;
    void updateBatch(List<PARJXKHMBMX> list) ;
    PARJXKHMBMX get(String key) ;
    boolean save(PARJXKHMBMX et) ;
    void saveBatch(List<PARJXKHMBMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PARJXKHMBMX> searchDefault(PARJXKHMBMXSearchContext context) ;
    List<PARJXKHMBMX> selectByParjxkhmbid(String parjxkhmbid) ;
    void removeByParjxkhmbid(String parjxkhmbid) ;
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


