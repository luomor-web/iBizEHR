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

import cn.ibizlab.ehr.core.pim.domain.PIMPROVINCE;
import cn.ibizlab.ehr.core.pim.filter.PIMPROVINCESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPROVINCE] 服务对象接口
 */
public interface IPIMPROVINCEService extends IService<PIMPROVINCE>{

    boolean checkKey(PIMPROVINCE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMPROVINCE get(String key) ;
    boolean create(PIMPROVINCE et) ;
    void createBatch(List<PIMPROVINCE> list) ;
    PIMPROVINCE getDraft(PIMPROVINCE et) ;
    boolean update(PIMPROVINCE et) ;
    void updateBatch(List<PIMPROVINCE> list) ;
    boolean save(PIMPROVINCE et) ;
    void saveBatch(List<PIMPROVINCE> list) ;
    Page<PIMPROVINCE> searchDefault(PIMPROVINCESearchContext context) ;
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


