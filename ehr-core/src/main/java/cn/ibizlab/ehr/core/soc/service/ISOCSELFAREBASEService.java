package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASE;
import cn.ibizlab.ehr.core.soc.filter.SOCSELFAREBASESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SOCSELFAREBASE] 服务对象接口
 */
public interface ISOCSELFAREBASEService extends IService<SOCSELFAREBASE>{

    SOCSELFAREBASE getDraft(SOCSELFAREBASE et) ;
    boolean checkKey(SOCSELFAREBASE et) ;
    boolean save(SOCSELFAREBASE et) ;
    void saveBatch(List<SOCSELFAREBASE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SOCSELFAREBASE et) ;
    void createBatch(List<SOCSELFAREBASE> list) ;
    boolean update(SOCSELFAREBASE et) ;
    void updateBatch(List<SOCSELFAREBASE> list) ;
    SOCSELFAREBASE get(String key) ;
    Page<SOCSELFAREBASE> searchDefault(SOCSELFAREBASESearchContext context) ;
    List<SOCSELFAREBASE> selectByOrmorgid(String orgid) ;
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


