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
import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
import cn.ibizlab.ehr.core.pim.filter.PimFaminfoSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimFaminfoMapper extends BaseMapper<PimFaminfo>{

    Page<PimFaminfo> searchJLSSGR(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchJTLXR(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchDefault(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchJLSSGLY(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchFAZZSY(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchZIZHU(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    Page<PimFaminfo> searchJLSS(IPage page, @Param("srf") PimFaminfoSearchContext context, @Param("ew") Wrapper<PimFaminfo> wrapper) ;
    @Override
    PimFaminfo selectById(Serializable id);
    @Override
    int insert(PimFaminfo entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimFaminfo entity);
    @Override
    int update(@Param(Constants.ENTITY) PimFaminfo entity, @Param("ew") Wrapper<PimFaminfo> updateWrapper);
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

    List<PimFaminfo> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
