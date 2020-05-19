package cn.ibizlab.ehr.core.pcm.service;

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

import cn.ibizlab.ehr.core.pcm.domain.PCMLOG;
import cn.ibizlab.ehr.core.pcm.filter.PCMLOGSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMLOG] 服务对象接口
 */
public interface IPCMLOGService extends IService<PCMLOG>{

    boolean create(PCMLOG et) ;
    void createBatch(List<PCMLOG> list) ;
    boolean update(PCMLOG et) ;
    void updateBatch(List<PCMLOG> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMLOG getDraft(PCMLOG et) ;
    PCMLOG get(String key) ;
    boolean checkKey(PCMLOG et) ;
    boolean save(PCMLOG et) ;
    void saveBatch(List<PCMLOG> list) ;
    Page<PCMLOG> searchDefault(PCMLOGSearchContext context) ;
    List<PCMLOG> selectByPimpersonid(String pimpersonid) ;
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


