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
import cn.ibizlab.ehr.core.pim.domain.PIMWORKHISTORY;
import cn.ibizlab.ehr.core.pim.filter.PIMWORKHISTORYSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMWORKHISTORYMapper extends BaseMapper<PIMWORKHISTORY>{

    Page<PIMWORKHISTORY> searchDefault(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchIsMain(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchJLSSGLY(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchZIZHU(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchJLSS(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchFAZZSY(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    Page<PIMWORKHISTORY> searchJLSSGR(IPage page, @Param("srf") PIMWORKHISTORYSearchContext context, @Param("ew") Wrapper<PIMWORKHISTORY> wrapper) ;
    @Override
    PIMWORKHISTORY selectById(Serializable id);
    @Override
    int insert(PIMWORKHISTORY entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMWORKHISTORY entity);
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

    List<PIMWORKHISTORY> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<PIMWORKHISTORY> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
