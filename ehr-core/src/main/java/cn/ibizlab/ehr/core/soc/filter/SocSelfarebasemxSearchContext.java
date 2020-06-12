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
import cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx;
/**
 * 关系型数据实体[SocSelfarebasemx] 查询条件对象
 */
@Slf4j
@Data
public class SocSelfarebasemxSearchContext extends QueryWrapperContext<SocSelfarebasemx> {

	private String n_socselfarebasemxname_like;//[社保明细名称]
	public void setN_socselfarebasemxname_like(String n_socselfarebasemxname_like) {
        this.n_socselfarebasemxname_like = n_socselfarebasemxname_like;
        if(!ObjectUtils.isEmpty(this.n_socselfarebasemxname_like)){
            this.getSearchCond().like("socselfarebasemxname", n_socselfarebasemxname_like);
        }
    }
	private String n_sbfllx_eq;//[社保福利类型]
	public void setN_sbfllx_eq(String n_sbfllx_eq) {
        this.n_sbfllx_eq = n_sbfllx_eq;
        if(!ObjectUtils.isEmpty(this.n_sbfllx_eq)){
            this.getSearchCond().eq("sbfllx", n_sbfllx_eq);
        }
    }
	private String n_sbfllx_like;//[社保福利类型]
	public void setN_sbfllx_like(String n_sbfllx_like) {
        this.n_sbfllx_like = n_sbfllx_like;
        if(!ObjectUtils.isEmpty(this.n_sbfllx_like)){
            this.getSearchCond().like("sbfllx", n_sbfllx_like);
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
	private String n_socselfarebaseid_eq;//[参保地标识]
	public void setN_socselfarebaseid_eq(String n_socselfarebaseid_eq) {
        this.n_socselfarebaseid_eq = n_socselfarebaseid_eq;
        if(!ObjectUtils.isEmpty(this.n_socselfarebaseid_eq)){
            this.getSearchCond().eq("socselfarebaseid", n_socselfarebaseid_eq);
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
                     wrapper.like("socselfarebasemxname", query)   
            );
		 }
	}
}




