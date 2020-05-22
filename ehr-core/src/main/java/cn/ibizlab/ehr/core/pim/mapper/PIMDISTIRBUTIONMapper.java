package cn.ibizlab.ehr.core.pim.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;
import cn.ibizlab.ehr.core.pim.filter.PIMDISTIRBUTIONSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMDISTIRBUTIONMapper extends BaseMapper<PIMDISTIRBUTION>{

    Page<PIMDISTIRBUTION> searchGBYXZFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchLGTX(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchISOUTRECORD(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchYDCFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchYXFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchZPCJFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchYDWQX(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchDQYXFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchJDRYHMC(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchJDDQ(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchEXPEREENCE(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchJLSS(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchZIZHU(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchDefault(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchDQFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchMobDefault(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    Page<PIMDISTIRBUTION> searchKDDYXZFP(IPage page, @Param("srf") PIMDISTIRBUTIONSearchContext context, @Param("ew") Wrapper<PIMDISTIRBUTION> wrapper) ;
    @Override
    PIMDISTIRBUTION selectById(Serializable id);
    @Override
    int insert(PIMDISTIRBUTION entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMDISTIRBUTION entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMDISTIRBUTION entity, @Param("ew") Wrapper<PIMDISTIRBUTION> updateWrapper);
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

    List<PIMDISTIRBUTION> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PIMDISTIRBUTION> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PIMDISTIRBUTION> selectByYbmid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PIMDISTIRBUTION> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PIMDISTIRBUTION> selectByYzzid(@Param("orgid") Serializable orgid) ;

    List<PIMDISTIRBUTION> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PIMDISTIRBUTION> selectByOrmpostid1(@Param("ormpostid") Serializable ormpostid) ;

    List<PIMDISTIRBUTION> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
