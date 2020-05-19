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
import cn.ibizlab.ehr.core.common.domain.Org;
/**
 * 关系型数据实体[Org] 查询条件对象
 */
@Slf4j
@Data
public class OrgSearchContext extends QueryWrapperContext<Org> {

	private String n_shortname_like;//[简称]
	public void setN_shortname_like(String n_shortname_like) {
        this.n_shortname_like = n_shortname_like;
        if(!ObjectUtils.isEmpty(this.n_shortname_like)){
            this.getSelectCond().like("shortname", n_shortname_like);
        }
    }
	private String n_orgname_like;//[组织机构名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_porgname_eq;//[上级机构]
	public void setN_porgname_eq(String n_porgname_eq) {
        this.n_porgname_eq = n_porgname_eq;
        if(!ObjectUtils.isEmpty(this.n_porgname_eq)){
            this.getSelectCond().eq("porgname", n_porgname_eq);
        }
    }
	private String n_porgname_like;//[上级机构]
	public void setN_porgname_like(String n_porgname_like) {
        this.n_porgname_like = n_porgname_like;
        if(!ObjectUtils.isEmpty(this.n_porgname_like)){
            this.getSelectCond().like("porgname", n_porgname_like);
        }
    }
	private String n_porgid_eq;//[组织机构]
	public void setN_porgid_eq(String n_porgid_eq) {
        this.n_porgid_eq = n_porgid_eq;
        if(!ObjectUtils.isEmpty(this.n_porgid_eq)){
            this.getSelectCond().eq("porgid", n_porgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgname",query);
		 }
	}
}




