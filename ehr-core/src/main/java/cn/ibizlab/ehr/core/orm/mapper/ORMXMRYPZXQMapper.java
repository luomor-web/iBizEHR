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
import cn.ibizlab.ehr.core.orm.domain.ORMXMRYPZXQ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRYPZXQSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ORMXMRYPZXQMapper extends BaseMapper<ORMXMRYPZXQ>{

    Page<ORMXMRYPZXQ> searchRSSH(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchCURFQTP(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchCXSJ(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchKZXMQX(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchSFSH(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchCURFQSF(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchTPSH(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchSFCXSJ(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchMODSPSH(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchDefault(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    Page<ORMXMRYPZXQ> searchXMCBMX(IPage page, @Param("srf") ORMXMRYPZXQSearchContext context, @Param("ew") Wrapper<ORMXMRYPZXQ> wrapper) ;
    @Override
    ORMXMRYPZXQ selectById(Serializable id);
    @Override
    int insert(ORMXMRYPZXQ entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ORMXMRYPZXQ entity);
    @Override
    int update(@Param(Constants.ENTITY) ORMXMRYPZXQ entity, @Param("ew") Wrapper<ORMXMRYPZXQ> updateWrapper);
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

    List<ORMXMRYPZXQ> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<ORMXMRYPZXQ> selectByOrmpostid(@Param("ormpostid") Serializable ormpostid) ;

    List<ORMXMRYPZXQ> selectByOrmxmxqjhid(@Param("ormxmxqjhid") Serializable ormxmxqjhid) ;

    List<ORMXMRYPZXQ> selectByModpimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<ORMXMRYPZXQ> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

    List<ORMXMRYPZXQ> selectByRealpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
