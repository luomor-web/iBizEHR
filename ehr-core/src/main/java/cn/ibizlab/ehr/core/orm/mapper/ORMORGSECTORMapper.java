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
import cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSECTORSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMORGSECTORMapper extends BaseMapper<ORMORGSECTOR>{

    Page<ORMORGSECTOR> searchCURORMORG(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchXMBBZGL(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchJSYXMB(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchCurZZBM(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchCurZZBM_KQSZ(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchCURORG(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchCurOrgSector(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchDefault(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchBaseInfo(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchDQZZXBM(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchRsshInfo(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchSubOrgsector(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchPimpersonInfoOrgsector(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchHisInfo(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchSubZZBM(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchProExpandInfo(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    Page<ORMORGSECTOR> searchBMBZGL(IPage page, @Param("srf") ORMORGSECTORSearchContext context, @Param("ew") Wrapper<ORMORGSECTOR> wrapper) ;
    @Override
    ORMORGSECTOR selectById(Serializable id);
    @Override
    int insert(ORMORGSECTOR entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMORGSECTOR entity);
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

    List<ORMORGSECTOR> selectByPorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<ORMORGSECTOR> selectByProdepid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<ORMORGSECTOR> selectByOrgid(@Param("orgid") Serializable orgid) ;

    List<ORMORGSECTOR> selectByOrmxmglid(@Param("ormxmglid") Serializable ormxmglid) ;

    List<ORMORGSECTOR> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<ORMORGSECTOR> selectByProleaderid(@Param("pimpersonid") Serializable pimpersonid) ;

}
