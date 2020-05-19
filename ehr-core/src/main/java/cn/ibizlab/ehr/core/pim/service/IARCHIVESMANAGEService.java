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

import cn.ibizlab.ehr.core.pim.domain.ARCHIVESMANAGE;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVESMANAGESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[ARCHIVESMANAGE] 服务对象接口
 */
public interface IARCHIVESMANAGEService extends IService<ARCHIVESMANAGE>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    ARCHIVESMANAGE getDraft(ARCHIVESMANAGE et) ;
    boolean update(ARCHIVESMANAGE et) ;
    void updateBatch(List<ARCHIVESMANAGE> list) ;
    boolean create(ARCHIVESMANAGE et) ;
    void createBatch(List<ARCHIVESMANAGE> list) ;
    boolean save(ARCHIVESMANAGE et) ;
    void saveBatch(List<ARCHIVESMANAGE> list) ;
    boolean checkKey(ARCHIVESMANAGE et) ;
    ARCHIVESMANAGE get(String key) ;
    Page<ARCHIVESMANAGE> searchDefault(ARCHIVESMANAGESearchContext context) ;
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


