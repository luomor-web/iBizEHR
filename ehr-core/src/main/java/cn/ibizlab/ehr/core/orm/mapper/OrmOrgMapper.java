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
import cn.ibizlab.ehr.core.orm.domain.OrmOrg;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmOrgMapper extends BaseMapper<OrmOrg>{

    Page<OrmOrg> searchALLSIGNORG(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchAllLevelTwoOrg2(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchOrglist_Profile(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<HashMap> searchREP_ORG(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchAuthOrg(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchGSGWZY(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchSubSubOrg(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchDefault(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchCurChild(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchSJYXZZ(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<HashMap> searchREP_ORGPNUM(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchKZSJZZXZ(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchDanQian(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchAllLevelTwoOrg(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchSubOrg(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchHTGLDW(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchKZXLXZ(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchAuthSJYXZZ(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchUseByFP(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    Page<OrmOrg> searchCurPorg(IPage page, @Param("srf") OrmOrgSearchContext context, @Param("ew") Wrapper<OrmOrg> wrapper) ;
    @Override
    OrmOrg selectById(Serializable id);
    @Override
    int insert(OrmOrg entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmOrg entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmOrg entity, @Param("ew") Wrapper<OrmOrg> updateWrapper);
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

    List<OrmOrg> selectByPorgid(@Param("orgid") Serializable orgid) ;

}
