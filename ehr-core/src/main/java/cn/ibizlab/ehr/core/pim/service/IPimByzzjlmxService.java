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

import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
import cn.ibizlab.ehr.core.pim.filter.PimByzzjlmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimByzzjlmx] 服务对象接口
 */
public interface IPimByzzjlmxService extends IService<PimByzzjlmx>{

    PimByzzjlmx sHTG(PimByzzjlmx et) ;
    PimByzzjlmx get(String key) ;
    PimByzzjlmx returnYPZ(PimByzzjlmx et) ;
    PimByzzjlmx jSPTG(PimByzzjlmx et) ;
    PimByzzjlmx fillPersonInfo(PimByzzjlmx et) ;
    PimByzzjlmx getDraft(PimByzzjlmx et) ;
    PimByzzjlmx jSHTG(PimByzzjlmx et) ;
    PimByzzjlmx jSHBTG(PimByzzjlmx et) ;
    PimByzzjlmx ensure(PimByzzjlmx et) ;
    PimByzzjlmx sHBTG(PimByzzjlmx et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimByzzjlmx gSDSZSP(PimByzzjlmx et) ;
    PimByzzjlmx zZCZ(PimByzzjlmx et) ;
    PimByzzjlmx dSB(PimByzzjlmx et) ;
    boolean update(PimByzzjlmx et) ;
    void updateBatch(List<PimByzzjlmx> list) ;
    boolean create(PimByzzjlmx et) ;
    void createBatch(List<PimByzzjlmx> list) ;
    PimByzzjlmx jZBSHQR(PimByzzjlmx et) ;
    PimByzzjlmx gSDSZSPBTG(PimByzzjlmx et) ;
    PimByzzjlmx gSCSBTG(PimByzzjlmx et) ;
    PimByzzjlmx jSPBTG(PimByzzjlmx et) ;
    boolean save(PimByzzjlmx et) ;
    void saveBatch(List<PimByzzjlmx> list) ;
    PimByzzjlmx gSCS(PimByzzjlmx et) ;
    boolean checkKey(PimByzzjlmx et) ;
    PimByzzjlmx updatePeopleNum(PimByzzjlmx et) ;
    PimByzzjlmx jZBSPQR(PimByzzjlmx et) ;
    Page<PimByzzjlmx> searchZZWSHDS(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchUnApproved(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDDJZBSH(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchBYLZZJL(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDGSDSZSH(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchHTRY(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDJZBSP(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDSB(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchFinishYGBH(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDJZBSH(PimByzzjlmxSearchContext context) ;
    Page<PimByzzjlmx> searchDefault(PimByzzjlmxSearchContext context) ;
    List<PimByzzjlmx> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PimByzzjlmx> selectByPimbyygzzsqid(String pimbyygzzsqid) ;
    void removeByPimbyygzzsqid(String pimbyygzzsqid) ;
    List<PimByzzjlmx> selectByPimexaminationresultsid(String pimexaminationresultsid) ;
    void removeByPimexaminationresultsid(String pimexaminationresultsid) ;
    List<PimByzzjlmx> selectByPimpersonid(String pimpersonid) ;
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

    List<PimByzzjlmx> getPimbyzzjlmxByIds(List<String> ids) ;
    List<PimByzzjlmx> getPimbyzzjlmxByEntities(List<PimByzzjlmx> entities) ;

}


