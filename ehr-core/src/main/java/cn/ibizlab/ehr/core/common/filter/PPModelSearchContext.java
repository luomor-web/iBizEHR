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
import cn.ibizlab.ehr.core.common.domain.PPModel;
/**
 * 关系型数据实体[PPModel] 查询条件对象
 */
@Slf4j
@Data
public class PPModelSearchContext extends QueryWrapperContext<PPModel> {

	private String n_ppmodel_eq;//[页面布局]
	public void setN_ppmodel_eq(String n_ppmodel_eq) {
        this.n_ppmodel_eq = n_ppmodel_eq;
        if(!ObjectUtils.isEmpty(this.n_ppmodel_eq)){
            this.getSelectCond().eq("ppmodel", n_ppmodel_eq);
        }
    }
	private String n_r1pvpartname_eq;//[右侧部件1]
	public void setN_r1pvpartname_eq(String n_r1pvpartname_eq) {
        this.n_r1pvpartname_eq = n_r1pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_r1pvpartname_eq)){
            this.getSelectCond().eq("r1pvpartname", n_r1pvpartname_eq);
        }
    }
	private String n_r1pvpartname_like;//[右侧部件1]
	public void setN_r1pvpartname_like(String n_r1pvpartname_like) {
        this.n_r1pvpartname_like = n_r1pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_r1pvpartname_like)){
            this.getSelectCond().like("r1pvpartname", n_r1pvpartname_like);
        }
    }
	private String n_c3pvpartname_eq;//[中间部件3]
	public void setN_c3pvpartname_eq(String n_c3pvpartname_eq) {
        this.n_c3pvpartname_eq = n_c3pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_c3pvpartname_eq)){
            this.getSelectCond().eq("c3pvpartname", n_c3pvpartname_eq);
        }
    }
	private String n_c3pvpartname_like;//[中间部件3]
	public void setN_c3pvpartname_like(String n_c3pvpartname_like) {
        this.n_c3pvpartname_like = n_c3pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_c3pvpartname_like)){
            this.getSelectCond().like("c3pvpartname", n_c3pvpartname_like);
        }
    }
	private String n_l3pvpartname_eq;//[左侧部件3]
	public void setN_l3pvpartname_eq(String n_l3pvpartname_eq) {
        this.n_l3pvpartname_eq = n_l3pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_l3pvpartname_eq)){
            this.getSelectCond().eq("l3pvpartname", n_l3pvpartname_eq);
        }
    }
	private String n_l3pvpartname_like;//[左侧部件3]
	public void setN_l3pvpartname_like(String n_l3pvpartname_like) {
        this.n_l3pvpartname_like = n_l3pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_l3pvpartname_like)){
            this.getSelectCond().like("l3pvpartname", n_l3pvpartname_like);
        }
    }
	private String n_r3pvpartname_eq;//[右侧部件3]
	public void setN_r3pvpartname_eq(String n_r3pvpartname_eq) {
        this.n_r3pvpartname_eq = n_r3pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_r3pvpartname_eq)){
            this.getSelectCond().eq("r3pvpartname", n_r3pvpartname_eq);
        }
    }
	private String n_r3pvpartname_like;//[右侧部件3]
	public void setN_r3pvpartname_like(String n_r3pvpartname_like) {
        this.n_r3pvpartname_like = n_r3pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_r3pvpartname_like)){
            this.getSelectCond().like("r3pvpartname", n_r3pvpartname_like);
        }
    }
	private String n_c1pvpartname_eq;//[中间部件1]
	public void setN_c1pvpartname_eq(String n_c1pvpartname_eq) {
        this.n_c1pvpartname_eq = n_c1pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_c1pvpartname_eq)){
            this.getSelectCond().eq("c1pvpartname", n_c1pvpartname_eq);
        }
    }
	private String n_c1pvpartname_like;//[中间部件1]
	public void setN_c1pvpartname_like(String n_c1pvpartname_like) {
        this.n_c1pvpartname_like = n_c1pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_c1pvpartname_like)){
            this.getSelectCond().like("c1pvpartname", n_c1pvpartname_like);
        }
    }
	private String n_r4pvpartname_eq;//[右侧部件4]
	public void setN_r4pvpartname_eq(String n_r4pvpartname_eq) {
        this.n_r4pvpartname_eq = n_r4pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_r4pvpartname_eq)){
            this.getSelectCond().eq("r4pvpartname", n_r4pvpartname_eq);
        }
    }
	private String n_r4pvpartname_like;//[右侧部件4]
	public void setN_r4pvpartname_like(String n_r4pvpartname_like) {
        this.n_r4pvpartname_like = n_r4pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_r4pvpartname_like)){
            this.getSelectCond().like("r4pvpartname", n_r4pvpartname_like);
        }
    }
	private String n_l2pvpartname_eq;//[左侧部件2]
	public void setN_l2pvpartname_eq(String n_l2pvpartname_eq) {
        this.n_l2pvpartname_eq = n_l2pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_l2pvpartname_eq)){
            this.getSelectCond().eq("l2pvpartname", n_l2pvpartname_eq);
        }
    }
	private String n_l2pvpartname_like;//[左侧部件2]
	public void setN_l2pvpartname_like(String n_l2pvpartname_like) {
        this.n_l2pvpartname_like = n_l2pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_l2pvpartname_like)){
            this.getSelectCond().like("l2pvpartname", n_l2pvpartname_like);
        }
    }
	private String n_l4pvpartname_eq;//[左侧部件4]
	public void setN_l4pvpartname_eq(String n_l4pvpartname_eq) {
        this.n_l4pvpartname_eq = n_l4pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_l4pvpartname_eq)){
            this.getSelectCond().eq("l4pvpartname", n_l4pvpartname_eq);
        }
    }
	private String n_l4pvpartname_like;//[左侧部件4]
	public void setN_l4pvpartname_like(String n_l4pvpartname_like) {
        this.n_l4pvpartname_like = n_l4pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_l4pvpartname_like)){
            this.getSelectCond().like("l4pvpartname", n_l4pvpartname_like);
        }
    }
	private String n_l1pvpartname_eq;//[左侧部件1]
	public void setN_l1pvpartname_eq(String n_l1pvpartname_eq) {
        this.n_l1pvpartname_eq = n_l1pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_l1pvpartname_eq)){
            this.getSelectCond().eq("l1pvpartname", n_l1pvpartname_eq);
        }
    }
	private String n_l1pvpartname_like;//[左侧部件1]
	public void setN_l1pvpartname_like(String n_l1pvpartname_like) {
        this.n_l1pvpartname_like = n_l1pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_l1pvpartname_like)){
            this.getSelectCond().like("l1pvpartname", n_l1pvpartname_like);
        }
    }
	private String n_portalpagename_eq;//[频道页]
	public void setN_portalpagename_eq(String n_portalpagename_eq) {
        this.n_portalpagename_eq = n_portalpagename_eq;
        if(!ObjectUtils.isEmpty(this.n_portalpagename_eq)){
            this.getSelectCond().eq("portalpagename", n_portalpagename_eq);
        }
    }
	private String n_portalpagename_like;//[频道页]
	public void setN_portalpagename_like(String n_portalpagename_like) {
        this.n_portalpagename_like = n_portalpagename_like;
        if(!ObjectUtils.isEmpty(this.n_portalpagename_like)){
            this.getSelectCond().like("portalpagename", n_portalpagename_like);
        }
    }
	private String n_c4pvpartname_eq;//[中间部件4]
	public void setN_c4pvpartname_eq(String n_c4pvpartname_eq) {
        this.n_c4pvpartname_eq = n_c4pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_c4pvpartname_eq)){
            this.getSelectCond().eq("c4pvpartname", n_c4pvpartname_eq);
        }
    }
	private String n_c4pvpartname_like;//[中间部件4]
	public void setN_c4pvpartname_like(String n_c4pvpartname_like) {
        this.n_c4pvpartname_like = n_c4pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_c4pvpartname_like)){
            this.getSelectCond().like("c4pvpartname", n_c4pvpartname_like);
        }
    }
	private String n_c2pvpartname_eq;//[中间部件2]
	public void setN_c2pvpartname_eq(String n_c2pvpartname_eq) {
        this.n_c2pvpartname_eq = n_c2pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_c2pvpartname_eq)){
            this.getSelectCond().eq("c2pvpartname", n_c2pvpartname_eq);
        }
    }
	private String n_c2pvpartname_like;//[中间部件2]
	public void setN_c2pvpartname_like(String n_c2pvpartname_like) {
        this.n_c2pvpartname_like = n_c2pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_c2pvpartname_like)){
            this.getSelectCond().like("c2pvpartname", n_c2pvpartname_like);
        }
    }
	private String n_r2pvpartname_eq;//[右侧部件2]
	public void setN_r2pvpartname_eq(String n_r2pvpartname_eq) {
        this.n_r2pvpartname_eq = n_r2pvpartname_eq;
        if(!ObjectUtils.isEmpty(this.n_r2pvpartname_eq)){
            this.getSelectCond().eq("r2pvpartname", n_r2pvpartname_eq);
        }
    }
	private String n_r2pvpartname_like;//[右侧部件2]
	public void setN_r2pvpartname_like(String n_r2pvpartname_like) {
        this.n_r2pvpartname_like = n_r2pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_r2pvpartname_like)){
            this.getSelectCond().like("r2pvpartname", n_r2pvpartname_like);
        }
    }
	private String n_r1pvpartid_eq;//[右侧部件1]
	public void setN_r1pvpartid_eq(String n_r1pvpartid_eq) {
        this.n_r1pvpartid_eq = n_r1pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_r1pvpartid_eq)){
            this.getSelectCond().eq("r1pvpartid", n_r1pvpartid_eq);
        }
    }
	private String n_c3pvpartid_eq;//[中间部件3]
	public void setN_c3pvpartid_eq(String n_c3pvpartid_eq) {
        this.n_c3pvpartid_eq = n_c3pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_c3pvpartid_eq)){
            this.getSelectCond().eq("c3pvpartid", n_c3pvpartid_eq);
        }
    }
	private String n_c1pvpartid_eq;//[中间部件1]
	public void setN_c1pvpartid_eq(String n_c1pvpartid_eq) {
        this.n_c1pvpartid_eq = n_c1pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_c1pvpartid_eq)){
            this.getSelectCond().eq("c1pvpartid", n_c1pvpartid_eq);
        }
    }
	private String n_l1pvpartid_eq;//[左侧部件1]
	public void setN_l1pvpartid_eq(String n_l1pvpartid_eq) {
        this.n_l1pvpartid_eq = n_l1pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_l1pvpartid_eq)){
            this.getSelectCond().eq("l1pvpartid", n_l1pvpartid_eq);
        }
    }
	private String n_r4pvpartid_eq;//[右侧部件4]
	public void setN_r4pvpartid_eq(String n_r4pvpartid_eq) {
        this.n_r4pvpartid_eq = n_r4pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_r4pvpartid_eq)){
            this.getSelectCond().eq("r4pvpartid", n_r4pvpartid_eq);
        }
    }
	private String n_l4pvpartid_eq;//[左侧部件4]
	public void setN_l4pvpartid_eq(String n_l4pvpartid_eq) {
        this.n_l4pvpartid_eq = n_l4pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_l4pvpartid_eq)){
            this.getSelectCond().eq("l4pvpartid", n_l4pvpartid_eq);
        }
    }
	private String n_l2pvpartid_eq;//[左侧部件2]
	public void setN_l2pvpartid_eq(String n_l2pvpartid_eq) {
        this.n_l2pvpartid_eq = n_l2pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_l2pvpartid_eq)){
            this.getSelectCond().eq("l2pvpartid", n_l2pvpartid_eq);
        }
    }
	private String n_c4pvpartid_eq;//[中间部件4]
	public void setN_c4pvpartid_eq(String n_c4pvpartid_eq) {
        this.n_c4pvpartid_eq = n_c4pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_c4pvpartid_eq)){
            this.getSelectCond().eq("c4pvpartid", n_c4pvpartid_eq);
        }
    }
	private String n_l3pvpartid_eq;//[左侧部件3]
	public void setN_l3pvpartid_eq(String n_l3pvpartid_eq) {
        this.n_l3pvpartid_eq = n_l3pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_l3pvpartid_eq)){
            this.getSelectCond().eq("l3pvpartid", n_l3pvpartid_eq);
        }
    }
	private String n_portalpageid_eq;//[门户页面]
	public void setN_portalpageid_eq(String n_portalpageid_eq) {
        this.n_portalpageid_eq = n_portalpageid_eq;
        if(!ObjectUtils.isEmpty(this.n_portalpageid_eq)){
            this.getSelectCond().eq("portalpageid", n_portalpageid_eq);
        }
    }
	private String n_r3pvpartid_eq;//[右侧部件3]
	public void setN_r3pvpartid_eq(String n_r3pvpartid_eq) {
        this.n_r3pvpartid_eq = n_r3pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_r3pvpartid_eq)){
            this.getSelectCond().eq("r3pvpartid", n_r3pvpartid_eq);
        }
    }
	private String n_r2pvpartid_eq;//[右侧部件2]
	public void setN_r2pvpartid_eq(String n_r2pvpartid_eq) {
        this.n_r2pvpartid_eq = n_r2pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_r2pvpartid_eq)){
            this.getSelectCond().eq("r2pvpartid", n_r2pvpartid_eq);
        }
    }
	private String n_c2pvpartid_eq;//[中间部件2]
	public void setN_c2pvpartid_eq(String n_c2pvpartid_eq) {
        this.n_c2pvpartid_eq = n_c2pvpartid_eq;
        if(!ObjectUtils.isEmpty(this.n_c2pvpartid_eq)){
            this.getSelectCond().eq("c2pvpartid", n_c2pvpartid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("portalpagename",query);
		 }
	}
}




