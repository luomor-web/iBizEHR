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

import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZRATE;
import cn.ibizlab.ehr.core.sal.filter.SALSTDXMGZRATESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SALSTDXMGZRATE] 服务对象接口
 */
public interface ISALSTDXMGZRATEService extends IService<SALSTDXMGZRATE>{

    SALSTDXMGZRATE getDraft(SALSTDXMGZRATE et) ;
    boolean checkKey(SALSTDXMGZRATE et) ;
    boolean save(SALSTDXMGZRATE et) ;
    void saveBatch(List<SALSTDXMGZRATE> list) ;
    boolean create(SALSTDXMGZRATE et) ;
    void createBatch(List<SALSTDXMGZRATE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SALSTDXMGZRATE get(String key) ;
    boolean update(SALSTDXMGZRATE et) ;
    void updateBatch(List<SALSTDXMGZRATE> list) ;
    Page<SALSTDXMGZRATE> searchDefault(SALSTDXMGZRATESearchContext context) ;
    List<SALSTDXMGZRATE> selectByOrmorgid(String orgid) ;
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


