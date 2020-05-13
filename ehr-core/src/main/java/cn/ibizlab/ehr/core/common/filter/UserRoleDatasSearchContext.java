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
import cn.ibizlab.ehr.core.common.domain.UserRoleDatas;
/**
 * 关系型数据实体[UserRoleDatas] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDatasSearchContext extends QueryWrapperContext<UserRoleDatas> {

	private String n_userroledatasname_like;//[用户角色数据能力名称]
	public void setN_userroledatasname_like(String n_userroledatasname_like) {
        this.n_userroledatasname_like = n_userroledatasname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledatasname_like)){
            this.getSelectCond().like("userroledatasname", n_userroledatasname_like);
        }
    }
	private String n_userroledataname_eq;//[实体数据能力]
	public void setN_userroledataname_eq(String n_userroledataname_eq) {
        this.n_userroledataname_eq = n_userroledataname_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_eq)){
            this.getSelectCond().eq("userroledataname", n_userroledataname_eq);
        }
    }
	private String n_userroledataname_like;//[实体数据能力]
	public void setN_userroledataname_like(String n_userroledataname_like) {
        this.n_userroledataname_like = n_userroledataname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_like)){
            this.getSelectCond().like("userroledataname", n_userroledataname_like);
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
	private String n_userroleid_eq;//[用户角色]
	public void setN_userroleid_eq(String n_userroleid_eq) {
        this.n_userroleid_eq = n_userroleid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroleid_eq)){
            this.getSelectCond().eq("userroleid", n_userroleid_eq);
        }
    }
	private String n_userroledataid_eq;//[实体数据角色能力]
	public void setN_userroledataid_eq(String n_userroledataid_eq) {
        this.n_userroledataid_eq = n_userroledataid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledataid_eq)){
            this.getSelectCond().eq("userroledataid", n_userroledataid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroledatasname",query);
			this.getSelectCond().or().like("userroledataname",query);
		 }
	}
}




