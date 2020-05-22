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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEFJ;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEFJSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMPROFILEFJMapper extends BaseMapper<PCMPROFILEFJ>{

    Page<PCMPROFILEFJ> searchPROFILEFJ(IPage page, @Param("srf") PCMPROFILEFJSearchContext context, @Param("ew") Wrapper<PCMPROFILEFJ> wrapper) ;
    Page<PCMPROFILEFJ> searchDefault(IPage page, @Param("srf") PCMPROFILEFJSearchContext context, @Param("ew") Wrapper<PCMPROFILEFJ> wrapper) ;
    @Override
    PCMPROFILEFJ selectById(Serializable id);
    @Override
    int insert(PCMPROFILEFJ entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMPROFILEFJ entity);
    @Override
    int update(@Param(Constants.ENTITY) PCMPROFILEFJ entity, @Param("ew") Wrapper<PCMPROFILEFJ> updateWrapper);
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
