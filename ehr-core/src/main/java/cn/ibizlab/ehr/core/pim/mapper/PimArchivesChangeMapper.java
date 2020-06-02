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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesChangeSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimArchivesChangeMapper extends BaseMapper<PimArchivesChange>{

    Page<PimArchivesChange> searchDADCJL(IPage page, @Param("srf") PimArchivesChangeSearchContext context, @Param("ew") Wrapper<PimArchivesChange> wrapper) ;
    Page<PimArchivesChange> searchDefault(IPage page, @Param("srf") PimArchivesChangeSearchContext context, @Param("ew") Wrapper<PimArchivesChange> wrapper) ;
    @Override
    PimArchivesChange selectById(Serializable id);
    @Override
    int insert(PimArchivesChange entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimArchivesChange entity);
    @Override
    int update(@Param(Constants.ENTITY) PimArchivesChange entity, @Param("ew") Wrapper<PimArchivesChange> updateWrapper);
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

    List<PimArchivesChange> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PimArchivesChange> selectByOrmorgid2(@Param("orgid") Serializable orgid) ;

    List<PimArchivesChange> selectByPimarchivesid(@Param("pimarchivesid") Serializable pimarchivesid) ;

    List<PimArchivesChange> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
