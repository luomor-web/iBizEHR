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

import cn.ibizlab.ehr.core.att.domain.AttEndanceRecordTemp;
import cn.ibizlab.ehr.core.att.filter.AttEndanceRecordTempSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[AttEndanceRecordTemp] 服务对象接口
 */
public interface IAttEndanceRecordTempService extends IService<AttEndanceRecordTemp>{

    boolean update(AttEndanceRecordTemp et) ;
    void updateBatch(List<AttEndanceRecordTemp> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(AttEndanceRecordTemp et) ;
    void saveBatch(List<AttEndanceRecordTemp> list) ;
    AttEndanceRecordTemp getDraft(AttEndanceRecordTemp et) ;
    AttEndanceRecordTemp get(String key) ;
    boolean create(AttEndanceRecordTemp et) ;
    void createBatch(List<AttEndanceRecordTemp> list) ;
    boolean checkKey(AttEndanceRecordTemp et) ;
    Page<AttEndanceRecordTemp> searchDefault(AttEndanceRecordTempSearchContext context) ;
    List<AttEndanceRecordTemp> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<AttEndanceRecordTemp> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<AttEndanceRecordTemp> selectByPimpersonid(String pimpersonid) ;
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

    List<AttEndanceRecordTemp> getAttendancerecordtempByIds(List<String> ids) ;
    List<AttEndanceRecordTemp> getAttendancerecordtempByEntities(List<AttEndanceRecordTemp> entities) ;

}


