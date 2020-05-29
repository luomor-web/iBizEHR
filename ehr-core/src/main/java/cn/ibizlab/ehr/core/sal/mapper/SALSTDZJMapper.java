package cn.ibizlab.ehr.core.sal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.sal.domain.SALSTDZJ;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZJSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SALSTDZJMapper extends BaseMapper<SALSTDZJ>{

    Page<SALSTDZJ> searchDefault(IPage page, @Param("srf") SALSTDZJSearchContext context, @Param("ew") Wrapper<SALSTDZJ> wrapper) ;
    @Override
    SALSTDZJ selectById(Serializable id);
    @Override
    int insert(SALSTDZJ entity);
    @Override
    int updateById(@Param(Constants.ENTITY) SALSTDZJ entity);
    @Override
    int update(@Param(Constants.ENTITY) SALSTDZJ entity, @Param("ew") Wrapper<SALSTDZJ> updateWrapper);
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

    List<SALSTDZJ> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

}
