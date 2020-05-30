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
import cn.ibizlab.ehr.core.pcm.domain.PcmRcxl;
import cn.ibizlab.ehr.core.pcm.filter.PcmRcxlSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmRcxlMapper extends BaseMapper<PcmRcxl>{

    Page<PcmRcxl> searchCurrent(IPage page, @Param("srf") PcmRcxlSearchContext context, @Param("ew") Wrapper<PcmRcxl> wrapper) ;
    Page<PcmRcxl> searchRCXLPPXLLX(IPage page, @Param("srf") PcmRcxlSearchContext context, @Param("ew") Wrapper<PcmRcxl> wrapper) ;
    Page<PcmRcxl> searchZiDQ(IPage page, @Param("srf") PcmRcxlSearchContext context, @Param("ew") Wrapper<PcmRcxl> wrapper) ;
    Page<PcmRcxl> searchDefault(IPage page, @Param("srf") PcmRcxlSearchContext context, @Param("ew") Wrapper<PcmRcxl> wrapper) ;
    Page<PcmRcxl> searchGenDQ(IPage page, @Param("srf") PcmRcxlSearchContext context, @Param("ew") Wrapper<PcmRcxl> wrapper) ;
    @Override
    PcmRcxl selectById(Serializable id);
    @Override
    int insert(PcmRcxl entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmRcxl entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmRcxl entity, @Param("ew") Wrapper<PcmRcxl> updateWrapper);
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

    List<PcmRcxl> selectByPcmrcxlid2(@Param("pcmrcxlid") Serializable pcmrcxlid) ;

}
