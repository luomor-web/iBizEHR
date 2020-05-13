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

import cn.ibizlab.ehr.core.pcm.domain.PCMZPMEGL;
import cn.ibizlab.ehr.core.pcm.filter.PCMZPMEGLSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMZPMEGL] 服务对象接口
 */
public interface IPCMZPMEGLService extends IService<PCMZPMEGL>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PCMZPMEGL et) ;
    boolean save(PCMZPMEGL et) ;
    void saveBatch(List<PCMZPMEGL> list) ;
    boolean update(PCMZPMEGL et) ;
    void updateBatch(List<PCMZPMEGL> list) ;
    boolean create(PCMZPMEGL et) ;
    void createBatch(List<PCMZPMEGL> list) ;
    PCMZPMEGL get(String key) ;
    PCMZPMEGL getDraft(PCMZPMEGL et) ;
    Page<PCMZPMEGL> searchCurND(PCMZPMEGLSearchContext context) ;
    Page<PCMZPMEGL> searchDefault(PCMZPMEGLSearchContext context) ;
    List<PCMZPMEGL> selectByOrmorgid(String orgid) ;
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


