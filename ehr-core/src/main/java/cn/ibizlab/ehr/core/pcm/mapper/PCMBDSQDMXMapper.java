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
import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDMXSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMBDSQDMXMapper extends BaseMapper<PCMBDSQDMX>{

    Page<PCMBDSQDMX> searchJPSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchNTSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchNTSQMXGR(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchTXSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchGZSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchZJBDSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchDGSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchCQBXSQMXDS(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchLZSQMX(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchLZSQMXGR(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    Page<PCMBDSQDMX> searchDefault(IPage page, @Param("srf") PCMBDSQDMXSearchContext context, @Param("ew") Wrapper<PCMBDSQDMX> wrapper) ;
    @Override
    PCMBDSQDMX selectById(Serializable id);
    @Override
    int insert(PCMBDSQDMX entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMBDSQDMX entity);
    @Override
    int update(@Param(Constants.ENTITY) PCMBDSQDMX entity, @Param("ew") Wrapper<PCMBDSQDMX> updateWrapper);
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

    List<PCMBDSQDMX> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PCMBDSQDMX> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PCMBDSQDMX> selectByOrmorgsectorid2(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PCMBDSQDMX> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PCMBDSQDMX> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PCMBDSQDMX> selectByPcmbdsqdid(@Param("pcmbdsqdid") Serializable pcmbdsqdid) ;

    List<PCMBDSQDMX> selectByLzmtrid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<PCMBDSQDMX> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
