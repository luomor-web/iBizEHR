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
import cn.ibizlab.ehr.core.pim.domain.PimLanguageAbility;
import cn.ibizlab.ehr.core.pim.filter.PimLanguageAbilitySearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimLanguageAbilityMapper extends BaseMapper<PimLanguageAbility>{

    Page<PimLanguageAbility> searchJLSSGR(IPage page, @Param("srf") PimLanguageAbilitySearchContext context, @Param("ew") Wrapper<PimLanguageAbility> wrapper) ;
    Page<PimLanguageAbility> searchDefault(IPage page, @Param("srf") PimLanguageAbilitySearchContext context, @Param("ew") Wrapper<PimLanguageAbility> wrapper) ;
    Page<PimLanguageAbility> searchJLSS(IPage page, @Param("srf") PimLanguageAbilitySearchContext context, @Param("ew") Wrapper<PimLanguageAbility> wrapper) ;
    Page<PimLanguageAbility> searchZIZHU(IPage page, @Param("srf") PimLanguageAbilitySearchContext context, @Param("ew") Wrapper<PimLanguageAbility> wrapper) ;
    Page<PimLanguageAbility> searchJLSSGLY(IPage page, @Param("srf") PimLanguageAbilitySearchContext context, @Param("ew") Wrapper<PimLanguageAbility> wrapper) ;
    @Override
    PimLanguageAbility selectById(Serializable id);
    @Override
    int insert(PimLanguageAbility entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimLanguageAbility entity);
    @Override
    int update(@Param(Constants.ENTITY) PimLanguageAbility entity, @Param("ew") Wrapper<PimLanguageAbility> updateWrapper);
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

    List<PimLanguageAbility> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
