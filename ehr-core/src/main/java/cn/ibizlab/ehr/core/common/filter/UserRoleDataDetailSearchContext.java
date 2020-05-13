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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataDetail;
/**
 * 关系型数据实体[UserRoleDataDetail] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDataDetailSearchContext extends QueryWrapperContext<UserRoleDataDetail> {

	private String n_userroledatadetailname_like;//[数据对象能力明细名称]
	public void setN_userroledatadetailname_like(String n_userroledatadetailname_like) {
        this.n_userroledatadetailname_like = n_userroledatadetailname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledatadetailname_like)){
            this.getSelectCond().like("userroledatadetailname", n_userroledatadetailname_like);
        }
    }
	private String n_userroledataname_eq;//[数据对象能力]
	public void setN_userroledataname_eq(String n_userroledataname_eq) {
        this.n_userroledataname_eq = n_userroledataname_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_eq)){
            this.getSelectCond().eq("userroledataname", n_userroledataname_eq);
        }
    }
	private String n_userroledataname_like;//[数据对象能力]
	public void setN_userroledataname_like(String n_userroledataname_like) {
        this.n_userroledataname_like = n_userroledataname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_like)){
            this.getSelectCond().like("userroledataname", n_userroledataname_like);
        }
    }
	private String n_querymodelname_eq;//[查询模型]
	public void setN_querymodelname_eq(String n_querymodelname_eq) {
        this.n_querymodelname_eq = n_querymodelname_eq;
        if(!ObjectUtils.isEmpty(this.n_querymodelname_eq)){
            this.getSelectCond().eq("querymodelname", n_querymodelname_eq);
        }
    }
	private String n_querymodelname_like;//[查询模型]
	public void setN_querymodelname_like(String n_querymodelname_like) {
        this.n_querymodelname_like = n_querymodelname_like;
        if(!ObjectUtils.isEmpty(this.n_querymodelname_like)){
            this.getSelectCond().like("querymodelname", n_querymodelname_like);
        }
    }
	private String n_userroledataid_eq;//[数据对象能力]
	public void setN_userroledataid_eq(String n_userroledataid_eq) {
        this.n_userroledataid_eq = n_userroledataid_eq;
        if(!ObjectUtils.isEmpty(this.n_userroledataid_eq)){
            this.getSelectCond().eq("userroledataid", n_userroledataid_eq);
        }
    }
	private String n_querymodelid_eq;//[查询模型]
	public void setN_querymodelid_eq(String n_querymodelid_eq) {
        this.n_querymodelid_eq = n_querymodelid_eq;
        if(!ObjectUtils.isEmpty(this.n_querymodelid_eq)){
            this.getSelectCond().eq("querymodelid", n_querymodelid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroledatadetailname",query);
		 }
	}
}




