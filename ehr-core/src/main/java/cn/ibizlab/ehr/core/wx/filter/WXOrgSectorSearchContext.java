package cn.ibizlab.ehr.core.wx.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.wx.domain.WXOrgSector;
/**
 * 关系型数据实体[WXOrgSector] 查询条件对象
 */
@Slf4j
@Data
public class WXOrgSectorSearchContext extends QueryWrapperContext<WXOrgSector> {

	private String n_wxorgsectorname_like;//[微信部门名称]
	public void setN_wxorgsectorname_like(String n_wxorgsectorname_like) {
        this.n_wxorgsectorname_like = n_wxorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_wxorgsectorname_like)){
            this.getSelectCond().like("wxorgsectorname", n_wxorgsectorname_like);
        }
    }
	private String n_wxaccountname_eq;//[微信公众号]
	public void setN_wxaccountname_eq(String n_wxaccountname_eq) {
        this.n_wxaccountname_eq = n_wxaccountname_eq;
        if(!ObjectUtils.isEmpty(this.n_wxaccountname_eq)){
            this.getSelectCond().eq("wxaccountname", n_wxaccountname_eq);
        }
    }
	private String n_wxaccountname_like;//[微信公众号]
	public void setN_wxaccountname_like(String n_wxaccountname_like) {
        this.n_wxaccountname_like = n_wxaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_wxaccountname_like)){
            this.getSelectCond().like("wxaccountname", n_wxaccountname_like);
        }
    }
	private String n_orgsectorname_eq;//[机构部门]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSelectCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[机构部门]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_wxaccountid_eq;//[微信公众号]
	public void setN_wxaccountid_eq(String n_wxaccountid_eq) {
        this.n_wxaccountid_eq = n_wxaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_wxaccountid_eq)){
            this.getSelectCond().eq("wxaccountid", n_wxaccountid_eq);
        }
    }
	private String n_orgsectorid_eq;//[机构部门]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSelectCond().eq("orgsectorid", n_orgsectorid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wxorgsectorname",query);
		 }
	}
}




