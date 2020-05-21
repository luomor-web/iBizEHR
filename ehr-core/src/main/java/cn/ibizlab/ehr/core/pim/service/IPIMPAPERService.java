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

import cn.ibizlab.ehr.core.pim.domain.PIMPAPER;
import cn.ibizlab.ehr.core.pim.filter.PIMPAPERSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPAPER] 服务对象接口
 */
public interface IPIMPAPERService extends IService<PIMPAPER>{

    boolean update(PIMPAPER et) ;
    void updateBatch(List<PIMPAPER> list) ;
    PIMPAPER getDraft(PIMPAPER et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PIMPAPER et) ;
    void createBatch(List<PIMPAPER> list) ;
    PIMPAPER get(String key) ;
    boolean save(PIMPAPER et) ;
    void saveBatch(List<PIMPAPER> list) ;
    boolean checkKey(PIMPAPER et) ;
    Page<PIMPAPER> searchDefault(PIMPAPERSearchContext context) ;
    Page<PIMPAPER> searchJLSSGR(PIMPAPERSearchContext context) ;
    Page<PIMPAPER> searchJLSSGLY(PIMPAPERSearchContext context) ;
    List<PIMPAPER> selectByPimpersonid(String pimpersonid) ;
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


