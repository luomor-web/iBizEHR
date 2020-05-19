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

import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
import cn.ibizlab.ehr.core.pim.filter.PIMARMYCADRESSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMARMYCADRES] 服务对象接口
 */
public interface IPIMARMYCADRESService extends IService<PIMARMYCADRES>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PIMARMYCADRES getDraft(PIMARMYCADRES et) ;
    boolean checkKey(PIMARMYCADRES et) ;
    boolean create(PIMARMYCADRES et) ;
    void createBatch(List<PIMARMYCADRES> list) ;
    boolean update(PIMARMYCADRES et) ;
    void updateBatch(List<PIMARMYCADRES> list) ;
    PIMARMYCADRES get(String key) ;
    boolean save(PIMARMYCADRES et) ;
    void saveBatch(List<PIMARMYCADRES> list) ;
    Page<PIMARMYCADRES> searchDefault(PIMARMYCADRESSearchContext context) ;
    Page<PIMARMYCADRES> searchJLSSGLY(PIMARMYCADRESSearchContext context) ;
    Page<PIMARMYCADRES> searchJLSSGR(PIMARMYCADRESSearchContext context) ;
    List<PIMARMYCADRES> selectByPimpersonid(String pimpersonid) ;
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


