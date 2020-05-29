package cn.ibizlab.ehr.core.att.service;

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

import cn.ibizlab.ehr.core.att.domain.AttEndenceOrmorgscetor;
import cn.ibizlab.ehr.core.att.filter.AttEndenceOrmorgscetorSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndenceOrmorgscetor] 服务对象接口
 */
public interface IAttEndenceOrmorgscetorService extends IService<AttEndenceOrmorgscetor>{

    AttEndenceOrmorgscetor get(String key) ;
    boolean create(AttEndenceOrmorgscetor et) ;
    void createBatch(List<AttEndenceOrmorgscetor> list) ;
    boolean update(AttEndenceOrmorgscetor et) ;
    void updateBatch(List<AttEndenceOrmorgscetor> list) ;
    boolean checkKey(AttEndenceOrmorgscetor et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    AttEndenceOrmorgscetor getDraft(AttEndenceOrmorgscetor et) ;
    boolean save(AttEndenceOrmorgscetor et) ;
    void saveBatch(List<AttEndenceOrmorgscetor> list) ;
    Page<AttEndenceOrmorgscetor> searchDefault(AttEndenceOrmorgscetorSearchContext context) ;
    List<AttEndenceOrmorgscetor> selectByAttendencesetupid(String attendencesetupid) ;
    void removeByAttendencesetupid(String attendencesetupid) ;
    List<AttEndenceOrmorgscetor> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
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

    List<AttEndenceOrmorgscetor> getAttendenceormorgscetorByIds(List<String> ids) ;
    List<AttEndenceOrmorgscetor> getAttendenceormorgscetorByEntities(List<AttEndenceOrmorgscetor> entities) ;

}


