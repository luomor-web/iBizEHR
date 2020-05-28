package cn.ibizlab.ehr.core.orm.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.orm.domain.ORMUSER;
/**
 * 关系型数据实体[ORMUSER] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ORMUSERSearchContext extends QueryWrapperContext<ORMUSER> {

	private String n_usercode_eq;//[用户编号]
	public void setN_usercode_eq(String n_usercode_eq) {
        this.n_usercode_eq = n_usercode_eq;
        if(!ObjectUtils.isEmpty(this.n_usercode_eq)){
            this.getSelectCond().eq("usercode", n_usercode_eq);
        }
    }
	private String n_orgusername_like;//[用户名称]
	public void setN_orgusername_like(String n_orgusername_like) {
        this.n_orgusername_like = n_orgusername_like;
        if(!ObjectUtils.isEmpty(this.n_orgusername_like)){
            this.getSelectCond().like("orgusername", n_orgusername_like);
        }
    }
	private String n_orgname_eq;//[所属组织]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSelectCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[所属组织]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_orgsectorname_eq;//[所属部门]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSelectCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[所属部门]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_orgid_eq;//[组织ID]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_orgsectorid_eq;//[部门ID]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSelectCond().eq("orgsectorid", n_orgsectorid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgusername",query);
		 }
	}
}




