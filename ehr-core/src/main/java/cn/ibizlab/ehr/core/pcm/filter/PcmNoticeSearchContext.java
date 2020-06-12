package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmNotice;
/**
 * 关系型数据实体[PcmNotice] 查询条件对象
 */
@Slf4j
@Data
public class PcmNoticeSearchContext extends QueryWrapperContext<PcmNotice> {

	private String n_noticetype_eq;//[提醒类型]
	public void setN_noticetype_eq(String n_noticetype_eq) {
        this.n_noticetype_eq = n_noticetype_eq;
        if(!ObjectUtils.isEmpty(this.n_noticetype_eq)){
            this.getSearchCond().eq("noticetype", n_noticetype_eq);
        }
    }
	private Integer n_roletype_eq;//[通知角色类型]
	public void setN_roletype_eq(Integer n_roletype_eq) {
        this.n_roletype_eq = n_roletype_eq;
        if(!ObjectUtils.isEmpty(this.n_roletype_eq)){
            this.getSearchCond().eq("roletype", n_roletype_eq);
        }
    }
	private Integer n_done_eq;//[是否已处理]
	public void setN_done_eq(Integer n_done_eq) {
        this.n_done_eq = n_done_eq;
        if(!ObjectUtils.isEmpty(this.n_done_eq)){
            this.getSearchCond().eq("done", n_done_eq);
        }
    }
	private String n_pcmnoticename_like;//[提醒消息名称]
	public void setN_pcmnoticename_like(String n_pcmnoticename_like) {
        this.n_pcmnoticename_like = n_pcmnoticename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmnoticename_like)){
            this.getSearchCond().like("pcmnoticename", n_pcmnoticename_like);
        }
    }
	private String n_ssfw_eq;//[所属范围]
	public void setN_ssfw_eq(String n_ssfw_eq) {
        this.n_ssfw_eq = n_ssfw_eq;
        if(!ObjectUtils.isEmpty(this.n_ssfw_eq)){
            this.getSearchCond().eq("ssfw", n_ssfw_eq);
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
	private String n_pimpersonname_eq;//[异动员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[异动员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ygbh_like;//[异动员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
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
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimdistirbutionid_eq;//[分配信息标识]
	public void setN_pimdistirbutionid_eq(String n_pimdistirbutionid_eq) {
        this.n_pimdistirbutionid_eq = n_pimdistirbutionid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimdistirbutionid_eq)){
            this.getSearchCond().eq("pimdistirbutionid", n_pimdistirbutionid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("pcmnoticename", query)   
            );
		 }
	}
}




