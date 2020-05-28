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
import cn.ibizlab.ehr.core.orm.domain.ORMDepEstMan;
/**
 * 关系型数据实体[ORMDepEstMan] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ORMDepEstManSearchContext extends QueryWrapperContext<ORMDepEstMan> {

	private String n_ormdepestmanname_like;//[部门编制管理名称]
	public void setN_ormdepestmanname_like(String n_ormdepestmanname_like) {
        this.n_ormdepestmanname_like = n_ormdepestmanname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdepestmanname_like)){
            this.getSelectCond().like("ormdepestmanname", n_ormdepestmanname_like);
        }
    }
	private String n_ormdutyname_eq;//[职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSelectCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSelectCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormzwbzmc_eq;//[职务编制]
	public void setN_ormzwbzmc_eq(String n_ormzwbzmc_eq) {
        this.n_ormzwbzmc_eq = n_ormzwbzmc_eq;
        if(!ObjectUtils.isEmpty(this.n_ormzwbzmc_eq)){
            this.getSelectCond().eq("ormzwbzmc", n_ormzwbzmc_eq);
        }
    }
	private String n_ormzwbzmc_like;//[职务编制]
	public void setN_ormzwbzmc_like(String n_ormzwbzmc_like) {
        this.n_ormzwbzmc_like = n_ormzwbzmc_like;
        if(!ObjectUtils.isEmpty(this.n_ormzwbzmc_like)){
            this.getSelectCond().like("ormzwbzmc", n_ormzwbzmc_like);
        }
    }
	private String n_ormzwbzid_eq;//[职务编制ID]
	public void setN_ormzwbzid_eq(String n_ormzwbzid_eq) {
        this.n_ormzwbzid_eq = n_ormzwbzid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormzwbzid_eq)){
            this.getSelectCond().eq("ormzwbzid", n_ormzwbzid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务ID]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSelectCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("ormdepestmanname",query);
			this.getSelectCond().or().like("ormdutyname",query);
		 }
	}
}




