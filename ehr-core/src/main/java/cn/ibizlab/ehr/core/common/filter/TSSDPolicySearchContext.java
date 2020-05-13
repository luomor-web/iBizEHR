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
import cn.ibizlab.ehr.core.common.domain.TSSDPolicy;
/**
 * 关系型数据实体[TSSDPolicy] 查询条件对象
 */
@Slf4j
@Data
public class TSSDPolicySearchContext extends QueryWrapperContext<TSSDPolicy> {

	private String n_tssdpolicyname_like;//[任务时刻策略名称]
	public void setN_tssdpolicyname_like(String n_tssdpolicyname_like) {
        this.n_tssdpolicyname_like = n_tssdpolicyname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdpolicyname_like)){
            this.getSelectCond().like("tssdpolicyname", n_tssdpolicyname_like);
        }
    }
	private String n_tssdpolicytype_eq;//[策略类型]
	public void setN_tssdpolicytype_eq(String n_tssdpolicytype_eq) {
        this.n_tssdpolicytype_eq = n_tssdpolicytype_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdpolicytype_eq)){
            this.getSelectCond().eq("tssdpolicytype", n_tssdpolicytype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdpolicyname",query);
		 }
	}
}




