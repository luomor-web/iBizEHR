package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo;
/**
 * 关系型数据实体[SocWelfareInfo] 查询条件对象
 */
@Slf4j
@Data
public class SocWelfareInfoSearchContext extends QueryWrapperContext<SocWelfareInfo> {

	private String n_grgjjzh_like;//[个人公积金账号]
	public void setN_grgjjzh_like(String n_grgjjzh_like) {
        this.n_grgjjzh_like = n_grgjjzh_like;
        if(!ObjectUtils.isEmpty(this.n_grgjjzh_like)){
            this.getSearchCond().like("grgjjzh", n_grgjjzh_like);
        }
    }
	private String n_grsbzh_like;//[个人社保账号]
	public void setN_grsbzh_like(String n_grsbzh_like) {
        this.n_grsbzh_like = n_grsbzh_like;
        if(!ObjectUtils.isEmpty(this.n_grsbzh_like)){
            this.getSearchCond().like("grsbzh", n_grsbzh_like);
        }
    }
	private String n_socwelfareinfoname_like;//[个人社保福利名称]
	public void setN_socwelfareinfoname_like(String n_socwelfareinfoname_like) {
        this.n_socwelfareinfoname_like = n_socwelfareinfoname_like;
        if(!ObjectUtils.isEmpty(this.n_socwelfareinfoname_like)){
            this.getSearchCond().like("socwelfareinfoname", n_socwelfareinfoname_like);
        }
    }
	private String n_zjhm_like;//[证件号码]
	public void setN_zjhm_like(String n_zjhm_like) {
        this.n_zjhm_like = n_zjhm_like;
        if(!ObjectUtils.isEmpty(this.n_zjhm_like)){
            this.getSearchCond().like("zjhm", n_zjhm_like);
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
	private String n_soccompanywelname_eq;//[单位社保账户名称]
	public void setN_soccompanywelname_eq(String n_soccompanywelname_eq) {
        this.n_soccompanywelname_eq = n_soccompanywelname_eq;
        if(!ObjectUtils.isEmpty(this.n_soccompanywelname_eq)){
            this.getSearchCond().eq("soccompanywelname", n_soccompanywelname_eq);
        }
    }
	private String n_soccompanywelname_like;//[单位社保账户名称]
	public void setN_soccompanywelname_like(String n_soccompanywelname_like) {
        this.n_soccompanywelname_like = n_soccompanywelname_like;
        if(!ObjectUtils.isEmpty(this.n_soccompanywelname_like)){
            this.getSearchCond().like("soccompanywelname", n_soccompanywelname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_soccompanywelid_eq;//[单位社保账户标识]
	public void setN_soccompanywelid_eq(String n_soccompanywelid_eq) {
        this.n_soccompanywelid_eq = n_soccompanywelid_eq;
        if(!ObjectUtils.isEmpty(this.n_soccompanywelid_eq)){
            this.getSearchCond().eq("soccompanywelid", n_soccompanywelid_eq);
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
                     wrapper.like("socwelfareinfoname", query)   
            );
		 }
	}
}




