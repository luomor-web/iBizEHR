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

import cn.ibizlab.ehr.core.par.domain.PARYDGZJHMX;
import cn.ibizlab.ehr.core.par.filter.PARYDGZJHMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARYDGZJHMX] 服务对象接口
 */
public interface IPARYDGZJHMXService extends IService<PARYDGZJHMX>{

    boolean update(PARYDGZJHMX et) ;
    void updateBatch(List<PARYDGZJHMX> list) ;
    boolean save(PARYDGZJHMX et) ;
    void saveBatch(List<PARYDGZJHMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PARYDGZJHMX get(String key) ;
    boolean checkKey(PARYDGZJHMX et) ;
    PARYDGZJHMX getDraft(PARYDGZJHMX et) ;
    boolean create(PARYDGZJHMX et) ;
    void createBatch(List<PARYDGZJHMX> list) ;
    Page<PARYDGZJHMX> searchDefault(PARYDGZJHMXSearchContext context) ;
    List<PARYDGZJHMX> selectByParydgzjhid(String parydgzjhid) ;
    void removeByParydgzjhid(String parydgzjhid) ;
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


