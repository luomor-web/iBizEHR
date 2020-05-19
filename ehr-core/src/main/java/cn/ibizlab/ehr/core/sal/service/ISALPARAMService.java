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

import cn.ibizlab.ehr.core.sal.domain.SALPARAM;
import cn.ibizlab.ehr.core.sal.filter.SALPARAMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALPARAM] 服务对象接口
 */
public interface ISALPARAMService extends IService<SALPARAM>{

    boolean save(SALPARAM et) ;
    void saveBatch(List<SALPARAM> list) ;
    SALPARAM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SALPARAM et) ;
    boolean create(SALPARAM et) ;
    void createBatch(List<SALPARAM> list) ;
    boolean update(SALPARAM et) ;
    void updateBatch(List<SALPARAM> list) ;
    SALPARAM getDraft(SALPARAM et) ;
    Page<SALPARAM> searchDefault(SALPARAMSearchContext context) ;
    List<SALPARAM> selectBySalsourceid(String salsourceid) ;
    void removeBySalsourceid(String salsourceid) ;
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


