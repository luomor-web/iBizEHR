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

import cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSZZKHJGJLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMJXSZZKHJGJL] 服务对象接口
 */
public interface IPCMJXSZZKHJGJLService extends IService<PCMJXSZZKHJGJL>{

    boolean checkKey(PCMJXSZZKHJGJL et) ;
    PCMJXSZZKHJGJL getDraft(PCMJXSZZKHJGJL et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMJXSZZKHJGJL get(String key) ;
    boolean create(PCMJXSZZKHJGJL et) ;
    void createBatch(List<PCMJXSZZKHJGJL> list) ;
    boolean update(PCMJXSZZKHJGJL et) ;
    void updateBatch(List<PCMJXSZZKHJGJL> list) ;
    boolean save(PCMJXSZZKHJGJL et) ;
    void saveBatch(List<PCMJXSZZKHJGJL> list) ;
    Page<PCMJXSZZKHJGJL> searchDefault(PCMJXSZZKHJGJLSearchContext context) ;
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

    List<PCMJXSZZKHJGJL> getPcmjxszzkhjgjlByIds(List<String> ids) ;
    List<PCMJXSZZKHJGJL> getPcmjxszzkhjgjlByEntities(List<PCMJXSZZKHJGJL> entities) ;

}


