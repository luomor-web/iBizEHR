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

import cn.ibizlab.ehr.core.common.domain.MsgSendQueueHis;
import cn.ibizlab.ehr.core.common.filter.MsgSendQueueHisSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgSendQueueHis] 服务对象接口
 */
public interface IMsgSendQueueHisService extends IService<MsgSendQueueHis>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    MsgSendQueueHis getDraft(MsgSendQueueHis et) ;
    boolean checkKey(MsgSendQueueHis et) ;
    boolean update(MsgSendQueueHis et) ;
    void updateBatch(List<MsgSendQueueHis> list) ;
    MsgSendQueueHis get(String key) ;
    boolean save(MsgSendQueueHis et) ;
    void saveBatch(List<MsgSendQueueHis> list) ;
    boolean create(MsgSendQueueHis et) ;
    void createBatch(List<MsgSendQueueHis> list) ;
    Page<MsgSendQueueHis> searchDefault(MsgSendQueueHisSearchContext context) ;
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


