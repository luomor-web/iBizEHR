package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
/**
 * 关系型数据实体[PcmDdsqdmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmDdsqdmxSearchContext extends QueryWrapperContext<PcmDdsqdmx> {

	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_ddtype_eq;//[调动类型（更新、修正）]
	public void setN_ddtype_eq(String n_ddtype_eq) {
        this.n_ddtype_eq = n_ddtype_eq;
        if(!ObjectUtils.isEmpty(this.n_ddtype_eq)){
            this.getSearchCond().eq("ddtype", n_ddtype_eq);
        }
    }
	private String n_pcmddsqdmxname_like;//[调动申请单明细名称]
	public void setN_pcmddsqdmxname_like(String n_pcmddsqdmxname_like) {
        this.n_pcmddsqdmxname_like = n_pcmddsqdmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmddsqdmxname_like)){
            this.getSearchCond().like("pcmddsqdmxname", n_pcmddsqdmxname_like);
        }
    }
	private String n_pimdistirbutionname_eq;//[员工姓名]
	public void setN_pimdistirbutionname_eq(String n_pimdistirbutionname_eq) {
        this.n_pimdistirbutionname_eq = n_pimdistirbutionname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimdistirbutionname_eq)){
            this.getSearchCond().eq("pimdistirbutionname", n_pimdistirbutionname_eq);
        }
    }
	private String n_pimdistirbutionname_like;//[员工姓名]
	public void setN_pimdistirbutionname_like(String n_pimdistirbutionname_like) {
        this.n_pimdistirbutionname_like = n_pimdistirbutionname_like;
        if(!ObjectUtils.isEmpty(this.n_pimdistirbutionname_like)){
            this.getSearchCond().like("pimdistirbutionname", n_pimdistirbutionname_like);
        }
    }
	private String n_pcmddsqdname_eq;//[标题]
	public void setN_pcmddsqdname_eq(String n_pcmddsqdname_eq) {
        this.n_pcmddsqdname_eq = n_pcmddsqdname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmddsqdname_eq)){
            this.getSearchCond().eq("pcmddsqdname", n_pcmddsqdname_eq);
        }
    }
	private String n_pcmddsqdname_like;//[标题]
	public void setN_pcmddsqdname_like(String n_pcmddsqdname_like) {
        this.n_pcmddsqdname_like = n_pcmddsqdname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmddsqdname_like)){
            this.getSearchCond().like("pcmddsqdname", n_pcmddsqdname_like);
        }
    }
	private String n_orgsectorname_eq;//[新部门/项目]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSearchCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[新部门/项目]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSearchCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_ormdutyname_eq;//[新职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[新职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
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
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_orgname_eq;//[组织名称]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSearchCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[组织名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_ormpostid_eq;//[岗位ID]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务ID]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_orgid_eq;//[组织机构标识]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_pcmddsqdid_eq;//[调动申请单标识]
	public void setN_pcmddsqdid_eq(String n_pcmddsqdid_eq) {
        this.n_pcmddsqdid_eq = n_pcmddsqdid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmddsqdid_eq)){
            this.getSearchCond().eq("pcmddsqdid", n_pcmddsqdid_eq);
        }
    }
	private String n_pimdistirbutionid_eq;//[分配信息标识]
	public void setN_pimdistirbutionid_eq(String n_pimdistirbutionid_eq) {
        this.n_pimdistirbutionid_eq = n_pimdistirbutionid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimdistirbutionid_eq)){
            this.getSearchCond().eq("pimdistirbutionid", n_pimdistirbutionid_eq);
        }
    }
	private String n_orgsectorid_eq;//[部门标识]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSearchCond().eq("orgsectorid", n_orgsectorid_eq);
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
                     wrapper.like("pcmddsqdmxname", query)   
                        .or().like("pimdistirbutionname", query)            
                        .or().like("ygbh", query)            
            );
		 }
	}
}




