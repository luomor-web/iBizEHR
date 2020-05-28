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
import cn.ibizlab.ehr.core.pcm.domain.TestResult;
/**
 * 关系型数据实体[TestResult] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResultSearchContext extends QueryWrapperContext<TestResult> {

	private String n_testresultname_like;//[测评结果信息名称]
	public void setN_testresultname_like(String n_testresultname_like) {
        this.n_testresultname_like = n_testresultname_like;
        if(!ObjectUtils.isEmpty(this.n_testresultname_like)){
            this.getSelectCond().like("testresultname", n_testresultname_like);
        }
    }
	private String n_psychologyhealthylevel_eq;//[心理健康等级]
	public void setN_psychologyhealthylevel_eq(String n_psychologyhealthylevel_eq) {
        this.n_psychologyhealthylevel_eq = n_psychologyhealthylevel_eq;
        if(!ObjectUtils.isEmpty(this.n_psychologyhealthylevel_eq)){
            this.getSelectCond().eq("psychologyhealthylevel", n_psychologyhealthylevel_eq);
        }
    }
	private String n_flag_eq;//[是否有效]
	public void setN_flag_eq(String n_flag_eq) {
        this.n_flag_eq = n_flag_eq;
        if(!ObjectUtils.isEmpty(this.n_flag_eq)){
            this.getSelectCond().eq("flag", n_flag_eq);
        }
    }
	private String n_pcmprofilename_eq;//[姓名]
	public void setN_pcmprofilename_eq(String n_pcmprofilename_eq) {
        this.n_pcmprofilename_eq = n_pcmprofilename_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_eq)){
            this.getSelectCond().eq("pcmprofilename", n_pcmprofilename_eq);
        }
    }
	private String n_pcmprofilename_like;//[姓名]
	public void setN_pcmprofilename_like(String n_pcmprofilename_like) {
        this.n_pcmprofilename_like = n_pcmprofilename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_like)){
            this.getSelectCond().like("pcmprofilename", n_pcmprofilename_like);
        }
    }
	private String n_pcmprofileid_eq;//[应聘者ID]
	public void setN_pcmprofileid_eq(String n_pcmprofileid_eq) {
        this.n_pcmprofileid_eq = n_pcmprofileid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileid_eq)){
            this.getSelectCond().eq("pcmprofileid", n_pcmprofileid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("testresultname",query);
		 }
	}
}




