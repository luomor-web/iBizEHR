package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMINVOICE;
import cn.ibizlab.ehr.core.trm.filter.TRMINVOICESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMINVOICE] 服务对象接口
 */
public interface ITRMINVOICEService extends IService<TRMINVOICE>{

    boolean create(TRMINVOICE et) ;
    void createBatch(List<TRMINVOICE> list) ;
    boolean save(TRMINVOICE et) ;
    void saveBatch(List<TRMINVOICE> list) ;
    TRMINVOICE getDraft(TRMINVOICE et) ;
    boolean checkKey(TRMINVOICE et) ;
    TRMINVOICE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TRMINVOICE et) ;
    void updateBatch(List<TRMINVOICE> list) ;
    Page<TRMINVOICE> searchDefault(TRMINVOICESearchContext context) ;
    List<TRMINVOICE> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TRMINVOICE> getTrminvoiceByIds(List<String> ids) ;
    List<TRMINVOICE> getTrminvoiceByEntities(List<TRMINVOICE> entities) ;

}


