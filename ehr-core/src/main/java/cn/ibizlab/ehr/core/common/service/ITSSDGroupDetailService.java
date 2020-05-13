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

import cn.ibizlab.ehr.core.common.domain.TSSDGroupDetail;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TSSDGroupDetail] 服务对象接口
 */
public interface ITSSDGroupDetailService extends IService<TSSDGroupDetail>{

    TSSDGroupDetail getDraft(TSSDGroupDetail et) ;
    boolean create(TSSDGroupDetail et) ;
    void createBatch(List<TSSDGroupDetail> list) ;
    boolean update(TSSDGroupDetail et) ;
    void updateBatch(List<TSSDGroupDetail> list) ;
    boolean save(TSSDGroupDetail et) ;
    void saveBatch(List<TSSDGroupDetail> list) ;
    boolean checkKey(TSSDGroupDetail et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TSSDGroupDetail get(String key) ;
    Page<TSSDGroupDetail> searchDefault(TSSDGroupDetailSearchContext context) ;
    List<TSSDGroupDetail> selectByTssdgroupid(String tssdgroupid) ;
    void removeByTssdgroupid(String tssdgroupid) ;
    List<TSSDGroupDetail> selectByTssditemid(String tssditemid) ;
    void removeByTssditemid(String tssditemid) ;
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


