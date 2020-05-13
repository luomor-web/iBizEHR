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
import cn.ibizlab.ehr.core.orm.domain.ORMORG;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMORGMapper extends BaseMapper<ORMORG>{

    Page<ORMORG> searchALLSIGNORG(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchAllLevelTwoOrg2(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchOrglist_Profile(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<HashMap> searchREP_ORG(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchAuthOrg(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchGSGWZY(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchSubSubOrg(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchDefault(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchCurChild(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchSJYXZZ(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<HashMap> searchREP_ORGPNUM(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchKZSJZZXZ(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchDanQian(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchAllLevelTwoOrg(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchSubOrg(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchHTGLDW(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchKZXLXZ(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchAuthSJYXZZ(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchUseByFP(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    Page<ORMORG> searchCurPorg(IPage page, @Param("srf") ORMORGSearchContext context, @Param("ew") Wrapper<ORMORG> wrapper) ;
    @Override
    ORMORG selectById(Serializable id);
    @Override
    int insert(ORMORG entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMORG entity);
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

    List<ORMORG> selectByPorgid(@Param("orgid") Serializable orgid) ;

}
