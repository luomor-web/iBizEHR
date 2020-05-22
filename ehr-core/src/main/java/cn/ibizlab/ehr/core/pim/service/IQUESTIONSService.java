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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.pim.domain.QUESTIONS;
import cn.ibizlab.ehr.core.pim.filter.QUESTIONSSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[QUESTIONS] 服务对象接口
 */
public interface IQUESTIONSService extends IService<QUESTIONS>{

    QUESTIONS removeTemp(QUESTIONS et) ;
    QUESTIONS getTemp(QUESTIONS et) ;
    QUESTIONS getDraftTempMajor(QUESTIONS et) ;
    QUESTIONS updateTemp(QUESTIONS et) ;
    boolean save(QUESTIONS et) ;
    void saveBatch(List<QUESTIONS> list) ;
    QUESTIONS createTempMajor(QUESTIONS et) ;
    boolean update(QUESTIONS et) ;
    void updateBatch(List<QUESTIONS> list) ;
    QUESTIONS get(String key) ;
    QUESTIONS updateTempMajor(QUESTIONS et) ;
    boolean checkKey(QUESTIONS et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(QUESTIONS et) ;
    void createBatch(List<QUESTIONS> list) ;
    QUESTIONS getTempMajor(QUESTIONS et) ;
    QUESTIONS getDraft(QUESTIONS et) ;
    QUESTIONS createTemp(QUESTIONS et) ;
    QUESTIONS removeTempMajor(QUESTIONS et) ;
    QUESTIONS getDraftTemp(QUESTIONS et) ;
    Page<QUESTIONS> searchQUERYcurrentQUESTION(QUESTIONSSearchContext context) ;
    Page<QUESTIONS> searchDefault(QUESTIONSSearchContext context) ;
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


