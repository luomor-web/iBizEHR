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

import cn.ibizlab.ehr.core.pim.domain.PimStafftype;
import cn.ibizlab.ehr.core.pim.filter.PimStafftypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimStafftype] 服务对象接口
 */
public interface IPimStafftypeService extends IService<PimStafftype>{

    boolean checkKey(PimStafftype et) ;
    PimStafftype get(String key) ;
    PimStafftype getDraft(PimStafftype et) ;
    boolean create(PimStafftype et) ;
    void createBatch(List<PimStafftype> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PimStafftype et) ;
    void saveBatch(List<PimStafftype> list) ;
    boolean update(PimStafftype et) ;
    void updateBatch(List<PimStafftype> list) ;
    Page<PimStafftype> searchDefault(PimStafftypeSearchContext context) ;
    Page<PimStafftype> searchYPZ(PimStafftypeSearchContext context) ;
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

    List<PimStafftype> getPimstafftypeByIds(List<String> ids) ;
    List<PimStafftype> getPimstafftypeByEntities(List<PimStafftype> entities) ;

}


