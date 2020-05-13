package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.DataAuditDetail;
import cn.ibizlab.ehr.core.common.filter.DataAuditDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DataAuditDetail] 服务对象接口
 */
public interface IDataAuditDetailService extends IService<DataAuditDetail>{

    boolean save(DataAuditDetail et) ;
    void saveBatch(List<DataAuditDetail> list) ;
    DataAuditDetail getDraft(DataAuditDetail et) ;
    DataAuditDetail get(String key) ;
    boolean create(DataAuditDetail et) ;
    void createBatch(List<DataAuditDetail> list) ;
    boolean update(DataAuditDetail et) ;
    void updateBatch(List<DataAuditDetail> list) ;
    boolean checkKey(DataAuditDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<DataAuditDetail> searchDefault(DataAuditDetailSearchContext context) ;
    List<DataAuditDetail> selectByDataauditid(String dataauditid) ;
    void removeByDataauditid(String dataauditid) ;
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


