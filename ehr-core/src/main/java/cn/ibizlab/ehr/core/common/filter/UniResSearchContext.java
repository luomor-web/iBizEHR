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
import cn.ibizlab.ehr.core.common.domain.UniRes;
/**
 * 关系型数据实体[UniRes] 查询条件对象
 */
@Slf4j
@Data
public class UniResSearchContext extends QueryWrapperContext<UniRes> {

	private String n_uniresname_like;//[统一资源名称]
	public void setN_uniresname_like(String n_uniresname_like) {
        this.n_uniresname_like = n_uniresname_like;
        if(!ObjectUtils.isEmpty(this.n_uniresname_like)){
            this.getSelectCond().like("uniresname", n_uniresname_like);
        }
    }
	private String n_unirestype_eq;//[统一资源类型]
	public void setN_unirestype_eq(String n_unirestype_eq) {
        this.n_unirestype_eq = n_unirestype_eq;
        if(!ObjectUtils.isEmpty(this.n_unirestype_eq)){
            this.getSelectCond().eq("unirestype", n_unirestype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("uniresname",query);
		 }
	}
}




