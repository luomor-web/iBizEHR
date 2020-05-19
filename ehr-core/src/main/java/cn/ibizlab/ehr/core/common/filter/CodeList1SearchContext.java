package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.CodeList1;
/**
 * 关系型数据实体[CodeList1] 查询条件对象
 */
@Slf4j
@Data
public class CodeList1SearchContext extends QueryWrapperContext<CodeList1> {

	private String n_ormode_eq;//[或模式]
	public void setN_ormode_eq(String n_ormode_eq) {
        this.n_ormode_eq = n_ormode_eq;
        if(!ObjectUtils.isEmpty(this.n_ormode_eq)){
            this.getSelectCond().eq("ormode", n_ormode_eq);
        }
    }
	private String n_codelistname_like;//[代码表名称]
	public void setN_codelistname_like(String n_codelistname_like) {
        this.n_codelistname_like = n_codelistname_like;
        if(!ObjectUtils.isEmpty(this.n_codelistname_like)){
            this.getSelectCond().like("codelistname", n_codelistname_like);
        }
    }
	private String n_dename_eq;//[数据实体]
	public void setN_dename_eq(String n_dename_eq) {
        this.n_dename_eq = n_dename_eq;
        if(!ObjectUtils.isEmpty(this.n_dename_eq)){
            this.getSelectCond().eq("dename", n_dename_eq);
        }
    }
	private String n_dename_like;//[数据实体]
	public void setN_dename_like(String n_dename_like) {
        this.n_dename_like = n_dename_like;
        if(!ObjectUtils.isEmpty(this.n_dename_like)){
            this.getSelectCond().like("dename", n_dename_like);
        }
    }
	private String n_deid_eq;//[数据实体]
	public void setN_deid_eq(String n_deid_eq) {
        this.n_deid_eq = n_deid_eq;
        if(!ObjectUtils.isEmpty(this.n_deid_eq)){
            this.getSelectCond().eq("deid", n_deid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("codelistname",query);
		 }
	}
}




