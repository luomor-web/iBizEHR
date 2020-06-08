package cn.ibizlab.ehr.core.pcm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pcm.domain.PcmSgqMgr;
import cn.ibizlab.ehr.core.pcm.filter.PcmSgqMgrSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmSgqMgrMapper extends BaseMapper<PcmSgqMgr>{

    Page<PcmSgqMgr> searchDefault(IPage page, @Param("srf") PcmSgqMgrSearchContext context, @Param("ew") Wrapper<PcmSgqMgr> wrapper) ;
    @Override
    PcmSgqMgr selectById(Serializable id);
    @Override
    int insert(PcmSgqMgr entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmSgqMgr entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmSgqMgr entity, @Param("ew") Wrapper<PcmSgqMgr> updateWrapper);
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

    List<PcmSgqMgr> selectByPcmbdsqdmxid(@Param("pcmbdsqdmxid") Serializable pcmbdsqdmxid) ;

    List<PcmSgqMgr> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
