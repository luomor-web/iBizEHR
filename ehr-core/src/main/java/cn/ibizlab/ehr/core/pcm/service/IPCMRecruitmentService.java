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

import cn.ibizlab.ehr.core.pcm.domain.PCMRecruitment;
import cn.ibizlab.ehr.core.pcm.filter.PCMRecruitmentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PCMRecruitment] 服务对象接口
 */
public interface IPCMRecruitmentService extends IService<PCMRecruitment>{

    PCMRecruitment getDraft(PCMRecruitment et) ;
    PCMRecruitment get(String key) ;
    boolean save(PCMRecruitment et) ;
    void saveBatch(List<PCMRecruitment> list) ;
    boolean create(PCMRecruitment et) ;
    void createBatch(List<PCMRecruitment> list) ;
    boolean checkKey(PCMRecruitment et) ;
    boolean update(PCMRecruitment et) ;
    void updateBatch(List<PCMRecruitment> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<PCMRecruitment> searchNBZP(PCMRecruitmentSearchContext context) ;
    Page<PCMRecruitment> searchDefault(PCMRecruitmentSearchContext context) ;
    List<PCMRecruitment> selectByOrmdutyid(String ormdutyid) ;
    void removeByOrmdutyid(String ormdutyid) ;
    List<PCMRecruitment> selectByOrmorgsectorid(String orgsectorid) ;
    void removeByOrmorgsectorid(String orgsectorid) ;
    List<PCMRecruitment> selectByOrmorgid(String orgid) ;
    void removeByOrmorgid(String orgid) ;
    List<PCMRecruitment> selectByOrmpostid(String ormpostid) ;
    void removeByOrmpostid(String ormpostid) ;
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


