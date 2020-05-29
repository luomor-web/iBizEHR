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

import cn.ibizlab.ehr.core.soc.domain.SocSelfareBase;
import cn.ibizlab.ehr.core.soc.filter.SocSelfareBaseSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocSelfareBase] 服务对象接口
 */
public interface ISocSelfareBaseService extends IService<SocSelfareBase>{

    SocSelfareBase getDraft(SocSelfareBase et) ;
    boolean checkKey(SocSelfareBase et) ;
    boolean save(SocSelfareBase et) ;
    void saveBatch(List<SocSelfareBase> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SocSelfareBase et) ;
    void createBatch(List<SocSelfareBase> list) ;
    boolean update(SocSelfareBase et) ;
    void updateBatch(List<SocSelfareBase> list) ;
    SocSelfareBase get(String key) ;
    Page<SocSelfareBase> searchDefault(SocSelfareBaseSearchContext context) ;
    List<SocSelfareBase> selectByOrmorgid(String orgid) ;
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

    List<SocSelfareBase> getSocselfarebaseByIds(List<String> ids) ;
    List<SocSelfareBase> getSocselfarebaseByEntities(List<SocSelfareBase> entities) ;

}


