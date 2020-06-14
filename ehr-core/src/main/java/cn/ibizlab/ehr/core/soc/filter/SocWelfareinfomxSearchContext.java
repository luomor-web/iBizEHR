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
import cn.ibizlab.ehr.core.soc.domain.SocWelfareinfomx;
/**
 * 关系型数据实体[SocWelfareinfomx] 查询条件对象
 */
@Slf4j
@Data
public class SocWelfareinfomxSearchContext extends QueryWrapperContext<SocWelfareinfomx> {

	private String n_socwelfareinfomxname_like;//[个人社保福利明细名称]
	public void setN_socwelfareinfomxname_like(String n_socwelfareinfomxname_like) {
        this.n_socwelfareinfomxname_like = n_socwelfareinfomxname_like;
        if(!ObjectUtils.isEmpty(this.n_socwelfareinfomxname_like)){
            this.getSearchCond().like("socwelfareinfomxname", n_socwelfareinfomxname_like);
        }
    }
	private String n_socwelfareinfoname_eq;//[个人社保福利名称]
	public void setN_socwelfareinfoname_eq(String n_socwelfareinfoname_eq) {
        this.n_socwelfareinfoname_eq = n_socwelfareinfoname_eq;
        if(!ObjectUtils.isEmpty(this.n_socwelfareinfoname_eq)){
            this.getSearchCond().eq("socwelfareinfoname", n_socwelfareinfoname_eq);
        }
    }
	private String n_socwelfareinfoname_like;//[个人社保福利名称]
	public void setN_socwelfareinfoname_like(String n_socwelfareinfoname_like) {
        this.n_socwelfareinfoname_like = n_socwelfareinfoname_like;
        if(!ObjectUtils.isEmpty(this.n_socwelfareinfoname_like)){
            this.getSearchCond().like("socwelfareinfoname", n_socwelfareinfoname_like);
        }
    }
	private String n_socselfarebasemxid_eq;//[社保明细标识]
	public void setN_socselfarebasemxid_eq(String n_socselfarebasemxid_eq) {
        this.n_socselfarebasemxid_eq = n_socselfarebasemxid_eq;
        if(!ObjectUtils.isEmpty(this.n_socselfarebasemxid_eq)){
            this.getSearchCond().eq("socselfarebasemxid", n_socselfarebasemxid_eq);
        }
    }
	private String n_socwelfareinfoid_eq;//[个人社保福利明细标识]
	public void setN_socwelfareinfoid_eq(String n_socwelfareinfoid_eq) {
        this.n_socwelfareinfoid_eq = n_socwelfareinfoid_eq;
        if(!ObjectUtils.isEmpty(this.n_socwelfareinfoid_eq)){
            this.getSearchCond().eq("socwelfareinfoid", n_socwelfareinfoid_eq);
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
                     wrapper.like("socwelfareinfomxname", query)   
            );
		 }
	}
}




