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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINBUAPPLY;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINBUAPPLYSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TRMTRAINBUAPPLYMapper extends BaseMapper<TRMTRAINBUAPPLY>{

    Page<TRMTRAINBUAPPLY> searchDefault(IPage page, @Param("srf") TRMTRAINBUAPPLYSearchContext context, @Param("ew") Wrapper<TRMTRAINBUAPPLY> wrapper) ;
    @Override
    TRMTRAINBUAPPLY selectById(Serializable id);
    @Override
    int insert(TRMTRAINBUAPPLY entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TRMTRAINBUAPPLY entity);
    @Override
    int update(@Param(Constants.ENTITY) TRMTRAINBUAPPLY entity, @Param("ew") Wrapper<TRMTRAINBUAPPLY> updateWrapper);
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

    List<TRMTRAINBUAPPLY> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TRMTRAINBUAPPLY> selectByTrmtrainplantermid(@Param("trmtrainplantermid") Serializable trmtrainplantermid) ;

}
