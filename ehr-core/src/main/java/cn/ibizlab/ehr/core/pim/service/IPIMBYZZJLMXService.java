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

import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;
import cn.ibizlab.ehr.core.pim.filter.PIMBYZZJLMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMBYZZJLMX] 服务对象接口
 */
public interface IPIMBYZZJLMXService extends IService<PIMBYZZJLMX>{

    PIMBYZZJLMX sHTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX get(String key) ;
    PIMBYZZJLMX returnYPZ(PIMBYZZJLMX et) ;
    PIMBYZZJLMX jSPTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX fillPersonInfo(PIMBYZZJLMX et) ;
    PIMBYZZJLMX getDraft(PIMBYZZJLMX et) ;
    PIMBYZZJLMX jSHTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX jSHBTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX ensure(PIMBYZZJLMX et) ;
    PIMBYZZJLMX sHBTG(PIMBYZZJLMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMBYZZJLMX gSDSZSP(PIMBYZZJLMX et) ;
    PIMBYZZJLMX zZCZ(PIMBYZZJLMX et) ;
    PIMBYZZJLMX dSB(PIMBYZZJLMX et) ;
    boolean update(PIMBYZZJLMX et) ;
    void updateBatch(List<PIMBYZZJLMX> list) ;
    boolean create(PIMBYZZJLMX et) ;
    void createBatch(List<PIMBYZZJLMX> list) ;
    PIMBYZZJLMX jZBSHQR(PIMBYZZJLMX et) ;
    PIMBYZZJLMX gSDSZSPBTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX gSCSBTG(PIMBYZZJLMX et) ;
    PIMBYZZJLMX jSPBTG(PIMBYZZJLMX et) ;
    boolean save(PIMBYZZJLMX et) ;
    void saveBatch(List<PIMBYZZJLMX> list) ;
    PIMBYZZJLMX gSCS(PIMBYZZJLMX et) ;
    boolean checkKey(PIMBYZZJLMX et) ;
    PIMBYZZJLMX updatePeopleNum(PIMBYZZJLMX et) ;
    PIMBYZZJLMX jZBSPQR(PIMBYZZJLMX et) ;
    Page<PIMBYZZJLMX> searchZZWSHDS(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchUnApproved(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDDJZBSH(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchBYLZZJL(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDGSDSZSH(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchHTRY(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDJZBSP(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDSB(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchFinishYGBH(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDJZBSH(PIMBYZZJLMXSearchContext context) ;
    Page<PIMBYZZJLMX> searchDefault(PIMBYZZJLMXSearchContext context) ;
    List<PIMBYZZJLMX> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PIMBYZZJLMX> selectByPimbyygzzsqid(String pimbyygzzsqid) ;
    void removeByPimbyygzzsqid(String pimbyygzzsqid) ;
    List<PIMBYZZJLMX> selectByPimexaminationresultsid(String pimexaminationresultsid) ;
    void removeByPimexaminationresultsid(String pimexaminationresultsid) ;
    List<PIMBYZZJLMX> selectByPimpersonid(String pimpersonid) ;
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

}


