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

import cn.ibizlab.ehr.core.pim.domain.PimQualMajor;
import cn.ibizlab.ehr.core.pim.filter.PimQualMajorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimQualMajor] 服务对象接口
 */
public interface IPimQualMajorService extends IService<PimQualMajor>{

    boolean create(PimQualMajor et) ;
    void createBatch(List<PimQualMajor> list) ;
    boolean checkKey(PimQualMajor et) ;
    boolean update(PimQualMajor et) ;
    void updateBatch(List<PimQualMajor> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimQualMajor getDraft(PimQualMajor et) ;
    boolean save(PimQualMajor et) ;
    void saveBatch(List<PimQualMajor> list) ;
    PimQualMajor get(String key) ;
    Page<PimQualMajor> searchDefault(PimQualMajorSearchContext context) ;
    Page<PimQualMajor> searchXZZGZY(PimQualMajorSearchContext context) ;
    List<PimQualMajor> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PimQualMajor> selectByPimqualtypeid(String pimqualtypeid) ;
    void removeByPimqualtypeid(String pimqualtypeid) ;
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

    List<PimQualMajor> getPimqualmajorByIds(List<String> ids) ;
    List<PimQualMajor> getPimqualmajorByEntities(List<PimQualMajor> entities) ;

}


