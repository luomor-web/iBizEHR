package cn.ibizlab.ehr.core.orm.service;

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

import cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSECTORSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMORGSECTOR] 服务对象接口
 */
public interface IORMORGSECTORService extends IService<ORMORGSECTOR>{

    ORMORGSECTOR changeEdition(ORMORGSECTOR et) ;
    boolean create(ORMORGSECTOR et) ;
    void createBatch(List<ORMORGSECTOR> list) ;
    ORMORGSECTOR synOrgSectPro(ORMORGSECTOR et) ;
    ORMORGSECTOR cLWC(ORMORGSECTOR et) ;
    boolean checkKey(ORMORGSECTOR et) ;
    boolean save(ORMORGSECTOR et) ;
    void saveBatch(List<ORMORGSECTOR> list) ;
    ORMORGSECTOR getDraft(ORMORGSECTOR et) ;
    ORMORGSECTOR tJ(ORMORGSECTOR et) ;
    boolean update(ORMORGSECTOR et) ;
    void updateBatch(List<ORMORGSECTOR> list) ;
    ORMORGSECTOR get(String key) ;
    ORMORGSECTOR synOrgSectOderNum(ORMORGSECTOR et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMORGSECTOR synOrgSec(ORMORGSECTOR et) ;
    Page<ORMORGSECTOR> searchCURORMORG(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchXMBBZGL(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchJSYXMB(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchCurZZBM(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchCurZZBM_KQSZ(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchCURORG(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchCurOrgSector(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchDefault(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchBaseInfo(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchDQZZXBM(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchRsshInfo(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchSubOrgsector(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchPimpersonInfoOrgsector(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchHisInfo(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchSubZZBM(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchProExpandInfo(ORMORGSECTORSearchContext context) ;
    Page<ORMORGSECTOR> searchBMBZGL(ORMORGSECTORSearchContext context) ;
    List<ORMORGSECTOR> selectByPorgsectorid(String orgsectorid) ;
    void removeByPorgsectorid(String orgsectorid) ;
    List<ORMORGSECTOR> selectByProdepid(String orgsectorid) ;
    void removeByProdepid(String orgsectorid) ;
    List<ORMORGSECTOR> selectByOrgid(String orgid) ;
    void removeByOrgid(String orgid) ;
    List<ORMORGSECTOR> selectByOrmxmglid(String ormxmglid) ;
    void removeByOrmxmglid(String ormxmglid) ;
    List<ORMORGSECTOR> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<ORMORGSECTOR> selectByProleaderid(String pimpersonid) ;
    void removeByProleaderid(String pimpersonid) ;
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


