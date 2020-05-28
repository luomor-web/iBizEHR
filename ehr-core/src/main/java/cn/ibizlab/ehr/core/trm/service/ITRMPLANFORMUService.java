package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMPLANFORMU;
import cn.ibizlab.ehr.core.trm.filter.TRMPLANFORMUSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMPLANFORMU] 服务对象接口
 */
public interface ITRMPLANFORMUService extends IService<TRMPLANFORMU>{

    boolean save(TRMPLANFORMU et) ;
    void saveBatch(List<TRMPLANFORMU> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMPLANFORMU get(String key) ;
    boolean update(TRMPLANFORMU et) ;
    void updateBatch(List<TRMPLANFORMU> list) ;
    boolean create(TRMPLANFORMU et) ;
    void createBatch(List<TRMPLANFORMU> list) ;
    TRMPLANFORMU getDraft(TRMPLANFORMU et) ;
    boolean checkKey(TRMPLANFORMU et) ;
    Page<TRMPLANFORMU> searchDefault(TRMPLANFORMUSearchContext context) ;
    List<TRMPLANFORMU> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TRMPLANFORMU> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TRMPLANFORMU> selectByPimpersonid(String pimpersonid) ;
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

    List<TRMPLANFORMU> getTrmplanformuByIds(List<String> ids) ;
    List<TRMPLANFORMU> getTrmplanformuByEntities(List<TRMPLANFORMU> entities) ;

}


