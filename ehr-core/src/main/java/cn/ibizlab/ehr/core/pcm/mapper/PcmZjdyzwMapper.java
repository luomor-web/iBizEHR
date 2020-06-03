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
import cn.ibizlab.ehr.core.pcm.domain.PcmZjdyzw;
import cn.ibizlab.ehr.core.pcm.filter.PcmZjdyzwSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmZjdyzwMapper extends BaseMapper<PcmZjdyzw>{

    Page<PcmZjdyzw> searchDefault(IPage page, @Param("srf") PcmZjdyzwSearchContext context, @Param("ew") Wrapper<PcmZjdyzw> wrapper) ;
    @Override
    PcmZjdyzw selectById(Serializable id);
    @Override
    int insert(PcmZjdyzw entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmZjdyzw entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmZjdyzw entity, @Param("ew") Wrapper<PcmZjdyzw> updateWrapper);
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

    List<PcmZjdyzw> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<PcmZjdyzw> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

}
