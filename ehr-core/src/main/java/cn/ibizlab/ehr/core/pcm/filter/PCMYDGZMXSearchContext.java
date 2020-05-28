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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDGZMX;
/**
 * 关系型数据实体[PCMYDGZMX] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PCMYDGZMXSearchContext extends QueryWrapperContext<PCMYDGZMX> {

	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_gztype_eq;//[挂职类型]
	public void setN_gztype_eq(String n_gztype_eq) {
        this.n_gztype_eq = n_gztype_eq;
        if(!ObjectUtils.isEmpty(this.n_gztype_eq)){
            this.getSelectCond().eq("gztype", n_gztype_eq);
        }
    }
	private String n_pcmydgzmxname_like;//[异动挂职明细名称]
	public void setN_pcmydgzmxname_like(String n_pcmydgzmxname_like) {
        this.n_pcmydgzmxname_like = n_pcmydgzmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydgzmxname_like)){
            this.getSelectCond().like("pcmydgzmxname", n_pcmydgzmxname_like);
        }
    }
	private String n_sfdq_eq;//[是否到期]
	public void setN_sfdq_eq(String n_sfdq_eq) {
        this.n_sfdq_eq = n_sfdq_eq;
        if(!ObjectUtils.isEmpty(this.n_sfdq_eq)){
            this.getSelectCond().eq("sfdq", n_sfdq_eq);
        }
    }
	private String n_wbzz_like;//[外部组织]
	public void setN_wbzz_like(String n_wbzz_like) {
        this.n_wbzz_like = n_wbzz_like;
        if(!ObjectUtils.isEmpty(this.n_wbzz_like)){
            this.getSelectCond().like("wbzz", n_wbzz_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_zz_like;//[所属组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSelectCond().like("zz", n_zz_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pimpersonname",query);
			this.getSelectCond().or().like("pcmydgzmxname",query);
			this.getSelectCond().or().like("ygbh",query);
		 }
	}
}




