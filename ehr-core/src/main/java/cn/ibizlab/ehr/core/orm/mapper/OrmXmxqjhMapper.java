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
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqjhSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmXmxqjhMapper extends BaseMapper<OrmXmxqjh>{

    Page<OrmXmxqjh> searchBaseInfo(IPage page, @Param("srf") OrmXmxqjhSearchContext context, @Param("ew") Wrapper<OrmXmxqjh> wrapper) ;
    Page<OrmXmxqjh> searchXMTJQX(IPage page, @Param("srf") OrmXmxqjhSearchContext context, @Param("ew") Wrapper<OrmXmxqjh> wrapper) ;
    Page<OrmXmxqjh> searchDefault(IPage page, @Param("srf") OrmXmxqjhSearchContext context, @Param("ew") Wrapper<OrmXmxqjh> wrapper) ;
    Page<OrmXmxqjh> searchRsshInfo(IPage page, @Param("srf") OrmXmxqjhSearchContext context, @Param("ew") Wrapper<OrmXmxqjh> wrapper) ;
    @Override
    OrmXmxqjh selectById(Serializable id);
    @Override
    int insert(OrmXmxqjh entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmXmxqjh entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmXmxqjh entity, @Param("ew") Wrapper<OrmXmxqjh> updateWrapper);
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

    List<OrmXmxqjh> selectByOrmxmglid(@Param("ormxmglid") Serializable ormxmglid) ;

    List<OrmXmxqjh> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
