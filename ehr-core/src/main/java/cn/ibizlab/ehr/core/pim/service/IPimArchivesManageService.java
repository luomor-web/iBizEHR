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

import cn.ibizlab.ehr.core.pim.domain.PimArchivesManage;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesManageSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimArchivesManage] 服务对象接口
 */
public interface IPimArchivesManageService extends IService<PimArchivesManage>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PimArchivesManage getDraft(PimArchivesManage et) ;
    boolean update(PimArchivesManage et) ;
    void updateBatch(List<PimArchivesManage> list) ;
    boolean create(PimArchivesManage et) ;
    void createBatch(List<PimArchivesManage> list) ;
    boolean save(PimArchivesManage et) ;
    void saveBatch(List<PimArchivesManage> list) ;
    boolean checkKey(PimArchivesManage et) ;
    PimArchivesManage get(String key) ;
    Page<PimArchivesManage> searchDefault(PimArchivesManageSearchContext context) ;
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

    List<PimArchivesManage> getPimarchivesmanageByIds(List<String> ids) ;
    List<PimArchivesManage> getPimarchivesmanageByEntities(List<PimArchivesManage> entities) ;

}


