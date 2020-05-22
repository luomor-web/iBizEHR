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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJDMXSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMYDJDMXMapper extends BaseMapper<PCMYDJDMX>{

    Page<PCMYDJDMX> searchJDGLDQ(IPage page, @Param("srf") PCMYDJDMXSearchContext context, @Param("ew") Wrapper<PCMYDJDMX> wrapper) ;
    Page<PCMYDJDMX> searchJDLSJLDQ(IPage page, @Param("srf") PCMYDJDMXSearchContext context, @Param("ew") Wrapper<PCMYDJDMX> wrapper) ;
    Page<PCMYDJDMX> searchDefault(IPage page, @Param("srf") PCMYDJDMXSearchContext context, @Param("ew") Wrapper<PCMYDJDMX> wrapper) ;
    @Override
    PCMYDJDMX selectById(Serializable id);
    @Override
    int insert(PCMYDJDMX entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMYDJDMX entity);
    @Override
    int update(@Param(Constants.ENTITY) PCMYDJDMX entity, @Param("ew") Wrapper<PCMYDJDMX> updateWrapper);
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

    List<PCMYDJDMX> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PCMYDJDMX> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PCMYDJDMX> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PCMYDJDMX> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PCMYDJDMX> selectByPimdistirbutionid(@Param("pimdistirbutionid") Serializable pimdistirbutionid) ;

}
