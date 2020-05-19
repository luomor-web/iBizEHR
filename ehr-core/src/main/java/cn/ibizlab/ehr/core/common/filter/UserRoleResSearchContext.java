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
import cn.ibizlab.ehr.core.common.domain.UserRoleRes;
/**
 * 关系型数据实体[UserRoleRes] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleResSearchContext extends QueryWrapperContext<UserRoleRes> {

	private String n_userroleresname_like;//[用户角色资源能力名称]
	public void setN_userroleresname_like(String n_userroleresname_like) {
        this.n_userroleresname_like = n_userroleresname_like;
        if(!ObjectUtils.isEmpty(this.n_userroleresname_like)){
            this.getSelectCond().like("userroleresname", n_userroleresname_like);
        }
    }
	private String n_userrolename_eq;//[用户角色]
	public void setN_userrolename_eq(String n_userrolename_eq) {
        this.n_userrolename_eq = n_userrolename_eq;
        if(!ObjectUtils.isEmpty(this.n_userrolename_eq)){
            this.getSelectCond().eq("userrolename", n_userrolename_eq);
        }
    }
	private String n_userrolename_like;//[用户角色]
	public void setN_userrolename_like(String n_userrolename_like) {
        this.n_userrolename_like = n_userrolename_like;
        if(!ObjectUtils.isEmpty(this.n_userrolename_like)){
            this.getSelectCond().like("userrolename", n_userrolename_like);
        }
    }
	private String n_uniresname_eq;//[资源]
	public void setN_uniresname_eq(String n_uniresname_eq) {
        this.n_uniresname_eq = n_uniresname_eq;
        if(!ObjectUtils.isEmpty(this.n_uniresname_eq)){
            this.getSelectCond().eq("uniresname", n_uniresname_eq);
        }
    }
	private String n_uniresname_like;//[资源]
	public void setN_uniresname_like(String n_uniresname_like) {
        this.n_uniresname_like = n_uniresname_like;
        if(!ObjectUtils.isEmpty(this.n_uniresname_like)){
            this.getSelectCond().like("uniresname", n_uniresname_like);
        }
    }
	private String n_userroleid_eq;//[用户角色]
	public void setN_userroleid_eq(String n_userroleid_eq) {
        this.n_userroleid_eq = n_userroleid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroleid_eq)){
            this.getSelectCond().eq("userroleid", n_userroleid_eq);
        }
    }
	private String n_uniresid_eq;//[统一资源]
	public void setN_uniresid_eq(String n_uniresid_eq) {
        this.n_uniresid_eq = n_uniresid_eq;
        if(!ObjectUtils.isEmpty(this.n_uniresid_eq)){
            this.getSelectCond().eq("uniresid", n_uniresid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroleresname",query);
			this.getSelectCond().or().like("uniresname",query);
		 }
	}
}




