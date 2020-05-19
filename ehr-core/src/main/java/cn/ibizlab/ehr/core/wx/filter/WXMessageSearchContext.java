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
import cn.ibizlab.ehr.core.wx.domain.WXMessage;
/**
 * 关系型数据实体[WXMessage] 查询条件对象
 */
@Slf4j
@Data
public class WXMessageSearchContext extends QueryWrapperContext<WXMessage> {

	private String n_wxmessagename_like;//[微信消息名称]
	public void setN_wxmessagename_like(String n_wxmessagename_like) {
        this.n_wxmessagename_like = n_wxmessagename_like;
        if(!ObjectUtils.isEmpty(this.n_wxmessagename_like)){
            this.getSelectCond().like("wxmessagename", n_wxmessagename_like);
        }
    }
	private String n_msgtype_eq;//[消息类型]
	public void setN_msgtype_eq(String n_msgtype_eq) {
        this.n_msgtype_eq = n_msgtype_eq;
        if(!ObjectUtils.isEmpty(this.n_msgtype_eq)){
            this.getSelectCond().eq("msgtype", n_msgtype_eq);
        }
    }
	private String n_respmsgtype_eq;//[反馈消息类型]
	public void setN_respmsgtype_eq(String n_respmsgtype_eq) {
        this.n_respmsgtype_eq = n_respmsgtype_eq;
        if(!ObjectUtils.isEmpty(this.n_respmsgtype_eq)){
            this.getSelectCond().eq("respmsgtype", n_respmsgtype_eq);
        }
    }
	private String n_wxentappname_eq;//[微信企业应用]
	public void setN_wxentappname_eq(String n_wxentappname_eq) {
        this.n_wxentappname_eq = n_wxentappname_eq;
        if(!ObjectUtils.isEmpty(this.n_wxentappname_eq)){
            this.getSelectCond().eq("wxentappname", n_wxentappname_eq);
        }
    }
	private String n_wxentappname_like;//[微信企业应用]
	public void setN_wxentappname_like(String n_wxentappname_like) {
        this.n_wxentappname_like = n_wxentappname_like;
        if(!ObjectUtils.isEmpty(this.n_wxentappname_like)){
            this.getSelectCond().like("wxentappname", n_wxentappname_like);
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
	private String n_wxentappid_eq;//[微信企业应用]
	public void setN_wxentappid_eq(String n_wxentappid_eq) {
        this.n_wxentappid_eq = n_wxentappid_eq;
        if(!ObjectUtils.isEmpty(this.n_wxentappid_eq)){
            this.getSelectCond().eq("wxentappid", n_wxentappid_eq);
        }
    }
	private String n_wxaccountid_eq;//[微信公众号]
	public void setN_wxaccountid_eq(String n_wxaccountid_eq) {
        this.n_wxaccountid_eq = n_wxaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_wxaccountid_eq)){
            this.getSelectCond().eq("wxaccountid", n_wxaccountid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wxmessagename",query);
		 }
	}
}




