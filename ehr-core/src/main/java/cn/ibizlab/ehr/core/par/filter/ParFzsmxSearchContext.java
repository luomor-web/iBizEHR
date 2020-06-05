package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.ParFzsmx;
/**
 * 关系型数据实体[ParFzsmx] 查询条件对象
 */
@Slf4j
@Data
public class ParFzsmxSearchContext extends QueryWrapperContext<ParFzsmx> {

	private String n_parfzsmxname_like;//[通知选择助总领导明细名称]
	public void setN_parfzsmxname_like(String n_parfzsmxname_like) {
        this.n_parfzsmxname_like = n_parfzsmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parfzsmxname_like)){
            this.getSelectCond().like("parfzsmxname", n_parfzsmxname_like);
        }
    }
	private String n_pimpersonname_eq;//[领导姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[领导姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_partzggname_eq;//[标题]
	public void setN_partzggname_eq(String n_partzggname_eq) {
        this.n_partzggname_eq = n_partzggname_eq;
        if(!ObjectUtils.isEmpty(this.n_partzggname_eq)){
            this.getSelectCond().eq("partzggname", n_partzggname_eq);
        }
    }
	private String n_partzggname_like;//[标题]
	public void setN_partzggname_like(String n_partzggname_like) {
        this.n_partzggname_like = n_partzggname_like;
        if(!ObjectUtils.isEmpty(this.n_partzggname_like)){
            this.getSelectCond().like("partzggname", n_partzggname_like);
        }
    }
	private String n_pimpersonid_eq;//[领导姓名ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_partzggid_eq;//[通知ID]
	public void setN_partzggid_eq(String n_partzggid_eq) {
        this.n_partzggid_eq = n_partzggid_eq;
        if(!ObjectUtils.isEmpty(this.n_partzggid_eq)){
            this.getSelectCond().eq("partzggid", n_partzggid_eq);
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
                     wrapper.like("parfzsmxname", query)   
            );
		 }
	}
}




