package cn.ibizlab.ehr.core.att.service;

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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.att.domain.ATTENDANCESUMMARYMX;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCESUMMARYMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ATTENDANCESUMMARYMX] 服务对象接口
 */
public interface IATTENDANCESUMMARYMXService extends IService<ATTENDANCESUMMARYMX>{

    boolean create(ATTENDANCESUMMARYMX et) ;
    void createBatch(List<ATTENDANCESUMMARYMX> list) ;
    boolean checkKey(ATTENDANCESUMMARYMX et) ;
    ATTENDANCESUMMARYMX get(String key) ;
    ATTENDANCESUMMARYMX getDraft(ATTENDANCESUMMARYMX et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(ATTENDANCESUMMARYMX et) ;
    void saveBatch(List<ATTENDANCESUMMARYMX> list) ;
    boolean update(ATTENDANCESUMMARYMX et) ;
    void updateBatch(List<ATTENDANCESUMMARYMX> list) ;
    Page<ATTENDANCESUMMARYMX> searchDefault(ATTENDANCESUMMARYMXSearchContext context) ;
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

    List<ATTENDANCESUMMARYMX> getAttendancesummarymxByIds(List<String> ids) ;
    List<ATTENDANCESUMMARYMX> getAttendancesummarymxByEntities(List<ATTENDANCESUMMARYMX> entities) ;

}


