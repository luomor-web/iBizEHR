package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.LoginAccount;
/**
 * 关系型数据实体[LoginAccount] 查询条件对象
 */
@Slf4j
@Data
public class LoginAccountSearchContext extends QueryWrapperContext<LoginAccount> {

	private String n_appuitheme_eq;//[应用界面主题]
	public void setN_appuitheme_eq(String n_appuitheme_eq) {
        this.n_appuitheme_eq = n_appuitheme_eq;
        if(!ObjectUtils.isEmpty(this.n_appuitheme_eq)){
            this.getSelectCond().eq("appuitheme", n_appuitheme_eq);
        }
    }
	private String n_loginaccountname_like;//[登录帐户]
	public void setN_loginaccountname_like(String n_loginaccountname_like) {
        this.n_loginaccountname_like = n_loginaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_loginaccountname_like)){
            this.getSelectCond().like("loginaccountname", n_loginaccountname_like);
        }
    }
	private Integer n_isenable_eq;//[是否启用]
	public void setN_isenable_eq(Integer n_isenable_eq) {
        this.n_isenable_eq = n_isenable_eq;
        if(!ObjectUtils.isEmpty(this.n_isenable_eq)){
            this.getSelectCond().eq("isenable", n_isenable_eq);
        }
    }
	private String n_language_eq;//[默认语言]
	public void setN_language_eq(String n_language_eq) {
        this.n_language_eq = n_language_eq;
        if(!ObjectUtils.isEmpty(this.n_language_eq)){
            this.getSelectCond().eq("language", n_language_eq);
        }
    }
	private String n_username_eq;//[用户]
	public void setN_username_eq(String n_username_eq) {
        this.n_username_eq = n_username_eq;
        if(!ObjectUtils.isEmpty(this.n_username_eq)){
            this.getSelectCond().eq("username", n_username_eq);
        }
    }
	private String n_username_like;//[用户]
	public void setN_username_like(String n_username_like) {
        this.n_username_like = n_username_like;
        if(!ObjectUtils.isEmpty(this.n_username_like)){
            this.getSelectCond().like("username", n_username_like);
        }
    }
	private String n_userid_eq;//[用户]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSelectCond().eq("userid", n_userid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("loginaccountname",query);
		 }
	}
}




