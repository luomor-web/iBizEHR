package cn.ibizlab.ehr.core.soc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.soc.domain.SocWelfareinfomx;
import cn.ibizlab.ehr.core.soc.filter.SocWelfareinfomxSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SocWelfareinfomxMapper extends BaseMapper<SocWelfareinfomx>{

    Page<SocWelfareinfomx> searchDefault(IPage page, @Param("srf") SocWelfareinfomxSearchContext context, @Param("ew") Wrapper<SocWelfareinfomx> wrapper) ;
    @Override
    SocWelfareinfomx selectById(Serializable id);
    @Override
    int insert(SocWelfareinfomx entity);
    @Override
    int updateById(@Param(Constants.ENTITY) SocWelfareinfomx entity);
    @Override
    int update(@Param(Constants.ENTITY) SocWelfareinfomx entity, @Param("ew") Wrapper<SocWelfareinfomx> updateWrapper);
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

    List<SocWelfareinfomx> selectBySocselfarebasemxid(@Param("socselfarebasemxid") Serializable socselfarebasemxid) ;

    List<SocWelfareinfomx> selectBySocwelfareinfoid(@Param("socwelfareinfoid") Serializable socwelfareinfoid) ;

}
