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
import cn.ibizlab.ehr.core.par.domain.ParJxndkhjg;
/**
 * 关系型数据实体[ParJxndkhjg] 查询条件对象
 */
@Slf4j
@Data
public class ParJxndkhjgSearchContext extends QueryWrapperContext<ParJxndkhjg> {

	private String n_khnd_eq;//[考核年度]
	public void setN_khnd_eq(String n_khnd_eq) {
        this.n_khnd_eq = n_khnd_eq;
        if(!ObjectUtils.isEmpty(this.n_khnd_eq)){
            this.getSearchCond().eq("khnd", n_khnd_eq);
        }
    }
	private String n_khzq_eq;//[考核周期]
	public void setN_khzq_eq(String n_khzq_eq) {
        this.n_khzq_eq = n_khzq_eq;
        if(!ObjectUtils.isEmpty(this.n_khzq_eq)){
            this.getSearchCond().eq("khzq", n_khzq_eq);
        }
    }
	private String n_khpgdj_eq;//[考核定级]
	public void setN_khpgdj_eq(String n_khpgdj_eq) {
        this.n_khpgdj_eq = n_khpgdj_eq;
        if(!ObjectUtils.isEmpty(this.n_khpgdj_eq)){
            this.getSearchCond().eq("khpgdj", n_khpgdj_eq);
        }
    }
	private String n_parjxndkhjgname_like;//[绩效年度考核结果名称]
	public void setN_parjxndkhjgname_like(String n_parjxndkhjgname_like) {
        this.n_parjxndkhjgname_like = n_parjxndkhjgname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxndkhjgname_like)){
            this.getSearchCond().like("parjxndkhjgname", n_parjxndkhjgname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("parjxndkhjgname", query)   
            );
		 }
	}
}




