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

import cn.ibizlab.ehr.core.pcm.domain.PcmYdlzmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdlzmxSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmYdlzmx] 服务对象接口
 */
public interface IPcmYdlzmxService extends IService<PcmYdlzmx>{

    boolean update(PcmYdlzmx et) ;
    void updateBatch(List<PcmYdlzmx> list) ;
    PcmYdlzmx isFinished(PcmYdlzmx et) ;
    PcmYdlzmx fillPersonInfo(PcmYdlzmx et) ;
    PcmYdlzmx get(String key) ;
    boolean create(PcmYdlzmx et) ;
    void createBatch(List<PcmYdlzmx> list) ;
    boolean checkKey(PcmYdlzmx et) ;
    PcmYdlzmx getDraft(PcmYdlzmx et) ;
    boolean save(PcmYdlzmx et) ;
    void saveBatch(List<PcmYdlzmx> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmYdlzmx> searchGLDQ(PcmYdlzmxSearchContext context) ;
    Page<PcmYdlzmx> searchJLDQ(PcmYdlzmxSearchContext context) ;
    Page<PcmYdlzmx> searchDefault(PcmYdlzmxSearchContext context) ;
    List<PcmYdlzmx> selectByLzmtrid(String pimpersonid) ;
    void removeByLzmtrid(String pimpersonid) ;
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

    List<PcmYdlzmx> getPcmydlzmxByIds(List<String> ids) ;
    List<PcmYdlzmx> getPcmydlzmxByEntities(List<PcmYdlzmx> entities) ;

}


