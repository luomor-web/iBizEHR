package cn.ibizlab.ehr.core.att.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.att.domain.AttEndanceSettings;
import cn.ibizlab.ehr.core.att.filter.AttEndanceSettingsSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface AttEndanceSettingsMapper extends BaseMapper<AttEndanceSettings>{

    Page<AttEndanceSettings> searchYGSZKQ(IPage page, @Param("srf") AttEndanceSettingsSearchContext context, @Param("ew") Wrapper<AttEndanceSettings> wrapper) ;
    Page<AttEndanceSettings> searchFYGZZKQ(IPage page, @Param("srf") AttEndanceSettingsSearchContext context, @Param("ew") Wrapper<AttEndanceSettings> wrapper) ;
    Page<AttEndanceSettings> searchDefault(IPage page, @Param("srf") AttEndanceSettingsSearchContext context, @Param("ew") Wrapper<AttEndanceSettings> wrapper) ;
    @Override
    AttEndanceSettings selectById(Serializable id);
    @Override
    int insert(AttEndanceSettings entity);
    @Override
    int updateById(@Param(Constants.ENTITY) AttEndanceSettings entity);
    @Override
    int update(@Param(Constants.ENTITY) AttEndanceSettings entity, @Param("ew") Wrapper<AttEndanceSettings> updateWrapper);
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

    List<AttEndanceSettings> selectByAttendencesetupid(@Param("attendencesetupid") Serializable attendencesetupid) ;

    List<AttEndanceSettings> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
