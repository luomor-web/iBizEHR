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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESCHANGE;
/**
 * 关系型数据实体[PIMARCHIVESCHANGE] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PIMARCHIVESCHANGESearchContext extends QueryWrapperContext<PIMARCHIVESCHANGE> {

	private String n_pimarchiveschangename_like;//[归档地变更记录]
	public void setN_pimarchiveschangename_like(String n_pimarchiveschangename_like) {
        this.n_pimarchiveschangename_like = n_pimarchiveschangename_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchiveschangename_like)){
            this.getSelectCond().like("pimarchiveschangename", n_pimarchiveschangename_like);
        }
    }
	private String n_dazt_eq;//[档案状态]
	public void setN_dazt_eq(String n_dazt_eq) {
        this.n_dazt_eq = n_dazt_eq;
        if(!ObjectUtils.isEmpty(this.n_dazt_eq)){
            this.getSelectCond().eq("dazt", n_dazt_eq);
        }
    }
	private String n_ddjltype_eq;//[调档记录类型]
	public void setN_ddjltype_eq(String n_ddjltype_eq) {
        this.n_ddjltype_eq = n_ddjltype_eq;
        if(!ObjectUtils.isEmpty(this.n_ddjltype_eq)){
            this.getSelectCond().eq("ddjltype", n_ddjltype_eq);
        }
    }
	private String n_ormorgname2_eq;//[调入单位]
	public void setN_ormorgname2_eq(String n_ormorgname2_eq) {
        this.n_ormorgname2_eq = n_ormorgname2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_eq)){
            this.getSelectCond().eq("ormorgname2", n_ormorgname2_eq);
        }
    }
	private String n_ormorgname2_like;//[调入单位]
	public void setN_ormorgname2_like(String n_ormorgname2_like) {
        this.n_ormorgname2_like = n_ormorgname2_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_like)){
            this.getSelectCond().like("ormorgname2", n_ormorgname2_like);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimarchivesname_eq;//[档案名称]
	public void setN_pimarchivesname_eq(String n_pimarchivesname_eq) {
        this.n_pimarchivesname_eq = n_pimarchivesname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_eq)){
            this.getSelectCond().eq("pimarchivesname", n_pimarchivesname_eq);
        }
    }
	private String n_pimarchivesname_like;//[档案名称]
	public void setN_pimarchivesname_like(String n_pimarchivesname_like) {
        this.n_pimarchivesname_like = n_pimarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_like)){
            this.getSelectCond().like("pimarchivesname", n_pimarchivesname_like);
        }
    }
	private String n_ormorgname_eq;//[调出单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[调出单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgid2_eq;//[调入单位标识]
	public void setN_ormorgid2_eq(String n_ormorgid2_eq) {
        this.n_ormorgid2_eq = n_ormorgid2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid2_eq)){
            this.getSelectCond().eq("ormorgid2", n_ormorgid2_eq);
        }
    }
	private String n_ormorgid_eq;//[调出单位标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimarchivesid_eq;//[档案信息标识]
	public void setN_pimarchivesid_eq(String n_pimarchivesid_eq) {
        this.n_pimarchivesid_eq = n_pimarchivesid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesid_eq)){
            this.getSelectCond().eq("pimarchivesid", n_pimarchivesid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pimarchiveschangename",query);
		 }
	}
}




