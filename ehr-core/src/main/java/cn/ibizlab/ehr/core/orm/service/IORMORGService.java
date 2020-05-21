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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.orm.domain.ORMORG;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMORG] 服务对象接口
 */
public interface IORMORGService extends IService<ORMORG>{

    boolean update(ORMORG et) ;
    void updateBatch(List<ORMORG> list) ;
    ORMORG synOrg(ORMORG et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ORMORG getDraft(ORMORG et) ;
    ORMORG get(String key) ;
    boolean checkKey(ORMORG et) ;
    boolean create(ORMORG et) ;
    void createBatch(List<ORMORG> list) ;
    boolean save(ORMORG et) ;
    void saveBatch(List<ORMORG> list) ;
    Page<ORMORG> searchALLSIGNORG(ORMORGSearchContext context) ;
    Page<ORMORG> searchAllLevelTwoOrg2(ORMORGSearchContext context) ;
    Page<ORMORG> searchOrglist_Profile(ORMORGSearchContext context) ;
    Page<HashMap> searchREP_ORG(ORMORGSearchContext context) ;
    Page<ORMORG> searchAuthOrg(ORMORGSearchContext context) ;
    Page<ORMORG> searchGSGWZY(ORMORGSearchContext context) ;
    Page<ORMORG> searchSubSubOrg(ORMORGSearchContext context) ;
    Page<ORMORG> searchDefault(ORMORGSearchContext context) ;
    Page<ORMORG> searchCurChild(ORMORGSearchContext context) ;
    Page<ORMORG> searchSJYXZZ(ORMORGSearchContext context) ;
    Page<HashMap> searchREP_ORGPNUM(ORMORGSearchContext context) ;
    Page<ORMORG> searchKZSJZZXZ(ORMORGSearchContext context) ;
    Page<ORMORG> searchDanQian(ORMORGSearchContext context) ;
    Page<ORMORG> searchAllLevelTwoOrg(ORMORGSearchContext context) ;
    Page<ORMORG> searchSubOrg(ORMORGSearchContext context) ;
    Page<ORMORG> searchHTGLDW(ORMORGSearchContext context) ;
    Page<ORMORG> searchKZXLXZ(ORMORGSearchContext context) ;
    Page<ORMORG> searchAuthSJYXZZ(ORMORGSearchContext context) ;
    Page<ORMORG> searchUseByFP(ORMORGSearchContext context) ;
    Page<ORMORG> searchCurPorg(ORMORGSearchContext context) ;
    List<ORMORG> selectByPorgid(String orgid) ;
    void removeByPorgid(String orgid) ;
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


