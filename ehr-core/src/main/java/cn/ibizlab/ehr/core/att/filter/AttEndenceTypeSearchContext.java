package cn.ibizlab.ehr.core.att.filter;

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
import cn.ibizlab.ehr.core.att.domain.AttEndenceType;
/**
 * 关系型数据实体[AttEndenceType] 查询条件对象
 */
@Slf4j
@Data
public class AttEndenceTypeSearchContext extends QueryWrapperContext<AttEndenceType> {

	private String n_typecode_like;//[考勤类型代码]
	public void setN_typecode_like(String n_typecode_like) {
        this.n_typecode_like = n_typecode_like;
        if(!ObjectUtils.isEmpty(this.n_typecode_like)){
            this.getSearchCond().like("typecode", n_typecode_like);
        }
    }
	private String n_attendencetypename_like;//[考勤类型名称]
	public void setN_attendencetypename_like(String n_attendencetypename_like) {
        this.n_attendencetypename_like = n_attendencetypename_like;
        if(!ObjectUtils.isEmpty(this.n_attendencetypename_like)){
            this.getSearchCond().like("attendencetypename", n_attendencetypename_like);
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
                     wrapper.like("attendencetypename", query)   
            );
		 }
	}
}




