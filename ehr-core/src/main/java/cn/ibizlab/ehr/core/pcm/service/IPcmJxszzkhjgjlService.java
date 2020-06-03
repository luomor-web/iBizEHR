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

import cn.ibizlab.ehr.core.pcm.domain.PcmJxszzkhjgjl;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxszzkhjgjlSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmJxszzkhjgjl] 服务对象接口
 */
public interface IPcmJxszzkhjgjlService extends IService<PcmJxszzkhjgjl>{

    boolean checkKey(PcmJxszzkhjgjl et) ;
    PcmJxszzkhjgjl getDraft(PcmJxszzkhjgjl et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmJxszzkhjgjl get(String key) ;
    boolean create(PcmJxszzkhjgjl et) ;
    void createBatch(List<PcmJxszzkhjgjl> list) ;
    boolean update(PcmJxszzkhjgjl et) ;
    void updateBatch(List<PcmJxszzkhjgjl> list) ;
    boolean save(PcmJxszzkhjgjl et) ;
    void saveBatch(List<PcmJxszzkhjgjl> list) ;
    Page<PcmJxszzkhjgjl> searchDefault(PcmJxszzkhjgjlSearchContext context) ;
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

    List<PcmJxszzkhjgjl> getPcmjxszzkhjgjlByIds(List<String> ids) ;
    List<PcmJxszzkhjgjl> getPcmjxszzkhjgjlByEntities(List<PcmJxszzkhjgjl> entities) ;

}


