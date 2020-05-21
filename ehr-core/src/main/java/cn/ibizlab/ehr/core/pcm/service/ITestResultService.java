package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.TestResult;
import cn.ibizlab.ehr.core.pcm.filter.TestResultSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TestResult] 服务对象接口
 */
public interface ITestResultService extends IService<TestResult>{

    TestResult getDraft(TestResult et) ;
    boolean checkKey(TestResult et) ;
    boolean create(TestResult et) ;
    void createBatch(List<TestResult> list) ;
    boolean save(TestResult et) ;
    void saveBatch(List<TestResult> list) ;
    TestResult get(String key) ;
    boolean update(TestResult et) ;
    void updateBatch(List<TestResult> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<TestResult> searchDefault(TestResultSearchContext context) ;
    List<TestResult> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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


