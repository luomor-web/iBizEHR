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
import cn.ibizlab.ehr.core.pim.domain.PimQualMajor;
/**
 * 关系型数据实体[PimQualMajor] 查询条件对象
 */
@Slf4j
@Data
public class PimQualMajorSearchContext extends QueryWrapperContext<PimQualMajor> {

	private String n_gwlx_eq;//[岗位类型]
	public void setN_gwlx_eq(String n_gwlx_eq) {
        this.n_gwlx_eq = n_gwlx_eq;
        if(!ObjectUtils.isEmpty(this.n_gwlx_eq)){
            this.getSearchCond().eq("gwlx", n_gwlx_eq);
        }
    }
	private String n_pimqualmajorid_like;//[执业资格专业编码]
	public void setN_pimqualmajorid_like(String n_pimqualmajorid_like) {
        this.n_pimqualmajorid_like = n_pimqualmajorid_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorid_like)){
            this.getSearchCond().like("pimqualmajorid", n_pimqualmajorid_like);
        }
    }
	private String n_zyzgzy_like;//[执业资格名称]
	public void setN_zyzgzy_like(String n_zyzgzy_like) {
        this.n_zyzgzy_like = n_zyzgzy_like;
        if(!ObjectUtils.isEmpty(this.n_zyzgzy_like)){
            this.getSearchCond().like("zyzgzy", n_zyzgzy_like);
        }
    }
	private String n_pimqualmajorname_like;//[执业资格]
	public void setN_pimqualmajorname_like(String n_pimqualmajorname_like) {
        this.n_pimqualmajorname_like = n_pimqualmajorname_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorname_like)){
            this.getSearchCond().like("pimqualmajorname", n_pimqualmajorname_like);
        }
    }
	private String n_professionaltype_eq;//[执业资格类别]
	public void setN_professionaltype_eq(String n_professionaltype_eq) {
        this.n_professionaltype_eq = n_professionaltype_eq;
        if(!ObjectUtils.isEmpty(this.n_professionaltype_eq)){
            this.getSearchCond().eq("professionaltype", n_professionaltype_eq);
        }
    }
	private String n_pimqualtypename_eq;//[执业资格类别]
	public void setN_pimqualtypename_eq(String n_pimqualtypename_eq) {
        this.n_pimqualtypename_eq = n_pimqualtypename_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_eq)){
            this.getSearchCond().eq("pimqualtypename", n_pimqualtypename_eq);
        }
    }
	private String n_pimqualtypename_like;//[执业资格类别]
	public void setN_pimqualtypename_like(String n_pimqualtypename_like) {
        this.n_pimqualtypename_like = n_pimqualtypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_like)){
            this.getSearchCond().like("pimqualtypename", n_pimqualtypename_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimqualtypeid_eq;//[执业资格类别标识]
	public void setN_pimqualtypeid_eq(String n_pimqualtypeid_eq) {
        this.n_pimqualtypeid_eq = n_pimqualtypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypeid_eq)){
            this.getSearchCond().eq("pimqualtypeid", n_pimqualtypeid_eq);
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
                     wrapper.like("gwzs", query)   
                        .or().like("zyzgzy", query)            
            );
		 }
	}
}




