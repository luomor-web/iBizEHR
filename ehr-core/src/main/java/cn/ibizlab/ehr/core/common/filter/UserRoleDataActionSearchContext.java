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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataAction;
/**
 * 关系型数据实体[UserRoleDataAction] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDataActionSearchContext extends QueryWrapperContext<UserRoleDataAction> {

	private String n_userroledataactionname_like;//[操作名称]
	public void setN_userroledataactionname_like(String n_userroledataactionname_like) {
        this.n_userroledataactionname_like = n_userroledataactionname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledataactionname_like)){
            this.getSelectCond().like("userroledataactionname", n_userroledataactionname_like);
        }
    }
	private String n_userroledataname_eq;//[用户角色]
	public void setN_userroledataname_eq(String n_userroledataname_eq) {
        this.n_userroledataname_eq = n_userroledataname_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_eq)){
            this.getSelectCond().eq("userroledataname", n_userroledataname_eq);
        }
    }
	private String n_userroledataname_like;//[用户角色]
	public void setN_userroledataname_like(String n_userroledataname_like) {
        this.n_userroledataname_like = n_userroledataname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_like)){
            this.getSelectCond().like("userroledataname", n_userroledataname_like);
        }
    }
	private String n_userroledataid_eq;//[用户角色数据操作_用户角色数据]
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
			this.getSelectCond().or().like("userroledataactionname",query);
		 }
	}
}




