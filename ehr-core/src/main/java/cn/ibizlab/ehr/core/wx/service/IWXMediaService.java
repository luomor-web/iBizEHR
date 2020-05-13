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

import cn.ibizlab.ehr.core.wx.domain.WXMedia;
import cn.ibizlab.ehr.core.wx.filter.WXMediaSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXMedia] 服务对象接口
 */
public interface IWXMediaService extends IService<WXMedia>{

    boolean create(WXMedia et) ;
    void createBatch(List<WXMedia> list) ;
    boolean checkKey(WXMedia et) ;
    WXMedia getDraft(WXMedia et) ;
    boolean save(WXMedia et) ;
    void saveBatch(List<WXMedia> list) ;
    boolean update(WXMedia et) ;
    void updateBatch(List<WXMedia> list) ;
    WXMedia get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<WXMedia> searchDefault(WXMediaSearchContext context) ;
    List<WXMedia> selectByWxaccountid(String wxaccountid) ;
    void removeByWxaccountid(String wxaccountid) ;
    List<WXMedia> selectByWxentappid(String wxentappid) ;
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


