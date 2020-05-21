package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.OrgUnitCat;
import cn.ibizlab.ehr.core.common.filter.OrgUnitCatSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrgUnitCat] 服务对象接口
 */
public interface IOrgUnitCatService extends IService<OrgUnitCat>{

    boolean update(OrgUnitCat et) ;
    void updateBatch(List<OrgUnitCat> list) ;
    boolean create(OrgUnitCat et) ;
    void createBatch(List<OrgUnitCat> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    OrgUnitCat getDraft(OrgUnitCat et) ;
    boolean save(OrgUnitCat et) ;
    void saveBatch(List<OrgUnitCat> list) ;
    boolean checkKey(OrgUnitCat et) ;
    OrgUnitCat get(String key) ;
    Page<OrgUnitCat> searchDefault(OrgUnitCatSearchContext context) ;
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


