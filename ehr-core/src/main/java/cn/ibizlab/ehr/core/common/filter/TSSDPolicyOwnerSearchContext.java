package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.TSSDPolicyOwner;
/**
 * 关系型数据实体[TSSDPolicyOwner] 查询条件对象
 */
@Slf4j
@Data
public class TSSDPolicyOwnerSearchContext extends QueryWrapperContext<TSSDPolicyOwner> {

	private String n_tssdpolicyownername_like;//[任务时刻策略所有者名称]
	public void setN_tssdpolicyownername_like(String n_tssdpolicyownername_like) {
        this.n_tssdpolicyownername_like = n_tssdpolicyownername_like;
        if(!ObjectUtils.isEmpty(this.n_tssdpolicyownername_like)){
            this.getSelectCond().like("tssdpolicyownername", n_tssdpolicyownername_like);
        }
    }
	private String n_tssdpolicyownertype_eq;//[所有者类型]
	public void setN_tssdpolicyownertype_eq(String n_tssdpolicyownertype_eq) {
        this.n_tssdpolicyownertype_eq = n_tssdpolicyownertype_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdpolicyownertype_eq)){
            this.getSelectCond().eq("tssdpolicyownertype", n_tssdpolicyownertype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdpolicyownername",query);
		 }
	}
}




