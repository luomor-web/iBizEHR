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

import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmDdsqd] 服务对象接口
 */
public interface IPcmDdsqdService extends IService<PcmDdsqd>{

    boolean create(PcmDdsqd et) ;
    void createBatch(List<PcmDdsqd> list) ;
    PcmDdsqd pDD(PcmDdsqd et) ;
    PcmDdsqd get(String key) ;
    boolean update(PcmDdsqd et) ;
    void updateBatch(List<PcmDdsqd> list) ;
    boolean checkKey(PcmDdsqd et) ;
    boolean save(PcmDdsqd et) ;
    void saveBatch(List<PcmDdsqd> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmDdsqd getDraft(PcmDdsqd et) ;
    Page<PcmDdsqd> searchDefault(PcmDdsqdSearchContext context) ;
    List<PcmDdsqd> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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

    List<PcmDdsqd> getPcmddsqdByIds(List<String> ids) ;
    List<PcmDdsqd> getPcmddsqdByEntities(List<PcmDdsqd> entities) ;

}


