package cn.ibizlab.ehr.core.orm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.orm.domain.OrmRank;
import cn.ibizlab.ehr.core.orm.filter.OrmRankSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmRankMapper extends BaseMapper<OrmRank>{

    Page<OrmRank> searchJZRANK(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    Page<OrmRank> searchJSRANK(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    Page<OrmRank> searchDJYX(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    Page<OrmRank> searchJSNRANK(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    Page<OrmRank> searchDefault(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    Page<OrmRank> searchCurRank(IPage page, @Param("srf") OrmRankSearchContext context, @Param("ew") Wrapper<OrmRank> wrapper) ;
    @Override
    OrmRank selectById(Serializable id);
    @Override
    int insert(OrmRank entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmRank entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmRank entity, @Param("ew") Wrapper<OrmRank> updateWrapper);
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

}
