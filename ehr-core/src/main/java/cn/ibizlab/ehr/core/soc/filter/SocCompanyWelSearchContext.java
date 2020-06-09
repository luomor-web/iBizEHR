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
import cn.ibizlab.ehr.core.soc.domain.SocCompanyWel;
/**
 * 关系型数据实体[SocCompanyWel] 查询条件对象
 */
@Slf4j
@Data
public class SocCompanyWelSearchContext extends QueryWrapperContext<SocCompanyWel> {

	private String n_soccompanywelname_like;//[单位社保账户]
	public void setN_soccompanywelname_like(String n_soccompanywelname_like) {
        this.n_soccompanywelname_like = n_soccompanywelname_like;
        if(!ObjectUtils.isEmpty(this.n_soccompanywelname_like)){
            this.getSearchCond().like("soccompanywelname", n_soccompanywelname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_socselfarebasename_eq;//[社保参保地名称]
	public void setN_socselfarebasename_eq(String n_socselfarebasename_eq) {
        this.n_socselfarebasename_eq = n_socselfarebasename_eq;
        if(!ObjectUtils.isEmpty(this.n_socselfarebasename_eq)){
            this.getSearchCond().eq("socselfarebasename", n_socselfarebasename_eq);
        }
    }
	private String n_socselfarebasename_like;//[社保参保地名称]
	public void setN_socselfarebasename_like(String n_socselfarebasename_like) {
        this.n_socselfarebasename_like = n_socselfarebasename_like;
        if(!ObjectUtils.isEmpty(this.n_socselfarebasename_like)){
            this.getSearchCond().like("socselfarebasename", n_socselfarebasename_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_socselfarebaseid_eq;//[社保参保地标识]
	public void setN_socselfarebaseid_eq(String n_socselfarebaseid_eq) {
        this.n_socselfarebaseid_eq = n_socselfarebaseid_eq;
        if(!ObjectUtils.isEmpty(this.n_socselfarebaseid_eq)){
            this.getSearchCond().eq("socselfarebaseid", n_socselfarebaseid_eq);
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
                     wrapper.like("soccompanywelname", query)   
            );
		 }
	}
}




