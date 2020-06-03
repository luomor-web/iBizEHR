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

import cn.ibizlab.ehr.core.pcm.domain.PcmRecruitment;
import cn.ibizlab.ehr.core.pcm.filter.PcmRecruitmentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmRecruitment] 服务对象接口
 */
public interface IPcmRecruitmentService extends IService<PcmRecruitment>{

    PcmRecruitment getDraft(PcmRecruitment et) ;
    PcmRecruitment get(String key) ;
    boolean save(PcmRecruitment et) ;
    void saveBatch(List<PcmRecruitment> list) ;
    boolean create(PcmRecruitment et) ;
    void createBatch(List<PcmRecruitment> list) ;
    boolean checkKey(PcmRecruitment et) ;
    boolean update(PcmRecruitment et) ;
    void updateBatch(List<PcmRecruitment> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmRecruitment> searchNBZP(PcmRecruitmentSearchContext context) ;
    Page<PcmRecruitment> searchDefault(PcmRecruitmentSearchContext context) ;
    List<PcmRecruitment> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PcmRecruitment> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmRecruitment> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmRecruitment> selectByOrmpostid(String ormpostid) ;
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

    List<PcmRecruitment> getPcmrecruitmentByIds(List<String> ids) ;
    List<PcmRecruitment> getPcmrecruitmentByEntities(List<PcmRecruitment> entities) ;

}


