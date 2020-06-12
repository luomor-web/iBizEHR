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
import cn.ibizlab.ehr.core.pcm.domain.PcmTdzwxx;
/**
 * 关系型数据实体[PcmTdzwxx] 查询条件对象
 */
@Slf4j
@Data
public class PcmTdzwxxSearchContext extends QueryWrapperContext<PcmTdzwxx> {

	private String n_flag_eq;//[是否有效]
	public void setN_flag_eq(String n_flag_eq) {
        this.n_flag_eq = n_flag_eq;
        if(!ObjectUtils.isEmpty(this.n_flag_eq)){
            this.getSearchCond().eq("flag", n_flag_eq);
        }
    }
	private String n_tdzwxxname_like;//[职位名称]
	public void setN_tdzwxxname_like(String n_tdzwxxname_like) {
        this.n_tdzwxxname_like = n_tdzwxxname_like;
        if(!ObjectUtils.isEmpty(this.n_tdzwxxname_like)){
            this.getSearchCond().like("tdzwxxname", n_tdzwxxname_like);
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
                     wrapper.like("tdzwxxname", query)   
            );
		 }
	}
}




