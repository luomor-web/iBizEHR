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
import cn.ibizlab.ehr.core.orm.domain.ORMUSER;
import cn.ibizlab.ehr.core.orm.filter.ORMUSERSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMUSERMapper extends BaseMapper<ORMUSER>{

    Page<ORMUSER> searchDQZZJXJZZ(IPage page, @Param("srf") ORMUSERSearchContext context, @Param("ew") Wrapper<ORMUSER> wrapper) ;
    Page<ORMUSER> searchDefault(IPage page, @Param("srf") ORMUSERSearchContext context, @Param("ew") Wrapper<ORMUSER> wrapper) ;
    @Override
    ORMUSER selectById(Serializable id);
    @Override
    int insert(ORMUSER entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMUSER entity);
    @Override
    int update(@Param(Constants.ENTITY) ORMUSER entity, @Param("ew") Wrapper<ORMUSER> updateWrapper);
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

    List<ORMUSER> selectByOrgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<ORMUSER> selectByOrgid(@Param("orgid") Serializable orgid) ;

}
