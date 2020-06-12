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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdtxmx;
/**
 * 关系型数据实体[PcmYdtxmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmYdtxmxSearchContext extends QueryWrapperContext<PcmYdtxmx> {

	private String n_pcmydtxmxname_like;//[异动退休明细名称]
	public void setN_pcmydtxmxname_like(String n_pcmydtxmxname_like) {
        this.n_pcmydtxmxname_like = n_pcmydtxmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydtxmxname_like)){
            this.getSearchCond().like("pcmydtxmxname", n_pcmydtxmxname_like);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_pcmydbxmxname_like;//[异动病休明细名称]
	public void setN_pcmydbxmxname_like(String n_pcmydbxmxname_like) {
        this.n_pcmydbxmxname_like = n_pcmydbxmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmydbxmxname_like)){
            this.getSearchCond().like("pcmydbxmxname", n_pcmydbxmxname_like);
        }
    }
	private String n_bm_like;//[所属部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSearchCond().like("bm", n_bm_like);
        }
    }
	private String n_zz_like;//[所属组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
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
                     wrapper.like("pcmydtxmxname", query)   
                        .or().like("pimpersonname", query)            
                        .or().like("ygbh", query)            
            );
		 }
	}
}




