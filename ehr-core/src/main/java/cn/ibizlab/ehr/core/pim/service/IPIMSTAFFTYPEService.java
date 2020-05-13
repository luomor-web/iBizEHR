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

import cn.ibizlab.ehr.core.pim.domain.PIMSTAFFTYPE;
import cn.ibizlab.ehr.core.pim.filter.PIMSTAFFTYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMSTAFFTYPE] 服务对象接口
 */
public interface IPIMSTAFFTYPEService extends IService<PIMSTAFFTYPE>{

    boolean checkKey(PIMSTAFFTYPE et) ;
    PIMSTAFFTYPE get(String key) ;
    PIMSTAFFTYPE getDraft(PIMSTAFFTYPE et) ;
    boolean create(PIMSTAFFTYPE et) ;
    void createBatch(List<PIMSTAFFTYPE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMSTAFFTYPE et) ;
    void saveBatch(List<PIMSTAFFTYPE> list) ;
    boolean update(PIMSTAFFTYPE et) ;
    void updateBatch(List<PIMSTAFFTYPE> list) ;
    Page<PIMSTAFFTYPE> searchDefault(PIMSTAFFTYPESearchContext context) ;
    Page<PIMSTAFFTYPE> searchYPZ(PIMSTAFFTYPESearchContext context) ;
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

