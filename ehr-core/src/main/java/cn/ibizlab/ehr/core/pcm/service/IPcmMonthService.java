package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PcmMonth;
import cn.ibizlab.ehr.core.pcm.filter.PcmMonthSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmMonth] 服务对象接口
 */
public interface IPcmMonthService extends IService<PcmMonth>{

    boolean update(PcmMonth et) ;
    void updateBatch(List<PcmMonth> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmMonth et) ;
    void saveBatch(List<PcmMonth> list) ;
    boolean create(PcmMonth et) ;
    void createBatch(List<PcmMonth> list) ;
    boolean checkKey(PcmMonth et) ;
    PcmMonth get(String key) ;
    PcmMonth getDraft(PcmMonth et) ;
    Page<PcmMonth> searchDefault(PcmMonthSearchContext context) ;
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

    List<PcmMonth> getPcmmonthByIds(List<String> ids) ;
    List<PcmMonth> getPcmmonthByEntities(List<PcmMonth> entities) ;

}


