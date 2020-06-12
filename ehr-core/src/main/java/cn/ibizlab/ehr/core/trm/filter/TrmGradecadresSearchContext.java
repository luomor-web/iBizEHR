package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TrmGradecadres;
/**
 * 关系型数据实体[TrmGradecadres] 查询条件对象
 */
@Slf4j
@Data
public class TrmGradecadresSearchContext extends QueryWrapperContext<TrmGradecadres> {

	private String n_trmgradecadresname_like;//[优秀青年干部推荐名称]
	public void setN_trmgradecadresname_like(String n_trmgradecadresname_like) {
        this.n_trmgradecadresname_like = n_trmgradecadresname_like;
        if(!ObjectUtils.isEmpty(this.n_trmgradecadresname_like)){
            this.getSearchCond().like("trmgradecadresname", n_trmgradecadresname_like);
        }
    }
	private String n_ormdutyname_eq;//[职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_pimpersonname_eq;//[领导人]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[领导人]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonname2_eq;//[姓名]
	public void setN_pimpersonname2_eq(String n_pimpersonname2_eq) {
        this.n_pimpersonname2_eq = n_pimpersonname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_eq)){
            this.getSearchCond().eq("pimpersonname2", n_pimpersonname2_eq);
        }
    }
	private String n_pimpersonname2_like;//[姓名]
	public void setN_pimpersonname2_like(String n_pimpersonname2_like) {
        this.n_pimpersonname2_like = n_pimpersonname2_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_like)){
            this.getSearchCond().like("pimpersonname2", n_pimpersonname2_like);
        }
    }
	private String n_ormorgsectorname2_eq;//[所属部门]
	public void setN_ormorgsectorname2_eq(String n_ormorgsectorname2_eq) {
        this.n_ormorgsectorname2_eq = n_ormorgsectorname2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname2_eq)){
            this.getSearchCond().eq("ormorgsectorname2", n_ormorgsectorname2_eq);
        }
    }
	private String n_ormorgsectorname2_like;//[所属部门]
	public void setN_ormorgsectorname2_like(String n_ormorgsectorname2_like) {
        this.n_ormorgsectorname2_like = n_ormorgsectorname2_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname2_like)){
            this.getSearchCond().like("ormorgsectorname2", n_ormorgsectorname2_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormrankname_eq;//[职级]
	public void setN_ormrankname_eq(String n_ormrankname_eq) {
        this.n_ormrankname_eq = n_ormrankname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_eq)){
            this.getSearchCond().eq("ormrankname", n_ormrankname_eq);
        }
    }
	private String n_ormrankname_like;//[职级]
	public void setN_ormrankname_like(String n_ormrankname_like) {
        this.n_ormrankname_like = n_ormrankname_like;
        if(!ObjectUtils.isEmpty(this.n_ormrankname_like)){
            this.getSearchCond().like("ormrankname", n_ormrankname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgname2_eq;//[所属组织]
	public void setN_ormorgname2_eq(String n_ormorgname2_eq) {
        this.n_ormorgname2_eq = n_ormorgname2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_eq)){
            this.getSearchCond().eq("ormorgname2", n_ormorgname2_eq);
        }
    }
	private String n_ormorgname2_like;//[所属组织]
	public void setN_ormorgname2_like(String n_ormorgname2_like) {
        this.n_ormorgname2_like = n_ormorgname2_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_like)){
            this.getSearchCond().like("ormorgname2", n_ormorgname2_like);
        }
    }
	private String n_ormrankid_eq;//[职级标识]
	public void setN_ormrankid_eq(String n_ormrankid_eq) {
        this.n_ormrankid_eq = n_ormrankid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormrankid_eq)){
            this.getSearchCond().eq("ormrankid", n_ormrankid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务管理标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_ormorgsectorid2_eq;//[部门标识]
	public void setN_ormorgsectorid2_eq(String n_ormorgsectorid2_eq) {
        this.n_ormorgsectorid2_eq = n_ormorgsectorid2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid2_eq)){
            this.getSearchCond().eq("ormorgsectorid2", n_ormorgsectorid2_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormorgid2_eq;//[组织标识]
	public void setN_ormorgid2_eq(String n_ormorgid2_eq) {
        this.n_ormorgid2_eq = n_ormorgid2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid2_eq)){
            this.getSearchCond().eq("ormorgid2", n_ormorgid2_eq);
        }
    }
	private String n_pimpersonid2_eq;//[人员信息标识]
	public void setN_pimpersonid2_eq(String n_pimpersonid2_eq) {
        this.n_pimpersonid2_eq = n_pimpersonid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid2_eq)){
            this.getSearchCond().eq("pimpersonid2", n_pimpersonid2_eq);
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
                     wrapper.like("trmgradecadresname", query)   
            );
		 }
	}
}




