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

import cn.ibizlab.ehr.core.wf.domain.WFUIWizard;
import cn.ibizlab.ehr.core.wf.filter.WFUIWizardSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFUIWizard] 服务对象接口
 */
public interface IWFUIWizardService extends IService<WFUIWizard>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(WFUIWizard et) ;
    void updateBatch(List<WFUIWizard> list) ;
    boolean save(WFUIWizard et) ;
    void saveBatch(List<WFUIWizard> list) ;
    WFUIWizard getDraft(WFUIWizard et) ;
    boolean create(WFUIWizard et) ;
    void createBatch(List<WFUIWizard> list) ;
    boolean checkKey(WFUIWizard et) ;
    WFUIWizard get(String key) ;
    Page<WFUIWizard> searchDefault(WFUIWizardSearchContext context) ;
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


