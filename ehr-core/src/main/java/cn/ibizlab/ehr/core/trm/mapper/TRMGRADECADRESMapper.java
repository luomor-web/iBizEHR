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
import cn.ibizlab.ehr.core.trm.domain.TRMGRADECADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMGRADECADRESSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TRMGRADECADRESMapper extends BaseMapper<TRMGRADECADRES>{

    Page<TRMGRADECADRES> searchDefault(IPage page, @Param("srf") TRMGRADECADRESSearchContext context, @Param("ew") Wrapper<TRMGRADECADRES> wrapper) ;
    @Override
    TRMGRADECADRES selectById(Serializable id);
    @Override
    int insert(TRMGRADECADRES entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TRMGRADECADRES entity);
    @Override
    int update(@Param(Constants.ENTITY) TRMGRADECADRES entity, @Param("ew") Wrapper<TRMGRADECADRES> updateWrapper);
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

    List<TRMGRADECADRES> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<TRMGRADECADRES> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TRMGRADECADRES> selectByOrmorgsectorid2(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TRMGRADECADRES> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TRMGRADECADRES> selectByOrmorgid2(@Param("orgid") Serializable orgid) ;

    List<TRMGRADECADRES> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<TRMGRADECADRES> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<TRMGRADECADRES> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

}
