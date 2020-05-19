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

import cn.ibizlab.ehr.core.orm.domain.ORMXMBQ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBQSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ORMXMBQ] 服务对象接口
 */
public interface IORMXMBQService extends IService<ORMXMBQ>{

    ORMXMBQ get(String key) ;
    boolean create(ORMXMBQ et) ;
    void createBatch(List<ORMXMBQ> list) ;
    boolean save(ORMXMBQ et) ;
    void saveBatch(List<ORMXMBQ> list) ;
    boolean checkKey(ORMXMBQ et) ;
    ORMXMBQ getDraft(ORMXMBQ et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(ORMXMBQ et) ;
    void updateBatch(List<ORMXMBQ> list) ;
    Page<ORMXMBQ> searchDefault(ORMXMBQSearchContext context) ;
    List<ORMXMBQ> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
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


