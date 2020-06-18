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
import cn.ibizlab.ehr.core.pim.domain.PimPerson;
import cn.ibizlab.ehr.core.pim.filter.PimPersonSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimPersonMapper extends BaseMapper<PimPerson>{

    Page<PimPerson> searchKFPRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSetAttRules(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSetSocArchives(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchYGXXGLY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchXMBRYCX(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchCurOrgPerson(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchJLSSGR(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchCurLeader(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSFHMD(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSSTRERSONINFO(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchCurJHRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchKTXYG(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchBYLYG(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchGBHMC(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchGZDQGL(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchKQJRYCX(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchLTXSTAFF(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<HashMap> searchREP_PERSONORGTYPE(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchAuthPerson(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchDefault(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchKGZRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSELFHELPID(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSYQYGCX(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchLZRYHMC(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchTitleUse(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchJXQYGCX(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchYXZFPRYDS(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchRYZT_30(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchDTXYG(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchXZKQRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<HashMap> searchREP_PERSONAGE(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchSYQKZZRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchJXQKZZRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchTXGB(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchKZJBDRY(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchCurOrgPimperson(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchTXRYCX(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    Page<PimPerson> searchKXZSYQKZZRYDS(IPage page, @Param("srf") PimPersonSearchContext context, @Param("ew") Wrapper<PimPerson> wrapper) ;
    @Override
    PimPerson selectById(Serializable id);
    @Override
    int insert(PimPerson entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimPerson entity);
    @Override
    int update(@Param(Constants.ENTITY) PimPerson entity, @Param("ew") Wrapper<PimPerson> updateWrapper);
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

    List<PimPerson> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PimPerson> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PimPerson> selectByPcmjxsygzzjlmxid(@Param("pcmjxsygzzjlmxid") Serializable pcmjxsygzzjlmxid) ;

    List<PimPerson> selectByPcmrcxlid(@Param("pcmrcxlid") Serializable pcmrcxlid) ;

    List<PimPerson> selectByPimcityid(@Param("pimcityid") Serializable pimcityid) ;

    List<PimPerson> selectByPimmajorsetypeid(@Param("pimmajorsetypeid") Serializable pimmajorsetypeid) ;

    List<PimPerson> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PimPerson> selectByPimpersonid3(@Param("pimpersonid") Serializable pimpersonid) ;

}
