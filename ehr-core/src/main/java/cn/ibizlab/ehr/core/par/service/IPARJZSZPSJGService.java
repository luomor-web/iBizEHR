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

import cn.ibizlab.ehr.core.par.domain.PARJZSZPSJG;
import cn.ibizlab.ehr.core.par.filter.PARJZSZPSJGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PARJZSZPSJG] 服务对象接口
 */
public interface IPARJZSZPSJGService extends IService<PARJZSZPSJG>{

    PARJZSZPSJG get(String key) ;
    boolean update(PARJZSZPSJG et) ;
    void updateBatch(List<PARJZSZPSJG> list) ;
    boolean save(PARJZSZPSJG et) ;
    void saveBatch(List<PARJZSZPSJG> list) ;
    boolean checkKey(PARJZSZPSJG et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PARJZSZPSJG getDraft(PARJZSZPSJG et) ;
    boolean create(PARJZSZPSJG et) ;
    void createBatch(List<PARJZSZPSJG> list) ;
    Page<PARJZSZPSJG> searchDefault(PARJZSZPSJGSearchContext context) ;
    List<PARJZSZPSJG> selectByPimpersonid(String pimpersonid) ;
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


