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
import cn.ibizlab.ehr.core.att.domain.AttendRecordDetail;
/**
 * 关系型数据实体[AttendRecordDetail] 查询条件对象
 */
@Slf4j
@Data
public class AttendRecordDetailSearchContext extends QueryWrapperContext<AttendRecordDetail> {

	private String n_attendrecorddetailname_like;//[考勤记录明细名称]
	public void setN_attendrecorddetailname_like(String n_attendrecorddetailname_like) {
        this.n_attendrecorddetailname_like = n_attendrecorddetailname_like;
        if(!ObjectUtils.isEmpty(this.n_attendrecorddetailname_like)){
            this.getSearchCond().like("attendrecorddetailname", n_attendrecorddetailname_like);
        }
    }
	private String n_attendancerecordname_eq;//[考勤记录名称]
	public void setN_attendancerecordname_eq(String n_attendancerecordname_eq) {
        this.n_attendancerecordname_eq = n_attendancerecordname_eq;
        if(!ObjectUtils.isEmpty(this.n_attendancerecordname_eq)){
            this.getSearchCond().eq("attendancerecordname", n_attendancerecordname_eq);
        }
    }
	private String n_attendancerecordname_like;//[考勤记录名称]
	public void setN_attendancerecordname_like(String n_attendancerecordname_like) {
        this.n_attendancerecordname_like = n_attendancerecordname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancerecordname_like)){
            this.getSearchCond().like("attendancerecordname", n_attendancerecordname_like);
        }
    }
	private String n_attendancerecordid_eq;//[考勤记录标识]
	public void setN_attendancerecordid_eq(String n_attendancerecordid_eq) {
        this.n_attendancerecordid_eq = n_attendancerecordid_eq;
        if(!ObjectUtils.isEmpty(this.n_attendancerecordid_eq)){
            this.getSearchCond().eq("attendancerecordid", n_attendancerecordid_eq);
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
                     wrapper.like("attendrecorddetailname", query)   
            );
		 }
	}
}




