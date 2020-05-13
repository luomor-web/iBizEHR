package cn.ibizlab.ehr.core.wf.service;

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

import cn.ibizlab.ehr.core.wf.domain.WFReminder;
import cn.ibizlab.ehr.core.wf.filter.WFReminderSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFReminder] 服务对象接口
 */
public interface IWFReminderService extends IService<WFReminder>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(WFReminder et) ;
    void createBatch(List<WFReminder> list) ;
    boolean checkKey(WFReminder et) ;
    WFReminder get(String key) ;
    WFReminder getDraft(WFReminder et) ;
    boolean update(WFReminder et) ;
    void updateBatch(List<WFReminder> list) ;
    boolean save(WFReminder et) ;
    void saveBatch(List<WFReminder> list) ;
    Page<WFReminder> searchDefault(WFReminderSearchContext context) ;
    List<WFReminder> selectByWfstepactorid(String wfstepactorid) ;
    void removeByWfstepactorid(String wfstepactorid) ;
    List<WFReminder> selectByWfuserid(String wfuserid) ;
    void removeByWfuserid(String wfuserid) ;
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


