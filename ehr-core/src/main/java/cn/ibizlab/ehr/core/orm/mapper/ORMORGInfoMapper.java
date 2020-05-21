package cn.ibizlab.ehr.core.orm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.orm.domain.ORMORGInfo;
import cn.ibizlab.ehr.core.orm.filter.ORMORGInfoSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMORGInfoMapper extends BaseMapper<ORMORGInfo>{

    Page<ORMORGInfo> searchSubOrgsector(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchCX(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchCurOrgsector(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchCurChild(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchCurPorg(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchSubPerson(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchDefault(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    Page<ORMORGInfo> searchSuborg(IPage page, @Param("srf") ORMORGInfoSearchContext context, @Param("ew") Wrapper<ORMORGInfo> wrapper) ;
    @Override
    ORMORGInfo selectById(Serializable id);
    @Override
    int insert(ORMORGInfo entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMORGInfo entity);
    @Override
    int update(@Param(Constants.ENTITY) ORMORGInfo entity, @Param("ew") Wrapper<ORMORGInfo> updateWrapper);
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
