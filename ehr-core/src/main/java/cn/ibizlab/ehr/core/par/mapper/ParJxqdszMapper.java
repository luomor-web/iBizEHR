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
import cn.ibizlab.ehr.core.par.domain.ParJxqdsz;
import cn.ibizlab.ehr.core.par.filter.ParJxqdszSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ParJxqdszMapper extends BaseMapper<ParJxqdsz>{

    Page<ParJxqdsz> searchDefault(IPage page, @Param("srf") ParJxqdszSearchContext context, @Param("ew") Wrapper<ParJxqdsz> wrapper) ;
    @Override
    ParJxqdsz selectById(Serializable id);
    @Override
    int insert(ParJxqdsz entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ParJxqdsz entity);
    @Override
    int update(@Param(Constants.ENTITY) ParJxqdsz entity, @Param("ew") Wrapper<ParJxqdsz> updateWrapper);
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

    List<ParJxqdsz> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

}
