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
import cn.ibizlab.ehr.core.orm.domain.OrmPost;
import cn.ibizlab.ehr.core.orm.filter.OrmPostSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmPostMapper extends BaseMapper<OrmPost>{

    Page<OrmPost> searchEJZZGW(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchAuthPost(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchCurOrg(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchDQGW(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchDQORGGW(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchGWXH(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchDefault(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchJZBGWCX(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    Page<OrmPost> searchCXGW(IPage page, @Param("srf") OrmPostSearchContext context, @Param("ew") Wrapper<OrmPost> wrapper) ;
    @Override
    OrmPost selectById(Serializable id);
    @Override
    int insert(OrmPost entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmPost entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmPost entity, @Param("ew") Wrapper<OrmPost> updateWrapper);
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

    List<OrmPost> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

}
