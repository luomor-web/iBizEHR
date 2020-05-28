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
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.ehr.core.pcm.domain.PCMGXXKTEMP;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXXKTEMPSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMGXXKTEMP] 服务对象接口
 */
public interface IPCMGXXKTEMPService extends IService<PCMGXXKTEMP>{

    PCMGXXKTEMP getDraft(PCMGXXKTEMP et) ;
    boolean create(PCMGXXKTEMP et) ;
    void createBatch(List<PCMGXXKTEMP> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMGXXKTEMP et) ;
    boolean save(PCMGXXKTEMP et) ;
    void saveBatch(List<PCMGXXKTEMP> list) ;
    PCMGXXKTEMP get(String key) ;
    boolean update(PCMGXXKTEMP et) ;
    void updateBatch(List<PCMGXXKTEMP> list) ;
    Page<PCMGXXKTEMP> searchDefault(PCMGXXKTEMPSearchContext context) ;
    List<PCMGXXKTEMP> selectByPcmgxmlid(String pcmgxmlid) ;
    void removeByPcmgxmlid(String pcmgxmlid) ;
    List<PCMGXXKTEMP> selectByPcmxkmlid(String pcmxkmlid) ;
    void removeByPcmxkmlid(String pcmxkmlid) ;
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

    List<PCMGXXKTEMP> getPcmgxxktempByIds(List<String> ids) ;
    List<PCMGXXKTEMP> getPcmgxxktempByEntities(List<PCMGXXKTEMP> entities) ;

}


