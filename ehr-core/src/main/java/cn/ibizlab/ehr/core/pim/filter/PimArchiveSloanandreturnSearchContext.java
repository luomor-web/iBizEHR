package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
/**
 * 关系型数据实体[PimArchiveSloanandreturn] 查询条件对象
 */
@Slf4j
@Data
public class PimArchiveSloanandreturnSearchContext extends QueryWrapperContext<PimArchiveSloanandreturn> {

	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_pimarchivesloanandreturnname_like;//[档案借阅及归还记录名称]
	public void setN_pimarchivesloanandreturnname_like(String n_pimarchivesloanandreturnname_like) {
        this.n_pimarchivesloanandreturnname_like = n_pimarchivesloanandreturnname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesloanandreturnname_like)){
            this.getSearchCond().like("pimarchivesloanandreturnname", n_pimarchivesloanandreturnname_like);
        }
    }
	private String n_pimarchivesname_eq;//[档案信息名称]
	public void setN_pimarchivesname_eq(String n_pimarchivesname_eq) {
        this.n_pimarchivesname_eq = n_pimarchivesname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_eq)){
            this.getSearchCond().eq("pimarchivesname", n_pimarchivesname_eq);
        }
    }
	private String n_pimarchivesname_like;//[档案信息名称]
	public void setN_pimarchivesname_like(String n_pimarchivesname_like) {
        this.n_pimarchivesname_like = n_pimarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_like)){
            this.getSearchCond().like("pimarchivesname", n_pimarchivesname_like);
        }
    }
	private String n_pimpersonname2_eq;//[借阅人]
	public void setN_pimpersonname2_eq(String n_pimpersonname2_eq) {
        this.n_pimpersonname2_eq = n_pimpersonname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_eq)){
            this.getSearchCond().eq("pimpersonname2", n_pimpersonname2_eq);
        }
    }
	private String n_pimpersonname2_like;//[借阅人]
	public void setN_pimpersonname2_like(String n_pimpersonname2_like) {
        this.n_pimpersonname2_like = n_pimpersonname2_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_like)){
            this.getSearchCond().like("pimpersonname2", n_pimpersonname2_like);
        }
    }
	private String n_pimpersonname3_eq;//[审批人]
	public void setN_pimpersonname3_eq(String n_pimpersonname3_eq) {
        this.n_pimpersonname3_eq = n_pimpersonname3_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname3_eq)){
            this.getSearchCond().eq("pimpersonname3", n_pimpersonname3_eq);
        }
    }
	private String n_pimpersonname3_like;//[审批人]
	public void setN_pimpersonname3_like(String n_pimpersonname3_like) {
        this.n_pimpersonname3_like = n_pimpersonname3_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname3_like)){
            this.getSearchCond().like("pimpersonname3", n_pimpersonname3_like);
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
	private String n_pimpersonid3_eq;//[人员信息标识]
	public void setN_pimpersonid3_eq(String n_pimpersonid3_eq) {
        this.n_pimpersonid3_eq = n_pimpersonid3_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid3_eq)){
            this.getSearchCond().eq("pimpersonid3", n_pimpersonid3_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimarchivesid_eq;//[档案信息标识]
	public void setN_pimarchivesid_eq(String n_pimarchivesid_eq) {
        this.n_pimarchivesid_eq = n_pimarchivesid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesid_eq)){
            this.getSearchCond().eq("pimarchivesid", n_pimarchivesid_eq);
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
                     wrapper.like("pimarchivesloanandreturnname", query)   
            );
		 }
	}
}




