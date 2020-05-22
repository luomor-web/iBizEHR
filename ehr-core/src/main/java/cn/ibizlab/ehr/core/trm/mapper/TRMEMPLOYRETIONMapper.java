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
import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
import cn.ibizlab.ehr.core.trm.filter.TRMEMPLOYRETIONSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TRMEMPLOYRETIONMapper extends BaseMapper<TRMEMPLOYRETION>{

    Page<TRMEMPLOYRETION> searchDefault(IPage page, @Param("srf") TRMEMPLOYRETIONSearchContext context, @Param("ew") Wrapper<TRMEMPLOYRETION> wrapper) ;
    @Override
    TRMEMPLOYRETION selectById(Serializable id);
    @Override
    int insert(TRMEMPLOYRETION entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TRMEMPLOYRETION entity);
    @Override
    int update(@Param(Constants.ENTITY) TRMEMPLOYRETION entity, @Param("ew") Wrapper<TRMEMPLOYRETION> updateWrapper);
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

    List<TRMEMPLOYRETION> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TRMEMPLOYRETION> selectByTrmcouarrangeid(@Param("trmcouarrangeid") Serializable trmcouarrangeid) ;

    List<TRMEMPLOYRETION> selectByTrmtrainactapplyid(@Param("trmtrainactapplyid") Serializable trmtrainactapplyid) ;

    List<TRMEMPLOYRETION> selectByTrmtrainagencyid(@Param("trmtrainagencyid") Serializable trmtrainagencyid) ;

}
