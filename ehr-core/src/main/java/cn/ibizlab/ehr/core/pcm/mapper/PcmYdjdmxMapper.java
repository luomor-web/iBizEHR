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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjdmxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmYdjdmxMapper extends BaseMapper<PcmYdjdmx>{

    Page<PcmYdjdmx> searchJDGLDQ(IPage page, @Param("srf") PcmYdjdmxSearchContext context, @Param("ew") Wrapper<PcmYdjdmx> wrapper) ;
    Page<PcmYdjdmx> searchJDLSJLDQ(IPage page, @Param("srf") PcmYdjdmxSearchContext context, @Param("ew") Wrapper<PcmYdjdmx> wrapper) ;
    Page<PcmYdjdmx> searchDefault(IPage page, @Param("srf") PcmYdjdmxSearchContext context, @Param("ew") Wrapper<PcmYdjdmx> wrapper) ;
    @Override
    PcmYdjdmx selectById(Serializable id);
    @Override
    int insert(PcmYdjdmx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmYdjdmx entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmYdjdmx entity, @Param("ew") Wrapper<PcmYdjdmx> updateWrapper);
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

    List<PcmYdjdmx> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PcmYdjdmx> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmYdjdmx> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PcmYdjdmx> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PcmYdjdmx> selectByPimdistirbutionid(@Param("pimdistirbutionid") Serializable pimdistirbutionid) ;

}
