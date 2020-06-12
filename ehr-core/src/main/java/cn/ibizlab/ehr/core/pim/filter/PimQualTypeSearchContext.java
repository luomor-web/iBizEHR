package cn.ibizlab.ehr.core.pim.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.pim.domain.PimQualType;
/**
 * 关系型数据实体[PimQualType] 查询条件对象
 */
@Slf4j
@Data
public class PimQualTypeSearchContext extends QueryWrapperContext<PimQualType> {

	private String n_pimqualtypeid_like;//[岗位（技能）证书目录ID]
	public void setN_pimqualtypeid_like(String n_pimqualtypeid_like) {
        this.n_pimqualtypeid_like = n_pimqualtypeid_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypeid_like)){
            this.getSearchCond().like("pimqualtypeid", n_pimqualtypeid_like);
        }
    }
	private String n_pimqualtypename_like;//[岗位（技能）证书]
	public void setN_pimqualtypename_like(String n_pimqualtypename_like) {
        this.n_pimqualtypename_like = n_pimqualtypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_like)){
            this.getSearchCond().like("pimqualtypename", n_pimqualtypename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("pimqualtypename", query)   
            );
		 }
	}
}




