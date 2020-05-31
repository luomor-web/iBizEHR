package cn.ibizlab.ehr.core.orm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
import cn.ibizlab.ehr.core.orm.filter.OrmXmrypzxqSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface OrmXmrypzxqMapper extends BaseMapper<OrmXmrypzxq>{

    Page<OrmXmrypzxq> searchRSSH(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchCURFQTP(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchCXSJ(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchKZXMQX(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchSFSH(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchCURFQSF(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchTPSH(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchSFCXSJ(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchMODSPSH(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchDefault(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    Page<OrmXmrypzxq> searchXMCBMX(IPage page, @Param("srf") OrmXmrypzxqSearchContext context, @Param("ew") Wrapper<OrmXmrypzxq> wrapper) ;
    @Override
    OrmXmrypzxq selectById(Serializable id);
    @Override
    int insert(OrmXmrypzxq entity);
    @Override
    int updateById(@Param(Constants.ENTITY) OrmXmrypzxq entity);
    @Override
    int update(@Param(Constants.ENTITY) OrmXmrypzxq entity, @Param("ew") Wrapper<OrmXmrypzxq> updateWrapper);
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

    List<OrmXmrypzxq> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<OrmXmrypzxq> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<OrmXmrypzxq> selectByOrmxmxqjhid(@Param("ormxmxqjhid") Serializable ormxmxqjhid) ;

    List<OrmXmrypzxq> selectByModpimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<OrmXmrypzxq> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<OrmXmrypzxq> selectByRealpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
