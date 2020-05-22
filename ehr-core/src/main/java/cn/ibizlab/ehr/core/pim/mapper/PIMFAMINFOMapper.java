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
import cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO;
import cn.ibizlab.ehr.core.pim.filter.PIMFAMINFOSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMFAMINFOMapper extends BaseMapper<PIMFAMINFO>{

    Page<PIMFAMINFO> searchJLSSGR(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchJTLXR(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchDefault(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchJLSSGLY(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchFAZZSY(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchZIZHU(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    Page<PIMFAMINFO> searchJLSS(IPage page, @Param("srf") PIMFAMINFOSearchContext context, @Param("ew") Wrapper<PIMFAMINFO> wrapper) ;
    @Override
    PIMFAMINFO selectById(Serializable id);
    @Override
    int insert(PIMFAMINFO entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMFAMINFO entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMFAMINFO entity, @Param("ew") Wrapper<PIMFAMINFO> updateWrapper);
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

    List<PIMFAMINFO> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
