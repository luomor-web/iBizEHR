package cn.ibizlab.ehr.core.att.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportmxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface AttEndanceMreportmxMapper extends BaseMapper<AttEndanceMreportmx>{

    Page<AttEndanceMreportmx> searchDefault(IPage page, @Param("srf") AttEndanceMreportmxSearchContext context, @Param("ew") Wrapper<AttEndanceMreportmx> wrapper) ;
    Page<AttEndanceMreportmx> searchKQYBMXDY(IPage page, @Param("srf") AttEndanceMreportmxSearchContext context, @Param("ew") Wrapper<AttEndanceMreportmx> wrapper) ;
    Page<AttEndanceMreportmx> searchCurPerson(IPage page, @Param("srf") AttEndanceMreportmxSearchContext context, @Param("ew") Wrapper<AttEndanceMreportmx> wrapper) ;
    @Override
    AttEndanceMreportmx selectById(Serializable id);
    @Override
    int insert(AttEndanceMreportmx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) AttEndanceMreportmx entity);
    @Override
    int update(@Param(Constants.ENTITY) AttEndanceMreportmx entity, @Param("ew") Wrapper<AttEndanceMreportmx> updateWrapper);
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

    List<AttEndanceMreportmx> selectByAttendancemreportid2(@Param("attendancemreportid") Serializable attendancemreportid) ;

    List<AttEndanceMreportmx> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
