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

import cn.ibizlab.ehr.core.pcm.domain.PcmNotice;
import cn.ibizlab.ehr.core.pcm.filter.PcmNoticeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PcmNotice] 服务对象接口
 */
public interface IPcmNoticeService extends IService<PcmNotice>{

    boolean create(PcmNotice et) ;
    void createBatch(List<PcmNotice> list) ;
    boolean update(PcmNotice et) ;
    void updateBatch(List<PcmNotice> list) ;
    boolean save(PcmNotice et) ;
    void saveBatch(List<PcmNotice> list) ;
    PcmNotice get(String key) ;
    PcmNotice getDraft(PcmNotice et) ;
    boolean checkKey(PcmNotice et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PcmNotice> searchNOTICE_DAGLYDQ(PcmNoticeSearchContext context) ;
    Page<PcmNotice> searchNOTICE_XCZYDQ(PcmNoticeSearchContext context) ;
    Page<PcmNotice> searchNOTICE_KQZYDQ(PcmNoticeSearchContext context) ;
    Page<PcmNotice> searchNOTICE_RSZYDQ(PcmNoticeSearchContext context) ;
    Page<PcmNotice> searchDefault(PcmNoticeSearchContext context) ;
    Page<PcmNotice> searchNOTICE_SBFLZYDQ(PcmNoticeSearchContext context) ;
    List<PcmNotice> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PcmNotice> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PcmNotice> selectByPimdistirbutionid(String pimdistirbutionid) ;
    void removeByPimdistirbutionid(String pimdistirbutionid) ;
    List<PcmNotice> selectByPimpersonid(String pimpersonid) ;
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

    List<PcmNotice> getPcmnoticeByIds(List<String> ids) ;
    List<PcmNotice> getPcmnoticeByEntities(List<PcmNotice> entities) ;

}


