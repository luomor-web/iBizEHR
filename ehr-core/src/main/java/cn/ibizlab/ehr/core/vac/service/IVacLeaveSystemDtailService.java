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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.vac.domain.VacLeaveSystemDtail;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveSystemDtailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacLeaveSystemDtail] 服务对象接口
 */
public interface IVacLeaveSystemDtailService extends IService<VacLeaveSystemDtail>{

    boolean update(VacLeaveSystemDtail et) ;
    void updateBatch(List<VacLeaveSystemDtail> list) ;
    boolean checkKey(VacLeaveSystemDtail et) ;
    boolean save(VacLeaveSystemDtail et) ;
    void saveBatch(List<VacLeaveSystemDtail> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    VacLeaveSystemDtail getDraft(VacLeaveSystemDtail et) ;
    VacLeaveSystemDtail get(String key) ;
    boolean create(VacLeaveSystemDtail et) ;
    void createBatch(List<VacLeaveSystemDtail> list) ;
    Page<VacLeaveSystemDtail> searchDefault(VacLeaveSystemDtailSearchContext context) ;
    List<VacLeaveSystemDtail> selectByVacleavesystemid(String vacleavesystemid) ;
    void removeByVacleavesystemid(String vacleavesystemid) ;
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

    List<VacLeaveSystemDtail> getVacleavesystemdtailByIds(List<String> ids) ;
    List<VacLeaveSystemDtail> getVacleavesystemdtailByEntities(List<VacLeaveSystemDtail> entities) ;

}


