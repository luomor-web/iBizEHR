package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE;
import cn.ibizlab.ehr.core.pim.filter.PIMENCLOSURESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMENCLOSURE] 服务对象接口
 */
public interface IPIMENCLOSUREService extends IService<PIMENCLOSURE>{

    PIMENCLOSURE getDraft(PIMENCLOSURE et) ;
    boolean checkKey(PIMENCLOSURE et) ;
    boolean save(PIMENCLOSURE et) ;
    void saveBatch(List<PIMENCLOSURE> list) ;
    boolean update(PIMENCLOSURE et) ;
    void updateBatch(List<PIMENCLOSURE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PIMENCLOSURE et) ;
    void createBatch(List<PIMENCLOSURE> list) ;
    PIMENCLOSURE get(String key) ;
    Page<PIMENCLOSURE> searchPCMPROFILE_FJ(PIMENCLOSURESearchContext context) ;
    Page<PIMENCLOSURE> searchDefault(PIMENCLOSURESearchContext context) ;
    List<PIMENCLOSURE> selectByPimpersonid(String pimpersonid) ;
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

}


