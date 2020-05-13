package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACLEAVETIPS;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVETIPSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEAVETIPS] 服务对象接口
 */
public interface IVACLEAVETIPSService extends IService<VACLEAVETIPS>{

    VACLEAVETIPS checkQJZL(VACLEAVETIPS et) ;
    boolean create(VACLEAVETIPS et) ;
    void createBatch(List<VACLEAVETIPS> list) ;
    VACLEAVETIPS getDraft(VACLEAVETIPS et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(VACLEAVETIPS et) ;
    VACLEAVETIPS checkRepeat(VACLEAVETIPS et) ;
    VACLEAVETIPS get(String key) ;
    boolean update(VACLEAVETIPS et) ;
    void updateBatch(List<VACLEAVETIPS> list) ;
    boolean save(VACLEAVETIPS et) ;
    void saveBatch(List<VACLEAVETIPS> list) ;
    Page<VACLEAVETIPS> searchDefault(VACLEAVETIPSSearchContext context) ;
    List<VACLEAVETIPS> selectByVacholidayrulesid(String vacholidayrulesid) ;
    void removeByVacholidayrulesid(String vacholidayrulesid) ;
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


