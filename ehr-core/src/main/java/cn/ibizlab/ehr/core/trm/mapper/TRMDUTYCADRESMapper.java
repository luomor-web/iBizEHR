package cn.ibizlab.ehr.core.trm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMDUTYCADRESSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TRMDUTYCADRESMapper extends BaseMapper<TRMDUTYCADRES>{

    Page<TRMDUTYCADRES> searchCurCXFW(IPage page, @Param("srf") TRMDUTYCADRESSearchContext context, @Param("ew") Wrapper<TRMDUTYCADRES> wrapper) ;
    Page<TRMDUTYCADRES> searchDefault(IPage page, @Param("srf") TRMDUTYCADRESSearchContext context, @Param("ew") Wrapper<TRMDUTYCADRES> wrapper) ;
    @Override
    TRMDUTYCADRES selectById(Serializable id);
    @Override
    int insert(TRMDUTYCADRES entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TRMDUTYCADRES entity);
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

    List<TRMDUTYCADRES> selectByOrgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TRMDUTYCADRES> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<TRMDUTYCADRES> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TRMDUTYCADRES> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TRMDUTYCADRES> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<TRMDUTYCADRES> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<TRMDUTYCADRES> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<TRMDUTYCADRES> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

}