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
import cn.ibizlab.ehr.core.pcm.domain.PcmGbhmc;
/**
 * 关系型数据实体[PcmGbhmc] 查询条件对象
 */
@Slf4j
@Data
public class PcmGbhmcSearchContext extends QueryWrapperContext<PcmGbhmc> {

	private Integer n_isleaderteam_eq;//[是否属于领导班子]
	public void setN_isleaderteam_eq(Integer n_isleaderteam_eq) {
        this.n_isleaderteam_eq = n_isleaderteam_eq;
        if(!ObjectUtils.isEmpty(this.n_isleaderteam_eq)){
            this.getSearchCond().eq("isleaderteam", n_isleaderteam_eq);
        }
    }
	private String n_mz_eq;//[民族]
	public void setN_mz_eq(String n_mz_eq) {
        this.n_mz_eq = n_mz_eq;
        if(!ObjectUtils.isEmpty(this.n_mz_eq)){
            this.getSearchCond().eq("mz", n_mz_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_rank_eq;//[职级]
	public void setN_rank_eq(String n_rank_eq) {
        this.n_rank_eq = n_rank_eq;
        if(!ObjectUtils.isEmpty(this.n_rank_eq)){
            this.getSearchCond().eq("rank", n_rank_eq);
        }
    }
	private String n_gw_like;//[岗位]
	public void setN_gw_like(String n_gw_like) {
        this.n_gw_like = n_gw_like;
        if(!ObjectUtils.isEmpty(this.n_gw_like)){
            this.getSearchCond().like("gw", n_gw_like);
        }
    }
	private String n_zjhm_like;//[证件号码]
	public void setN_zjhm_like(String n_zjhm_like) {
        this.n_zjhm_like = n_zjhm_like;
        if(!ObjectUtils.isEmpty(this.n_zjhm_like)){
            this.getSearchCond().like("zjhm", n_zjhm_like);
        }
    }
	private String n_ormorgsectorname_like;//[部门/项目]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_zw_like;//[职务]
	public void setN_zw_like(String n_zw_like) {
        this.n_zw_like = n_zw_like;
        if(!ObjectUtils.isEmpty(this.n_zw_like)){
            this.getSearchCond().like("zw", n_zw_like);
        }
    }
	private String n_zzdzs_like;//[组织]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
        }
    }
	private String n_zzmm_eq;//[政治面貌]
	public void setN_zzmm_eq(String n_zzmm_eq) {
        this.n_zzmm_eq = n_zzmm_eq;
        if(!ObjectUtils.isEmpty(this.n_zzmm_eq)){
            this.getSearchCond().eq("zzmm", n_zzmm_eq);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_zgcode_eq;//[在岗状态]
	public void setN_zgcode_eq(String n_zgcode_eq) {
        this.n_zgcode_eq = n_zgcode_eq;
        if(!ObjectUtils.isEmpty(this.n_zgcode_eq)){
            this.getSearchCond().eq("zgcode", n_zgcode_eq);
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




