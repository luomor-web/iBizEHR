package cn.ibizlab.ehr.core.pim.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pim.domain.PIMPAPER;
import cn.ibizlab.ehr.core.pim.filter.PIMPAPERSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMPAPERMapper extends BaseMapper<PIMPAPER>{

    Page<PIMPAPER> searchDefault(IPage page, @Param("srf") PIMPAPERSearchContext context, @Param("ew") Wrapper<PIMPAPER> wrapper) ;
    Page<PIMPAPER> searchJLSSGR(IPage page, @Param("srf") PIMPAPERSearchContext context, @Param("ew") Wrapper<PIMPAPER> wrapper) ;
    Page<PIMPAPER> searchJLSSGLY(IPage page, @Param("srf") PIMPAPERSearchContext context, @Param("ew") Wrapper<PIMPAPER> wrapper) ;
    @Override
    PIMPAPER selectById(Serializable id);
    @Override
    int insert(PIMPAPER entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMPAPER entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMPAPER entity, @Param("ew") Wrapper<PIMPAPER> updateWrapper);
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

    List<PIMPAPER> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
