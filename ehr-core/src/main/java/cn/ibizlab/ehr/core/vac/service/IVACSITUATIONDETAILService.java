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

import cn.ibizlab.ehr.core.vac.domain.VACSITUATIONDETAIL;
import cn.ibizlab.ehr.core.vac.filter.VACSITUATIONDETAILSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACSITUATIONDETAIL] 服务对象接口
 */
public interface IVACSITUATIONDETAILService extends IService<VACSITUATIONDETAIL>{

    boolean update(VACSITUATIONDETAIL et) ;
    void updateBatch(List<VACSITUATIONDETAIL> list) ;
    VACSITUATIONDETAIL getDraft(VACSITUATIONDETAIL et) ;
    boolean create(VACSITUATIONDETAIL et) ;
    void createBatch(List<VACSITUATIONDETAIL> list) ;
    VACSITUATIONDETAIL get(String key) ;
    boolean checkKey(VACSITUATIONDETAIL et) ;
    boolean save(VACSITUATIONDETAIL et) ;
    void saveBatch(List<VACSITUATIONDETAIL> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<VACSITUATIONDETAIL> searchDefault(VACSITUATIONDETAILSearchContext context) ;
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


