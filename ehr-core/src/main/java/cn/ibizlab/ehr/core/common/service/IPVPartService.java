package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.PVPart;
import cn.ibizlab.ehr.core.common.filter.PVPartSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PVPart] 服务对象接口
 */
public interface IPVPartService extends IService<PVPart>{

    boolean update(PVPart et) ;
    void updateBatch(List<PVPart> list) ;
    PVPart get(String key) ;
    boolean checkKey(PVPart et) ;
    PVPart getDraft(PVPart et) ;
    boolean save(PVPart et) ;
    void saveBatch(List<PVPart> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PVPart et) ;
    void createBatch(List<PVPart> list) ;
    Page<PVPart> searchDefault(PVPartSearchContext context) ;
    Page<PVPart> searchCurPV(PVPartSearchContext context) ;
    List<PVPart> selectByPortalpageid(String portalpageid) ;
    void removeByPortalpageid(String portalpageid) ;
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


