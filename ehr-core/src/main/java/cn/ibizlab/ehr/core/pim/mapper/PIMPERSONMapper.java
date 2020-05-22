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
import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMPERSONMapper extends BaseMapper<PIMPERSON>{

    Page<PIMPERSON> searchKFPRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchYGXXGLY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchXMBRYCX(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchCurOrgPerson(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchJLSSGR(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchCurLeader(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchSFHMD(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchSSTRERSONINFO(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchCurJHRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchKTXYG(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchBYLYG(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchGBHMC(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchGZDQGL(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchKQJRYCX(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchLTXSTAFF(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<HashMap> searchREP_PERSONORGTYPE(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchAuthPerson(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchDefault(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchKGZRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchSELFHELPID(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchSYQYGCX(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchLZRYHMC(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchTitleUse(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchJXQYGCX(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchYXZFPRYDS(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchRYZT_30(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchDTXYG(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchXZKQRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<HashMap> searchREP_PERSONAGE(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchSYQKZZRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchJXQKZZRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchTXGB(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchKZJBDRY(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchCurOrgPimperson(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchTXRYCX(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    Page<PIMPERSON> searchKXZSYQKZZRYDS(IPage page, @Param("srf") PIMPERSONSearchContext context, @Param("ew") Wrapper<PIMPERSON> wrapper) ;
    @Override
    PIMPERSON selectById(Serializable id);
    @Override
    int insert(PIMPERSON entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMPERSON entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMPERSON entity, @Param("ew") Wrapper<PIMPERSON> updateWrapper);
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

    List<PIMPERSON> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PIMPERSON> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PIMPERSON> selectByPcmjxsygzzjlmxid(@Param("pcmjxsygzzjlmxid") Serializable pcmjxsygzzjlmxid) ;

    List<PIMPERSON> selectByPcmrcxlid(@Param("pcmrcxlid") Serializable pcmrcxlid) ;

    List<PIMPERSON> selectByPimcityid(@Param("pimcityid") Serializable pimcityid) ;

    List<PIMPERSON> selectByPimmajorsetypeid(@Param("pimmajorsetypeid") Serializable pimmajorsetypeid) ;

    List<PIMPERSON> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PIMPERSON> selectByPimpersonid3(@Param("pimpersonid") Serializable pimpersonid) ;

}
