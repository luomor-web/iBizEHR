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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEFieldes;
/**
 * 关系型数据实体[UserRoleDEFieldes] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDEFieldesSearchContext extends QueryWrapperContext<UserRoleDEFieldes> {

	private String n_userroledefieldsname_like;//[用户角色相关实体属性访问控制]
	public void setN_userroledefieldsname_like(String n_userroledefieldsname_like) {
        this.n_userroledefieldsname_like = n_userroledefieldsname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledefieldsname_like)){
            this.getSelectCond().like("userroledefieldsname", n_userroledefieldsname_like);
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
	private String n_userroledefieldname_eq;//[实体属性控制]
	public void setN_userroledefieldname_eq(String n_userroledefieldname_eq) {
        this.n_userroledefieldname_eq = n_userroledefieldname_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledefieldname_eq)){
            this.getSelectCond().eq("userroledefieldname", n_userroledefieldname_eq);
        }
    }
	private String n_userroledefieldname_like;//[实体属性控制]
	public void setN_userroledefieldname_like(String n_userroledefieldname_like) {
        this.n_userroledefieldname_like = n_userroledefieldname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledefieldname_like)){
            this.getSelectCond().like("userroledefieldname", n_userroledefieldname_like);
        }
    }
	private String n_userroleid_eq;//[用户角色]
	public void setN_userroleid_eq(String n_userroleid_eq) {
        this.n_userroleid_eq = n_userroleid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroleid_eq)){
            this.getSelectCond().eq("userroleid", n_userroleid_eq);
        }
    }
	private String n_userroledefieldid_eq;//[实体属性访问能力]
	public void setN_userroledefieldid_eq(String n_userroledefieldid_eq) {
        this.n_userroledefieldid_eq = n_userroledefieldid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledefieldid_eq)){
            this.getSelectCond().eq("userroledefieldid", n_userroledefieldid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroledefieldsname",query);
		 }
	}
}




