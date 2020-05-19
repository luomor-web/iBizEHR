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

import cn.ibizlab.ehr.core.pim.domain.PIMCORRECTIONAPPLY;
import cn.ibizlab.ehr.core.pim.filter.PIMCORRECTIONAPPLYSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMCORRECTIONAPPLY] 服务对象接口
 */
public interface IPIMCORRECTIONAPPLYService extends IService<PIMCORRECTIONAPPLY>{

    boolean create(PIMCORRECTIONAPPLY et) ;
    void createBatch(List<PIMCORRECTIONAPPLY> list) ;
    PIMCORRECTIONAPPLY getDraft(PIMCORRECTIONAPPLY et) ;
    boolean checkKey(PIMCORRECTIONAPPLY et) ;
    boolean save(PIMCORRECTIONAPPLY et) ;
    void saveBatch(List<PIMCORRECTIONAPPLY> list) ;
    PIMCORRECTIONAPPLY get(String key) ;
    boolean update(PIMCORRECTIONAPPLY et) ;
    void updateBatch(List<PIMCORRECTIONAPPLY> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PIMCORRECTIONAPPLY> searchDefault(PIMCORRECTIONAPPLYSearchContext context) ;
    List<PIMCORRECTIONAPPLY> selectByPimbyygzzsqid(String pimbyygzzsqid) ;
    void removeByPimbyygzzsqid(String pimbyygzzsqid) ;
    List<PIMCORRECTIONAPPLY> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
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


