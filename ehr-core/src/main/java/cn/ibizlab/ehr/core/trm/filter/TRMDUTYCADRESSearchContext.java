package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
/**
 * 关系型数据实体[TRMDUTYCADRES] 查询条件对象
 */
@Slf4j
@Data
public class TRMDUTYCADRESSearchContext extends QueryWrapperContext<TRMDUTYCADRES> {

	private String n_cstype_eq;//[产生方式]
	public void setN_cstype_eq(String n_cstype_eq) {
        this.n_cstype_eq = n_cstype_eq;
        if(!ObjectUtils.isEmpty(this.n_cstype_eq)){
            this.getSelectCond().eq("cstype", n_cstype_eq);
        }
    }
	private String n_trmdutycadresname_like;//[职务优秀青年干部管理名称]
	public void setN_trmdutycadresname_like(String n_trmdutycadresname_like) {
        this.n_trmdutycadresname_like = n_trmdutycadresname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdutycadresname_like)){
            this.getSelectCond().like("trmdutycadresname", n_trmdutycadresname_like);
        }
    }
	private String n_tcyy_eq;//[退出原因]
	public void setN_tcyy_eq(String n_tcyy_eq) {
        this.n_tcyy_eq = n_tcyy_eq;
        if(!ObjectUtils.isEmpty(this.n_tcyy_eq)){
            this.getSelectCond().eq("tcyy", n_tcyy_eq);
        }
    }
	private String n_year_eq;//[年度]
	public void setN_year_eq(String n_year_eq) {
        this.n_year_eq = n_year_eq;
        if(!ObjectUtils.isEmpty(this.n_year_eq)){
            this.getSelectCond().eq("year", n_year_eq);
        }
    }
	private String n_status_eq;//[状态]
	public void setN_status_eq(String n_status_eq) {
        this.n_status_eq = n_status_eq;
        if(!ObjectUtils.isEmpty(this.n_status_eq)){
            this.getSelectCond().eq("status", n_status_eq);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_pimpersonname_eq;//[领导人]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[领导人]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormrankname_eq;//[拟任职级]
	public void setN_ormrankname_eq(String n_ormrankname_eq) {
        this.n_ormrankname_eq = n_ormrankname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_eq)){
            this.getSelectCond().eq("ormrankname", n_ormrankname_eq);
        }
    }
	private String n_ormrankname_like;//[拟任职级]
	public void setN_ormrankname_like(String n_ormrankname_like) {
        this.n_ormrankname_like = n_ormrankname_like;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_like)){
            this.getSelectCond().like("ormrankname", n_ormrankname_like);
        }
    }
	private String n_ormpostname_eq;//[岗位(停用)]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSelectCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[岗位(停用)]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSelectCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_pimpersonname2_eq;//[优秀年轻干部]
	public void setN_pimpersonname2_eq(String n_pimpersonname2_eq) {
        this.n_pimpersonname2_eq = n_pimpersonname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_eq)){
            this.getSelectCond().eq("pimpersonname2", n_pimpersonname2_eq);
        }
    }
	private String n_pimpersonname2_like;//[优秀年轻干部]
	public void setN_pimpersonname2_like(String n_pimpersonname2_like) {
        this.n_pimpersonname2_like = n_pimpersonname2_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_like)){
            this.getSelectCond().like("pimpersonname2", n_pimpersonname2_like);
        }
    }
	private String n_orgsectorname_eq;//[部门/项目]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSelectCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[部门/项目]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[拟任部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSelectCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[拟任部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSelectCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormdutyname_eq;//[拟任职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSelectCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[拟任职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSelectCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormpostid_eq;//[岗位集标识]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSelectCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_orgsectorid_eq;//[部门标识]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSelectCond().eq("orgsectorid", n_orgsectorid_eq);
        }
    }
	private String n_pimpersonid2_eq;//[人员信息标识]
	public void setN_pimpersonid2_eq(String n_pimpersonid2_eq) {
        this.n_pimpersonid2_eq = n_pimpersonid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid2_eq)){
            this.getSelectCond().eq("pimpersonid2", n_pimpersonid2_eq);
        }
    }
	private String n_ormrankid_eq;//[职级标识]
	public void setN_ormrankid_eq(String n_ormrankid_eq) {
        this.n_ormrankid_eq = n_ormrankid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankid_eq)){
            this.getSelectCond().eq("ormrankid", n_ormrankid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务管理标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSelectCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSelectCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("trmdutycadresname",query);
		 }
	}
}




