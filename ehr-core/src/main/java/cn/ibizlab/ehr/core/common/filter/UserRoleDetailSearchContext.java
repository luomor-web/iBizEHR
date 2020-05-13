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
import cn.ibizlab.ehr.core.common.domain.UserRoleDetail;
/**
 * 关系型数据实体[UserRoleDetail] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDetailSearchContext extends QueryWrapperContext<UserRoleDetail> {

	private String n_userdata_like;//[用户数据]
	public void setN_userdata_like(String n_userdata_like) {
        this.n_userdata_like = n_userdata_like;
        if(!ObjectUtils.isEmpty(this.n_userdata_like)){
            this.getSelectCond().like("userdata", n_userdata_like);
        }
    }
	private String n_userroledetailname_like;//[用户角色成员名称]
	public void setN_userroledetailname_like(String n_userroledetailname_like) {
        this.n_userroledetailname_like = n_userroledetailname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledetailname_like)){
            this.getSelectCond().like("userroledetailname", n_userroledetailname_like);
        }
    }
	private String n_userdata2_like;//[用户数据2]
	public void setN_userdata2_like(String n_userdata2_like) {
        this.n_userdata2_like = n_userdata2_like;
        if(!ObjectUtils.isEmpty(this.n_userdata2_like)){
            this.getSelectCond().like("userdata2", n_userdata2_like);
        }
    }
	private String n_userobjectname_eq;//[用户对象]
	public void setN_userobjectname_eq(String n_userobjectname_eq) {
        this.n_userobjectname_eq = n_userobjectname_eq;
        if(!ObjectUtils.isEmpty(this.n_userobjectname_eq)){
            this.getSelectCond().eq("userobjectname", n_userobjectname_eq);
        }
    }
	private String n_userobjectname_like;//[用户对象]
	public void setN_userobjectname_like(String n_userobjectname_like) {
        this.n_userobjectname_like = n_userobjectname_like;
        if(!ObjectUtils.isEmpty(this.n_userobjectname_like)){
            this.getSelectCond().like("userobjectname", n_userobjectname_like);
        }
    }
	private String n_uesrrolename_eq;//[用户角色]
	public void setN_uesrrolename_eq(String n_uesrrolename_eq) {
        this.n_uesrrolename_eq = n_uesrrolename_eq;
        if(!ObjectUtils.isEmpty(this.n_uesrrolename_eq)){
            this.getSelectCond().eq("uesrrolename", n_uesrrolename_eq);
        }
    }
	private String n_uesrrolename_like;//[用户角色]
	public void setN_uesrrolename_like(String n_uesrrolename_like) {
        this.n_uesrrolename_like = n_uesrrolename_like;
        if(!ObjectUtils.isEmpty(this.n_uesrrolename_like)){
            this.getSelectCond().like("uesrrolename", n_uesrrolename_like);
        }
    }
	private String n_userobjectid_eq;//[用户对象]
	public void setN_userobjectid_eq(String n_userobjectid_eq) {
        this.n_userobjectid_eq = n_userobjectid_eq;
        if(!ObjectUtils.isEmpty(this.n_userobjectid_eq)){
            this.getSelectCond().eq("userobjectid", n_userobjectid_eq);
        }
    }
	private String n_userroleid_eq;//[用户角色]
	public void setN_userroleid_eq(String n_userroleid_eq) {
        this.n_userroleid_eq = n_userroleid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroleid_eq)){
            this.getSelectCond().eq("userroleid", n_userroleid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroledetailname",query);
			this.getSelectCond().or().like("userobjectname",query);
		 }
	}
}




