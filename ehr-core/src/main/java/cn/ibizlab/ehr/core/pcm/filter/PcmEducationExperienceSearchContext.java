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
import cn.ibizlab.ehr.core.pcm.domain.PcmEducationExperience;
/**
 * 关系型数据实体[PcmEducationExperience] 查询条件对象
 */
@Slf4j
@Data
public class PcmEducationExperienceSearchContext extends QueryWrapperContext<PcmEducationExperience> {

	private String n_flag_eq;//[是否有效]
	public void setN_flag_eq(String n_flag_eq) {
        this.n_flag_eq = n_flag_eq;
        if(!ObjectUtils.isEmpty(this.n_flag_eq)){
            this.getSearchCond().eq("flag", n_flag_eq);
        }
    }
	private String n_pcmeducationexperiencename_like;//[教育背景名称]
	public void setN_pcmeducationexperiencename_like(String n_pcmeducationexperiencename_like) {
        this.n_pcmeducationexperiencename_like = n_pcmeducationexperiencename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmeducationexperiencename_like)){
            this.getSearchCond().like("pcmeducationexperiencename", n_pcmeducationexperiencename_like);
        }
    }
	private String n_formsoflearning_eq;//[学习形式]
	public void setN_formsoflearning_eq(String n_formsoflearning_eq) {
        this.n_formsoflearning_eq = n_formsoflearning_eq;
        if(!ObjectUtils.isEmpty(this.n_formsoflearning_eq)){
            this.getSearchCond().eq("formsoflearning", n_formsoflearning_eq);
        }
    }
	private String n_sfxzy_eq;//[是否小专业]
	public void setN_sfxzy_eq(String n_sfxzy_eq) {
        this.n_sfxzy_eq = n_sfxzy_eq;
        if(!ObjectUtils.isEmpty(this.n_sfxzy_eq)){
            this.getSearchCond().eq("sfxzy", n_sfxzy_eq);
        }
    }
	private String n_xkml_eq;//[一级学科]
	public void setN_xkml_eq(String n_xkml_eq) {
        this.n_xkml_eq = n_xkml_eq;
        if(!ObjectUtils.isEmpty(this.n_xkml_eq)){
            this.getSearchCond().eq("xkml", n_xkml_eq);
        }
    }
	private String n_higestxl_eq;//[是否最高学历]
	public void setN_higestxl_eq(String n_higestxl_eq) {
        this.n_higestxl_eq = n_higestxl_eq;
        if(!ObjectUtils.isEmpty(this.n_higestxl_eq)){
            this.getSearchCond().eq("higestxl", n_higestxl_eq);
        }
    }
	private String n_xxxz_eq;//[学校性质]
	public void setN_xxxz_eq(String n_xxxz_eq) {
        this.n_xxxz_eq = n_xxxz_eq;
        if(!ObjectUtils.isEmpty(this.n_xxxz_eq)){
            this.getSearchCond().eq("xxxz", n_xxxz_eq);
        }
    }
	private String n_xl_eq;//[学历]
	public void setN_xl_eq(String n_xl_eq) {
        this.n_xl_eq = n_xl_eq;
        if(!ObjectUtils.isEmpty(this.n_xl_eq)){
            this.getSearchCond().eq("xl", n_xl_eq);
        }
    }
	private String n_firstxl_eq;//[是否第一学历]
	public void setN_firstxl_eq(String n_firstxl_eq) {
        this.n_firstxl_eq = n_firstxl_eq;
        if(!ObjectUtils.isEmpty(this.n_firstxl_eq)){
            this.getSearchCond().eq("firstxl", n_firstxl_eq);
        }
    }
	private String n_pcmprofilename_eq;//[姓名]
	public void setN_pcmprofilename_eq(String n_pcmprofilename_eq) {
        this.n_pcmprofilename_eq = n_pcmprofilename_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_eq)){
            this.getSearchCond().eq("pcmprofilename", n_pcmprofilename_eq);
        }
    }
	private String n_pcmprofilename_like;//[姓名]
	public void setN_pcmprofilename_like(String n_pcmprofilename_like) {
        this.n_pcmprofilename_like = n_pcmprofilename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_like)){
            this.getSearchCond().like("pcmprofilename", n_pcmprofilename_like);
        }
    }
	private String n_pcmprofileid_eq;//[应聘者ID]
	public void setN_pcmprofileid_eq(String n_pcmprofileid_eq) {
        this.n_pcmprofileid_eq = n_pcmprofileid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileid_eq)){
            this.getSearchCond().eq("pcmprofileid", n_pcmprofileid_eq);
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
                     wrapper.like("pcmeducationexperiencename", query)   
            );
		 }
	}
}




