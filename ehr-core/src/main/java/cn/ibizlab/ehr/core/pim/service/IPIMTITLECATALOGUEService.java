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

import cn.ibizlab.ehr.core.pim.domain.PIMTITLECATALOGUE;
import cn.ibizlab.ehr.core.pim.filter.PIMTITLECATALOGUESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMTITLECATALOGUE] 服务对象接口
 */
public interface IPIMTITLECATALOGUEService extends IService<PIMTITLECATALOGUE>{

    boolean save(PIMTITLECATALOGUE et) ;
    void saveBatch(List<PIMTITLECATALOGUE> list) ;
    boolean update(PIMTITLECATALOGUE et) ;
    void updateBatch(List<PIMTITLECATALOGUE> list) ;
    PIMTITLECATALOGUE getDraft(PIMTITLECATALOGUE et) ;
    boolean create(PIMTITLECATALOGUE et) ;
    void createBatch(List<PIMTITLECATALOGUE> list) ;
    boolean checkKey(PIMTITLECATALOGUE et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMTITLECATALOGUE get(String key) ;
    Page<PIMTITLECATALOGUE> searchIsRootDQ(PIMTITLECATALOGUESearchContext context) ;
    Page<PIMTITLECATALOGUE> searchNotRootDQ(PIMTITLECATALOGUESearchContext context) ;
    Page<PIMTITLECATALOGUE> searchDefault(PIMTITLECATALOGUESearchContext context) ;
    List<PIMTITLECATALOGUE> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PIMTITLECATALOGUE> selectByPimtitlecatalogueid2(String pimtitlecatalogueid) ;
    void removeByPimtitlecatalogueid2(String pimtitlecatalogueid) ;
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


