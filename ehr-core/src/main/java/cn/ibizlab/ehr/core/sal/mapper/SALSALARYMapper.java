package cn.ibizlab.ehr.core.sal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.sal.domain.SALSALARY;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SALSALARYMapper extends BaseMapper<SALSALARY>{

    Page<SALSALARY> searchDefault(IPage page, @Param("srf") SALSALARYSearchContext context, @Param("ew") Wrapper<SALSALARY> wrapper) ;
    @Override
    SALSALARY selectById(Serializable id);
    @Override
    int insert(SALSALARY entity);
    @Override
    int updateById(@Param(Constants.ENTITY) SALSALARY entity);
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

    List<SALSALARY> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<SALSALARY> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<SALSALARY> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<SALSALARY> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<SALSALARY> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<SALSALARY> selectBySalplanid(@Param("salplanid") Serializable salplanid) ;

    List<SALSALARY> selectBySalsalarybillid(@Param("salsalarybillid") Serializable salsalarybillid) ;

}
