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

import cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTMENT;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINACTMENTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRAINACTMENT] 服务对象接口
 */
public interface ITRMTRAINACTMENTService extends IService<TRMTRAINACTMENT>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TRMTRAINACTMENT getDraft(TRMTRAINACTMENT et) ;
    boolean checkKey(TRMTRAINACTMENT et) ;
    TRMTRAINACTMENT get(String key) ;
    boolean save(TRMTRAINACTMENT et) ;
    void saveBatch(List<TRMTRAINACTMENT> list) ;
    boolean create(TRMTRAINACTMENT et) ;
    void createBatch(List<TRMTRAINACTMENT> list) ;
    boolean update(TRMTRAINACTMENT et) ;
    void updateBatch(List<TRMTRAINACTMENT> list) ;
    Page<TRMTRAINACTMENT> searchDefault(TRMTRAINACTMENTSearchContext context) ;
    List<TRMTRAINACTMENT> selectByTrmtrainactapplyid(String trmtrainactapplyid) ;
    void removeByTrmtrainactapplyid(String trmtrainactapplyid) ;
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


