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
import cn.ibizlab.ehr.core.common.domain.UserGroupDetail;
/**
 * 关系型数据实体[UserGroupDetail] 查询条件对象
 */
@Slf4j
@Data
public class UserGroupDetailSearchContext extends QueryWrapperContext<UserGroupDetail> {

	private String n_usergroupdetailname_like;//[用户组成员名称]
	public void setN_usergroupdetailname_like(String n_usergroupdetailname_like) {
        this.n_usergroupdetailname_like = n_usergroupdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_usergroupdetailname_like)){
            this.getSelectCond().like("usergroupdetailname", n_usergroupdetailname_like);
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
	private String n_usergroupname_eq;//[用户组]
	public void setN_usergroupname_eq(String n_usergroupname_eq) {
        this.n_usergroupname_eq = n_usergroupname_eq;
        if(!ObjectUtils.isEmpty(this.n_usergroupname_eq)){
            this.getSelectCond().eq("usergroupname", n_usergroupname_eq);
        }
    }
	private String n_usergroupname_like;//[用户组]
	public void setN_usergroupname_like(String n_usergroupname_like) {
        this.n_usergroupname_like = n_usergroupname_like;
        if(!ObjectUtils.isEmpty(this.n_usergroupname_like)){
            this.getSelectCond().like("usergroupname", n_usergroupname_like);
        }
    }
	private String n_usergroupid_eq;//[用户组]
	public void setN_usergroupid_eq(String n_usergroupid_eq) {
        this.n_usergroupid_eq = n_usergroupid_eq;
        if(!ObjectUtils.isEmpty(this.n_usergroupid_eq)){
            this.getSelectCond().eq("usergroupid", n_usergroupid_eq);
        }
    }
	private String n_userobjectid_eq;//[用户对象]
	public void setN_userobjectid_eq(String n_userobjectid_eq) {
        this.n_userobjectid_eq = n_userobjectid_eq;
        if(!ObjectUtils.isEmpty(this.n_userobjectid_eq)){
            this.getSelectCond().eq("userobjectid", n_userobjectid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("usergroupdetailname",query);
		 }
	}
}




