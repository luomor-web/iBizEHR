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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL;
/**
 * 关系型数据实体[PCMJXSZZKHJGJL] 查询条件对象
 */
@Slf4j
@Data
public class PCMJXSZZKHJGJLSearchContext extends QueryWrapperContext<PCMJXSZZKHJGJL> {

	private String n_pj_eq;//[评价]
	public void setN_pj_eq(String n_pj_eq) {
        this.n_pj_eq = n_pj_eq;
        if(!ObjectUtils.isEmpty(this.n_pj_eq)){
            this.getSelectCond().eq("pj", n_pj_eq);
        }
    }
	private String n_pcmjxszzkhjgjlname_like;//[员工]
	public void setN_pcmjxszzkhjgjlname_like(String n_pcmjxszzkhjgjlname_like) {
        this.n_pcmjxszzkhjgjlname_like = n_pcmjxszzkhjgjlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxszzkhjgjlname_like)){
            this.getSelectCond().like("pcmjxszzkhjgjlname", n_pcmjxszzkhjgjlname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmjxszzkhjgjlname",query);
		 }
	}
}




