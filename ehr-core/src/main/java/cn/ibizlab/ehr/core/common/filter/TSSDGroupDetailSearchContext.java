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
import cn.ibizlab.ehr.core.common.domain.TSSDGroupDetail;
/**
 * 关系型数据实体[TSSDGroupDetail] 查询条件对象
 */
@Slf4j
@Data
public class TSSDGroupDetailSearchContext extends QueryWrapperContext<TSSDGroupDetail> {

	private String n_tssdgroupdetailname_like;//[任务时刻策略组明细名称]
	public void setN_tssdgroupdetailname_like(String n_tssdgroupdetailname_like) {
        this.n_tssdgroupdetailname_like = n_tssdgroupdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdgroupdetailname_like)){
            this.getSelectCond().like("tssdgroupdetailname", n_tssdgroupdetailname_like);
        }
    }
	private String n_tssdgroupname_eq;//[任务时刻策略组]
	public void setN_tssdgroupname_eq(String n_tssdgroupname_eq) {
        this.n_tssdgroupname_eq = n_tssdgroupname_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdgroupname_eq)){
            this.getSelectCond().eq("tssdgroupname", n_tssdgroupname_eq);
        }
    }
	private String n_tssdgroupname_like;//[任务时刻策略组]
	public void setN_tssdgroupname_like(String n_tssdgroupname_like) {
        this.n_tssdgroupname_like = n_tssdgroupname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdgroupname_like)){
            this.getSelectCond().like("tssdgroupname", n_tssdgroupname_like);
        }
    }
	private String n_tssditemname_eq;//[任务时刻策略项]
	public void setN_tssditemname_eq(String n_tssditemname_eq) {
        this.n_tssditemname_eq = n_tssditemname_eq;
        if(!ObjectUtils.isEmpty(this.n_tssditemname_eq)){
            this.getSelectCond().eq("tssditemname", n_tssditemname_eq);
        }
    }
	private String n_tssditemname_like;//[任务时刻策略项]
	public void setN_tssditemname_like(String n_tssditemname_like) {
        this.n_tssditemname_like = n_tssditemname_like;
        if(!ObjectUtils.isEmpty(this.n_tssditemname_like)){
            this.getSelectCond().like("tssditemname", n_tssditemname_like);
        }
    }
	private String n_tssdgroupid_eq;//[任务时刻策略组]
	public void setN_tssdgroupid_eq(String n_tssdgroupid_eq) {
        this.n_tssdgroupid_eq = n_tssdgroupid_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdgroupid_eq)){
            this.getSelectCond().eq("tssdgroupid", n_tssdgroupid_eq);
        }
    }
	private String n_tssditemid_eq;//[任务时刻策略项]
	public void setN_tssditemid_eq(String n_tssditemid_eq) {
        this.n_tssditemid_eq = n_tssditemid_eq;
        if(!ObjectUtils.isEmpty(this.n_tssditemid_eq)){
            this.getSelectCond().eq("tssditemid", n_tssditemid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdgroupdetailname",query);
		 }
	}
}




