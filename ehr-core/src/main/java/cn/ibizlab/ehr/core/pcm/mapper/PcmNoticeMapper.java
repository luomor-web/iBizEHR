package cn.ibizlab.ehr.core.pcm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.ehr.core.pcm.domain.PcmNotice;
import cn.ibizlab.ehr.core.pcm.filter.PcmNoticeSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface PcmNoticeMapper extends BaseMapper<PcmNotice>{

    Page<PcmNotice> searchNOTICE_DAGLYDQ(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    Page<PcmNotice> searchNOTICE_XCZYDQ(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    Page<PcmNotice> searchNOTICE_KQZYDQ(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    Page<PcmNotice> searchNOTICE_RSZYDQ(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    Page<PcmNotice> searchDefault(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    Page<PcmNotice> searchNOTICE_SBFLZYDQ(IPage page, @Param("srf") PcmNoticeSearchContext context, @Param("ew") Wrapper<PcmNotice> wrapper) ;
    @Override
    PcmNotice selectById(Serializable id);
    @Override
    int insert(PcmNotice entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PcmNotice entity);
    @Override
    int update(@Param(Constants.ENTITY) PcmNotice entity, @Param("ew") Wrapper<PcmNotice> updateWrapper);
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

    List<PcmNotice> selectByOrmorgsectorid(@Param("orgsectorid") Serializable orgsectorid) ;

    List<PcmNotice> selectByOrmorgid(@Param("orgid") Serializable orgid) ;

    List<PcmNotice> selectByPimdistirbutionid(@Param("pimdistirbutionid") Serializable pimdistirbutionid) ;

    List<PcmNotice> selectByPimpersonid(@Param("pimpersonid") Serializable pimpersonid) ;

}
