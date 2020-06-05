package cn.ibizlab.ehr.core.trm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.trm.domain.TrmInvoice;
import cn.ibizlab.ehr.core.trm.filter.TrmInvoiceSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface TrmInvoiceMapper extends BaseMapper<TrmInvoice>{

    Page<TrmInvoice> searchDefault(IPage page, @Param("srf") TrmInvoiceSearchContext context, @Param("ew") Wrapper<TrmInvoice> wrapper) ;
    @Override
    TrmInvoice selectById(Serializable id);
    @Override
    int insert(TrmInvoice entity);
    @Override
    int updateById(@Param(Constants.ENTITY) TrmInvoice entity);
    @Override
    int update(@Param(Constants.ENTITY) TrmInvoice entity, @Param("ew") Wrapper<TrmInvoice> updateWrapper);
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

    List<TrmInvoice> selectByTrmtrainagencyid(@Param("trmtrainagencyid") Serializable trmtrainagencyid) ;

}
