package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE;
import cn.ibizlab.ehr.core.trm.filter.TRMCOUARRANGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMCOUARRANGE] 服务对象接口
 */
public interface ITRMCOUARRANGEService extends IService<TRMCOUARRANGE>{

    boolean create(TRMCOUARRANGE et) ;
    void createBatch(List<TRMCOUARRANGE> list) ;
    TRMCOUARRANGE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMCOUARRANGE getDraft(TRMCOUARRANGE et) ;
    boolean checkKey(TRMCOUARRANGE et) ;
    boolean save(TRMCOUARRANGE et) ;
    void saveBatch(List<TRMCOUARRANGE> list) ;
    boolean update(TRMCOUARRANGE et) ;
    void updateBatch(List<TRMCOUARRANGE> list) ;
    Page<TRMCOUARRANGE> searchDefault(TRMCOUARRANGESearchContext context) ;
    List<TRMCOUARRANGE> selectByTrmagencyrecordid(String trmagencyrecordid) ;
    void removeByTrmagencyrecordid(String trmagencyrecordid) ;
    List<TRMCOUARRANGE> selectByTrmcoursesystemid(String trmcoursesystemid) ;
    void removeByTrmcoursesystemid(String trmcoursesystemid) ;
    List<TRMCOUARRANGE> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
    List<TRMCOUARRANGE> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
    List<TRMCOUARRANGE> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TRMCOUARRANGE> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TRMCOUARRANGE> selectByTrmtrainfaciesid(String trmtrainfaciesid) ;
    void removeByTrmtrainfaciesid(String trmtrainfaciesid) ;
    List<TRMCOUARRANGE> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TRMCOUARRANGE> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
    List<TRMCOUARRANGE> selectByTrmtrianpersonid(String trmtrianpersonid) ;
    void removeByTrmtrianpersonid(String trmtrianpersonid) ;
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


