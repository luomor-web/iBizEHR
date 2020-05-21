package cn.ibizlab.ehr.core.wf.service;

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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.wf.domain.WFUser;
import cn.ibizlab.ehr.core.wf.filter.WFUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUser] 服务对象接口
 */
public interface IWFUserService extends IService<WFUser>{

    WFUser getDraft(WFUser et) ;
    WFUser get(String key) ;
    boolean create(WFUser et) ;
    void createBatch(List<WFUser> list) ;
    boolean save(WFUser et) ;
    void saveBatch(List<WFUser> list) ;
    boolean update(WFUser et) ;
    void updateBatch(List<WFUser> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFUser et) ;
    Page<WFUser> searchDefault(WFUserSearchContext context) ;
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


