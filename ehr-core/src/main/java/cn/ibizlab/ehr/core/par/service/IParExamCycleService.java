package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParExamCycle;
import cn.ibizlab.ehr.core.par.filter.ParExamCycleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParExamCycle] 服务对象接口
 */
public interface IParExamCycleService extends IService<ParExamCycle>{

    boolean update(ParExamCycle et) ;
    void updateBatch(List<ParExamCycle> list) ;
    boolean create(ParExamCycle et) ;
    void createBatch(List<ParExamCycle> list) ;
    ParExamCycle getDraft(ParExamCycle et) ;
    boolean checkKey(ParExamCycle et) ;
    boolean save(ParExamCycle et) ;
    void saveBatch(List<ParExamCycle> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParExamCycle get(String key) ;
    Page<ParExamCycle> searchDefault(ParExamCycleSearchContext context) ;
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

    List<ParExamCycle> getParexamcycleByIds(List<String> ids) ;
    List<ParExamCycle> getParexamcycleByEntities(List<ParExamCycle> entities) ;

}


