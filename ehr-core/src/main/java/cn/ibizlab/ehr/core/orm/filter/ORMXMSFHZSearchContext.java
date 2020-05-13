package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.ORMXMSFHZ;
/**
 * 关系型数据实体[ORMXMSFHZ] 查询条件对象
 */
@Slf4j
@Data
public class ORMXMSFHZSearchContext extends QueryWrapperContext<ORMXMSFHZ> {

	private String n_month_eq;//[月份]
	public void setN_month_eq(String n_month_eq) {
        this.n_month_eq = n_month_eq;
        if(!ObjectUtils.isEmpty(this.n_month_eq)){
            this.getSelectCond().eq("month", n_month_eq);
        }
    }
	private String n_ey_eq;//[2月]
	public void setN_ey_eq(String n_ey_eq) {
        this.n_ey_eq = n_ey_eq;
        if(!ObjectUtils.isEmpty(this.n_ey_eq)){
            this.getSelectCond().eq("ey", n_ey_eq);
        }
    }
	private String n_jy_eq;//[9月]
	public void setN_jy_eq(String n_jy_eq) {
        this.n_jy_eq = n_jy_eq;
        if(!ObjectUtils.isEmpty(this.n_jy_eq)){
            this.getSelectCond().eq("jy", n_jy_eq);
        }
    }
	private String n_apy_eq;//[4月]
	public void setN_apy_eq(String n_apy_eq) {
        this.n_apy_eq = n_apy_eq;
        if(!ObjectUtils.isEmpty(this.n_apy_eq)){
            this.getSelectCond().eq("apy", n_apy_eq);
        }
    }
	private String n_yy_eq;//[1月]
	public void setN_yy_eq(String n_yy_eq) {
        this.n_yy_eq = n_yy_eq;
        if(!ObjectUtils.isEmpty(this.n_yy_eq)){
            this.getSelectCond().eq("yy", n_yy_eq);
        }
    }
	private String n_gw_like;//[岗位]
	public void setN_gw_like(String n_gw_like) {
        this.n_gw_like = n_gw_like;
        if(!ObjectUtils.isEmpty(this.n_gw_like)){
            this.getSelectCond().like("gw", n_gw_like);
        }
    }
	private String n_syy_eq;//[11月]
	public void setN_syy_eq(String n_syy_eq) {
        this.n_syy_eq = n_syy_eq;
        if(!ObjectUtils.isEmpty(this.n_syy_eq)){
            this.getSelectCond().eq("syy", n_syy_eq);
        }
    }
	private String n_sy_eq;//[3月]
	public void setN_sy_eq(String n_sy_eq) {
        this.n_sy_eq = n_sy_eq;
        if(!ObjectUtils.isEmpty(this.n_sy_eq)){
            this.getSelectCond().eq("sy", n_sy_eq);
        }
    }
	private String n_octy_eq;//[10月]
	public void setN_octy_eq(String n_octy_eq) {
        this.n_octy_eq = n_octy_eq;
        if(!ObjectUtils.isEmpty(this.n_octy_eq)){
            this.getSelectCond().eq("octy", n_octy_eq);
        }
    }
	private String n_ormxmsfhzname_like;//[标题]
	public void setN_ormxmsfhzname_like(String n_ormxmsfhzname_like) {
        this.n_ormxmsfhzname_like = n_ormxmsfhzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmsfhzname_like)){
            this.getSelectCond().like("ormxmsfhzname", n_ormxmsfhzname_like);
        }
    }
	private String n_wy_eq;//[5月]
	public void setN_wy_eq(String n_wy_eq) {
        this.n_wy_eq = n_wy_eq;
        if(!ObjectUtils.isEmpty(this.n_wy_eq)){
            this.getSelectCond().eq("wy", n_wy_eq);
        }
    }
	private String n_zz_like;//[组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSelectCond().like("zz", n_zz_like);
        }
    }
	private String n_ly_eq;//[6月]
	public void setN_ly_eq(String n_ly_eq) {
        this.n_ly_eq = n_ly_eq;
        if(!ObjectUtils.isEmpty(this.n_ly_eq)){
            this.getSelectCond().eq("ly", n_ly_eq);
        }
    }
	private String n_yf_eq;//[12月]
	public void setN_yf_eq(String n_yf_eq) {
        this.n_yf_eq = n_yf_eq;
        if(!ObjectUtils.isEmpty(this.n_yf_eq)){
            this.getSelectCond().eq("yf", n_yf_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_qy_eq;//[7月]
	public void setN_qy_eq(String n_qy_eq) {
        this.n_qy_eq = n_qy_eq;
        if(!ObjectUtils.isEmpty(this.n_qy_eq)){
            this.getSelectCond().eq("qy", n_qy_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("gw",query);
			this.getSelectCond().or().like("ormxmsfhzname",query);
			this.getSelectCond().or().like("zz",query);
			this.getSelectCond().or().like("nd",query);
		 }
	}
}




