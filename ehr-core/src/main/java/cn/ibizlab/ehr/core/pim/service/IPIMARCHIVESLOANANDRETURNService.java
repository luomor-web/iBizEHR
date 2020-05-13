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

import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESLOANANDRETURN;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESLOANANDRETURNSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMARCHIVESLOANANDRETURN] 服务对象接口
 */
public interface IPIMARCHIVESLOANANDRETURNService extends IService<PIMARCHIVESLOANANDRETURN>{

    PIMARCHIVESLOANANDRETURN get(String key) ;
    boolean update(PIMARCHIVESLOANANDRETURN et) ;
    void updateBatch(List<PIMARCHIVESLOANANDRETURN> list) ;
    boolean create(PIMARCHIVESLOANANDRETURN et) ;
    void createBatch(List<PIMARCHIVESLOANANDRETURN> list) ;
    PIMARCHIVESLOANANDRETURN getDraft(PIMARCHIVESLOANANDRETURN et) ;
    boolean checkKey(PIMARCHIVESLOANANDRETURN et) ;
    PIMARCHIVESLOANANDRETURN updateState(PIMARCHIVESLOANANDRETURN et) ;
    boolean save(PIMARCHIVESLOANANDRETURN et) ;
    void saveBatch(List<PIMARCHIVESLOANANDRETURN> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMARCHIVESLOANANDRETURN updateArchiveState(PIMARCHIVESLOANANDRETURN et) ;
    Page<PIMARCHIVESLOANANDRETURN> searchDefault(PIMARCHIVESLOANANDRETURNSearchContext context) ;
    List<PIMARCHIVESLOANANDRETURN> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
    List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid2(String pimpersonid) ;
    void removeByPimpersonid2(String pimpersonid) ;
    List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid3(String pimpersonid) ;
    void removeByPimpersonid3(String pimpersonid) ;
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


