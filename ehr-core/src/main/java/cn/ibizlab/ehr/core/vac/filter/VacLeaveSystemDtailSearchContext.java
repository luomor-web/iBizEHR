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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveSystemDtail;
/**
 * 关系型数据实体[VacLeaveSystemDtail] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaveSystemDtailSearchContext extends QueryWrapperContext<VacLeaveSystemDtail> {

	private String n_vacleavesystemdetailname_like;//[休假制度明细名称]
	public void setN_vacleavesystemdetailname_like(String n_vacleavesystemdetailname_like) {
        this.n_vacleavesystemdetailname_like = n_vacleavesystemdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemdetailname_like)){
            this.getSearchCond().like("vacleavesystemdetailname", n_vacleavesystemdetailname_like);
        }
    }
	private String n_xjlx_eq;//[休假类型]
	public void setN_xjlx_eq(String n_xjlx_eq) {
        this.n_xjlx_eq = n_xjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_xjlx_eq)){
            this.getSearchCond().eq("xjlx", n_xjlx_eq);
        }
    }
	private String n_vacleavesystemname_eq;//[休假制度名称]
	public void setN_vacleavesystemname_eq(String n_vacleavesystemname_eq) {
        this.n_vacleavesystemname_eq = n_vacleavesystemname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemname_eq)){
            this.getSearchCond().eq("vacleavesystemname", n_vacleavesystemname_eq);
        }
    }
	private String n_vacleavesystemname_like;//[休假制度名称]
	public void setN_vacleavesystemname_like(String n_vacleavesystemname_like) {
        this.n_vacleavesystemname_like = n_vacleavesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemname_like)){
            this.getSearchCond().like("vacleavesystemname", n_vacleavesystemname_like);
        }
    }
	private String n_vacleavesystemid_eq;//[休假制度管理标识]
	public void setN_vacleavesystemid_eq(String n_vacleavesystemid_eq) {
        this.n_vacleavesystemid_eq = n_vacleavesystemid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemid_eq)){
            this.getSearchCond().eq("vacleavesystemid", n_vacleavesystemid_eq);
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
                     wrapper.like("vacleavesystemdetailname", query)   
            );
		 }
	}
}




