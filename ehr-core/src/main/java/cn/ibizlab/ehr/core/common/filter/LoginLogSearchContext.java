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
import cn.ibizlab.ehr.core.common.domain.LoginLog;
/**
 * 关系型数据实体[LoginLog] 查询条件对象
 */
@Slf4j
@Data
public class LoginLogSearchContext extends QueryWrapperContext<LoginLog> {

	private String n_loginlogname_like;//[帐户使用记录名称]
	public void setN_loginlogname_like(String n_loginlogname_like) {
        this.n_loginlogname_like = n_loginlogname_like;
        if(!ObjectUtils.isEmpty(this.n_loginlogname_like)){
            this.getSelectCond().like("loginlogname", n_loginlogname_like);
        }
    }
	private String n_loginaccountname_eq;//[登录帐户]
	public void setN_loginaccountname_eq(String n_loginaccountname_eq) {
        this.n_loginaccountname_eq = n_loginaccountname_eq;
        if(!ObjectUtils.isEmpty(this.n_loginaccountname_eq)){
            this.getSelectCond().eq("loginaccountname", n_loginaccountname_eq);
        }
    }
	private String n_loginaccountname_like;//[登录帐户]
	public void setN_loginaccountname_like(String n_loginaccountname_like) {
        this.n_loginaccountname_like = n_loginaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_loginaccountname_like)){
            this.getSelectCond().like("loginaccountname", n_loginaccountname_like);
        }
    }
	private String n_loginaccountid_eq;//[登录帐户]
	public void setN_loginaccountid_eq(String n_loginaccountid_eq) {
        this.n_loginaccountid_eq = n_loginaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_loginaccountid_eq)){
            this.getSelectCond().eq("loginaccountid", n_loginaccountid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("loginlogname",query);
		 }
	}
}




