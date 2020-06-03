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

import cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx;
import cn.ibizlab.ehr.core.soc.filter.SocSelfarebasemxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocSelfarebasemx] 服务对象接口
 */
public interface ISocSelfarebasemxService extends IService<SocSelfarebasemx>{

    boolean checkKey(SocSelfarebasemx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SocSelfarebasemx get(String key) ;
    SocSelfarebasemx getDraft(SocSelfarebasemx et) ;
    boolean create(SocSelfarebasemx et) ;
    void createBatch(List<SocSelfarebasemx> list) ;
    boolean save(SocSelfarebasemx et) ;
    void saveBatch(List<SocSelfarebasemx> list) ;
    boolean update(SocSelfarebasemx et) ;
    void updateBatch(List<SocSelfarebasemx> list) ;
    Page<SocSelfarebasemx> searchDefault(SocSelfarebasemxSearchContext context) ;
    List<SocSelfarebasemx> selectBySoccompanywelid(String soccompanywelid) ;
    void removeBySoccompanywelid(String soccompanywelid) ;
    List<SocSelfarebasemx> selectBySocselfarebaseid(String socselfarebaseid) ;
    void removeBySocselfarebaseid(String socselfarebaseid) ;
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

    List<SocSelfarebasemx> getSocselfarebasemxByIds(List<String> ids) ;
    List<SocSelfarebasemx> getSocselfarebasemxByEntities(List<SocSelfarebasemx> entities) ;

}


