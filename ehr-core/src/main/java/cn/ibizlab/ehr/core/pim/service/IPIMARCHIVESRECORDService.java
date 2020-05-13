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

import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESRECORD;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESRECORDSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMARCHIVESRECORD] 服务对象接口
 */
public interface IPIMARCHIVESRECORDService extends IService<PIMARCHIVESRECORD>{

    boolean create(PIMARCHIVESRECORD et) ;
    void createBatch(List<PIMARCHIVESRECORD> list) ;
    boolean save(PIMARCHIVESRECORD et) ;
    void saveBatch(List<PIMARCHIVESRECORD> list) ;
    boolean update(PIMARCHIVESRECORD et) ;
    void updateBatch(List<PIMARCHIVESRECORD> list) ;
    boolean checkKey(PIMARCHIVESRECORD et) ;
    PIMARCHIVESRECORD get(String key) ;
    PIMARCHIVESRECORD getDraft(PIMARCHIVESRECORD et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMARCHIVESRECORD> searchDefault(PIMARCHIVESRECORDSearchContext context) ;
    List<PIMARCHIVESRECORD> selectByArchivalcatalogueid(String archivalcatalogueid) ;
    void removeByArchivalcatalogueid(String archivalcatalogueid) ;
    List<PIMARCHIVESRECORD> selectByPimarchivesid(String pimarchivesid) ;
    void removeByPimarchivesid(String pimarchivesid) ;
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


