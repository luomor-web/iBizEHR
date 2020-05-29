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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgInfo;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgInfoSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmOrgInfoMapper extends BaseMapper<OrmOrgInfo>{

    Page<OrmOrgInfo> searchSubOrgsector(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchCX(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchCurOrgsector(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchCurChild(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchCurPorg(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchSubPerson(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchDefault(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    Page<OrmOrgInfo> searchSuborg(IPage page, @Param("srf") OrmOrgInfoSearchContext context, @Param("ew") Wrapper<OrmOrgInfo> wrapper) ;
    @Override
    OrmOrgInfo selectById(Serializable id);
    @Override
    int insert(OrmOrgInfo entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmOrgInfo entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmOrgInfo entity, @Param("ew") Wrapper<OrmOrgInfo> updateWrapper);
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
