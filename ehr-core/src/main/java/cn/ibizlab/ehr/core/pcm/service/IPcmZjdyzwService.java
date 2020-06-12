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

import cn.ibizlab.ehr.core.pcm.domain.PcmZjdyzw;
import cn.ibizlab.ehr.core.pcm.filter.PcmZjdyzwSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmZjdyzw] 服务对象接口
 */
public interface IPcmZjdyzwService extends IService<PcmZjdyzw>{

    boolean checkKey(PcmZjdyzw et) ;
    PcmZjdyzw getDraft(PcmZjdyzw et) ;
    boolean create(PcmZjdyzw et) ;
    void createBatch(List<PcmZjdyzw> list) ;
    PcmZjdyzw get(String key) ;
    boolean update(PcmZjdyzw et) ;
    void updateBatch(List<PcmZjdyzw> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PcmZjdyzw et) ;
    void saveBatch(List<PcmZjdyzw> list) ;
    Page<PcmZjdyzw> searchDefault(PcmZjdyzwSearchContext context) ;
    List<PcmZjdyzw> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmZjdyzw> selectByOrmrankid(String ormrankid) ;
    void removeByOrmrankid(String ormrankid) ;
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

    List<PcmZjdyzw> getPcmzjdyzwByIds(List<String> ids) ;
    List<PcmZjdyzw> getPcmzjdyzwByEntities(List<PcmZjdyzw> entities) ;

}


