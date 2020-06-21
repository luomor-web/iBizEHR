package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocArea;
import cn.ibizlab.ehr.core.soc.filter.SocAreaSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocArea] 服务对象接口
 */
public interface ISocAreaService extends IService<SocArea>{

    boolean create(SocArea et) ;
    void createBatch(List<SocArea> list) ;
    SocArea getDraft(SocArea et) ;
    boolean update(SocArea et) ;
    void updateBatch(List<SocArea> list) ;
    SocArea get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(SocArea et) ;
    boolean save(SocArea et) ;
    void saveBatch(List<SocArea> list) ;
    Page<SocArea> searchDefault(SocAreaSearchContext context) ;
    List<SocArea> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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

    List<SocArea> getSocareaByIds(List<String> ids) ;
    List<SocArea> getSocareaByEntities(List<SocArea> entities) ;

}


