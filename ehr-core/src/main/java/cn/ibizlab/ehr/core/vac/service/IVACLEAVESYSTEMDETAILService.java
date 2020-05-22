package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEMDETAIL;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVESYSTEMDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEAVESYSTEMDETAIL] 服务对象接口
 */
public interface IVACLEAVESYSTEMDETAILService extends IService<VACLEAVESYSTEMDETAIL>{

    boolean update(VACLEAVESYSTEMDETAIL et) ;
    void updateBatch(List<VACLEAVESYSTEMDETAIL> list) ;
    boolean checkKey(VACLEAVESYSTEMDETAIL et) ;
    boolean save(VACLEAVESYSTEMDETAIL et) ;
    void saveBatch(List<VACLEAVESYSTEMDETAIL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VACLEAVESYSTEMDETAIL getDraft(VACLEAVESYSTEMDETAIL et) ;
    VACLEAVESYSTEMDETAIL get(String key) ;
    boolean create(VACLEAVESYSTEMDETAIL et) ;
    void createBatch(List<VACLEAVESYSTEMDETAIL> list) ;
    Page<VACLEAVESYSTEMDETAIL> searchDefault(VACLEAVESYSTEMDETAILSearchContext context) ;
    List<VACLEAVESYSTEMDETAIL> selectByVacleavesystemid(String vacleavesystemid) ;
    void removeByVacleavesystemid(String vacleavesystemid) ;
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


