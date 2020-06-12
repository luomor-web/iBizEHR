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
import cn.ibizlab.ehr.core.orm.domain.OrmZwdqgz;
/**
 * 关系型数据实体[OrmZwdqgz] 查询条件对象
 */
@Slf4j
@Data
public class OrmZwdqgzSearchContext extends QueryWrapperContext<OrmZwdqgz> {

	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
        }
    }
	private String n_zwlx_eq;//[职务名称]
	public void setN_zwlx_eq(String n_zwlx_eq) {
        this.n_zwlx_eq = n_zwlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zwlx_eq)){
            this.getSearchCond().eq("zwlx", n_zwlx_eq);
        }
    }
	private String n_ormzwdqgzname_like;//[职级到期规则名称]
	public void setN_ormzwdqgzname_like(String n_ormzwdqgzname_like) {
        this.n_ormzwdqgzname_like = n_ormzwdqgzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormzwdqgzname_like)){
            this.getSearchCond().like("ormzwdqgzname", n_ormzwdqgzname_like);
        }
    }
	private String n_ormrankname_eq;//[职级]
	public void setN_ormrankname_eq(String n_ormrankname_eq) {
        this.n_ormrankname_eq = n_ormrankname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_eq)){
            this.getSearchCond().eq("ormrankname", n_ormrankname_eq);
        }
    }
	private String n_ormrankname_like;//[职级]
	public void setN_ormrankname_like(String n_ormrankname_like) {
        this.n_ormrankname_like = n_ormrankname_like;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_like)){
            this.getSearchCond().like("ormrankname", n_ormrankname_like);
        }
    }
	private String n_ormdutyname_eq;//[职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormrankid_eq;//[职级标识]
	public void setN_ormrankid_eq(String n_ormrankid_eq) {
        this.n_ormrankid_eq = n_ormrankid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankid_eq)){
            this.getSearchCond().eq("ormrankid", n_ormrankid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
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
                     wrapper.like("ormzwdqgzname", query)   
            );
		 }
	}
}




