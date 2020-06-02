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
import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
import cn.ibizlab.ehr.core.trm.filter.TrmCouarrangeSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TrmCouarrangeMapper extends BaseMapper<TrmCouarrange>{

    Page<TrmCouarrange> searchDefault(IPage page, @Param("srf") TrmCouarrangeSearchContext context, @Param("ew") Wrapper<TrmCouarrange> wrapper) ;
    @Override
    TrmCouarrange selectById(Serializable id);
    @Override
    int insert(TrmCouarrange entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TrmCouarrange entity);
    @Override
    int update(@Param(Constants.ENTITY) TrmCouarrange entity, @Param("ew") Wrapper<TrmCouarrange> updateWrapper);
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

    List<TrmCouarrange> selectByTrmagencyrecordid(@Param("trmagencyrecordid") Serializable trmagencyrecordid) ;

    List<TrmCouarrange> selectByTrmcoursesystemid(@Param("trmcoursesystemid") Serializable trmcoursesystemid) ;

    List<TrmCouarrange> selectByTrmtrainactapplyid(@Param("trmtrainactapplyid") Serializable trmtrainactapplyid) ;

    List<TrmCouarrange> selectByTrmtrainaddressid(@Param("trmtrainaddressid") Serializable trmtrainaddressid) ;

    List<TrmCouarrange> selectByTrmtrainagencyid(@Param("trmtrainagencyid") Serializable trmtrainagencyid) ;

    List<TrmCouarrange> selectByTrmtraincourseid(@Param("trmtraincourseid") Serializable trmtraincourseid) ;

    List<TrmCouarrange> selectByTrmtrainfaciesid(@Param("trmtrainfaciesid") Serializable trmtrainfaciesid) ;

    List<TrmCouarrange> selectByTrmtrainplantermid(@Param("trmtrainplantermid") Serializable trmtrainplantermid) ;

    List<TrmCouarrange> selectByTrmtrainteacherid(@Param("trmtrainteacherid") Serializable trmtrainteacherid) ;

    List<TrmCouarrange> selectByTrmtrianpersonid(@Param("trmtrianpersonid") Serializable trmtrianpersonid) ;

}
