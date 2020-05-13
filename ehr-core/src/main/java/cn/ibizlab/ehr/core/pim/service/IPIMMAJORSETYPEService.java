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

import cn.ibizlab.ehr.core.pim.domain.PIMMAJORSETYPE;
import cn.ibizlab.ehr.core.pim.filter.PIMMAJORSETYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMMAJORSETYPE] 服务对象接口
 */
public interface IPIMMAJORSETYPEService extends IService<PIMMAJORSETYPE>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMMAJORSETYPE et) ;
    PIMMAJORSETYPE get(String key) ;
    boolean save(PIMMAJORSETYPE et) ;
    void saveBatch(List<PIMMAJORSETYPE> list) ;
    boolean create(PIMMAJORSETYPE et) ;
    void createBatch(List<PIMMAJORSETYPE> list) ;
    PIMMAJORSETYPE getDraft(PIMMAJORSETYPE et) ;
    boolean update(PIMMAJORSETYPE et) ;
    void updateBatch(List<PIMMAJORSETYPE> list) ;
    Page<PIMMAJORSETYPE> searchDefault(PIMMAJORSETYPESearchContext context) ;
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


