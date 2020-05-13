package cn.ibizlab.ehr.core.pim.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pim.domain.PIMEDUCATION;
import cn.ibizlab.ehr.core.pim.filter.PIMEDUCATIONSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMEDUCATIONMapper extends BaseMapper<PIMEDUCATION>{

    Page<PIMEDUCATION> searchFAZZSY(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchJLSS(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchZIZHU(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchADMDYZG(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchPERSONAL(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchADMSYSTEM(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<PIMEDUCATION> searchDefault(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    Page<HashMap> searchREP_EDU(IPage page, @Param("srf") PIMEDUCATIONSearchContext context, @Param("ew") Wrapper<PIMEDUCATION> wrapper) ;
    @Override
    PIMEDUCATION selectById(Serializable id);
    @Override
    int insert(PIMEDUCATION entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMEDUCATION entity);
    @Override
    int deleteById(Serializable id);
     /**
      * 自定义查询SQL
      * @param sql
      * @return
      */
     @Select("${sql}")
     List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义更新SQL
    * @param sql
    * @return
    */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义插入SQL
    * @param sql
    * @return
    */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义删除SQL
    * @param sql
    * @return
    */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map param);

    List<PIMEDUCATION> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
