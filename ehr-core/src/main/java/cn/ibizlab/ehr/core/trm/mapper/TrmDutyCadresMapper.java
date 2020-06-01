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
import cn.ibizlab.ehr.core.trm.domain.TrmDutyCadres;
import cn.ibizlab.ehr.core.trm.filter.TrmDutyCadresSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TrmDutyCadresMapper extends BaseMapper<TrmDutyCadres>{

    Page<TrmDutyCadres> searchCurCXFW(IPage page, @Param("srf") TrmDutyCadresSearchContext context, @Param("ew") Wrapper<TrmDutyCadres> wrapper) ;
    Page<TrmDutyCadres> searchDefault(IPage page, @Param("srf") TrmDutyCadresSearchContext context, @Param("ew") Wrapper<TrmDutyCadres> wrapper) ;
    @Override
    TrmDutyCadres selectById(Serializable id);
    @Override
    int insert(TrmDutyCadres entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TrmDutyCadres entity);
    @Override
    int update(@Param(Constants.ENTITY) TrmDutyCadres entity, @Param("ew") Wrapper<TrmDutyCadres> updateWrapper);
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

    List<TrmDutyCadres> selectByOrmdutyid(@Param("ormdutyid") Serializable ormdutyid) ;

    List<TrmDutyCadres> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<TrmDutyCadres> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TrmDutyCadres> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<TrmDutyCadres> selectByOrmrankid(@Param("ormrankid") Serializable ormrankid) ;

    List<TrmDutyCadres> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<TrmDutyCadres> selectByPimpersonid2(@Param("pimpersonid") Serializable pimpersonid) ;

}
