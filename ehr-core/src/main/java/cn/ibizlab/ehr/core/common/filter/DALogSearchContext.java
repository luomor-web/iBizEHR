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
import cn.ibizlab.ehr.core.common.domain.DALog;
/**
 * 关系型数据实体[DALog] 查询条件对象
 */
@Slf4j
@Data
public class DALogSearchContext extends QueryWrapperContext<DALog> {

	private String n_dalog_name_like;//[DA日志名称]
	public void setN_dalog_name_like(String n_dalog_name_like) {
        this.n_dalog_name_like = n_dalog_name_like;
        if(!ObjectUtils.isEmpty(this.n_dalog_name_like)){
            this.getSelectCond().like("dalog_name", n_dalog_name_like);
        }
    }
	private String n_objecttype_eq;//[对象类型]
	public void setN_objecttype_eq(String n_objecttype_eq) {
        this.n_objecttype_eq = n_objecttype_eq;
        if(!ObjectUtils.isEmpty(this.n_objecttype_eq)){
            this.getSelectCond().eq("objecttype", n_objecttype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("dalog_name",query);
		 }
	}
}




