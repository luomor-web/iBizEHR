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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMPROFILEMapper extends BaseMapper<PCMPROFILE>{

    Page<PCMPROFILE> searchYRDWSH_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchJLDSP(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchBD_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchYPZSPB_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchZPDWSH(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchBD(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchBHSP(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchLR(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchRLSB(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchFormType(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchHTRY_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchDefault(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchJZBSP(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchRZSP_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchJLDSP_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchBHSP_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchLR_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchYPZBB_READ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchHTRY(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchRZSP(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchYRDWCS_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchJZBSP_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    Page<PCMPROFILE> searchRLSB_CSRCYJ(IPage page, @Param("srf") PCMPROFILESearchContext context, @Param("ew") Wrapper<PCMPROFILE> wrapper) ;
    @Override
    PCMPROFILE selectById(Serializable id);
    @Override
    int insert(PCMPROFILE entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMPROFILE entity);
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

    List<PCMPROFILE> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PCMPROFILE> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PCMPROFILE> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PCMPROFILE> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PCMPROFILE> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
