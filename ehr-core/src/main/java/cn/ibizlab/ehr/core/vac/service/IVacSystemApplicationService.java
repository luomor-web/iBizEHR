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

import cn.ibizlab.ehr.core.vac.domain.VacSystemApplication;
import cn.ibizlab.ehr.core.vac.filter.VacSystemApplicationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VacSystemApplication] 服务对象接口
 */
public interface IVacSystemApplicationService extends IService<VacSystemApplication>{

    boolean create(VacSystemApplication et) ;
    void createBatch(List<VacSystemApplication> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(VacSystemApplication et) ;
    void updateBatch(List<VacSystemApplication> list) ;
    VacSystemApplication get(String key) ;
    boolean save(VacSystemApplication et) ;
    void saveBatch(List<VacSystemApplication> list) ;
    VacSystemApplication getDraft(VacSystemApplication et) ;
    boolean checkKey(VacSystemApplication et) ;
    Page<VacSystemApplication> searchDefault(VacSystemApplicationSearchContext context) ;
    List<VacSystemApplication> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<VacSystemApplication> selectByPimpersonid(String pimpersonid) ;
    void removeByPimpersonid(String pimpersonid) ;
    List<VacSystemApplication> selectByVacleavesystemid(String vacleavesystemid) ;
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

    List<VacSystemApplication> getVacsystemapplicationByIds(List<String> ids) ;
    List<VacSystemApplication> getVacsystemapplicationByEntities(List<VacSystemApplication> entities) ;

}


