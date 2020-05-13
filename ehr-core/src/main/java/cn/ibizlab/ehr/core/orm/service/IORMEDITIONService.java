package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.ORMEDITION;
import cn.ibizlab.ehr.core.orm.filter.ORMEDITIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMEDITION] 服务对象接口
 */
public interface IORMEDITIONService extends IService<ORMEDITION>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(ORMEDITION et) ;
    void createBatch(List<ORMEDITION> list) ;
    boolean save(ORMEDITION et) ;
    void saveBatch(List<ORMEDITION> list) ;
    ORMEDITION getDraft(ORMEDITION et) ;
    boolean update(ORMEDITION et) ;
    void updateBatch(List<ORMEDITION> list) ;
    boolean checkKey(ORMEDITION et) ;
    ORMEDITION get(String key) ;
    Page<ORMEDITION> searchDefault(ORMEDITIONSearchContext context) ;
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


