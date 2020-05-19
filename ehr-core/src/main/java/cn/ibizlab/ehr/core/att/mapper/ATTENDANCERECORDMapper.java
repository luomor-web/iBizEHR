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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORD;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCERECORDSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ATTENDANCERECORDMapper extends BaseMapper<ATTENDANCERECORD>{

    Page<ATTENDANCERECORD> searchDefault(IPage page, @Param("srf") ATTENDANCERECORDSearchContext context, @Param("ew") Wrapper<ATTENDANCERECORD> wrapper) ;
    @Override
    ATTENDANCERECORD selectById(Serializable id);
    @Override
    int insert(ATTENDANCERECORD entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ATTENDANCERECORD entity);
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

    List<ATTENDANCERECORD> selectByAttendancemreportid(@Param("attendancemreportmxid") Serializable attendancemreportmxid) ;

    List<ATTENDANCERECORD> selectByOrmbmkqdzid(@Param("ormbmkqdzid") Serializable ormbmkqdzid) ;

    List<ATTENDANCERECORD> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<ATTENDANCERECORD> selectByTrmtrainplantermid(@Param("trmtrainplantermid") Serializable trmtrainplantermid) ;

}
