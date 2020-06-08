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

import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
import cn.ibizlab.ehr.core.trm.filter.TrmCouarrangeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmCouarrange] 服务对象接口
 */
public interface ITrmCouarrangeService extends IService<TrmCouarrange>{

    boolean create(TrmCouarrange et) ;
    void createBatch(List<TrmCouarrange> list) ;
    TrmCouarrange get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmCouarrange getDraft(TrmCouarrange et) ;
    boolean checkKey(TrmCouarrange et) ;
    boolean save(TrmCouarrange et) ;
    void saveBatch(List<TrmCouarrange> list) ;
    boolean update(TrmCouarrange et) ;
    void updateBatch(List<TrmCouarrange> list) ;
    Page<TrmCouarrange> searchDefault(TrmCouarrangeSearchContext context) ;
    List<TrmCouarrange> selectByTrmagencyrecordid(String trmagencyrecordid) ;
    void removeByTrmagencyrecordid(String trmagencyrecordid) ;
    List<TrmCouarrange> selectByTrmcoursesystemid(String trmcoursesystemid) ;
    void removeByTrmcoursesystemid(String trmcoursesystemid) ;
    List<TrmCouarrange> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
    List<TrmCouarrange> selectByTrmtrainaddressid(String trmtrainaddressid) ;
    void removeByTrmtrainaddressid(String trmtrainaddressid) ;
    List<TrmCouarrange> selectByTrmtrainagencyid(String trmtrainagencyid) ;
    void removeByTrmtrainagencyid(String trmtrainagencyid) ;
    List<TrmCouarrange> selectByTrmtraincourseid(String trmtraincourseid) ;
    void removeByTrmtraincourseid(String trmtraincourseid) ;
    List<TrmCouarrange> selectByTrmtrainfaciesid(String trmtrainfaciesid) ;
    void removeByTrmtrainfaciesid(String trmtrainfaciesid) ;
    List<TrmCouarrange> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TrmCouarrange> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
    List<TrmCouarrange> selectByTrmtrianpersonid(String trmtrianpersonid) ;
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

    List<TrmCouarrange> getTrmcouarrangeByIds(List<String> ids) ;
    List<TrmCouarrange> getTrmcouarrangeByEntities(List<TrmCouarrange> entities) ;

}


