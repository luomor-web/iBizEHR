package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.PPModel;
import cn.ibizlab.ehr.core.common.filter.PPModelSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PPModel] 服务对象接口
 */
public interface IPPModelService extends IService<PPModel>{

    PPModel getDraft(PPModel et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PPModel et) ;
    boolean save(PPModel et) ;
    void saveBatch(List<PPModel> list) ;
    PPModel get(String key) ;
    boolean create(PPModel et) ;
    void createBatch(List<PPModel> list) ;
    boolean update(PPModel et) ;
    void updateBatch(List<PPModel> list) ;
    Page<PPModel> searchDefault(PPModelSearchContext context) ;
    List<PPModel> selectByPortalpageid(String portalpageid) ;
    void removeByPortalpageid(String portalpageid) ;
    List<PPModel> selectByC1pvpartid(String pvpartid) ;
    void removeByC1pvpartid(String pvpartid) ;
    List<PPModel> selectByC2pvpartid(String pvpartid) ;
    void removeByC2pvpartid(String pvpartid) ;
    List<PPModel> selectByC3pvpartid(String pvpartid) ;
    void removeByC3pvpartid(String pvpartid) ;
    List<PPModel> selectByC4pvpartid(String pvpartid) ;
    void removeByC4pvpartid(String pvpartid) ;
    List<PPModel> selectByL1pvpartid(String pvpartid) ;
    void removeByL1pvpartid(String pvpartid) ;
    List<PPModel> selectByL2pvpartid(String pvpartid) ;
    void removeByL2pvpartid(String pvpartid) ;
    List<PPModel> selectByL3pvpartid(String pvpartid) ;
    void removeByL3pvpartid(String pvpartid) ;
    List<PPModel> selectByL4pvpartid(String pvpartid) ;
    void removeByL4pvpartid(String pvpartid) ;
    List<PPModel> selectByR1pvpartid(String pvpartid) ;
    void removeByR1pvpartid(String pvpartid) ;
    List<PPModel> selectByR2pvpartid(String pvpartid) ;
    void removeByR2pvpartid(String pvpartid) ;
    List<PPModel> selectByR3pvpartid(String pvpartid) ;
    void removeByR3pvpartid(String pvpartid) ;
    List<PPModel> selectByR4pvpartid(String pvpartid) ;
    void removeByR4pvpartid(String pvpartid) ;
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


