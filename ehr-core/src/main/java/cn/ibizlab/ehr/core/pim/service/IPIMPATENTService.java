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

import cn.ibizlab.ehr.core.pim.domain.PIMPATENT;
import cn.ibizlab.ehr.core.pim.filter.PIMPATENTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMPATENT] 服务对象接口
 */
public interface IPIMPATENTService extends IService<PIMPATENT>{

    PIMPATENT get(String key) ;
    PIMPATENT getDraft(PIMPATENT et) ;
    boolean update(PIMPATENT et) ;
    void updateBatch(List<PIMPATENT> list) ;
    boolean create(PIMPATENT et) ;
    void createBatch(List<PIMPATENT> list) ;
    boolean save(PIMPATENT et) ;
    void saveBatch(List<PIMPATENT> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMPATENT et) ;
    Page<PIMPATENT> searchJLSSGLY(PIMPATENTSearchContext context) ;
    Page<PIMPATENT> searchDefault(PIMPATENTSearchContext context) ;
    Page<PIMPATENT> searchJLSSGR(PIMPATENTSearchContext context) ;
    List<PIMPATENT> selectByPimpersonid(String pimpersonid) ;
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


