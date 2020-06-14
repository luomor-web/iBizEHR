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
import cn.ibizlab.ehr.core.att.domain.AttEndenceOrmorgscetor;
/**
 * 关系型数据实体[AttEndenceOrmorgscetor] 查询条件对象
 */
@Slf4j
@Data
public class AttEndenceOrmorgscetorSearchContext extends QueryWrapperContext<AttEndenceOrmorgscetor> {

	private String n_attendenceormorgsectorname_like;//[考勤部门名称]
	public void setN_attendenceormorgsectorname_like(String n_attendenceormorgsectorname_like) {
        this.n_attendenceormorgsectorname_like = n_attendenceormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_attendenceormorgsectorname_like)){
            this.getSearchCond().like("attendenceormorgsectorname", n_attendenceormorgsectorname_like);
        }
    }
	private String n_attendencesetupname_eq;//[考勤表名称]
	public void setN_attendencesetupname_eq(String n_attendencesetupname_eq) {
        this.n_attendencesetupname_eq = n_attendencesetupname_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_eq)){
            this.getSearchCond().eq("attendencesetupname", n_attendencesetupname_eq);
        }
    }
	private String n_attendencesetupname_like;//[考勤表名称]
	public void setN_attendencesetupname_like(String n_attendencesetupname_like) {
        this.n_attendencesetupname_like = n_attendencesetupname_like;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_like)){
            this.getSearchCond().like("attendencesetupname", n_attendencesetupname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门名称]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门名称]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_attendencesetupid_eq;//[考勤设置标识]
	public void setN_attendencesetupid_eq(String n_attendencesetupid_eq) {
        this.n_attendencesetupid_eq = n_attendencesetupid_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupid_eq)){
            this.getSearchCond().eq("attendencesetupid", n_attendencesetupid_eq);
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
                     wrapper.like("ormorgsectorname", query)   
            );
		 }
	}
}




