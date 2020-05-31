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
import cn.ibizlab.ehr.core.pim.domain.PimExitandentry;
import cn.ibizlab.ehr.core.pim.filter.PimExitandentrySearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimExitandentryMapper extends BaseMapper<PimExitandentry>{

    Page<PimExitandentry> searchYGCGJ(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    Page<PimExitandentry> searchYGZZ(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    Page<PimExitandentry> searchMOBJLSS(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    Page<PimExitandentry> searchYSCGJ(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    Page<PimExitandentry> searchFormType(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    Page<PimExitandentry> searchDefault(IPage page, @Param("srf") PimExitandentrySearchContext context, @Param("ew") Wrapper<PimExitandentry> wrapper) ;
    @Override
    PimExitandentry selectById(Serializable id);
    @Override
    int insert(PimExitandentry entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimExitandentry entity);
    @Override
    int update(@Param(Constants.ENTITY) PimExitandentry entity, @Param("ew") Wrapper<PimExitandentry> updateWrapper);
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

    List<PimExitandentry> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
