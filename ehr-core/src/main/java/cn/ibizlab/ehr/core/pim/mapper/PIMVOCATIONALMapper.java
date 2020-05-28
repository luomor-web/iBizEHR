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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMVOCATIONALMapper extends BaseMapper<PIMVOCATIONAL>{

    Page<HashMap> searchREP_VOCATIONAL(IPage page, @Param("srf") PIMVOCATIONALSearchContext context, @Param("ew") Wrapper<PIMVOCATIONAL> wrapper) ;
    Page<PIMVOCATIONAL> searchAscriptionSysDQ(IPage page, @Param("srf") PIMVOCATIONALSearchContext context, @Param("ew") Wrapper<PIMVOCATIONAL> wrapper) ;
    Page<PIMVOCATIONAL> searchDefault(IPage page, @Param("srf") PIMVOCATIONALSearchContext context, @Param("ew") Wrapper<PIMVOCATIONAL> wrapper) ;
    Page<PIMVOCATIONAL> searchJLSS(IPage page, @Param("srf") PIMVOCATIONALSearchContext context, @Param("ew") Wrapper<PIMVOCATIONAL> wrapper) ;
    Page<PIMVOCATIONAL> searchZIZHU(IPage page, @Param("srf") PIMVOCATIONALSearchContext context, @Param("ew") Wrapper<PIMVOCATIONAL> wrapper) ;
    @Override
    PIMVOCATIONAL selectById(Serializable id);
    @Override
    int insert(PIMVOCATIONAL entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMVOCATIONAL entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMVOCATIONAL entity, @Param("ew") Wrapper<PIMVOCATIONAL> updateWrapper);
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

    List<PIMVOCATIONAL> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PIMVOCATIONAL> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PIMVOCATIONAL> selectByOrmsignorgid(@Param("ormsignorgid") Serializable ormsignorgid) ;

    List<PIMVOCATIONAL> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PIMVOCATIONAL> selectByPimqualmajorid(@Param("pimqualmajorid") Serializable pimqualmajorid) ;

    List<PIMVOCATIONAL> selectByPimqualtypeid(@Param("pimqualtypeid") Serializable pimqualtypeid) ;

    List<PIMVOCATIONAL> selectByPimvocationalcatalogid(@Param("pimvocationalcatalogid") Serializable pimvocationalcatalogid) ;

}
