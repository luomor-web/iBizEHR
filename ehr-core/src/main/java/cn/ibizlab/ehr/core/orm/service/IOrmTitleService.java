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

import cn.ibizlab.ehr.core.orm.domain.OrmTitle;
import cn.ibizlab.ehr.core.orm.filter.OrmTitleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[OrmTitle] 服务对象接口
 */
public interface IOrmTitleService extends IService<OrmTitle>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(OrmTitle et) ;
    void updateBatch(List<OrmTitle> list) ;
    OrmTitle getDraft(OrmTitle et) ;
    boolean save(OrmTitle et) ;
    void saveBatch(List<OrmTitle> list) ;
    boolean checkKey(OrmTitle et) ;
    OrmTitle get(String key) ;
    boolean create(OrmTitle et) ;
    void createBatch(List<OrmTitle> list) ;
    Page<OrmTitle> searchDefault(OrmTitleSearchContext context) ;
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

    List<OrmTitle> getOrmtitleByIds(List<String> ids) ;
    List<OrmTitle> getOrmtitleByEntities(List<OrmTitle> entities) ;

}


