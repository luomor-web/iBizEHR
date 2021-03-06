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
import cn.ibizlab.ehr.core.pim.domain.PimWorkHistory;
import cn.ibizlab.ehr.core.pim.filter.PimWorkHistorySearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimWorkHistoryMapper extends BaseMapper<PimWorkHistory>{

    Page<PimWorkHistory> searchDefault(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchIsMain(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchJLSSGLY(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchZIZHU(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchJLSS(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchFAZZSY(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    Page<PimWorkHistory> searchJLSSGR(IPage page, @Param("srf") PimWorkHistorySearchContext context, @Param("ew") Wrapper<PimWorkHistory> wrapper) ;
    @Override
    PimWorkHistory selectById(Serializable id);
    @Override
    int insert(PimWorkHistory entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimWorkHistory entity);
    @Override
    int update(@Param(Constants.ENTITY) PimWorkHistory entity, @Param("ew") Wrapper<PimWorkHistory> updateWrapper);
    @Override
    int deleteById(Serializable id);
     /**
      * ???????????????SQL
      * @param sql
      * @return
      */
     @Select("${sql}")
     List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map param);

    List<PimWorkHistory> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<PimWorkHistory> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
