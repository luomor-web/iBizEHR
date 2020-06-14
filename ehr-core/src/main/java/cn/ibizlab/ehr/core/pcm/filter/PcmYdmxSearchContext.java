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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
/**
 * 关系型数据实体[PcmYdmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmYdmxSearchContext extends QueryWrapperContext<PcmYdmx> {

	private String n_pcmydmxname_like;//[异动明细名称]
	public void setN_pcmydmxname_like(String n_pcmydmxname_like) {
        this.n_pcmydmxname_like = n_pcmydmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydmxname_like)){
            this.getSearchCond().like("pcmydmxname", n_pcmydmxname_like);
        }
    }
	private String n_yzw_eq;//[所属职务]
	public void setN_yzw_eq(String n_yzw_eq) {
        this.n_yzw_eq = n_yzw_eq;
        if(!ObjectUtils.isEmpty(this.n_yzw_eq)){
            this.getSearchCond().eq("yzw", n_yzw_eq);
        }
    }
	private String n_pcmydmxtype_eq;//[分组类型]
	public void setN_pcmydmxtype_eq(String n_pcmydmxtype_eq) {
        this.n_pcmydmxtype_eq = n_pcmydmxtype_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmydmxtype_eq)){
            this.getSearchCond().eq("pcmydmxtype", n_pcmydmxtype_eq);
        }
    }
	private String n_yrank_eq;//[职级]
	public void setN_yrank_eq(String n_yrank_eq) {
        this.n_yrank_eq = n_yrank_eq;
        if(!ObjectUtils.isEmpty(this.n_yrank_eq)){
            this.getSearchCond().eq("yrank", n_yrank_eq);
        }
    }
	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_ygw_eq;//[所属岗位]
	public void setN_ygw_eq(String n_ygw_eq) {
        this.n_ygw_eq = n_ygw_eq;
        if(!ObjectUtils.isEmpty(this.n_ygw_eq)){
            this.getSearchCond().eq("ygw", n_ygw_eq);
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
	private String n_zz_eq;//[所属组织]
	public void setN_zz_eq(String n_zz_eq) {
        this.n_zz_eq = n_zz_eq;
        if(!ObjectUtils.isEmpty(this.n_zz_eq)){
            this.getSearchCond().eq("zz", n_zz_eq);
        }
    }
	private String n_zz_like;//[所属组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
        }
    }
	private String n_bm_eq;//[所属部门]
	public void setN_bm_eq(String n_bm_eq) {
        this.n_bm_eq = n_bm_eq;
        if(!ObjectUtils.isEmpty(this.n_bm_eq)){
            this.getSearchCond().eq("bm", n_bm_eq);
        }
    }
	private String n_bm_like;//[所属部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSearchCond().like("bm", n_bm_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_zzid_eq;//[所属组织标识]
	public void setN_zzid_eq(String n_zzid_eq) {
        this.n_zzid_eq = n_zzid_eq;
        if(!ObjectUtils.isEmpty(this.n_zzid_eq)){
            this.getSearchCond().eq("zzid", n_zzid_eq);
        }
    }
	private String n_bmid_eq;//[部门标识]
	public void setN_bmid_eq(String n_bmid_eq) {
        this.n_bmid_eq = n_bmid_eq;
        if(!ObjectUtils.isEmpty(this.n_bmid_eq)){
            this.getSearchCond().eq("bmid", n_bmid_eq);
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
                     wrapper.like("pcmydmxname", query)   
            );
		 }
	}
}




