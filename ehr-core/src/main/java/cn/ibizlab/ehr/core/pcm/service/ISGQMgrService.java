package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.SGQMgr;
import cn.ibizlab.ehr.core.pcm.filter.SGQMgrSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SGQMgr] 服务对象接口
 */
public interface ISGQMgrService extends IService<SGQMgr>{

    SGQMgr get(String key) ;
    SGQMgr getDraft(SGQMgr et) ;
    boolean create(SGQMgr et) ;
    void createBatch(List<SGQMgr> list) ;
    boolean update(SGQMgr et) ;
    void updateBatch(List<SGQMgr> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SGQMgr et) ;
    boolean save(SGQMgr et) ;
    void saveBatch(List<SGQMgr> list) ;
    Page<SGQMgr> searchDefault(SGQMgrSearchContext context) ;
    List<SGQMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    void removeByPcmbdsqdmxid(String pcmbdsqdmxid) ;
    List<SGQMgr> selectByPimpersonid(String pimpersonid) ;
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


