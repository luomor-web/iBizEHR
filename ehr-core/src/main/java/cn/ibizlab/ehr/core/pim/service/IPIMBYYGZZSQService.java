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

import cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ;
import cn.ibizlab.ehr.core.pim.filter.PIMBYYGZZSQSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PIMBYYGZZSQ] 服务对象接口
 */
public interface IPIMBYYGZZSQService extends IService<PIMBYYGZZSQ>{

    PIMBYYGZZSQ get(String key) ;
    boolean update(PIMBYYGZZSQ et) ;
    void updateBatch(List<PIMBYYGZZSQ> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(PIMBYYGZZSQ et) ;
    void saveBatch(List<PIMBYYGZZSQ> list) ;
    PIMBYYGZZSQ getDraft(PIMBYYGZZSQ et) ;
    boolean create(PIMBYYGZZSQ et) ;
    void createBatch(List<PIMBYYGZZSQ> list) ;
    boolean checkKey(PIMBYYGZZSQ et) ;
    Page<PIMBYYGZZSQ> searchDefault(PIMBYYGZZSQSearchContext context) ;
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


