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
import cn.ibizlab.ehr.core.pim.domain.PimContract;
/**
 * 关系型数据实体[PimContract] 查询条件对象
 */
@Slf4j
@Data
public class PimContractSearchContext extends QueryWrapperContext<PimContract> {

	private String n_sslwpqgs_eq;//[劳务派遣公司]
	public void setN_sslwpqgs_eq(String n_sslwpqgs_eq) {
        this.n_sslwpqgs_eq = n_sslwpqgs_eq;
        if(!ObjectUtils.isEmpty(this.n_sslwpqgs_eq)){
            this.getSearchCond().eq("sslwpqgs", n_sslwpqgs_eq);
        }
    }
	private String n_htbh_like;//[合同编号]
	public void setN_htbh_like(String n_htbh_like) {
        this.n_htbh_like = n_htbh_like;
        if(!ObjectUtils.isEmpty(this.n_htbh_like)){
            this.getSearchCond().like("htbh", n_htbh_like);
        }
    }
	private String n_htlx_eq;//[合同类别]
	public void setN_htlx_eq(String n_htlx_eq) {
        this.n_htlx_eq = n_htlx_eq;
        if(!ObjectUtils.isEmpty(this.n_htlx_eq)){
            this.getSearchCond().eq("htlx", n_htlx_eq);
        }
    }
	private String n_pimcontractname_like;//[合同信息名称]
	public void setN_pimcontractname_like(String n_pimcontractname_like) {
        this.n_pimcontractname_like = n_pimcontractname_like;
        if(!ObjectUtils.isEmpty(this.n_pimcontractname_like)){
            this.getSearchCond().like("pimcontractname", n_pimcontractname_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_jsrq_gtandeq;//[结束日期]
	public void setN_jsrq_gtandeq(Timestamp n_jsrq_gtandeq) {
        this.n_jsrq_gtandeq = n_jsrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_jsrq_gtandeq)){
            this.getSearchCond().ge("jsrq", n_jsrq_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_jsrq_ltandeq;//[结束日期]
	public void setN_jsrq_ltandeq(Timestamp n_jsrq_ltandeq) {
        this.n_jsrq_ltandeq = n_jsrq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_jsrq_ltandeq)){
            this.getSearchCond().le("jsrq", n_jsrq_ltandeq);
        }
    }
	private String n_contracttype_eq;//[合同类型]
	public void setN_contracttype_eq(String n_contracttype_eq) {
        this.n_contracttype_eq = n_contracttype_eq;
        if(!ObjectUtils.isEmpty(this.n_contracttype_eq)){
            this.getSearchCond().eq("contracttype", n_contracttype_eq);
        }
    }
	private String n_htzt_eq;//[合同状态]
	public void setN_htzt_eq(String n_htzt_eq) {
        this.n_htzt_eq = n_htzt_eq;
        if(!ObjectUtils.isEmpty(this.n_htzt_eq)){
            this.getSearchCond().eq("htzt", n_htzt_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_qsrq_gtandeq;//[起始日期]
	public void setN_qsrq_gtandeq(Timestamp n_qsrq_gtandeq) {
        this.n_qsrq_gtandeq = n_qsrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_qsrq_gtandeq)){
            this.getSearchCond().ge("qsrq", n_qsrq_gtandeq);
        }
    }
	private String n_ormorgname_eq;//[合同管理单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[合同管理单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
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
	private String n_ormsignorgname_eq;//[合同签订单位]
	public void setN_ormsignorgname_eq(String n_ormsignorgname_eq) {
        this.n_ormsignorgname_eq = n_ormsignorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgname_eq)){
            this.getSearchCond().eq("ormsignorgname", n_ormsignorgname_eq);
        }
    }
	private String n_ormsignorgname_like;//[合同签订单位]
	public void setN_ormsignorgname_like(String n_ormsignorgname_like) {
        this.n_ormsignorgname_like = n_ormsignorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgname_like)){
            this.getSearchCond().like("ormsignorgname", n_ormsignorgname_like);
        }
    }
	private String n_contractsignorgname_eq;//[合同签订单位]
	public void setN_contractsignorgname_eq(String n_contractsignorgname_eq) {
        this.n_contractsignorgname_eq = n_contractsignorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_contractsignorgname_eq)){
            this.getSearchCond().eq("contractsignorgname", n_contractsignorgname_eq);
        }
    }
	private String n_contractsignorgname_like;//[合同签订单位]
	public void setN_contractsignorgname_like(String n_contractsignorgname_like) {
        this.n_contractsignorgname_like = n_contractsignorgname_like;
        if(!ObjectUtils.isEmpty(this.n_contractsignorgname_like)){
            this.getSearchCond().like("contractsignorgname", n_contractsignorgname_like);
        }
    }
	private String n_pimlabourcampanyname_eq;//[劳务派遣公司]
	public void setN_pimlabourcampanyname_eq(String n_pimlabourcampanyname_eq) {
        this.n_pimlabourcampanyname_eq = n_pimlabourcampanyname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimlabourcampanyname_eq)){
            this.getSearchCond().eq("pimlabourcampanyname", n_pimlabourcampanyname_eq);
        }
    }
	private String n_pimlabourcampanyname_like;//[劳务派遣公司]
	public void setN_pimlabourcampanyname_like(String n_pimlabourcampanyname_like) {
        this.n_pimlabourcampanyname_like = n_pimlabourcampanyname_like;
        if(!ObjectUtils.isEmpty(this.n_pimlabourcampanyname_like)){
            this.getSearchCond().like("pimlabourcampanyname", n_pimlabourcampanyname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ygzt_eq;//[员工状态]
	public void setN_ygzt_eq(String n_ygzt_eq) {
        this.n_ygzt_eq = n_ygzt_eq;
        if(!ObjectUtils.isEmpty(this.n_ygzt_eq)){
            this.getSearchCond().eq("ygzt", n_ygzt_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimlabourcampanyid_eq;//[劳务派遣公司管理标识]
	public void setN_pimlabourcampanyid_eq(String n_pimlabourcampanyid_eq) {
        this.n_pimlabourcampanyid_eq = n_pimlabourcampanyid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimlabourcampanyid_eq)){
            this.getSearchCond().eq("pimlabourcampanyid", n_pimlabourcampanyid_eq);
        }
    }
	private String n_contractsignorgid_eq;//[签约主体单位标识]
	public void setN_contractsignorgid_eq(String n_contractsignorgid_eq) {
        this.n_contractsignorgid_eq = n_contractsignorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_contractsignorgid_eq)){
            this.getSearchCond().eq("contractsignorgid", n_contractsignorgid_eq);
        }
    }
	private String n_ormorgid_eq;//[合同管理单位标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormsignorgid_eq;//[合同签订单位]
	public void setN_ormsignorgid_eq(String n_ormsignorgid_eq) {
        this.n_ormsignorgid_eq = n_ormsignorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgid_eq)){
            this.getSearchCond().eq("ormsignorgid", n_ormsignorgid_eq);
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
            );
		 }
	}
}




