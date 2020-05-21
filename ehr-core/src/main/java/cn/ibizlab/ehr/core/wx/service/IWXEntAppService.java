package cn.ibizlab.ehr.core.wx.service;

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

import cn.ibizlab.ehr.core.wx.domain.WXEntApp;
import cn.ibizlab.ehr.core.wx.filter.WXEntAppSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXEntApp] 服务对象接口
 */
public interface IWXEntAppService extends IService<WXEntApp>{

    WXEntApp getDraft(WXEntApp et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WXEntApp get(String key) ;
    boolean save(WXEntApp et) ;
    void saveBatch(List<WXEntApp> list) ;
    WXEntApp pubMenu(WXEntApp et) ;
    boolean create(WXEntApp et) ;
    void createBatch(List<WXEntApp> list) ;
    boolean update(WXEntApp et) ;
    void updateBatch(List<WXEntApp> list) ;
    boolean checkKey(WXEntApp et) ;
    Page<WXEntApp> searchDefault(WXEntAppSearchContext context) ;
    List<WXEntApp> selectByWxaccountid(String wxaccountid) ;
    void removeByWxaccountid(String wxaccountid) ;
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


