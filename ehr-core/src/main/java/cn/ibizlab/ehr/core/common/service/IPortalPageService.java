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

import cn.ibizlab.ehr.core.common.domain.PortalPage;
import cn.ibizlab.ehr.core.common.filter.PortalPageSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PortalPage] 服务对象接口
 */
public interface IPortalPageService extends IService<PortalPage>{

    boolean checkKey(PortalPage et) ;
    PortalPage get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PortalPage et) ;
    void updateBatch(List<PortalPage> list) ;
    boolean create(PortalPage et) ;
    void createBatch(List<PortalPage> list) ;
    boolean save(PortalPage et) ;
    void saveBatch(List<PortalPage> list) ;
    PortalPage getDraft(PortalPage et) ;
    Page<PortalPage> searchDefault(PortalPageSearchContext context) ;
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


