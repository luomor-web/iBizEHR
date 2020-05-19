package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PIMOUTPUT;
import cn.ibizlab.ehr.core.pim.filter.PIMOUTPUTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMOUTPUT] 服务对象接口
 */
public interface IPIMOUTPUTService extends IService<PIMOUTPUT>{

    boolean update(PIMOUTPUT et) ;
    void updateBatch(List<PIMOUTPUT> list) ;
    PIMOUTPUT get(String key) ;
    boolean create(PIMOUTPUT et) ;
    void createBatch(List<PIMOUTPUT> list) ;
    boolean checkKey(PIMOUTPUT et) ;
    PIMOUTPUT getDraft(PIMOUTPUT et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMOUTPUT et) ;
    void saveBatch(List<PIMOUTPUT> list) ;
    Page<PIMOUTPUT> searchCurOrg(PIMOUTPUTSearchContext context) ;
    Page<PIMOUTPUT> searchDefault(PIMOUTPUTSearchContext context) ;
    Page<HashMap> searchREP_OUTPUT(PIMOUTPUTSearchContext context) ;
    List<PIMOUTPUT> selectByOrmorgid(String orgid) ;
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


