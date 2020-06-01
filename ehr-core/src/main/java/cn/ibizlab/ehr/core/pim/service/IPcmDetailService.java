package cn.ibizlab.ehr.core.pim.service;

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

import cn.ibizlab.ehr.core.pim.domain.PcmDetail;
import cn.ibizlab.ehr.core.pim.filter.PcmDetailSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmDetail] 服务对象接口
 */
public interface IPcmDetailService extends IService<PcmDetail>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(PcmDetail et) ;
    void updateBatch(List<PcmDetail> list) ;
    boolean create(PcmDetail et) ;
    void createBatch(List<PcmDetail> list) ;
    boolean checkKey(PcmDetail et) ;
    PcmDetail get(String key) ;
    boolean save(PcmDetail et) ;
    void saveBatch(List<PcmDetail> list) ;
    PcmDetail getDraft(PcmDetail et) ;
    Page<PcmDetail> searchDefault(PcmDetailSearchContext context) ;
    List<PcmDetail> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmDetail> selectByOrmorgid(String orgid) ;
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

    List<PcmDetail> getPcmdetailByIds(List<String> ids) ;
    List<PcmDetail> getPcmdetailByEntities(List<PcmDetail> entities) ;

}


