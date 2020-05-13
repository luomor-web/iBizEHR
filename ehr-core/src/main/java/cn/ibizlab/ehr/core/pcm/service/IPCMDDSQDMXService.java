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

import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMDDSQDMX] 服务对象接口
 */
public interface IPCMDDSQDMXService extends IService<PCMDDSQDMX>{

    boolean update(PCMDDSQDMX et) ;
    void updateBatch(List<PCMDDSQDMX> list) ;
    PCMDDSQDMX dDUpdate(PCMDDSQDMX et) ;
    PCMDDSQDMX sQBTG(PCMDDSQDMX et) ;
    PCMDDSQDMX jDCZ(PCMDDSQDMX et) ;
    PCMDDSQDMX getDraft(PCMDDSQDMX et) ;
    boolean create(PCMDDSQDMX et) ;
    void createBatch(List<PCMDDSQDMX> list) ;
    PCMDDSQDMX dDCreate(PCMDDSQDMX et) ;
    PCMDDSQDMX get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMDDSQDMX zZSQ(PCMDDSQDMX et) ;
    boolean checkKey(PCMDDSQDMX et) ;
    PCMDDSQDMX dDCZ(PCMDDSQDMX et) ;
    PCMDDSQDMX sQTG(PCMDDSQDMX et) ;
    boolean save(PCMDDSQDMX et) ;
    void saveBatch(List<PCMDDSQDMX> list) ;
    PCMDDSQDMX jZCZ(PCMDDSQDMX et) ;
    Page<PCMDDSQDMX> searchJZSQMX(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchJDSQGR(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchDefault(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchJDSQMX(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchDDJL(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchGBDDJL(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchDDSQGR(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchDDMX(PCMDDSQDMXSearchContext context) ;
    Page<PCMDDSQDMX> searchJZSQGR(PCMDDSQDMXSearchContext context) ;
    List<PCMDDSQDMX> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMDDSQDMX> selectByOrgsectorid(String orgsectorid) ;
    void removeByOrgsectorid(String orgsectorid) ;
    List<PCMDDSQDMX> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
    List<PCMDDSQDMX> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PCMDDSQDMX> selectByPcmddsqdid(String pcmddsqdid) ;
    void removeByPcmddsqdid(String pcmddsqdid) ;
    List<PCMDDSQDMX> selectByPimdistirbutionid(String pimdistirbutionid) ;
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

}


