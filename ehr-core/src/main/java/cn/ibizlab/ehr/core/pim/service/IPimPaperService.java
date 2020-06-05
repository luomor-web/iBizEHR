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

import cn.ibizlab.ehr.core.pim.domain.PimPaper;
import cn.ibizlab.ehr.core.pim.filter.PimPaperSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PimPaper] 服务对象接口
 */
public interface IPimPaperService extends IService<PimPaper>{

    boolean update(PimPaper et) ;
    void updateBatch(List<PimPaper> list) ;
    PimPaper getDraft(PimPaper et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(PimPaper et) ;
    void createBatch(List<PimPaper> list) ;
    PimPaper get(String key) ;
    boolean save(PimPaper et) ;
    void saveBatch(List<PimPaper> list) ;
    boolean checkKey(PimPaper et) ;
    Page<PimPaper> searchDefault(PimPaperSearchContext context) ;
    Page<PimPaper> searchJLSSGR(PimPaperSearchContext context) ;
    Page<PimPaper> searchJLSSGLY(PimPaperSearchContext context) ;
    List<PimPaper> selectByPimpersonid(String pimpersonid) ;
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

    List<PimPaper> getPimpaperByIds(List<String> ids) ;
    List<PimPaper> getPimpaperByEntities(List<PimPaper> entities) ;

}


