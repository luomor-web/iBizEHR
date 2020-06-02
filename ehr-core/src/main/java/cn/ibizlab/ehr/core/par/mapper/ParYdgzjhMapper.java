package cn.ibizlab.ehr.core.par.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.par.domain.ParYdgzjh;
import cn.ibizlab.ehr.core.par.filter.ParYdgzjhSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ParYdgzjhMapper extends BaseMapper<ParYdgzjh>{

    Page<ParYdgzjh> searchDefault(IPage page, @Param("srf") ParYdgzjhSearchContext context, @Param("ew") Wrapper<ParYdgzjh> wrapper) ;
    @Override
    ParYdgzjh selectById(Serializable id);
    @Override
    int insert(ParYdgzjh entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ParYdgzjh entity);
    @Override
    int update(@Param(Constants.ENTITY) ParYdgzjh entity, @Param("ew") Wrapper<ParYdgzjh> updateWrapper);
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

    List<ParYdgzjh> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

}
