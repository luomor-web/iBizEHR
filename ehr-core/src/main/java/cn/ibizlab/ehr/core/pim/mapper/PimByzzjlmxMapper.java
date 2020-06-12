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
import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
import cn.ibizlab.ehr.core.pim.filter.PimByzzjlmxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimByzzjlmxMapper extends BaseMapper<PimByzzjlmx>{

    Page<PimByzzjlmx> searchZZWSHDS(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchUnApproved(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDDJZBSH(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchBYLZZJL(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDGSDSZSH(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchHTRY(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDJZBSP(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDSB(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchFinishYGBH(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDJZBSH(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    Page<PimByzzjlmx> searchDefault(IPage page, @Param("srf") PimByzzjlmxSearchContext context, @Param("ew") Wrapper<PimByzzjlmx> wrapper) ;
    @Override
    PimByzzjlmx selectById(Serializable id);
    @Override
    int insert(PimByzzjlmx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimByzzjlmx entity);
    @Override
    int update(@Param(Constants.ENTITY) PimByzzjlmx entity, @Param("ew") Wrapper<PimByzzjlmx> updateWrapper);
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

    List<PimByzzjlmx> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PimByzzjlmx> selectByPimbyygzzsqid(@Param("pimbyygzzsqid") Serializable pimbyygzzsqid) ;

    List<PimByzzjlmx> selectByPimexaminationresultsid(@Param("pimexaminationresultsid") Serializable pimexaminationresultsid) ;

    List<PimByzzjlmx> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
