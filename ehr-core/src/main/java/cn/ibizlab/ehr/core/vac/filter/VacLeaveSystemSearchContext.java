package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveSystem;
/**
 * 关系型数据实体[VacLeaveSystem] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaveSystemSearchContext extends QueryWrapperContext<VacLeaveSystem> {

	private String n_vacleavesystemname_like;//[休假制度名称]
	public void setN_vacleavesystemname_like(String n_vacleavesystemname_like) {
        this.n_vacleavesystemname_like = n_vacleavesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemname_like)){
            this.getSearchCond().like("vacleavesystemname", n_vacleavesystemname_like);
        }
    }
	private String n_sfqy_eq;//[是否启用]
	public void setN_sfqy_eq(String n_sfqy_eq) {
        this.n_sfqy_eq = n_sfqy_eq;
        if(!ObjectUtils.isEmpty(this.n_sfqy_eq)){
            this.getSearchCond().eq("sfqy", n_sfqy_eq);
        }
    }
	private String n_nd_eq;//[适用年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("vacleavesystemname", query)   
            );
		 }
	}
}



