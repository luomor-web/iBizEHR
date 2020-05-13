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

import cn.ibizlab.ehr.core.pcm.domain.PCMMonth;
import cn.ibizlab.ehr.core.pcm.filter.PCMMonthSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMMonth] 服务对象接口
 */
public interface IPCMMonthService extends IService<PCMMonth>{

    boolean update(PCMMonth et) ;
    void updateBatch(List<PCMMonth> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PCMMonth et) ;
    void saveBatch(List<PCMMonth> list) ;
    boolean create(PCMMonth et) ;
    void createBatch(List<PCMMonth> list) ;
    boolean checkKey(PCMMonth et) ;
    PCMMonth get(String key) ;
    PCMMonth getDraft(PCMMonth et) ;
    Page<PCMMonth> searchDefault(PCMMonthSearchContext context) ;
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

