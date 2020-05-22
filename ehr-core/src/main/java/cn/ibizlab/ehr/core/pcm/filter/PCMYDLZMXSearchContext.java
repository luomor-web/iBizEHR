package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDLZMX;
/**
 * 关系型数据实体[PCMYDLZMX] 查询条件对象
 */
@Slf4j
@Data
public class PCMYDLZMXSearchContext extends QueryWrapperContext<PCMYDLZMX> {

	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSelectCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_yytype_eq;//[离职理由]
	public void setN_yytype_eq(String n_yytype_eq) {
        this.n_yytype_eq = n_yytype_eq;
        if(!ObjectUtils.isEmpty(this.n_yytype_eq)){
            this.getSelectCond().eq("yytype", n_yytype_eq);
        }
    }
	private String n_bm_like;//[所属部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSelectCond().like("bm", n_bm_like);
        }
    }
	private String n_pcmydlzmxname_like;//[异动离职明细名称]
	public void setN_pcmydlzmxname_like(String n_pcmydlzmxname_like) {
        this.n_pcmydlzmxname_like = n_pcmydlzmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydlzmxname_like)){
            this.getSelectCond().like("pcmydlzmxname", n_pcmydlzmxname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private Timestamp n_sxrq_gtandeq;//[离职日期]
	public void setN_sxrq_gtandeq(Timestamp n_sxrq_gtandeq) {
        this.n_sxrq_gtandeq = n_sxrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_sxrq_gtandeq)){
            this.getSelectCond().ge("sxrq", n_sxrq_gtandeq);
        }
    }
	private Timestamp n_sxrq_lt;//[离职日期]
	public void setN_sxrq_lt(Timestamp n_sxrq_lt) {
        this.n_sxrq_lt = n_sxrq_lt;
        if(!ObjectUtils.isEmpty(this.n_sxrq_lt)){
            this.getSelectCond().lt("sxrq", n_sxrq_lt);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_zz_like;//[所属组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSelectCond().like("zz", n_zz_like);
        }
    }
	private String n_lzmtrname_eq;//[离职面谈人]
	public void setN_lzmtrname_eq(String n_lzmtrname_eq) {
        this.n_lzmtrname_eq = n_lzmtrname_eq;
        if(!ObjectUtils.isEmpty(this.n_lzmtrname_eq)){
            this.getSelectCond().eq("lzmtrname", n_lzmtrname_eq);
        }
    }
	private String n_lzmtrname_like;//[离职面谈人]
	public void setN_lzmtrname_like(String n_lzmtrname_like) {
        this.n_lzmtrname_like = n_lzmtrname_like;
        if(!ObjectUtils.isEmpty(this.n_lzmtrname_like)){
            this.getSelectCond().like("lzmtrname", n_lzmtrname_like);
        }
    }
	private String n_lzmtrid_eq;//[人员信息标识]
	public void setN_lzmtrid_eq(String n_lzmtrid_eq) {
        this.n_lzmtrid_eq = n_lzmtrid_eq;
        if(!ObjectUtils.isEmpty(this.n_lzmtrid_eq)){
            this.getSelectCond().eq("lzmtrid", n_lzmtrid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmydlzmxname",query);
			this.getSelectCond().or().like("ygbh",query);
			this.getSelectCond().or().like("pimpersonname",query);
		 }
	}
}




