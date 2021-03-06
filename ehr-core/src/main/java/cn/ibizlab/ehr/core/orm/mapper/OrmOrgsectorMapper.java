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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgsectorSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmOrgsectorMapper extends BaseMapper<OrmOrgsector>{

    Page<OrmOrgsector> searchCURORMORG(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchXMBBZGL(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchJSYXMB(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchCurZZBM(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchCurZZBM_KQSZ(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchCURORG(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchCurOrgSector(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchDefault(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchBaseInfo(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchDQZZXBM(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchRsshInfo(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchSubOrgsector(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchPimpersonInfoOrgsector(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchHisInfo(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchSubZZBM(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchProExpandInfo(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    Page<OrmOrgsector> searchBMBZGL(IPage page, @Param("srf") OrmOrgsectorSearchContext context, @Param("ew") Wrapper<OrmOrgsector> wrapper) ;
    @Override
    OrmOrgsector selectById(Serializable id);
    @Override
    int insert(OrmOrgsector entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmOrgsector entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmOrgsector entity, @Param("ew") Wrapper<OrmOrgsector> updateWrapper);
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

    List<OrmOrgsector> selectByPorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<OrmOrgsector> selectByProdepid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<OrmOrgsector> selectByOrgid(@Param("orgid") Serializable orgid) ;

    List<OrmOrgsector> selectByOrmxmglid(@Param("ormxmglid") Serializable ormxmglid) ;

    List<OrmOrgsector> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<OrmOrgsector> selectByProleaderid(@Param("pimpersonid") Serializable pimpersonid) ;

}
