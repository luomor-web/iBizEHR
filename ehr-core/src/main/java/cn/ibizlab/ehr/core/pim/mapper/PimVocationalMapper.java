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
import cn.ibizlab.ehr.core.pim.domain.PimVocational;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimVocationalMapper extends BaseMapper<PimVocational>{

    Page<HashMap> searchREP_VOCATIONAL(IPage page, @Param("srf") PimVocationalSearchContext context, @Param("ew") Wrapper<PimVocational> wrapper) ;
    Page<PimVocational> searchAscriptionSysDQ(IPage page, @Param("srf") PimVocationalSearchContext context, @Param("ew") Wrapper<PimVocational> wrapper) ;
    Page<PimVocational> searchDefault(IPage page, @Param("srf") PimVocationalSearchContext context, @Param("ew") Wrapper<PimVocational> wrapper) ;
    Page<PimVocational> searchJLSS(IPage page, @Param("srf") PimVocationalSearchContext context, @Param("ew") Wrapper<PimVocational> wrapper) ;
    Page<PimVocational> searchZIZHU(IPage page, @Param("srf") PimVocationalSearchContext context, @Param("ew") Wrapper<PimVocational> wrapper) ;
    @Override
    PimVocational selectById(Serializable id);
    @Override
    int insert(PimVocational entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimVocational entity);
    @Override
    int update(@Param(Constants.ENTITY) PimVocational entity, @Param("ew") Wrapper<PimVocational> updateWrapper);
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

    List<PimVocational> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PimVocational> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PimVocational> selectByOrmsignorgid(@Param("ormsignorgid") Serializable ormsignorgid) ;

    List<PimVocational> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PimVocational> selectByPimqualmajorid(@Param("pimqualmajorid") Serializable pimqualmajorid) ;

    List<PimVocational> selectByPimqualtypeid(@Param("pimqualtypeid") Serializable pimqualtypeid) ;

    List<PimVocational> selectByPimvocationalcatalogid(@Param("pimvocationalcatalogid") Serializable pimvocationalcatalogid) ;

}
