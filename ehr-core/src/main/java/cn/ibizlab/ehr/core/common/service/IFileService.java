package cn.ibizlab.ehr.core.common.service;

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

import cn.ibizlab.ehr.core.common.domain.File;
import cn.ibizlab.ehr.core.common.filter.FileSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[File] 服务对象接口
 */
public interface IFileService extends IService<File>{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    File getDraft(File et) ;
    boolean save(File et) ;
    void saveBatch(List<File> list) ;
    File get(String key) ;
    boolean checkKey(File et) ;
    boolean create(File et) ;
    void createBatch(List<File> list) ;
    boolean update(File et) ;
    void updateBatch(List<File> list) ;
    Page<File> searchDefault(FileSearchContext context) ;
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


