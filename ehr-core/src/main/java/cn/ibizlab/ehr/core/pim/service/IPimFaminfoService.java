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

import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
import cn.ibizlab.ehr.core.pim.filter.PimFaminfoSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimFaminfo] 服务对象接口
 */
public interface IPimFaminfoService extends IService<PimFaminfo>{

    boolean checkKey(PimFaminfo et) ;
    PimFaminfo updateInfo(PimFaminfo et) ;
    PimFaminfo updateContact(PimFaminfo et) ;
    boolean create(PimFaminfo et) ;
    void createBatch(List<PimFaminfo> list) ;
    boolean update(PimFaminfo et) ;
    void updateBatch(List<PimFaminfo> list) ;
    PimFaminfo getDraft(PimFaminfo et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PimFaminfo et) ;
    void saveBatch(List<PimFaminfo> list) ;
    PimFaminfo get(String key) ;
    Page<PimFaminfo> searchJLSSGR(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchJTLXR(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchDefault(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchJLSSGLY(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchFAZZSY(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchZIZHU(PimFaminfoSearchContext context) ;
    Page<PimFaminfo> searchJLSS(PimFaminfoSearchContext context) ;
    List<PimFaminfo> selectByPimpersonid(String pimpersonid) ;
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

    List<PimFaminfo> getPimfaminfoByIds(List<String> ids) ;
    List<PimFaminfo> getPimfaminfoByEntities(List<PimFaminfo> entities) ;

}


