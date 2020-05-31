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

import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmDdsqdmx] 服务对象接口
 */
public interface IPcmDdsqdmxService extends IService<PcmDdsqdmx>{

    boolean update(PcmDdsqdmx et) ;
    void updateBatch(List<PcmDdsqdmx> list) ;
    PcmDdsqdmx dDUpdate(PcmDdsqdmx et) ;
    PcmDdsqdmx sQBTG(PcmDdsqdmx et) ;
    PcmDdsqdmx jDCZ(PcmDdsqdmx et) ;
    PcmDdsqdmx getDraft(PcmDdsqdmx et) ;
    boolean create(PcmDdsqdmx et) ;
    void createBatch(List<PcmDdsqdmx> list) ;
    PcmDdsqdmx dDCreate(PcmDdsqdmx et) ;
    PcmDdsqdmx get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PcmDdsqdmx zZSQ(PcmDdsqdmx et) ;
    boolean checkKey(PcmDdsqdmx et) ;
    PcmDdsqdmx dDCZ(PcmDdsqdmx et) ;
    PcmDdsqdmx sQTG(PcmDdsqdmx et) ;
    boolean save(PcmDdsqdmx et) ;
    void saveBatch(List<PcmDdsqdmx> list) ;
    PcmDdsqdmx jZCZ(PcmDdsqdmx et) ;
    Page<PcmDdsqdmx> searchJZSQMX(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchJDSQGR(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchDefault(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchJDSQMX(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchDDJL(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchGBDDJL(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchDDSQGR(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchDDMX(PcmDdsqdmxSearchContext context) ;
    Page<PcmDdsqdmx> searchJZSQGR(PcmDdsqdmxSearchContext context) ;
    List<PcmDdsqdmx> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmDdsqdmx> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<PcmDdsqdmx> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
    List<PcmDdsqdmx> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PcmDdsqdmx> selectByPcmddsqdid(String pcmddsqdid) ;
    void removeByPcmddsqdid(String pcmddsqdid) ;
    List<PcmDdsqdmx> selectByPimdistirbutionid(String pimdistirbutionid) ;
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

    List<PcmDdsqdmx> getPcmddsqdmxByIds(List<String> ids) ;
    List<PcmDdsqdmx> getPcmddsqdmxByEntities(List<PcmDdsqdmx> entities) ;

}


