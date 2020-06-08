package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TrmPlanFormu;
import cn.ibizlab.ehr.core.trm.filter.TrmPlanFormuSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TrmPlanFormu] 服务对象接口
 */
public interface ITrmPlanFormuService extends IService<TrmPlanFormu>{

    boolean save(TrmPlanFormu et) ;
    void saveBatch(List<TrmPlanFormu> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    TrmPlanFormu get(String key) ;
    boolean update(TrmPlanFormu et) ;
    void updateBatch(List<TrmPlanFormu> list) ;
    boolean create(TrmPlanFormu et) ;
    void createBatch(List<TrmPlanFormu> list) ;
    TrmPlanFormu getDraft(TrmPlanFormu et) ;
    boolean checkKey(TrmPlanFormu et) ;
    Page<TrmPlanFormu> searchDefault(TrmPlanFormuSearchContext context) ;
    List<TrmPlanFormu> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<TrmPlanFormu> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<TrmPlanFormu> selectByPimpersonid(String pimpersonid) ;
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

    List<TrmPlanFormu> getTrmplanformuByIds(List<String> ids) ;
    List<TrmPlanFormu> getTrmplanformuByEntities(List<TrmPlanFormu> entities) ;

}


