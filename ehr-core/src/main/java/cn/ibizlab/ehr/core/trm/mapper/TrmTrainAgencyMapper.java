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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAgencySearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TrmTrainAgencyMapper extends BaseMapper<TrmTrainAgency>{

    Page<TrmTrainAgency> searchDefault(IPage page, @Param("srf") TrmTrainAgencySearchContext context, @Param("ew") Wrapper<TrmTrainAgency> wrapper) ;
    @Override
    TrmTrainAgency selectById(Serializable id);
    @Override
    int insert(TrmTrainAgency entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TrmTrainAgency entity);
    @Override
    int update(@Param(Constants.ENTITY) TrmTrainAgency entity, @Param("ew") Wrapper<TrmTrainAgency> updateWrapper);
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

    List<TrmTrainAgency> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<TrmTrainAgency> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<TrmTrainAgency> selectByTrmtrainagencyid2(@Param("trmtrainagencyid") Serializable trmtrainagencyid) ;

}
