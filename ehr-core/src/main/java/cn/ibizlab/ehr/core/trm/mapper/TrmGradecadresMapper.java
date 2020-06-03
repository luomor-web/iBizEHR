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
import cn.ibizlab.ehr.core.trm.domain.TrmGradecadres;
import cn.ibizlab.ehr.core.trm.filter.TrmGradecadresSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TrmGradecadresMapper extends BaseMapper<TrmGradecadres>{

    Page<TrmGradecadres> searchDefault(IPage page, @Param("srf") TrmGradecadresSearchContext context, @Param("ew") Wrapper<TrmGradecadres> wrapper) ;
    @Override
    TrmGradecadres selectById(Serializable id);
    @Override
    int insert(TrmGradecadres entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TrmGradecadres entity);
    @Override
    int update(@Param(Constants.ENTITY) TrmGradecadres entity, @Param("ew") Wrapper<TrmGradecadres> updateWrapper);
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

    List<TrmGradecadres> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<TrmGradecadres> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TrmGradecadres> selectByOrmorgsectorid2(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TrmGradecadres> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TrmGradecadres> selectByOrmorgid2(@Param("orgid") Serializable orgid) ;

    List<TrmGradecadres> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<TrmGradecadres> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<TrmGradecadres> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

}
