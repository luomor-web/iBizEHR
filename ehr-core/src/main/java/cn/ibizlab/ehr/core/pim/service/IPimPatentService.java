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

import cn.ibizlab.ehr.core.pim.domain.PimPatent;
import cn.ibizlab.ehr.core.pim.filter.PimPatentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPatent] 服务对象接口
 */
public interface IPimPatentService extends IService<PimPatent>{

    PimPatent get(String key) ;
    PimPatent getDraft(PimPatent et) ;
    boolean update(PimPatent et) ;
    void updateBatch(List<PimPatent> list) ;
    boolean create(PimPatent et) ;
    void createBatch(List<PimPatent> list) ;
    boolean save(PimPatent et) ;
    void saveBatch(List<PimPatent> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PimPatent et) ;
    Page<PimPatent> searchJLSSGLY(PimPatentSearchContext context) ;
    Page<PimPatent> searchDefault(PimPatentSearchContext context) ;
    Page<PimPatent> searchJLSSGR(PimPatentSearchContext context) ;
    List<PimPatent> selectByPimpersonid(String pimpersonid) ;
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

    List<PimPatent> getPimpatentByIds(List<String> ids) ;
    List<PimPatent> getPimpatentByEntities(List<PimPatent> entities) ;

}


