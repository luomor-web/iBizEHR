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

import cn.ibizlab.ehr.core.pim.domain.PIMEXAMINATIONRESULTS;
import cn.ibizlab.ehr.core.pim.filter.PIMEXAMINATIONRESULTSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMEXAMINATIONRESULTS] 服务对象接口
 */
public interface IPIMEXAMINATIONRESULTSService extends IService<PIMEXAMINATIONRESULTS>{

    boolean update(PIMEXAMINATIONRESULTS et) ;
    void updateBatch(List<PIMEXAMINATIONRESULTS> list) ;
    boolean save(PIMEXAMINATIONRESULTS et) ;
    void saveBatch(List<PIMEXAMINATIONRESULTS> list) ;
    boolean checkKey(PIMEXAMINATIONRESULTS et) ;
    boolean create(PIMEXAMINATIONRESULTS et) ;
    void createBatch(List<PIMEXAMINATIONRESULTS> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMEXAMINATIONRESULTS getDraft(PIMEXAMINATIONRESULTS et) ;
    PIMEXAMINATIONRESULTS get(String key) ;
    Page<PIMEXAMINATIONRESULTS> searchDefault(PIMEXAMINATIONRESULTSSearchContext context) ;
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


