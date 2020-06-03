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

import cn.ibizlab.ehr.core.soc.domain.SocCompanyWel;
import cn.ibizlab.ehr.core.soc.filter.SocCompanyWelSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocCompanyWel] 服务对象接口
 */
public interface ISocCompanyWelService extends IService<SocCompanyWel>{

    boolean create(SocCompanyWel et) ;
    void createBatch(List<SocCompanyWel> list) ;
    boolean checkKey(SocCompanyWel et) ;
    boolean save(SocCompanyWel et) ;
    void saveBatch(List<SocCompanyWel> list) ;
    boolean update(SocCompanyWel et) ;
    void updateBatch(List<SocCompanyWel> list) ;
    SocCompanyWel get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SocCompanyWel getDraft(SocCompanyWel et) ;
    Page<SocCompanyWel> searchDefault(SocCompanyWelSearchContext context) ;
    List<SocCompanyWel> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<SocCompanyWel> selectBySocselfarebaseid(String socselfarebaseid) ;
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

    List<SocCompanyWel> getSoccompanywelByIds(List<String> ids) ;
    List<SocCompanyWel> getSoccompanywelByEntities(List<SocCompanyWel> entities) ;

}


