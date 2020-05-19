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

import cn.ibizlab.ehr.core.pim.domain.PersonStateMGR;
import cn.ibizlab.ehr.core.pim.filter.PersonStateMGRSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PersonStateMGR] 服务对象接口
 */
public interface IPersonStateMGRService extends IService<PersonStateMGR>{

    boolean save(PersonStateMGR et) ;
    void saveBatch(List<PersonStateMGR> list) ;
    boolean checkKey(PersonStateMGR et) ;
    PersonStateMGR getDraft(PersonStateMGR et) ;
    PersonStateMGR get(String key) ;
    boolean create(PersonStateMGR et) ;
    void createBatch(List<PersonStateMGR> list) ;
    boolean update(PersonStateMGR et) ;
    void updateBatch(List<PersonStateMGR> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PersonStateMGR> searchDefault(PersonStateMGRSearchContext context) ;
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


