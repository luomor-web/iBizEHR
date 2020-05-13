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

import cn.ibizlab.ehr.core.wx.domain.WXAccessToken;
import cn.ibizlab.ehr.core.wx.filter.WXAccessTokenSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXAccessToken] 服务对象接口
 */
public interface IWXAccessTokenService extends IService<WXAccessToken>{

    boolean update(WXAccessToken et) ;
    void updateBatch(List<WXAccessToken> list) ;
    WXAccessToken get(String key) ;
    boolean checkKey(WXAccessToken et) ;
    boolean save(WXAccessToken et) ;
    void saveBatch(List<WXAccessToken> list) ;
    boolean create(WXAccessToken et) ;
    void createBatch(List<WXAccessToken> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WXAccessToken getDraft(WXAccessToken et) ;
    Page<WXAccessToken> searchDefault(WXAccessTokenSearchContext context) ;
    List<WXAccessToken> selectByWxaccountid(String wxaccountid) ;
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


