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

import cn.ibizlab.ehr.core.common.domain.MsgTemplate;
import cn.ibizlab.ehr.core.common.filter.MsgTemplateSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgTemplate] 服务对象接口
 */
public interface IMsgTemplateService extends IService<MsgTemplate>{

    MsgTemplate getDraft(MsgTemplate et) ;
    boolean update(MsgTemplate et) ;
    void updateBatch(List<MsgTemplate> list) ;
    MsgTemplate get(String key) ;
    boolean create(MsgTemplate et) ;
    void createBatch(List<MsgTemplate> list) ;
    boolean checkKey(MsgTemplate et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(MsgTemplate et) ;
    void saveBatch(List<MsgTemplate> list) ;
    Page<MsgTemplate> searchDefault(MsgTemplateSearchContext context) ;
    List<MsgTemplate> selectByDeid(String deid) ;
    void removeByDeid(String deid) ;
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


