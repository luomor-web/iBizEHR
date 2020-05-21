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

import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaChart;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaChartSearchContext;


/**
 * 实体[DynaChart] 服务对象接口
 */
public interface IDynaChartService{

    DynaChart get(String key) ;
    DynaChart getDraft(DynaChart et) ;
    boolean checkKey(DynaChart et) ;
    boolean update(DynaChart et) ;
    void updateBatch(List<DynaChart> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(DynaChart et) ;
    void createBatch(List<DynaChart> list) ;
    boolean save(DynaChart et) ;
    void saveBatch(List<DynaChart> list) ;
    Page<DynaChart> searchDefault(DynaChartSearchContext context) ;

}



