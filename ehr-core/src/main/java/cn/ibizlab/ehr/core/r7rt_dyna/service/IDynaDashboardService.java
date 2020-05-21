package cn.ibizlab.ehr.core.r7rt_dyna.service;

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

import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaDashboard;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaDashboardSearchContext;


/**
 * 实体[DynaDashboard] 服务对象接口
 */
public interface IDynaDashboardService{

    boolean save(DynaDashboard et) ;
    void saveBatch(List<DynaDashboard> list) ;
    boolean update(DynaDashboard et) ;
    void updateBatch(List<DynaDashboard> list) ;
    DynaDashboard get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(DynaDashboard et) ;
    DynaDashboard getDraft(DynaDashboard et) ;
    boolean create(DynaDashboard et) ;
    void createBatch(List<DynaDashboard> list) ;
    Page<DynaDashboard> searchDefault(DynaDashboardSearchContext context) ;

}



