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

import cn.ibizlab.ehr.core.pcm.domain.PCMNotice;
import cn.ibizlab.ehr.core.pcm.filter.PCMNoticeSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMNotice] 服务对象接口
 */
public interface IPCMNoticeService extends IService<PCMNotice>{

    boolean create(PCMNotice et) ;
    void createBatch(List<PCMNotice> list) ;
    boolean update(PCMNotice et) ;
    void updateBatch(List<PCMNotice> list) ;
    boolean save(PCMNotice et) ;
    void saveBatch(List<PCMNotice> list) ;
    PCMNotice get(String key) ;
    PCMNotice getDraft(PCMNotice et) ;
    boolean checkKey(PCMNotice et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMNotice> searchNOTICE_DAGLYDQ(PCMNoticeSearchContext context) ;
    Page<PCMNotice> searchNOTICE_XCZYDQ(PCMNoticeSearchContext context) ;
    Page<PCMNotice> searchNOTICE_KQZYDQ(PCMNoticeSearchContext context) ;
    Page<PCMNotice> searchNOTICE_RSZYDQ(PCMNoticeSearchContext context) ;
    Page<PCMNotice> searchDefault(PCMNoticeSearchContext context) ;
    Page<PCMNotice> searchNOTICE_SBFLZYDQ(PCMNoticeSearchContext context) ;
    List<PCMNotice> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMNotice> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMNotice> selectByPimdistirbutionid(String pimdistirbutionid) ;
    void removeByPimdistirbutionid(String pimdistirbutionid) ;
    List<PCMNotice> selectByPimpersonid(String pimpersonid) ;
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


