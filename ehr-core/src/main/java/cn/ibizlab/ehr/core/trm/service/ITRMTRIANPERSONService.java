package cn.ibizlab.ehr.core.trm.service;

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

import cn.ibizlab.ehr.core.trm.domain.TRMTRIANPERSON;
import cn.ibizlab.ehr.core.trm.filter.TRMTRIANPERSONSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[TRMTRIANPERSON] 服务对象接口
 */
public interface ITRMTRIANPERSONService extends IService<TRMTRIANPERSON>{

    TRMTRIANPERSON getDraft(TRMTRIANPERSON et) ;
    boolean save(TRMTRIANPERSON et) ;
    void saveBatch(List<TRMTRIANPERSON> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(TRMTRIANPERSON et) ;
    boolean create(TRMTRIANPERSON et) ;
    void createBatch(List<TRMTRIANPERSON> list) ;
    TRMTRIANPERSON get(String key) ;
    boolean update(TRMTRIANPERSON et) ;
    void updateBatch(List<TRMTRIANPERSON> list) ;
    Page<TRMTRIANPERSON> searchDefault(TRMTRIANPERSONSearchContext context) ;
    List<TRMTRIANPERSON> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<TRMTRIANPERSON> selectByTrmtrainplantermid(String trmtrainplantermid) ;
    void removeByTrmtrainplantermid(String trmtrainplantermid) ;
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


