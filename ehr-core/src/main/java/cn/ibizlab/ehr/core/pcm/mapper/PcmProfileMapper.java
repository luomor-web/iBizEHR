package cn.ibizlab.ehr.core.pcm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmProfileMapper extends BaseMapper<PcmProfile>{

    Page<PcmProfile> searchYRDWSH_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchJLDSP(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchBD_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchYPZSPB_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchZPDWSH(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchBD(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchBHSP(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchLR(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchRLSB(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchFormType(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchHTRY_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchDefault(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchJZBSP(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchRZSP_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchJLDSP_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchBHSP_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchLR_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchYPZBB_READ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchHTRY(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchRZSP(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchYRDWCS_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchJZBSP_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    Page<PcmProfile> searchRLSB_CSRCYJ(IPage page, @Param("srf") PcmProfileSearchContext context, @Param("ew") Wrapper<PcmProfile> wrapper) ;
    @Override
    PcmProfile selectById(Serializable id);
    @Override
    int insert(PcmProfile entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmProfile entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmProfile entity, @Param("ew") Wrapper<PcmProfile> updateWrapper);
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

    List<PcmProfile> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PcmProfile> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmProfile> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PcmProfile> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PcmProfile> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
