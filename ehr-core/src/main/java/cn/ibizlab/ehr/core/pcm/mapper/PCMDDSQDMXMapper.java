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
import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDMXSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMDDSQDMXMapper extends BaseMapper<PCMDDSQDMX>{

    Page<PCMDDSQDMX> searchJZSQMX(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchJDSQGR(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchDefault(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchJDSQMX(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchDDJL(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchGBDDJL(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchDDSQGR(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchDDMX(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    Page<PCMDDSQDMX> searchJZSQGR(IPage page, @Param("srf") PCMDDSQDMXSearchContext context, @Param("ew") Wrapper<PCMDDSQDMX> wrapper) ;
    @Override
    PCMDDSQDMX selectById(Serializable id);
    @Override
    int insert(PCMDDSQDMX entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMDDSQDMX entity);
    @Override
    int update(@Param(Constants.ENTITY) PCMDDSQDMX entity, @Param("ew") Wrapper<PCMDDSQDMX> updateWrapper);
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

    List<PCMDDSQDMX> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PCMDDSQDMX> selectByOrgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PCMDDSQDMX> selectByOrgid(@Param("orgid") Serializable orgid) ;

    List<PCMDDSQDMX> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PCMDDSQDMX> selectByPcmddsqdid(@Param("pcmddsqdid") Serializable pcmddsqdid) ;

    List<PCMDDSQDMX> selectByPimdistirbutionid(@Param("pimdistirbutionid") Serializable pimdistirbutionid) ;

}
