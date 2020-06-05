package cn.ibizlab.ehr.core.soc.service;

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

import cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo;
import cn.ibizlab.ehr.core.soc.filter.SocWelfareInfoSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SocWelfareInfo] 服务对象接口
 */
public interface ISocWelfareInfoService extends IService<SocWelfareInfo>{

    boolean checkKey(SocWelfareInfo et) ;
    SocWelfareInfo getFJSJofPerson(SocWelfareInfo et) ;
    boolean save(SocWelfareInfo et) ;
    void saveBatch(List<SocWelfareInfo> list) ;
    SocWelfareInfo getDraft(SocWelfareInfo et) ;
    SocWelfareInfo get(String key) ;
    SocWelfareInfo getCBDofSOCCOMPANYWEL(SocWelfareInfo et) ;
    boolean update(SocWelfareInfo et) ;
    void updateBatch(List<SocWelfareInfo> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SocWelfareInfo et) ;
    void createBatch(List<SocWelfareInfo> list) ;
    Page<SocWelfareInfo> searchDefault(SocWelfareInfoSearchContext context) ;
    List<SocWelfareInfo> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<SocWelfareInfo> selectBySoccompanywelid(String soccompanywelid) ;
    void removeBySoccompanywelid(String soccompanywelid) ;
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

    List<SocWelfareInfo> getSocwelfareinfoByIds(List<String> ids) ;
    List<SocWelfareInfo> getSocwelfareinfoByEntities(List<SocWelfareInfo> entities) ;

}


