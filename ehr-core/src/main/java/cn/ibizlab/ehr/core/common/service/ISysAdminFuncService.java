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

import cn.ibizlab.ehr.core.common.domain.SysAdminFunc;
import cn.ibizlab.ehr.core.common.filter.SysAdminFuncSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysAdminFunc] 服务对象接口
 */
public interface ISysAdminFuncService extends IService<SysAdminFunc>{

    boolean update(SysAdminFunc et) ;
    void updateBatch(List<SysAdminFunc> list) ;
    boolean save(SysAdminFunc et) ;
    void saveBatch(List<SysAdminFunc> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysAdminFunc getDraft(SysAdminFunc et) ;
    boolean create(SysAdminFunc et) ;
    void createBatch(List<SysAdminFunc> list) ;
    SysAdminFunc get(String key) ;
    boolean checkKey(SysAdminFunc et) ;
    Page<SysAdminFunc> searchDefault(SysAdminFuncSearchContext context) ;
    List<SysAdminFunc> selectBySysadminid(String sysadminid) ;
    void removeBySysadminid(String sysadminid) ;
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


