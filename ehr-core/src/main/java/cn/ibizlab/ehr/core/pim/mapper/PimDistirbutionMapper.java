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
import cn.ibizlab.ehr.core.pim.domain.PimDistirbution;
import cn.ibizlab.ehr.core.pim.filter.PimDistirbutionSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimDistirbutionMapper extends BaseMapper<PimDistirbution>{

    Page<PimDistirbution> searchGBYXZFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchLGTX(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchISOUTRECORD(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchYDCFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchYXFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchZPCJFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchYDWQX(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchDQYXFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchJDRYHMC(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchJDDQ(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchEXPEREENCE(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchJLSS(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchZIZHU(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchDefault(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchDQFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchMobDefault(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    Page<PimDistirbution> searchKDDYXZFP(IPage page, @Param("srf") PimDistirbutionSearchContext context, @Param("ew") Wrapper<PimDistirbution> wrapper) ;
    @Override
    PimDistirbution selectById(Serializable id);
    @Override
    int insert(PimDistirbution entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimDistirbution entity);
    @Override
    int update(@Param(Constants.ENTITY) PimDistirbution entity, @Param("ew") Wrapper<PimDistirbution> updateWrapper);
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

    List<PimDistirbution> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PimDistirbution> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PimDistirbution> selectByYbmid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PimDistirbution> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PimDistirbution> selectByYzzid(@Param("orgid") Serializable orgid) ;

    List<PimDistirbution> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PimDistirbution> selectByOrmpostid1(@Param("ormpostid") Serializable ormpostid) ;

    List<PimDistirbution> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
