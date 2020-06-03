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
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmBdsqdmxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmBdsqdmxMapper extends BaseMapper<PcmBdsqdmx>{

    Page<PcmBdsqdmx> searchJPSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchNTSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchNTSQMXGR(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchTXSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchGZSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchZJBDSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchDGSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchCQBXSQMXDS(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchLZSQMX(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchLZSQMXGR(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    Page<PcmBdsqdmx> searchDefault(IPage page, @Param("srf") PcmBdsqdmxSearchContext context, @Param("ew") Wrapper<PcmBdsqdmx> wrapper) ;
    @Override
    PcmBdsqdmx selectById(Serializable id);
    @Override
    int insert(PcmBdsqdmx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmBdsqdmx entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmBdsqdmx entity, @Param("ew") Wrapper<PcmBdsqdmx> updateWrapper);
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

    List<PcmBdsqdmx> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PcmBdsqdmx> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmBdsqdmx> selectByOrmorgsectorid2(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmBdsqdmx> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PcmBdsqdmx> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PcmBdsqdmx> selectByPcmbdsqdid(@Param("pcmbdsqdid") Serializable pcmbdsqdid) ;

    List<PcmBdsqdmx> selectByLzmtrid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PcmBdsqdmx> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
