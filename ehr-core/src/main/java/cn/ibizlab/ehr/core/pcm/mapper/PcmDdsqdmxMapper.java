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
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdmxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmDdsqdmxMapper extends BaseMapper<PcmDdsqdmx>{

    Page<PcmDdsqdmx> searchJZSQMX(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchJDSQGR(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchDefault(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchJDSQMX(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchDDJL(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchGBDDJL(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchDDSQGR(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchDDMX(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    Page<PcmDdsqdmx> searchJZSQGR(IPage page, @Param("srf") PcmDdsqdmxSearchContext context, @Param("ew") Wrapper<PcmDdsqdmx> wrapper) ;
    @Override
    PcmDdsqdmx selectById(Serializable id);
    @Override
    int insert(PcmDdsqdmx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmDdsqdmx entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmDdsqdmx entity, @Param("ew") Wrapper<PcmDdsqdmx> updateWrapper);
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

    List<PcmDdsqdmx> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PcmDdsqdmx> selectByOrgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmDdsqdmx> selectByOrgid(@Param("orgid") Serializable orgid) ;

    List<PcmDdsqdmx> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PcmDdsqdmx> selectByPcmddsqdid(@Param("pcmddsqdid") Serializable pcmddsqdid) ;

    List<PcmDdsqdmx> selectByPimdistirbutionid(@Param("pimdistirbutionid") Serializable pimdistirbutionid) ;

}
