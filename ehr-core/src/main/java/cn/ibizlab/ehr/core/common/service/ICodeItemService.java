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

import cn.ibizlab.ehr.core.common.domain.CodeItem;
import cn.ibizlab.ehr.core.common.filter.CodeItemSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[CodeItem] 服务对象接口
 */
public interface ICodeItemService extends IService<CodeItem>{

    boolean save(CodeItem et) ;
    void saveBatch(List<CodeItem> list) ;
    boolean checkKey(CodeItem et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(CodeItem et) ;
    void updateBatch(List<CodeItem> list) ;
    boolean create(CodeItem et) ;
    void createBatch(List<CodeItem> list) ;
    CodeItem getDraft(CodeItem et) ;
    CodeItem get(String key) ;
    Page<CodeItem> searchDefault(CodeItemSearchContext context) ;
    Page<CodeItem> searchCurCL(CodeItemSearchContext context) ;
    List<CodeItem> selectByPcodeitemid(String codeitemid) ;
    void removeByPcodeitemid(String codeitemid) ;
    List<CodeItem> selectByCodelistid(String codelistid) ;
    void removeByCodelistid(String codelistid) ;
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

    List<CodeItem> getCodeitemByIds(List<String> ids) ;
    List<CodeItem> getCodeitemByEntities(List<CodeItem> entities) ;

}


