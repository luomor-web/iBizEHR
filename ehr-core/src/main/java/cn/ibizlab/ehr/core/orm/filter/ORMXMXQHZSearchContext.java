package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.ORMXMXQHZ;
/**
 * 关系型数据实体[ORMXMXQHZ] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ORMXMXQHZSearchContext extends QueryWrapperContext<ORMXMXQHZ> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_ormxmxqhzname_like;//[标题]
	public void setN_ormxmxqhzname_like(String n_ormxmxqhzname_like) {
        this.n_ormxmxqhzname_like = n_ormxmxqhzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmxqhzname_like)){
            this.getSelectCond().like("ormxmxqhzname", n_ormxmxqhzname_like);
        }
    }
	private String n_yf_eq;//[月份]
	public void setN_yf_eq(String n_yf_eq) {
        this.n_yf_eq = n_yf_eq;
        if(!ObjectUtils.isEmpty(this.n_yf_eq)){
            this.getSelectCond().eq("yf", n_yf_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("ormxmxqhzname",query);
		 }
	}
}




