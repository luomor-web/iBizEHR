package cn.ibizlab.ehr.core.vac.service;

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

import cn.ibizlab.ehr.core.vac.domain.VACDAYOFF;
import cn.ibizlab.ehr.core.vac.filter.VACDAYOFFSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[VACDAYOFF] 服务对象接口
 */
public interface IVACDAYOFFService extends IService<VACDAYOFF>{

    VACDAYOFF get(String key) ;
    VACDAYOFF getDraft(VACDAYOFF et) ;
    boolean checkKey(VACDAYOFF et) ;
    boolean save(VACDAYOFF et) ;
    void saveBatch(List<VACDAYOFF> list) ;
    boolean create(VACDAYOFF et) ;
    void createBatch(List<VACDAYOFF> list) ;
    boolean update(VACDAYOFF et) ;
    void updateBatch(List<VACDAYOFF> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<VACDAYOFF> searchDefault(VACDAYOFFSearchContext context) ;
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

    List<VACDAYOFF> getVacdayoffByIds(List<String> ids) ;
    List<VACDAYOFF> getVacdayoffByEntities(List<VACDAYOFF> entities) ;

}


