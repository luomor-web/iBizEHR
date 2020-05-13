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

import cn.ibizlab.ehr.core.wx.domain.WXMessage;
import cn.ibizlab.ehr.core.wx.filter.WXMessageSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXMessage] 服务对象接口
 */
public interface IWXMessageService extends IService<WXMessage>{

    boolean update(WXMessage et) ;
    void updateBatch(List<WXMessage> list) ;
    WXMessage getDraft(WXMessage et) ;
    boolean checkKey(WXMessage et) ;
    boolean create(WXMessage et) ;
    void createBatch(List<WXMessage> list) ;
    boolean save(WXMessage et) ;
    void saveBatch(List<WXMessage> list) ;
    WXMessage get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<WXMessage> searchDefault(WXMessageSearchContext context) ;
    List<WXMessage> selectByWxaccountid(String wxaccountid) ;
    void removeByWxaccountid(String wxaccountid) ;
    List<WXMessage> selectByWxentappid(String wxentappid) ;
    void removeByWxentappid(String wxentappid) ;
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


