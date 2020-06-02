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

import cn.ibizlab.ehr.core.trm.domain.TrmInvoice;
import cn.ibizlab.ehr.core.trm.filter.TrmInvoiceSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmInvoice] 服务对象接口
 */
public interface ITrmInvoiceService extends IService<TrmInvoice>{

    boolean create(TrmInvoice et) ;
    void createBatch(List<TrmInvoice> list) ;
    boolean save(TrmInvoice et) ;
    void saveBatch(List<TrmInvoice> list) ;
    TrmInvoice getDraft(TrmInvoice et) ;
    boolean checkKey(TrmInvoice et) ;
    TrmInvoice get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TrmInvoice et) ;
    void updateBatch(List<TrmInvoice> list) ;
    Page<TrmInvoice> searchDefault(TrmInvoiceSearchContext context) ;
    List<TrmInvoice> selectByTrmtrainagencyid(String trmtrainagencyid) ;
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

    List<TrmInvoice> getTrminvoiceByIds(List<String> ids) ;
    List<TrmInvoice> getTrminvoiceByEntities(List<TrmInvoice> entities) ;

}


