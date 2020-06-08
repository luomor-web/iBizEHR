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

import cn.ibizlab.ehr.core.pcm.domain.PcmGbhmc;
import cn.ibizlab.ehr.core.pcm.filter.PcmGbhmcSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmGbhmc] 服务对象接口
 */
public interface IPcmGbhmcService extends IService<PcmGbhmc>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmGbhmc get(String key) ;
    PcmGbhmc toggleLeader(PcmGbhmc et) ;
    PcmGbhmc getDraft(PcmGbhmc et) ;
    boolean create(PcmGbhmc et) ;
    void createBatch(List<PcmGbhmc> list) ;
    boolean update(PcmGbhmc et) ;
    void updateBatch(List<PcmGbhmc> list) ;
    boolean save(PcmGbhmc et) ;
    void saveBatch(List<PcmGbhmc> list) ;
    PcmGbhmc sGTG(PcmGbhmc et) ;
    boolean checkKey(PcmGbhmc et) ;
    PcmGbhmc sGBTG(PcmGbhmc et) ;
    Page<PcmGbhmc> searchGBHMCNewTree(PcmGbhmcSearchContext context) ;
    Page<PcmGbhmc> searchGBHMCTree(PcmGbhmcSearchContext context) ;
    Page<PcmGbhmc> searchDefault(PcmGbhmcSearchContext context) ;
    Page<PcmGbhmc> searchZJPD(PcmGbhmcSearchContext context) ;
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

    List<PcmGbhmc> getPcmgbhmcByIds(List<String> ids) ;
    List<PcmGbhmc> getPcmgbhmcByEntities(List<PcmGbhmc> entities) ;

}


