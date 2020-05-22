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

import cn.ibizlab.ehr.core.pcm.domain.PCMZJDYZW;
import cn.ibizlab.ehr.core.pcm.filter.PCMZJDYZWSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMZJDYZW] 服务对象接口
 */
public interface IPCMZJDYZWService extends IService<PCMZJDYZW>{

    boolean checkKey(PCMZJDYZW et) ;
    PCMZJDYZW getDraft(PCMZJDYZW et) ;
    boolean create(PCMZJDYZW et) ;
    void createBatch(List<PCMZJDYZW> list) ;
    PCMZJDYZW get(String key) ;
    boolean update(PCMZJDYZW et) ;
    void updateBatch(List<PCMZJDYZW> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMZJDYZW et) ;
    void saveBatch(List<PCMZJDYZW> list) ;
    Page<PCMZJDYZW> searchDefault(PCMZJDYZWSearchContext context) ;
    List<PCMZJDYZW> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMZJDYZW> selectByOrmrankid(String ormrankid) ;
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

}


