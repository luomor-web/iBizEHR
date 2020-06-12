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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgInfo;
/**
 * 关系型数据实体[OrmOrgInfo] 查询条件对象
 */
@Slf4j
@Data
public class OrmOrgInfoSearchContext extends QueryWrapperContext<OrmOrgInfo> {

	private String n_postinfo_eq;//[岗位]
	public void setN_postinfo_eq(String n_postinfo_eq) {
        this.n_postinfo_eq = n_postinfo_eq;
        if(!ObjectUtils.isEmpty(this.n_postinfo_eq)){
            this.getSearchCond().eq("postinfo", n_postinfo_eq);
        }
    }
	private String n_postinfo_like;//[岗位]
	public void setN_postinfo_like(String n_postinfo_like) {
        this.n_postinfo_like = n_postinfo_like;
        if(!ObjectUtils.isEmpty(this.n_postinfo_like)){
            this.getSearchCond().like("postinfo", n_postinfo_like);
        }
    }
	private String n_orgcode_eq;//[组织编码]
	public void setN_orgcode_eq(String n_orgcode_eq) {
        this.n_orgcode_eq = n_orgcode_eq;
        if(!ObjectUtils.isEmpty(this.n_orgcode_eq)){
            this.getSearchCond().eq("orgcode", n_orgcode_eq);
        }
    }
	private String n_startstopsign_eq;//[启停标识]
	public void setN_startstopsign_eq(String n_startstopsign_eq) {
        this.n_startstopsign_eq = n_startstopsign_eq;
        if(!ObjectUtils.isEmpty(this.n_startstopsign_eq)){
            this.getSearchCond().eq("startstopsign", n_startstopsign_eq);
        }
    }
	private String n_belongregion_eq;//[所属区域]
	public void setN_belongregion_eq(String n_belongregion_eq) {
        this.n_belongregion_eq = n_belongregion_eq;
        if(!ObjectUtils.isEmpty(this.n_belongregion_eq)){
            this.getSearchCond().eq("belongregion", n_belongregion_eq);
        }
    }
	private String n_substandard_eq;//[补贴标准]
	public void setN_substandard_eq(String n_substandard_eq) {
        this.n_substandard_eq = n_substandard_eq;
        if(!ObjectUtils.isEmpty(this.n_substandard_eq)){
            this.getSearchCond().eq("substandard", n_substandard_eq);
        }
    }
	private String n_ormorginfoname_like;//[组织名称]
	public void setN_ormorginfoname_like(String n_ormorginfoname_like) {
        this.n_ormorginfoname_like = n_ormorginfoname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorginfoname_like)){
            this.getSearchCond().like("ormorginfoname", n_ormorginfoname_like);
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
                     wrapper.like("shortname", query)   
                        .or().like("ormorginfoname", query)            
            );
		 }
	}
}




