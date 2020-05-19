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

import cn.ibizlab.ehr.core.wf.domain.WFSystemUser;
import cn.ibizlab.ehr.core.wf.filter.WFSystemUserSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFSystemUser] 服务对象接口
 */
public interface IWFSystemUserService extends IService<WFSystemUser>{

    boolean create(WFSystemUser et) ;
    void createBatch(List<WFSystemUser> list) ;
    boolean checkKey(WFSystemUser et) ;
    WFSystemUser get(String key) ;
    boolean save(WFSystemUser et) ;
    void saveBatch(List<WFSystemUser> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFSystemUser getDraft(WFSystemUser et) ;
    boolean update(WFSystemUser et) ;
    void updateBatch(List<WFSystemUser> list) ;
    Page<WFSystemUser> searchDefault(WFSystemUserSearchContext context) ;
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


