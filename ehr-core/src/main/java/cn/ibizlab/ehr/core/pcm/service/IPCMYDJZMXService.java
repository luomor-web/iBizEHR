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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDJZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJZMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDJZMX] 服务对象接口
 */
public interface IPCMYDJZMXService extends IService<PCMYDJZMX>{

    PCMYDJZMX getDraft(PCMYDJZMX et) ;
    boolean save(PCMYDJZMX et) ;
    void saveBatch(List<PCMYDJZMX> list) ;
    PCMYDJZMX rYHG(PCMYDJZMX et) ;
    PCMYDJZMX get(String key) ;
    boolean update(PCMYDJZMX et) ;
    void updateBatch(List<PCMYDJZMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMYDJZMX fillPersonInfo(PCMYDJZMX et) ;
    boolean checkKey(PCMYDJZMX et) ;
    boolean create(PCMYDJZMX et) ;
    void createBatch(List<PCMYDJZMX> list) ;
    Page<PCMYDJZMX> searchGLDS(PCMYDJZMXSearchContext context) ;
    Page<PCMYDJZMX> searchLSJLDS(PCMYDJZMXSearchContext context) ;
    Page<PCMYDJZMX> searchDefault(PCMYDJZMXSearchContext context) ;
    List<PCMYDJZMX> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMYDJZMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMYDJZMX> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMYDJZMX> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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


