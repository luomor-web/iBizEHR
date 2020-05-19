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
import cn.ibizlab.ehr.core.common.domain.UserRoleData;
/**
 * 关系型数据实体[UserRoleData] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDataSearchContext extends QueryWrapperContext<UserRoleData> {

	private String n_userroledataname_like;//[能力名称]
	public void setN_userroledataname_like(String n_userroledataname_like) {
        this.n_userroledataname_like = n_userroledataname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledataname_like)){
            this.getSelectCond().like("userroledataname", n_userroledataname_like);
        }
    }
	private String n_dename_eq;//[数据对象]
	public void setN_dename_eq(String n_dename_eq) {
        this.n_dename_eq = n_dename_eq;
        if(!ObjectUtils.isEmpty(this.n_dename_eq)){
            this.getSelectCond().eq("dename", n_dename_eq);
        }
    }
	private String n_dename_like;//[数据对象]
	public void setN_dename_like(String n_dename_like) {
        this.n_dename_like = n_dename_like;
        if(!ObjectUtils.isEmpty(this.n_dename_like)){
            this.getSelectCond().like("dename", n_dename_like);
        }
    }
	private String n_dstorgsectorname_eq;//[指定当前部门]
	public void setN_dstorgsectorname_eq(String n_dstorgsectorname_eq) {
        this.n_dstorgsectorname_eq = n_dstorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_dstorgsectorname_eq)){
            this.getSelectCond().eq("dstorgsectorname", n_dstorgsectorname_eq);
        }
    }
	private String n_dstorgsectorname_like;//[指定当前部门]
	public void setN_dstorgsectorname_like(String n_dstorgsectorname_like) {
        this.n_dstorgsectorname_like = n_dstorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_dstorgsectorname_like)){
            this.getSelectCond().like("dstorgsectorname", n_dstorgsectorname_like);
        }
    }
	private String n_dstorgname_eq;//[指定当前机构]
	public void setN_dstorgname_eq(String n_dstorgname_eq) {
        this.n_dstorgname_eq = n_dstorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_dstorgname_eq)){
            this.getSelectCond().eq("dstorgname", n_dstorgname_eq);
        }
    }
	private String n_dstorgname_like;//[指定当前机构]
	public void setN_dstorgname_like(String n_dstorgname_like) {
        this.n_dstorgname_like = n_dstorgname_like;
        if(!ObjectUtils.isEmpty(this.n_dstorgname_like)){
            this.getSelectCond().like("dstorgname", n_dstorgname_like);
        }
    }
	private String n_dstorgsectorid_eq;//[指定当前部门]
	public void setN_dstorgsectorid_eq(String n_dstorgsectorid_eq) {
        this.n_dstorgsectorid_eq = n_dstorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_dstorgsectorid_eq)){
            this.getSelectCond().eq("dstorgsectorid", n_dstorgsectorid_eq);
        }
    }
	private String n_dstorgid_eq;//[指定当前机构]
	public void setN_dstorgid_eq(String n_dstorgid_eq) {
        this.n_dstorgid_eq = n_dstorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_dstorgid_eq)){
            this.getSelectCond().eq("dstorgid", n_dstorgid_eq);
        }
    }
	private String n_deid_eq;//[数据实体]
	public void setN_deid_eq(String n_deid_eq) {
        this.n_deid_eq = n_deid_eq;
        if(!ObjectUtils.isEmpty(this.n_deid_eq)){
            this.getSelectCond().eq("deid", n_deid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userroledataname",query);
		 }
	}
}




