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

import cn.ibizlab.ehr.core.pim.domain.PIMGWTYPE;
import cn.ibizlab.ehr.core.pim.filter.PIMGWTYPESearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMGWTYPE] 服务对象接口
 */
public interface IPIMGWTYPEService extends IService<PIMGWTYPE>{

    boolean save(PIMGWTYPE et) ;
    void saveBatch(List<PIMGWTYPE> list) ;
    PIMGWTYPE getDraft(PIMGWTYPE et) ;
    PIMGWTYPE get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(PIMGWTYPE et) ;
    boolean update(PIMGWTYPE et) ;
    void updateBatch(List<PIMGWTYPE> list) ;
    boolean create(PIMGWTYPE et) ;
    void createBatch(List<PIMGWTYPE> list) ;
    Page<PIMGWTYPE> searchDefault(PIMGWTYPESearchContext context) ;
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


