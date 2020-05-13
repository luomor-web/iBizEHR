package cn.ibizlab.ehr.core.pim.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;
import cn.ibizlab.ehr.core.pim.filter.PIMBYZZJLMXSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PIMBYZZJLMXMapper extends BaseMapper<PIMBYZZJLMX>{

    Page<PIMBYZZJLMX> searchZZWSHDS(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchUnApproved(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDDJZBSH(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchBYLZZJL(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDGSDSZSH(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchHTRY(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDJZBSP(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDSB(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchFinishYGBH(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDJZBSH(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    Page<PIMBYZZJLMX> searchDefault(IPage page, @Param("srf") PIMBYZZJLMXSearchContext context, @Param("ew") Wrapper<PIMBYZZJLMX> wrapper) ;
    @Override
    PIMBYZZJLMX selectById(Serializable id);
    @Override
    int insert(PIMBYZZJLMX entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PIMBYZZJLMX entity);
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

    List<PIMBYZZJLMX> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<PIMBYZZJLMX> selectByPimbyygzzsqid(@Param("pimbyygzzsqid") Serializable pimbyygzzsqid) ;

    List<PIMBYZZJLMX> selectByPimexaminationresultsid(@Param("pimexaminationresultsid") Serializable pimexaminationresultsid) ;

    List<PIMBYZZJLMX> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
