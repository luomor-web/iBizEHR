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
import cn.ibizlab.ehr.core.pim.domain.PIMLANGUAGEABILITY;
import cn.ibizlab.ehr.core.pim.filter.PIMLANGUAGEABILITYSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMLANGUAGEABILITYMapper extends BaseMapper<PIMLANGUAGEABILITY>{

    Page<PIMLANGUAGEABILITY> searchJLSSGR(IPage page, @Param("srf") PIMLANGUAGEABILITYSearchContext context, @Param("ew") Wrapper<PIMLANGUAGEABILITY> wrapper) ;
    Page<PIMLANGUAGEABILITY> searchDefault(IPage page, @Param("srf") PIMLANGUAGEABILITYSearchContext context, @Param("ew") Wrapper<PIMLANGUAGEABILITY> wrapper) ;
    Page<PIMLANGUAGEABILITY> searchJLSS(IPage page, @Param("srf") PIMLANGUAGEABILITYSearchContext context, @Param("ew") Wrapper<PIMLANGUAGEABILITY> wrapper) ;
    Page<PIMLANGUAGEABILITY> searchZIZHU(IPage page, @Param("srf") PIMLANGUAGEABILITYSearchContext context, @Param("ew") Wrapper<PIMLANGUAGEABILITY> wrapper) ;
    Page<PIMLANGUAGEABILITY> searchJLSSGLY(IPage page, @Param("srf") PIMLANGUAGEABILITYSearchContext context, @Param("ew") Wrapper<PIMLANGUAGEABILITY> wrapper) ;
    @Override
    PIMLANGUAGEABILITY selectById(Serializable id);
    @Override
    int insert(PIMLANGUAGEABILITY entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMLANGUAGEABILITY entity);
    @Override
    int update(@Param(Constants.ENTITY) PIMLANGUAGEABILITY entity, @Param("ew") Wrapper<PIMLANGUAGEABILITY> updateWrapper);
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

    List<PIMLANGUAGEABILITY> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
