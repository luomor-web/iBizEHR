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

import cn.ibizlab.ehr.core.pcm.domain.PcmTdzwxx;
import cn.ibizlab.ehr.core.pcm.filter.PcmTdzwxxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmTdzwxx] 服务对象接口
 */
public interface IPcmTdzwxxService extends IService<PcmTdzwxx>{

    boolean create(PcmTdzwxx et) ;
    void createBatch(List<PcmTdzwxx> list) ;
    PcmTdzwxx getDraft(PcmTdzwxx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmTdzwxx et) ;
    void saveBatch(List<PcmTdzwxx> list) ;
    boolean update(PcmTdzwxx et) ;
    void updateBatch(List<PcmTdzwxx> list) ;
    boolean checkKey(PcmTdzwxx et) ;
    PcmTdzwxx get(String key) ;
    Page<PcmTdzwxx> searchDefault(PcmTdzwxxSearchContext context) ;
    List<PcmTdzwxx> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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

    List<PcmTdzwxx> getPcmtdzwxxByIds(List<String> ids) ;
    List<PcmTdzwxx> getPcmtdzwxxByEntities(List<PcmTdzwxx> entities) ;

}


