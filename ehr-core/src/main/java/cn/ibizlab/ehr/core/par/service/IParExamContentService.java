package cn.ibizlab.ehr.core.par.service;

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

import cn.ibizlab.ehr.core.par.domain.ParExamContent;
import cn.ibizlab.ehr.core.par.filter.ParExamContentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ParExamContent] 服务对象接口
 */
public interface IParExamContentService extends IService<ParExamContent>{

    boolean checkKey(ParExamContent et) ;
    ParExamContent get(String key) ;
    boolean save(ParExamContent et) ;
    void saveBatch(List<ParExamContent> list) ;
    boolean update(ParExamContent et) ;
    void updateBatch(List<ParExamContent> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ParExamContent getDraft(ParExamContent et) ;
    boolean create(ParExamContent et) ;
    void createBatch(List<ParExamContent> list) ;
    Page<ParExamContent> searchDefault(ParExamContentSearchContext context) ;
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

    List<ParExamContent> getParexamcontentByIds(List<String> ids) ;
    List<ParExamContent> getParexamcontentByEntities(List<ParExamContent> entities) ;

}


