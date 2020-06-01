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
import cn.ibizlab.ehr.core.pim.domain.PimArchives;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimArchivesMapper extends BaseMapper<PimArchives>{

    Page<PimArchives> searchEMLOYEENOFILE(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchSysOrgIsSrfOrg(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchDefault(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchJLSS(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchZIZHU(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchNOEMLOYEENOFILE(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    Page<PimArchives> searchPIMREADGJD(IPage page, @Param("srf") PimArchivesSearchContext context, @Param("ew") Wrapper<PimArchives> wrapper) ;
    @Override
    PimArchives selectById(Serializable id);
    @Override
    int insert(PimArchives entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimArchives entity);
    @Override
    int update(@Param(Constants.ENTITY) PimArchives entity, @Param("ew") Wrapper<PimArchives> updateWrapper);
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

    List<PimArchives> selectByArchivescenterid(@Param("archivescenterid") Serializable archivescenterid) ;

    List<PimArchives> selectByOrmorgid2(@Param("orgid") Serializable orgid) ;

    List<PimArchives> selectByOrmorgid3(@Param("orgid") Serializable orgid) ;

    List<PimArchives> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
