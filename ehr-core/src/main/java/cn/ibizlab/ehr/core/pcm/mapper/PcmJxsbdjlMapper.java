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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsbdjl;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsbdjlSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmJxsbdjlMapper extends BaseMapper<PcmJxsbdjl>{

    Page<PcmJxsbdjl> searchDefault(IPage page, @Param("srf") PcmJxsbdjlSearchContext context, @Param("ew") Wrapper<PcmJxsbdjl> wrapper) ;
    Page<PcmJxsbdjl> searchZIZHU(IPage page, @Param("srf") PcmJxsbdjlSearchContext context, @Param("ew") Wrapper<PcmJxsbdjl> wrapper) ;
    Page<PcmJxsbdjl> searchJLSS(IPage page, @Param("srf") PcmJxsbdjlSearchContext context, @Param("ew") Wrapper<PcmJxsbdjl> wrapper) ;
    @Override
    PcmJxsbdjl selectById(Serializable id);
    @Override
    int insert(PcmJxsbdjl entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmJxsbdjl entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmJxsbdjl entity, @Param("ew") Wrapper<PcmJxsbdjl> updateWrapper);
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

    List<PcmJxsbdjl> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmJxsbdjl> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PcmJxsbdjl> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PcmJxsbdjl> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
