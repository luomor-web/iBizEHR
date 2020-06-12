package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimDistirbution;
/**
 * 关系型数据实体[PimDistirbution] 查询条件对象
 */
@Slf4j
@Data
public class PimDistirbutionSearchContext extends QueryWrapperContext<PimDistirbution> {

	private String n_fpzt_eq;//[分配状态]
	public void setN_fpzt_eq(String n_fpzt_eq) {
        this.n_fpzt_eq = n_fpzt_eq;
        if(!ObjectUtils.isEmpty(this.n_fpzt_eq)){
            this.getSearchCond().eq("fpzt", n_fpzt_eq);
        }
    }
	private String n_yzw_eq;//[原职务]
	public void setN_yzw_eq(String n_yzw_eq) {
        this.n_yzw_eq = n_yzw_eq;
        if(!ObjectUtils.isEmpty(this.n_yzw_eq)){
            this.getSearchCond().eq("yzw", n_yzw_eq);
        }
    }
	private String n_pimdistirbutionname_like;//[分配信息名称]
	public void setN_pimdistirbutionname_like(String n_pimdistirbutionname_like) {
        this.n_pimdistirbutionname_like = n_pimdistirbutionname_like;
        if(!ObjectUtils.isEmpty(this.n_pimdistirbutionname_like)){
            this.getSearchCond().like("pimdistirbutionname", n_pimdistirbutionname_like);
        }
    }
	private String n_fplx_eq;//[分配]
	public void setN_fplx_eq(String n_fplx_eq) {
        this.n_fplx_eq = n_fplx_eq;
        if(!ObjectUtils.isEmpty(this.n_fplx_eq)){
            this.getSearchCond().eq("fplx", n_fplx_eq);
        }
    }
	private String n_ygw_eq;//[原岗位]
	public void setN_ygw_eq(String n_ygw_eq) {
        this.n_ygw_eq = n_ygw_eq;
        if(!ObjectUtils.isEmpty(this.n_ygw_eq)){
            this.getSearchCond().eq("ygw", n_ygw_eq);
        }
    }
	private String n_cfplx_eq;//[类型]
	public void setN_cfplx_eq(String n_cfplx_eq) {
        this.n_cfplx_eq = n_cfplx_eq;
        if(!ObjectUtils.isEmpty(this.n_cfplx_eq)){
            this.getSearchCond().eq("cfplx", n_cfplx_eq);
        }
    }
	private String n_ormpostname_eq;//[岗位]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[岗位]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_yzz_eq;//[原组织]
	public void setN_yzz_eq(String n_yzz_eq) {
        this.n_yzz_eq = n_yzz_eq;
        if(!ObjectUtils.isEmpty(this.n_yzz_eq)){
            this.getSearchCond().eq("yzz", n_yzz_eq);
        }
    }
	private String n_yzz_like;//[原组织]
	public void setN_yzz_like(String n_yzz_like) {
        this.n_yzz_like = n_yzz_like;
        if(!ObjectUtils.isEmpty(this.n_yzz_like)){
            this.getSearchCond().like("yzz", n_yzz_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormdutyname_eq;//[职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ybm_eq;//[原部门]
	public void setN_ybm_eq(String n_ybm_eq) {
        this.n_ybm_eq = n_ybm_eq;
        if(!ObjectUtils.isEmpty(this.n_ybm_eq)){
            this.getSearchCond().eq("ybm", n_ybm_eq);
        }
    }
	private String n_ybm_like;//[原部门]
	public void setN_ybm_like(String n_ybm_like) {
        this.n_ybm_like = n_ybm_like;
        if(!ObjectUtils.isEmpty(this.n_ybm_like)){
            this.getSearchCond().like("ybm", n_ybm_like);
        }
    }
	private String n_ormpostname1_eq;//[汇报关系]
	public void setN_ormpostname1_eq(String n_ormpostname1_eq) {
        this.n_ormpostname1_eq = n_ormpostname1_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname1_eq)){
            this.getSearchCond().eq("ormpostname1", n_ormpostname1_eq);
        }
    }
	private String n_ormpostname1_like;//[汇报关系]
	public void setN_ormpostname1_like(String n_ormpostname1_like) {
        this.n_ormpostname1_like = n_ormpostname1_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname1_like)){
            this.getSearchCond().like("ormpostname1", n_ormpostname1_like);
        }
    }
	private String n_ybmid_eq;//[部门标识]
	public void setN_ybmid_eq(String n_ybmid_eq) {
        this.n_ybmid_eq = n_ybmid_eq;
        if(!ObjectUtils.isEmpty(this.n_ybmid_eq)){
            this.getSearchCond().eq("ybmid", n_ybmid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_ormpostid1_eq;//[岗位管理标识]
	public void setN_ormpostid1_eq(String n_ormpostid1_eq) {
        this.n_ormpostid1_eq = n_ormpostid1_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid1_eq)){
            this.getSearchCond().eq("ormpostid1", n_ormpostid1_eq);
        }
    }
	private String n_ormpostid_eq;//[岗位管理标识]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务管理标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_yzzid_eq;//[组织标识]
	public void setN_yzzid_eq(String n_yzzid_eq) {
        this.n_yzzid_eq = n_yzzid_eq;
        if(!ObjectUtils.isEmpty(this.n_yzzid_eq)){
            this.getSearchCond().eq("yzzid", n_yzzid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("pimpersonname", query)   
                        .or().like("ygbh", query)            
            );
		 }
	}
}




