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
import cn.ibizlab.ehr.core.wx.domain.WXAccount;
/**
 * 关系型数据实体[WXAccount] 查询条件对象
 */
@Slf4j
@Data
public class WXAccountSearchContext extends QueryWrapperContext<WXAccount> {

	private String n_wxaccountname_like;//[微信公众号名称]
	public void setN_wxaccountname_like(String n_wxaccountname_like) {
        this.n_wxaccountname_like = n_wxaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_wxaccountname_like)){
            this.getSelectCond().like("wxaccountname", n_wxaccountname_like);
        }
    }
	private String n_orgname_eq;//[机构]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSelectCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[机构]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_orgid_eq;//[机构]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wxaccountname",query);
		 }
	}
}




