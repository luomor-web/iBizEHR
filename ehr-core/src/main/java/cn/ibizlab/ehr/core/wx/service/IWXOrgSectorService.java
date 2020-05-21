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

import cn.ibizlab.ehr.core.wx.domain.WXOrgSector;
import cn.ibizlab.ehr.core.wx.filter.WXOrgSectorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WXOrgSector] 服务对象接口
 */
public interface IWXOrgSectorService extends IService<WXOrgSector>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WXOrgSector et) ;
    boolean create(WXOrgSector et) ;
    void createBatch(List<WXOrgSector> list) ;
    WXOrgSector get(String key) ;
    boolean save(WXOrgSector et) ;
    void saveBatch(List<WXOrgSector> list) ;
    boolean update(WXOrgSector et) ;
    void updateBatch(List<WXOrgSector> list) ;
    WXOrgSector getDraft(WXOrgSector et) ;
    Page<WXOrgSector> searchDefault(WXOrgSectorSearchContext context) ;
    List<WXOrgSector> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<WXOrgSector> selectByWxaccountid(String wxaccountid) ;
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


