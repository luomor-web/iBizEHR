package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACSITUATION;
import cn.ibizlab.ehr.core.vac.filter.VACSITUATIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACSITUATION] 服务对象接口
 */
public interface IVACSITUATIONService extends IService<VACSITUATION>{

    boolean update(VACSITUATION et) ;
    void updateBatch(List<VACSITUATION> list) ;
    boolean create(VACSITUATION et) ;
    void createBatch(List<VACSITUATION> list) ;
    boolean checkKey(VACSITUATION et) ;
    VACSITUATION getDraft(VACSITUATION et) ;
    boolean save(VACSITUATION et) ;
    void saveBatch(List<VACSITUATION> list) ;
    VACSITUATION get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<VACSITUATION> searchDefault(VACSITUATIONSearchContext context) ;
    List<VACSITUATION> selectByPimpersonid(String pimpersonid) ;
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

    List<VACSITUATION> getVacsituationByIds(List<String> ids) ;
    List<VACSITUATION> getVacsituationByEntities(List<VACSITUATION> entities) ;

}


