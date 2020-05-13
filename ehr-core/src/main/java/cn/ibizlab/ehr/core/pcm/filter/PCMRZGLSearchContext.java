package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMRZGL;
/**
 * 关系型数据实体[PCMRZGL] 查询条件对象
 */
@Slf4j
@Data
public class PCMRZGLSearchContext extends QueryWrapperContext<PCMRZGL> {

	private String n_zj_eq;//[当前职级]
	public void setN_zj_eq(String n_zj_eq) {
        this.n_zj_eq = n_zj_eq;
        if(!ObjectUtils.isEmpty(this.n_zj_eq)){
            this.getSelectCond().eq("zj", n_zj_eq);
        }
    }
	private String n_dqzjxzw_eq;//[当前职务]
	public void setN_dqzjxzw_eq(String n_dqzjxzw_eq) {
        this.n_dqzjxzw_eq = n_dqzjxzw_eq;
        if(!ObjectUtils.isEmpty(this.n_dqzjxzw_eq)){
            this.getSelectCond().eq("dqzjxzw", n_dqzjxzw_eq);
        }
    }
	private String n_pcmrzglname_like;//[任职管理名称]
	public void setN_pcmrzglname_like(String n_pcmrzglname_like) {
        this.n_pcmrzglname_like = n_pcmrzglname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmrzglname_like)){
            this.getSelectCond().like("pcmrzglname", n_pcmrzglname_like);
        }
    }
	private String n_ygname_like;//[员工]
	public void setN_ygname_like(String n_ygname_like) {
        this.n_ygname_like = n_ygname_like;
        if(!ObjectUtils.isEmpty(this.n_ygname_like)){
            this.getSelectCond().like("ygname", n_ygname_like);
        }
    }
	private String n_sex_eq;//[性别]
	public void setN_sex_eq(String n_sex_eq) {
        this.n_sex_eq = n_sex_eq;
        if(!ObjectUtils.isEmpty(this.n_sex_eq)){
            this.getSelectCond().eq("sex", n_sex_eq);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_gw_eq;//[当前岗位]
	public void setN_gw_eq(String n_gw_eq) {
        this.n_gw_eq = n_gw_eq;
        if(!ObjectUtils.isEmpty(this.n_gw_eq)){
            this.getSelectCond().eq("gw", n_gw_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmrzglname",query);
			this.getSelectCond().or().like("ygname",query);
			this.getSelectCond().or().like("ygbh",query);
		 }
	}
}



