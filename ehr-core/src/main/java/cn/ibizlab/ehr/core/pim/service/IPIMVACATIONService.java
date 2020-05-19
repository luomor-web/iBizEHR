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

import cn.ibizlab.ehr.core.pim.domain.PIMVACATION;
import cn.ibizlab.ehr.core.pim.filter.PIMVACATIONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMVACATION] 服务对象接口
 */
public interface IPIMVACATIONService extends IService<PIMVACATION>{

    boolean update(PIMVACATION et) ;
    void updateBatch(List<PIMVACATION> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMVACATION getDraft(PIMVACATION et) ;
    boolean save(PIMVACATION et) ;
    void saveBatch(List<PIMVACATION> list) ;
    boolean create(PIMVACATION et) ;
    void createBatch(List<PIMVACATION> list) ;
    boolean checkKey(PIMVACATION et) ;
    PIMVACATION get(String key) ;
    Page<PIMVACATION> searchDefault(PIMVACATIONSearchContext context) ;
    List<PIMVACATION> selectByPimpersonid(String pimpersonid) ;
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


