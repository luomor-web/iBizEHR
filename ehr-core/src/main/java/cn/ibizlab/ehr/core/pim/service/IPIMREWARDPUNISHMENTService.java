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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.pim.domain.PIMREWARDPUNISHMENT;
import cn.ibizlab.ehr.core.pim.filter.PIMREWARDPUNISHMENTSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMREWARDPUNISHMENT] 服务对象接口
 */
public interface IPIMREWARDPUNISHMENTService extends IService<PIMREWARDPUNISHMENT>{

    boolean checkKey(PIMREWARDPUNISHMENT et) ;
    PIMREWARDPUNISHMENT get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMREWARDPUNISHMENT et) ;
    void saveBatch(List<PIMREWARDPUNISHMENT> list) ;
    PIMREWARDPUNISHMENT getDraft(PIMREWARDPUNISHMENT et) ;
    boolean create(PIMREWARDPUNISHMENT et) ;
    void createBatch(List<PIMREWARDPUNISHMENT> list) ;
    boolean update(PIMREWARDPUNISHMENT et) ;
    void updateBatch(List<PIMREWARDPUNISHMENT> list) ;
    Page<PIMREWARDPUNISHMENT> searchZIZHU(PIMREWARDPUNISHMENTSearchContext context) ;
    Page<PIMREWARDPUNISHMENT> searchHONORARY(PIMREWARDPUNISHMENTSearchContext context) ;
    Page<PIMREWARDPUNISHMENT> searchDefault(PIMREWARDPUNISHMENTSearchContext context) ;
    Page<PIMREWARDPUNISHMENT> searchJLSS(PIMREWARDPUNISHMENTSearchContext context) ;
    List<PIMREWARDPUNISHMENT> selectByPimpersonid(String pimpersonid) ;
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


