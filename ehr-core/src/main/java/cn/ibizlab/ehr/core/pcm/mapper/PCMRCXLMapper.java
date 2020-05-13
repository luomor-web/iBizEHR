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
import cn.ibizlab.ehr.core.pcm.domain.PCMRCXL;
import cn.ibizlab.ehr.core.pcm.filter.PCMRCXLSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PCMRCXLMapper extends BaseMapper<PCMRCXL>{

    Page<PCMRCXL> searchCurrent(IPage page, @Param("srf") PCMRCXLSearchContext context, @Param("ew") Wrapper<PCMRCXL> wrapper) ;
    Page<PCMRCXL> searchRCXLPPXLLX(IPage page, @Param("srf") PCMRCXLSearchContext context, @Param("ew") Wrapper<PCMRCXL> wrapper) ;
    Page<PCMRCXL> searchZiDQ(IPage page, @Param("srf") PCMRCXLSearchContext context, @Param("ew") Wrapper<PCMRCXL> wrapper) ;
    Page<PCMRCXL> searchDefault(IPage page, @Param("srf") PCMRCXLSearchContext context, @Param("ew") Wrapper<PCMRCXL> wrapper) ;
    Page<PCMRCXL> searchGenDQ(IPage page, @Param("srf") PCMRCXLSearchContext context, @Param("ew") Wrapper<PCMRCXL> wrapper) ;
    @Override
    PCMRCXL selectById(Serializable id);
    @Override
    int insert(PCMRCXL entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PCMRCXL entity);
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

    List<PCMRCXL> selectByPcmrcxlid2(@Param("pcmrcxlid") Serializable pcmrcxlid) ;

}
