package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmDuty;
/**
 * 关系型数据实体[OrmDuty] 查询条件对象
 */
@Slf4j
@Data
public class OrmDutySearchContext extends QueryWrapperContext<OrmDuty> {

	private String n_fglx_like;//[职务编码]
	public void setN_fglx_like(String n_fglx_like) {
        this.n_fglx_like = n_fglx_like;
        if(!ObjectUtils.isEmpty(this.n_fglx_like)){
            this.getSearchCond().like("fglx", n_fglx_like);
        }
    }
	private String n_zwjb_eq;//[职务级别]
	public void setN_zwjb_eq(String n_zwjb_eq) {
        this.n_zwjb_eq = n_zwjb_eq;
        if(!ObjectUtils.isEmpty(this.n_zwjb_eq)){
            this.getSearchCond().eq("zwjb", n_zwjb_eq);
        }
    }
	private String n_dyzj_eq;//[对应职级]
	public void setN_dyzj_eq(String n_dyzj_eq) {
        this.n_dyzj_eq = n_dyzj_eq;
        if(!ObjectUtils.isEmpty(this.n_dyzj_eq)){
            this.getSearchCond().eq("dyzj", n_dyzj_eq);
        }
    }
	private String n_zwlb_eq;//[层级]
	public void setN_zwlb_eq(String n_zwlb_eq) {
        this.n_zwlb_eq = n_zwlb_eq;
        if(!ObjectUtils.isEmpty(this.n_zwlb_eq)){
            this.getSearchCond().eq("zwlb", n_zwlb_eq);
        }
    }
	private String n_zwlb_like;//[层级]
	public void setN_zwlb_like(String n_zwlb_like) {
        this.n_zwlb_like = n_zwlb_like;
        if(!ObjectUtils.isEmpty(this.n_zwlb_like)){
            this.getSearchCond().like("zwlb", n_zwlb_like);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
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
                     wrapper.like("ormdutyname", query)   
            );
		 }
	}
}




