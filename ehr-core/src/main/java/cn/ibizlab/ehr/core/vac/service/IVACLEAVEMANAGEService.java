package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEMANAGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACLEAVEMANAGE] 服务对象接口
 */
public interface IVACLEAVEMANAGEService extends IService<VACLEAVEMANAGE>{

    VACLEAVEMANAGE updateQJMX(VACLEAVEMANAGE et) ;
    VACLEAVEMANAGE cB(VACLEAVEMANAGE et) ;
    VACLEAVEMANAGE getDraft(VACLEAVEMANAGE et) ;
    VACLEAVEMANAGE cX(VACLEAVEMANAGE et) ;
    boolean update(VACLEAVEMANAGE et) ;
    void updateBatch(List<VACLEAVEMANAGE> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VACLEAVEMANAGE getFJSJofPerson(VACLEAVEMANAGE et) ;
    boolean save(VACLEAVEMANAGE et) ;
    void saveBatch(List<VACLEAVEMANAGE> list) ;
    boolean create(VACLEAVEMANAGE et) ;
    void createBatch(List<VACLEAVEMANAGE> list) ;
    VACLEAVEMANAGE get(String key) ;
    boolean checkKey(VACLEAVEMANAGE et) ;
    VACLEAVEMANAGE mobStart(VACLEAVEMANAGE et) ;
    Page<VACLEAVEMANAGE> searchFormType(VACLEAVEMANAGESearchContext context) ;
    Page<VACLEAVEMANAGE> searchGR(VACLEAVEMANAGESearchContext context) ;
    Page<VACLEAVEMANAGE> searchMOBJLSS(VACLEAVEMANAGESearchContext context) ;
    Page<VACLEAVEMANAGE> searchJLSS(VACLEAVEMANAGESearchContext context) ;
    Page<VACLEAVEMANAGE> searchDefault(VACLEAVEMANAGESearchContext context) ;
    Page<VACLEAVEMANAGE> searchOnlySPTY(VACLEAVEMANAGESearchContext context) ;
    List<VACLEAVEMANAGE> selectByPimpersonid(String pimpersonid) ;
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


