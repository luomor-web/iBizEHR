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
import cn.ibizlab.ehr.core.pcm.domain.PCMGxxkTemp;
/**
 * 关系型数据实体[PCMGxxkTemp] 查询条件对象
 */
@Slf4j
@Data
public class PCMGxxkTempSearchContext extends QueryWrapperContext<PCMGxxkTemp> {

	private String n_pcmgxxktempname_like;//[高校学科中间表名称]
	public void setN_pcmgxxktempname_like(String n_pcmgxxktempname_like) {
        this.n_pcmgxxktempname_like = n_pcmgxxktempname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmgxxktempname_like)){
            this.getSearchCond().like("pcmgxxktempname", n_pcmgxxktempname_like);
        }
    }
	private String n_pcmgxmlname_eq;//[高校名称]
	public void setN_pcmgxmlname_eq(String n_pcmgxmlname_eq) {
        this.n_pcmgxmlname_eq = n_pcmgxmlname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmgxmlname_eq)){
            this.getSearchCond().eq("pcmgxmlname", n_pcmgxmlname_eq);
        }
    }
	private String n_pcmgxmlname_like;//[高校名称]
	public void setN_pcmgxmlname_like(String n_pcmgxmlname_like) {
        this.n_pcmgxmlname_like = n_pcmgxmlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmgxmlname_like)){
            this.getSearchCond().like("pcmgxmlname", n_pcmgxmlname_like);
        }
    }
	private String n_pcmxkmlname_eq;//[学科名称]
	public void setN_pcmxkmlname_eq(String n_pcmxkmlname_eq) {
        this.n_pcmxkmlname_eq = n_pcmxkmlname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxkmlname_eq)){
            this.getSearchCond().eq("pcmxkmlname", n_pcmxkmlname_eq);
        }
    }
	private String n_pcmxkmlname_like;//[学科名称]
	public void setN_pcmxkmlname_like(String n_pcmxkmlname_like) {
        this.n_pcmxkmlname_like = n_pcmxkmlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxkmlname_like)){
            this.getSearchCond().like("pcmxkmlname", n_pcmxkmlname_like);
        }
    }
	private String n_pcmxkmlid_eq;//[学科目录标识]
	public void setN_pcmxkmlid_eq(String n_pcmxkmlid_eq) {
        this.n_pcmxkmlid_eq = n_pcmxkmlid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxkmlid_eq)){
            this.getSearchCond().eq("pcmxkmlid", n_pcmxkmlid_eq);
        }
    }
	private String n_pcmgxmlid_eq;//[高校名录标识]
	public void setN_pcmgxmlid_eq(String n_pcmgxmlid_eq) {
        this.n_pcmgxmlid_eq = n_pcmgxmlid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmgxmlid_eq)){
            this.getSearchCond().eq("pcmgxmlid", n_pcmgxmlid_eq);
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
                     wrapper.like("pcmgxxktempname", query)   
            );
		 }
	}
}




