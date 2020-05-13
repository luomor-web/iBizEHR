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

import cn.ibizlab.ehr.core.pcm.domain.PCMYDJDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJDMXSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMYDJDMX] 服务对象接口
 */
public interface IPCMYDJDMXService extends IService<PCMYDJDMX>{

    PCMYDJDMX get(String key) ;
    PCMYDJDMX fillPersonInfo(PCMYDJDMX et) ;
    PCMYDJDMX getDraft(PCMYDJDMX et) ;
    boolean update(PCMYDJDMX et) ;
    void updateBatch(List<PCMYDJDMX> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PCMYDJDMX rYHG(PCMYDJDMX et) ;
    boolean checkKey(PCMYDJDMX et) ;
    boolean save(PCMYDJDMX et) ;
    void saveBatch(List<PCMYDJDMX> list) ;
    boolean create(PCMYDJDMX et) ;
    void createBatch(List<PCMYDJDMX> list) ;
    Page<PCMYDJDMX> searchJDGLDQ(PCMYDJDMXSearchContext context) ;
    Page<PCMYDJDMX> searchJDLSJLDQ(PCMYDJDMXSearchContext context) ;
    Page<PCMYDJDMX> searchDefault(PCMYDJDMXSearchContext context) ;
    List<PCMYDJDMX> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMYDJDMX> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMYDJDMX> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMYDJDMX> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
    List<PCMYDJDMX> selectByPimdistirbutionid(String pimdistirbutionid) ;
    void removeByPimdistirbutionid(String pimdistirbutionid) ;
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


