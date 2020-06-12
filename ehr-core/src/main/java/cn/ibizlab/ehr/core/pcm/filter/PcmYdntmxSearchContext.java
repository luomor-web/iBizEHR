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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdntmx;
/**
 * 关系型数据实体[PcmYdntmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmYdntmxSearchContext extends QueryWrapperContext<PcmYdntmx> {

	private String n_pcmydntmxname_like;//[异动内退明细名称]
	public void setN_pcmydntmxname_like(String n_pcmydntmxname_like) {
        this.n_pcmydntmxname_like = n_pcmydntmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydntmxname_like)){
            this.getSearchCond().like("pcmydntmxname", n_pcmydntmxname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_zz_like;//[所属组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
        }
    }
	private String n_bm_like;//[所属部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSearchCond().like("bm", n_bm_like);
        }
    }
	private String n_isfinished_eq;//[是否完成]
	public void setN_isfinished_eq(String n_isfinished_eq) {
        this.n_isfinished_eq = n_isfinished_eq;
        if(!ObjectUtils.isEmpty(this.n_isfinished_eq)){
            this.getSearchCond().eq("isfinished", n_isfinished_eq);
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
                     wrapper.like("pcmydntmxname", query)   
                        .or().like("ygbh", query)            
                        .or().like("pimpersonname", query)            
            );
		 }
	}
}




