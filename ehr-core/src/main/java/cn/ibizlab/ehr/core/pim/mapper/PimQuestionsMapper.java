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
import cn.ibizlab.ehr.core.pim.domain.PimQuestions;
import cn.ibizlab.ehr.core.pim.filter.PimQuestionsSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimQuestionsMapper extends BaseMapper<PimQuestions>{

    Page<PimQuestions> searchQUERYcurrentQUESTION(IPage page, @Param("srf") PimQuestionsSearchContext context, @Param("ew") Wrapper<PimQuestions> wrapper) ;
    Page<PimQuestions> searchDefault(IPage page, @Param("srf") PimQuestionsSearchContext context, @Param("ew") Wrapper<PimQuestions> wrapper) ;
    @Override
    PimQuestions selectById(Serializable id);
    @Override
    int insert(PimQuestions entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimQuestions entity);
    @Override
    int update(@Param(Constants.ENTITY) PimQuestions entity, @Param("ew") Wrapper<PimQuestions> updateWrapper);
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
