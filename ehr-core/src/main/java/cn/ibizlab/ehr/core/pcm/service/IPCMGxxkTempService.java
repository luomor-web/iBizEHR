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

import cn.ibizlab.ehr.core.pcm.domain.PCMGxxkTemp;
import cn.ibizlab.ehr.core.pcm.filter.PCMGxxkTempSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMGxxkTemp] 服务对象接口
 */
public interface IPCMGxxkTempService extends IService<PCMGxxkTemp>{

    PCMGxxkTemp getDraft(PCMGxxkTemp et) ;
    boolean create(PCMGxxkTemp et) ;
    void createBatch(List<PCMGxxkTemp> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMGxxkTemp et) ;
    boolean save(PCMGxxkTemp et) ;
    void saveBatch(List<PCMGxxkTemp> list) ;
    PCMGxxkTemp get(String key) ;
    boolean update(PCMGxxkTemp et) ;
    void updateBatch(List<PCMGxxkTemp> list) ;
    Page<PCMGxxkTemp> searchDefault(PCMGxxkTempSearchContext context) ;
    List<PCMGxxkTemp> selectByPcmgxmlid(String pcmgxmlid) ;
    void removeByPcmgxmlid(String pcmgxmlid) ;
    List<PCMGxxkTemp> selectByPcmxkmlid(String pcmxkmlid) ;
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

    List<PCMGxxkTemp> getPcmgxxktempByIds(List<String> ids) ;
    List<PCMGxxkTemp> getPcmgxxktempByEntities(List<PCMGxxkTemp> entities) ;

}


