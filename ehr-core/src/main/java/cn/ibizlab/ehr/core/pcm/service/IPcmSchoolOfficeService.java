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

import cn.ibizlab.ehr.core.pcm.domain.PcmSchoolOffice;
import cn.ibizlab.ehr.core.pcm.filter.PcmSchoolOfficeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmSchoolOffice] 服务对象接口
 */
public interface IPcmSchoolOfficeService extends IService<PcmSchoolOffice>{

    PcmSchoolOffice get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PcmSchoolOffice et) ;
    PcmSchoolOffice getDraft(PcmSchoolOffice et) ;
    boolean update(PcmSchoolOffice et) ;
    void updateBatch(List<PcmSchoolOffice> list) ;
    boolean save(PcmSchoolOffice et) ;
    void saveBatch(List<PcmSchoolOffice> list) ;
    boolean create(PcmSchoolOffice et) ;
    void createBatch(List<PcmSchoolOffice> list) ;
    Page<PcmSchoolOffice> searchDefault(PcmSchoolOfficeSearchContext context) ;
    List<PcmSchoolOffice> selectByPcmprofileid(String pcmprofileid) ;
    void removeByPcmprofileid(String pcmprofileid) ;
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

    List<PcmSchoolOffice> getPcmschoolofficeByIds(List<String> ids) ;
    List<PcmSchoolOffice> getPcmschoolofficeByEntities(List<PcmSchoolOffice> entities) ;

}


