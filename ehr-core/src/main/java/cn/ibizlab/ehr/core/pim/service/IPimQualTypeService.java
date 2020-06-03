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

import cn.ibizlab.ehr.core.pim.domain.PimQualType;
import cn.ibizlab.ehr.core.pim.filter.PimQualTypeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimQualType] 服务对象接口
 */
public interface IPimQualTypeService extends IService<PimQualType>{

    boolean create(PimQualType et) ;
    void createBatch(List<PimQualType> list) ;
    boolean save(PimQualType et) ;
    void saveBatch(List<PimQualType> list) ;
    boolean checkKey(PimQualType et) ;
    boolean update(PimQualType et) ;
    void updateBatch(List<PimQualType> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimQualType get(String key) ;
    PimQualType getDraft(PimQualType et) ;
    Page<PimQualType> searchDefault(PimQualTypeSearchContext context) ;
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

    List<PimQualType> getPimqualtypeByIds(List<String> ids) ;
    List<PimQualType> getPimqualtypeByEntities(List<PimQualType> entities) ;

}


