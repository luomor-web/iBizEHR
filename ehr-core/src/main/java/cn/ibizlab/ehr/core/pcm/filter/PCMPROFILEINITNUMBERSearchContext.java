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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEINITNUMBER;
/**
 * 关系型数据实体[PCMPROFILEINITNUMBER] 查询条件对象
 */
@Slf4j
@Data
public class PCMPROFILEINITNUMBERSearchContext extends QueryWrapperContext<PCMPROFILEINITNUMBER> {

	private String n_yglx_eq;//[员工类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSelectCond().eq("yglx", n_yglx_eq);
        }
    }
	private String n_pcmprofileinitnumbername_like;//[应聘者起始编号名称]
	public void setN_pcmprofileinitnumbername_like(String n_pcmprofileinitnumbername_like) {
        this.n_pcmprofileinitnumbername_like = n_pcmprofileinitnumbername_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileinitnumbername_like)){
            this.getSelectCond().like("pcmprofileinitnumbername", n_pcmprofileinitnumbername_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmprofileinitnumbername",query);
		 }
	}
}



