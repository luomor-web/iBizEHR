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
import cn.ibizlab.ehr.core.orm.domain.ORMPOST;
import cn.ibizlab.ehr.core.orm.filter.ORMPOSTSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMPOSTMapper extends BaseMapper<ORMPOST>{

    Page<ORMPOST> searchEJZZGW(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchAuthPost(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchCurOrg(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchDQGW(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchDQORGGW(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchGWXH(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchDefault(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchJZBGWCX(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    Page<ORMPOST> searchCXGW(IPage page, @Param("srf") ORMPOSTSearchContext context, @Param("ew") Wrapper<ORMPOST> wrapper) ;
    @Override
    ORMPOST selectById(Serializable id);
    @Override
    int insert(ORMPOST entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMPOST entity);
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

    List<ORMPOST> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

}