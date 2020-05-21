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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.common.domain.MsgAccountDetail;
import cn.ibizlab.ehr.core.common.filter.MsgAccountDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgAccountDetail] 服务对象接口
 */
public interface IMsgAccountDetailService extends IService<MsgAccountDetail>{

    MsgAccountDetail getDraft(MsgAccountDetail et) ;
    boolean update(MsgAccountDetail et) ;
    void updateBatch(List<MsgAccountDetail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(MsgAccountDetail et) ;
    boolean save(MsgAccountDetail et) ;
    void saveBatch(List<MsgAccountDetail> list) ;
    boolean create(MsgAccountDetail et) ;
    void createBatch(List<MsgAccountDetail> list) ;
    MsgAccountDetail get(String key) ;
    Page<MsgAccountDetail> searchDefault(MsgAccountDetailSearchContext context) ;
    List<MsgAccountDetail> selectByMajormsgaccountid(String msgaccountid) ;
    void removeByMajormsgaccountid(String msgaccountid) ;
    List<MsgAccountDetail> selectByMinormsgaccountid(String msgaccountid) ;
    void removeByMinormsgaccountid(String msgaccountid) ;
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


