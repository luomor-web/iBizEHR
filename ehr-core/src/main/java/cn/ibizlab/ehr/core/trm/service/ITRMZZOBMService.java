package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMZZOBM;
import cn.ibizlab.ehr.core.trm.filter.TRMZZOBMSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMZZOBM] 服务对象接口
 */
public interface ITRMZZOBMService extends IService<TRMZZOBM>{

    boolean create(TRMZZOBM et) ;
    void createBatch(List<TRMZZOBM> list) ;
    boolean update(TRMZZOBM et) ;
    void updateBatch(List<TRMZZOBM> list) ;
    boolean checkKey(TRMZZOBM et) ;
    TRMZZOBM getDraft(TRMZZOBM et) ;
    boolean save(TRMZZOBM et) ;
    void saveBatch(List<TRMZZOBM> list) ;
    TRMZZOBM get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TRMZZOBM> searchDefault(TRMZZOBMSearchContext context) ;
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


