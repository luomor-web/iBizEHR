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
import cn.ibizlab.ehr.core.pim.domain.PimWorkHistory;
/**
 * 关系型数据实体[PimWorkHistory] 查询条件对象
 */
@Slf4j
@Data
public class PimWorkHistorySearchContext extends QueryWrapperContext<PimWorkHistory> {

	private String n_pimworkhistoryname_like;//[工作履历名称]
	public void setN_pimworkhistoryname_like(String n_pimworkhistoryname_like) {
        this.n_pimworkhistoryname_like = n_pimworkhistoryname_like;
        if(!ObjectUtils.isEmpty(this.n_pimworkhistoryname_like)){
            this.getSearchCond().like("pimworkhistoryname", n_pimworkhistoryname_like);
        }
    }
	private String n_jlss_eq;//[记录所属]
	public void setN_jlss_eq(String n_jlss_eq) {
        this.n_jlss_eq = n_jlss_eq;
        if(!ObjectUtils.isEmpty(this.n_jlss_eq)){
            this.getSearchCond().eq("jlss", n_jlss_eq);
        }
    }
	private String n_cfplx_eq;//[兼职借调类型]
	public void setN_cfplx_eq(String n_cfplx_eq) {
        this.n_cfplx_eq = n_cfplx_eq;
        if(!ObjectUtils.isEmpty(this.n_cfplx_eq)){
            this.getSearchCond().eq("cfplx", n_cfplx_eq);
        }
    }
	private String n_jlczz_eq;//[记录操作者]
	public void setN_jlczz_eq(String n_jlczz_eq) {
        this.n_jlczz_eq = n_jlczz_eq;
        if(!ObjectUtils.isEmpty(this.n_jlczz_eq)){
            this.getSearchCond().eq("jlczz", n_jlczz_eq);
        }
    }
	private String n_jlspzt_eq;//[记录审批状态]
	public void setN_jlspzt_eq(String n_jlspzt_eq) {
        this.n_jlspzt_eq = n_jlspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jlspzt_eq)){
            this.getSearchCond().eq("jlspzt", n_jlspzt_eq);
        }
    }
	private String n_pimpersonname_eq;//[人员信息名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[人员信息名称]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormrankname_eq;//[职级]
	public void setN_ormrankname_eq(String n_ormrankname_eq) {
        this.n_ormrankname_eq = n_ormrankname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_eq)){
            this.getSearchCond().eq("ormrankname", n_ormrankname_eq);
        }
    }
	private String n_ormrankname_like;//[职级]
	public void setN_ormrankname_like(String n_ormrankname_like) {
        this.n_ormrankname_like = n_ormrankname_like;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_like)){
            this.getSearchCond().like("ormrankname", n_ormrankname_like);
        }
    }
	private String n_ormrankid_eq;//[职级标识]
	public void setN_ormrankid_eq(String n_ormrankid_eq) {
        this.n_ormrankid_eq = n_ormrankid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankid_eq)){
            this.getSearchCond().eq("ormrankid", n_ormrankid_eq);
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
                     wrapper.like("pimworkhistoryname", query)   
            );
		 }
	}
}




