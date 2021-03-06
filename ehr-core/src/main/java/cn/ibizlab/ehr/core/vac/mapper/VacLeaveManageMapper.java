package cn.ibizlab.ehr.core.vac.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveManageSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface VacLeaveManageMapper extends BaseMapper<VacLeaveManage>{

    Page<VacLeaveManage> searchFormType(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    Page<VacLeaveManage> searchGR(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    Page<VacLeaveManage> searchMOBJLSS(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    Page<VacLeaveManage> searchJLSS(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    Page<VacLeaveManage> searchDefault(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    Page<VacLeaveManage> searchOnlySPTY(IPage page, @Param("srf") VacLeaveManageSearchContext context, @Param("ew") Wrapper<VacLeaveManage> wrapper) ;
    @Override
    VacLeaveManage selectById(Serializable id);
    @Override
    int insert(VacLeaveManage entity);
    @Override
    int updateById(@Param(Constants.ENTITY) VacLeaveManage entity);
    @Override
    int update(@Param(Constants.ENTITY) VacLeaveManage entity, @Param("ew") Wrapper<VacLeaveManage> updateWrapper);
    @Override
    int deleteById(Serializable id);
     /**
      * ???????????????SQL
      * @param sql
      * @return
      */
     @Select("${sql}")
     List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * ???????????????SQL
    * @param sql
    * @return
    */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map param);

    List<VacLeaveManage> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
