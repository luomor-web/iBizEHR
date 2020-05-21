package cn.ibizlab.ehr.core.orm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.orm.domain.ORMRANK;
import cn.ibizlab.ehr.core.orm.filter.ORMRANKSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMRANKMapper extends BaseMapper<ORMRANK>{

    Page<ORMRANK> searchJZRANK(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    Page<ORMRANK> searchJSRANK(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    Page<ORMRANK> searchDJYX(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    Page<ORMRANK> searchJSNRANK(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    Page<ORMRANK> searchDefault(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    Page<ORMRANK> searchCurRank(IPage page, @Param("srf") ORMRANKSearchContext context, @Param("ew") Wrapper<ORMRANK> wrapper) ;
    @Override
    ORMRANK selectById(Serializable id);
    @Override
    int insert(ORMRANK entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMRANK entity);
    @Override
    int update(@Param(Constants.ENTITY) ORMRANK entity, @Param("ew") Wrapper<ORMRANK> updateWrapper);
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

}
