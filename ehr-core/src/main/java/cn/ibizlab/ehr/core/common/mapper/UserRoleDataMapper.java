package cn.ibizlab.ehr.core.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.common.domain.UserRoleData;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface UserRoleDataMapper extends BaseMapper<UserRoleData>{

    Page<UserRoleData> searchDefault(IPage page, @Param("srf") UserRoleDataSearchContext context, @Param("ew") Wrapper<UserRoleData> wrapper) ;
    @Override
    UserRoleData selectById(Serializable id);
    @Override
    int insert(UserRoleData entity);
    @Override
    int updateById(@Param(Constants.ENTITY) UserRoleData entity);
    @Override
    int update(@Param(Constants.ENTITY) UserRoleData entity, @Param("ew") Wrapper<UserRoleData> updateWrapper);
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

    List<UserRoleData> selectByDeid(@Param("deid") Serializable deid) ;

    List<UserRoleData> selectByDstorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<UserRoleData> selectByDstorgid(@Param("orgid") Serializable orgid) ;

}
