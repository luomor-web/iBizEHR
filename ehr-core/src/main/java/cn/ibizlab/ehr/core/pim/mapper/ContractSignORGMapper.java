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
import cn.ibizlab.ehr.core.pim.domain.ContractSignORG;
import cn.ibizlab.ehr.core.pim.filter.ContractSignORGSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface ContractSignORGMapper extends BaseMapper<ContractSignORG>{

    Page<ContractSignORG> searchDefault(IPage page, @Param("srf") ContractSignORGSearchContext context, @Param("ew") Wrapper<ContractSignORG> wrapper) ;
    Page<ContractSignORG> searchDefault2(IPage page, @Param("srf") ContractSignORGSearchContext context, @Param("ew") Wrapper<ContractSignORG> wrapper) ;
    @Override
    ContractSignORG selectById(Serializable id);
    @Override
    int insert(ContractSignORG entity);
    @Override
    int updateById(@Param(Constants.ENTITY) ContractSignORG entity);
    @Override
    int update(@Param(Constants.ENTITY) ContractSignORG entity, @Param("ew") Wrapper<ContractSignORG> updateWrapper);
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

    List<ContractSignORG> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<ContractSignORG> selectByOrmsignorgid(@Param("ormsignorgid") Serializable ormsignorgid) ;

}
