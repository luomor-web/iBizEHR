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
import cn.ibizlab.ehr.core.orm.domain.OrmPostDetails;
/**
 * 关系型数据实体[OrmPostDetails] 查询条件对象
 */
@Slf4j
@Data
public class OrmPostDetailsSearchContext extends QueryWrapperContext<OrmPostDetails> {

	private String n_ormpostdetailsname_like;//[岗位明细]
	public void setN_ormpostdetailsname_like(String n_ormpostdetailsname_like) {
        this.n_ormpostdetailsname_like = n_ormpostdetailsname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostdetailsname_like)){
            this.getSearchCond().like("ormpostdetailsname", n_ormpostdetailsname_like);
        }
    }
	private String n_ormpostname_eq;//[岗位集名称]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[岗位集名称]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_ormpostlibname_eq;//[岗位名称]
	public void setN_ormpostlibname_eq(String n_ormpostlibname_eq) {
        this.n_ormpostlibname_eq = n_ormpostlibname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostlibname_eq)){
            this.getSearchCond().eq("ormpostlibname", n_ormpostlibname_eq);
        }
    }
	private String n_ormpostlibname_like;//[岗位名称]
	public void setN_ormpostlibname_like(String n_ormpostlibname_like) {
        this.n_ormpostlibname_like = n_ormpostlibname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostlibname_like)){
            this.getSearchCond().like("ormpostlibname", n_ormpostlibname_like);
        }
    }
	private String n_ormpostid_eq;//[岗位集ID]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormpostlibid_eq;//[岗位ID]
	public void setN_ormpostlibid_eq(String n_ormpostlibid_eq) {
        this.n_ormpostlibid_eq = n_ormpostlibid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostlibid_eq)){
            this.getSearchCond().eq("ormpostlibid", n_ormpostlibid_eq);
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
                     wrapper.like("ormpostdetailsname", query)   
                        .or().like("ormpostlibname", query)            
            );
		 }
	}
}




