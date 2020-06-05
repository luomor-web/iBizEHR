package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjdmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdjdmx] 服务对象接口
 */
public interface IPcmYdjdmxService extends IService<PcmYdjdmx>{

    PcmYdjdmx get(String key) ;
    PcmYdjdmx getDraft(PcmYdjdmx et) ;
    boolean update(PcmYdjdmx et) ;
    void updateBatch(List<PcmYdjdmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmYdjdmx personBack(PcmYdjdmx et) ;
    PcmYdjdmx personInfo(PcmYdjdmx et) ;
    boolean checkKey(PcmYdjdmx et) ;
    boolean save(PcmYdjdmx et) ;
    void saveBatch(List<PcmYdjdmx> list) ;
    boolean create(PcmYdjdmx et) ;
    void createBatch(List<PcmYdjdmx> list) ;
    Page<PcmYdjdmx> searchJDGLDQ(PcmYdjdmxSearchContext context) ;
    Page<PcmYdjdmx> searchJDLSJLDQ(PcmYdjdmxSearchContext context) ;
    Page<PcmYdjdmx> searchDefault(PcmYdjdmxSearchContext context) ;
    List<PcmYdjdmx> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmYdjdmx> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmYdjdmx> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmYdjdmx> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PcmYdjdmx> selectByPimdistirbutionid(String pimdistirbutionid) ;
    void removeByPimdistirbutionid(String pimdistirbutionid) ;
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

    List<PcmYdjdmx> getPcmydjdmxByIds(List<String> ids) ;
    List<PcmYdjdmx> getPcmydjdmxByEntities(List<PcmYdjdmx> entities) ;

}


