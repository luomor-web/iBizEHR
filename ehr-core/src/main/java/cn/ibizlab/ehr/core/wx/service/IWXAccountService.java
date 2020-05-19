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

import cn.ibizlab.ehr.core.wx.domain.WXAccount;
import cn.ibizlab.ehr.core.wx.filter.WXAccountSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXAccount] 服务对象接口
 */
public interface IWXAccountService extends IService<WXAccount>{

    boolean create(WXAccount et) ;
    void createBatch(List<WXAccount> list) ;
    boolean checkKey(WXAccount et) ;
    boolean update(WXAccount et) ;
    void updateBatch(List<WXAccount> list) ;
    WXAccount syncOrgSector(WXAccount et) ;
    WXAccount pubMenu(WXAccount et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WXAccount syncOrgUser(WXAccount et) ;
    WXAccount get(String key) ;
    boolean save(WXAccount et) ;
    void saveBatch(List<WXAccount> list) ;
    WXAccount getDraft(WXAccount et) ;
    Page<WXAccount> searchDefault(WXAccountSearchContext context) ;
    List<WXAccount> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
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


