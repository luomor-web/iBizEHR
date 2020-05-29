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

import cn.ibizlab.ehr.core.common.domain.CodeList1;
import cn.ibizlab.ehr.core.common.filter.CodeList1SearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[CodeList1] 服务对象接口
 */
public interface ICodeList1Service extends IService<CodeList1>{

    CodeList1 get(String key) ;
    CodeList1 getDraft(CodeList1 et) ;
    boolean update(CodeList1 et) ;
    void updateBatch(List<CodeList1> list) ;
    CodeList1 refreshModel(CodeList1 et) ;
    boolean checkKey(CodeList1 et) ;
    boolean create(CodeList1 et) ;
    void createBatch(List<CodeList1> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(CodeList1 et) ;
    void saveBatch(List<CodeList1> list) ;
    Page<CodeList1> searchPersonUse(CodeList1SearchContext context) ;
    Page<CodeList1> searchDefault(CodeList1SearchContext context) ;
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

    List<CodeList1> getCodelist1ByIds(List<String> ids) ;
    List<CodeList1> getCodelist1ByEntities(List<CodeList1> entities) ;

}


