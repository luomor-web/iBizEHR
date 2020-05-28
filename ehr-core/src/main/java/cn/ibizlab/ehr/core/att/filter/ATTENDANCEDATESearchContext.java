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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEDATE;
/**
 * 关系型数据实体[ATTENDANCEDATE] 查询条件对象
 */
@Slf4j
@Data
public class ATTENDANCEDATESearchContext extends QueryWrapperContext<ATTENDANCEDATE> {

	private String n_attendancedatename_like;//[考勤日期名称]
	public void setN_attendancedatename_like(String n_attendancedatename_like) {
        this.n_attendancedatename_like = n_attendancedatename_like;
        if(!ObjectUtils.isEmpty(this.n_attendancedatename_like)){
            this.getSelectCond().like("attendancedatename", n_attendancedatename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("attendancedatename", query)   
            );
		 }
	}
}




