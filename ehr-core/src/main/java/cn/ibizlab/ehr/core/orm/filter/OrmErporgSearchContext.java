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
import cn.ibizlab.ehr.core.orm.domain.OrmErporg;
/**
 * 关系型数据实体[OrmErporg] 查询条件对象
 */
@Slf4j
@Data
public class OrmErporgSearchContext extends QueryWrapperContext<OrmErporg> {

	private String n_yyflag_eq;//[引用标志]
	public void setN_yyflag_eq(String n_yyflag_eq) {
        this.n_yyflag_eq = n_yyflag_eq;
        if(!ObjectUtils.isEmpty(this.n_yyflag_eq)){
            this.getSearchCond().eq("yyflag", n_yyflag_eq);
        }
    }
	private String n_ormerporgname_like;//[组织名称]
	public void setN_ormerporgname_like(String n_ormerporgname_like) {
        this.n_ormerporgname_like = n_ormerporgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormerporgname_like)){
            this.getSearchCond().like("ormerporgname", n_ormerporgname_like);
        }
    }
	private String n_orgcode_like;//[组织编码]
	public void setN_orgcode_like(String n_orgcode_like) {
        this.n_orgcode_like = n_orgcode_like;
        if(!ObjectUtils.isEmpty(this.n_orgcode_like)){
            this.getSearchCond().like("orgcode", n_orgcode_like);
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
                     wrapper.like("ormerporgname", query)   
            );
		 }
	}
}




