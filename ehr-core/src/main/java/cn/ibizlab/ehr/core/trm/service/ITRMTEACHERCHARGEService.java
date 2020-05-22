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

import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERCHARGE;
import cn.ibizlab.ehr.core.trm.filter.TRMTEACHERCHARGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTEACHERCHARGE] 服务对象接口
 */
public interface ITRMTEACHERCHARGEService extends IService<TRMTEACHERCHARGE>{

    boolean save(TRMTEACHERCHARGE et) ;
    void saveBatch(List<TRMTEACHERCHARGE> list) ;
    TRMTEACHERCHARGE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(TRMTEACHERCHARGE et) ;
    void updateBatch(List<TRMTEACHERCHARGE> list) ;
    boolean create(TRMTEACHERCHARGE et) ;
    void createBatch(List<TRMTEACHERCHARGE> list) ;
    TRMTEACHERCHARGE getDraft(TRMTEACHERCHARGE et) ;
    boolean checkKey(TRMTEACHERCHARGE et) ;
    Page<TRMTEACHERCHARGE> searchDefault(TRMTEACHERCHARGESearchContext context) ;
    List<TRMTEACHERCHARGE> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
    List<TRMTEACHERCHARGE> selectByTrmtrainteacherid(String trmtrainteacherid) ;
    void removeByTrmtrainteacherid(String trmtrainteacherid) ;
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


