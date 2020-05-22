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

import cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO;
import cn.ibizlab.ehr.core.pim.filter.PIMFAMINFOSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMFAMINFO] 服务对象接口
 */
public interface IPIMFAMINFOService extends IService<PIMFAMINFO>{

    boolean checkKey(PIMFAMINFO et) ;
    PIMFAMINFO updateInfo(PIMFAMINFO et) ;
    PIMFAMINFO updateContact(PIMFAMINFO et) ;
    boolean create(PIMFAMINFO et) ;
    void createBatch(List<PIMFAMINFO> list) ;
    boolean update(PIMFAMINFO et) ;
    void updateBatch(List<PIMFAMINFO> list) ;
    PIMFAMINFO getDraft(PIMFAMINFO et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMFAMINFO et) ;
    void saveBatch(List<PIMFAMINFO> list) ;
    PIMFAMINFO get(String key) ;
    Page<PIMFAMINFO> searchJLSSGR(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchJTLXR(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchDefault(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchJLSSGLY(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchFAZZSY(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchZIZHU(PIMFAMINFOSearchContext context) ;
    Page<PIMFAMINFO> searchJLSS(PIMFAMINFOSearchContext context) ;
    List<PIMFAMINFO> selectByPimpersonid(String pimpersonid) ;
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


