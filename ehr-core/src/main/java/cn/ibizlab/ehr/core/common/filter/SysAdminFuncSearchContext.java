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
import cn.ibizlab.ehr.core.common.domain.SysAdminFunc;
/**
 * 关系型数据实体[SysAdminFunc] 查询条件对象
 */
@Slf4j
@Data
public class SysAdminFuncSearchContext extends QueryWrapperContext<SysAdminFunc> {

	private String n_sysadminfuncname_like;//[系统管理功能名称]
	public void setN_sysadminfuncname_like(String n_sysadminfuncname_like) {
        this.n_sysadminfuncname_like = n_sysadminfuncname_like;
        if(!ObjectUtils.isEmpty(this.n_sysadminfuncname_like)){
            this.getSelectCond().like("sysadminfuncname", n_sysadminfuncname_like);
        }
    }
	private String n_sysadminname_eq;//[管理模块]
	public void setN_sysadminname_eq(String n_sysadminname_eq) {
        this.n_sysadminname_eq = n_sysadminname_eq;
        if(!ObjectUtils.isEmpty(this.n_sysadminname_eq)){
            this.getSelectCond().eq("sysadminname", n_sysadminname_eq);
        }
    }
	private String n_sysadminname_like;//[管理模块]
	public void setN_sysadminname_like(String n_sysadminname_like) {
        this.n_sysadminname_like = n_sysadminname_like;
        if(!ObjectUtils.isEmpty(this.n_sysadminname_like)){
            this.getSelectCond().like("sysadminname", n_sysadminname_like);
        }
    }
	private String n_sysadminid_eq;//[系统管理功能_管理模块]
	public void setN_sysadminid_eq(String n_sysadminid_eq) {
        this.n_sysadminid_eq = n_sysadminid_eq;
        if(!ObjectUtils.isEmpty(this.n_sysadminid_eq)){
            this.getSelectCond().eq("sysadminid", n_sysadminid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("sysadminfuncname",query);
		 }
	}
}




