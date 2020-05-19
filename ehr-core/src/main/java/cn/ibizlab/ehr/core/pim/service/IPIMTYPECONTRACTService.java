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

import cn.ibizlab.ehr.core.pim.domain.PIMTYPECONTRACT;
import cn.ibizlab.ehr.core.pim.filter.PIMTYPECONTRACTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMTYPECONTRACT] 服务对象接口
 */
public interface IPIMTYPECONTRACTService extends IService<PIMTYPECONTRACT>{

    boolean update(PIMTYPECONTRACT et) ;
    void updateBatch(List<PIMTYPECONTRACT> list) ;
    boolean checkKey(PIMTYPECONTRACT et) ;
    PIMTYPECONTRACT get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PIMTYPECONTRACT et) ;
    void createBatch(List<PIMTYPECONTRACT> list) ;
    boolean save(PIMTYPECONTRACT et) ;
    void saveBatch(List<PIMTYPECONTRACT> list) ;
    PIMTYPECONTRACT getDraft(PIMTYPECONTRACT et) ;
    Page<PIMTYPECONTRACT> searchDefault(PIMTYPECONTRACTSearchContext context) ;
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


