package cn.ibizlab.ehr.core.sal.service;

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

import cn.ibizlab.ehr.core.sal.domain.SALSTDZX;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDZX] 服务对象接口
 */
public interface ISALSTDZXService extends IService<SALSTDZX>{

    boolean save(SALSTDZX et) ;
    void saveBatch(List<SALSTDZX> list) ;
    SALSTDZX get(String key) ;
    boolean update(SALSTDZX et) ;
    void updateBatch(List<SALSTDZX> list) ;
    boolean create(SALSTDZX et) ;
    void createBatch(List<SALSTDZX> list) ;
    SALSTDZX getDraft(SALSTDZX et) ;
    boolean checkKey(SALSTDZX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<SALSTDZX> searchDefault(SALSTDZXSearchContext context) ;
    List<SALSTDZX> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<SALSTDZX> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


