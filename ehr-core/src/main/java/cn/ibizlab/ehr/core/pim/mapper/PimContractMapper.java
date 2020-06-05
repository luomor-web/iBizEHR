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
import cn.ibizlab.ehr.core.pim.domain.PimContract;
import cn.ibizlab.ehr.core.pim.filter.PimContractSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PimContractMapper extends BaseMapper<PimContract>{

    Page<PimContract> searchRSTXDS(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchJLSS(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchOrderByOrg(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchStopContracts(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchSignContracts(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchDefault(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchXYHT(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchZIZHU(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchLDHT(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    Page<PimContract> searchLWHT(IPage page, @Param("srf") PimContractSearchContext context, @Param("ew") Wrapper<PimContract> wrapper) ;
    @Override
    PimContract selectById(Serializable id);
    @Override
    int insert(PimContract entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PimContract entity);
    @Override
    int update(@Param(Constants.ENTITY) PimContract entity, @Param("ew") Wrapper<PimContract> updateWrapper);
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

    List<PimContract> selectByContractsignorgid(@Param("contractsignorgid") Serializable contractsignorgid) ;

    List<PimContract> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PimContract> selectByOrmsignorgid(@Param("ormsignorgid") Serializable ormsignorgid) ;

    List<PimContract> selectByPimlabourcampanyid(@Param("pimlabourcampanyid") Serializable pimlabourcampanyid) ;

    List<PimContract> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
