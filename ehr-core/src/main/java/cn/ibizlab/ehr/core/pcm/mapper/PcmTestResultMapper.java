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
import cn.ibizlab.ehr.core.pcm.domain.PcmTestResult;
import cn.ibizlab.ehr.core.pcm.filter.PcmTestResultSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmTestResultMapper extends BaseMapper<PcmTestResult>{

    Page<PcmTestResult> searchDefault(IPage page, @Param("srf") PcmTestResultSearchContext context, @Param("ew") Wrapper<PcmTestResult> wrapper) ;
    @Override
    PcmTestResult selectById(Serializable id);
    @Override
    int insert(PcmTestResult entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmTestResult entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmTestResult entity, @Param("ew") Wrapper<PcmTestResult> updateWrapper);
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

    List<PcmTestResult> selectByPcmprofileid(@Param("pcmprofileid") Serializable pcmprofileid) ;

}
