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
import cn.ibizlab.ehr.core.common.domain.TSSDItem;
/**
 * 关系型数据实体[TSSDItem] 查询条件对象
 */
@Slf4j
@Data
public class TSSDItemSearchContext extends QueryWrapperContext<TSSDItem> {

	private String n_hourtype_eq;//[小时]
	public void setN_hourtype_eq(String n_hourtype_eq) {
        this.n_hourtype_eq = n_hourtype_eq;
        if(!ObjectUtils.isEmpty(this.n_hourtype_eq)){
            this.getSelectCond().eq("hourtype", n_hourtype_eq);
        }
    }
	private String n_monthweektype_eq;//[月周]
	public void setN_monthweektype_eq(String n_monthweektype_eq) {
        this.n_monthweektype_eq = n_monthweektype_eq;
        if(!ObjectUtils.isEmpty(this.n_monthweektype_eq)){
            this.getSelectCond().eq("monthweektype", n_monthweektype_eq);
        }
    }
	private String n_minutetype_eq;//[分钟]
	public void setN_minutetype_eq(String n_minutetype_eq) {
        this.n_minutetype_eq = n_minutetype_eq;
        if(!ObjectUtils.isEmpty(this.n_minutetype_eq)){
            this.getSelectCond().eq("minutetype", n_minutetype_eq);
        }
    }
	private String n_secondtype_eq;//[秒钟]
	public void setN_secondtype_eq(String n_secondtype_eq) {
        this.n_secondtype_eq = n_secondtype_eq;
        if(!ObjectUtils.isEmpty(this.n_secondtype_eq)){
            this.getSelectCond().eq("secondtype", n_secondtype_eq);
        }
    }
	private String n_tssditemname_like;//[任务时刻策略项]
	public void setN_tssditemname_like(String n_tssditemname_like) {
        this.n_tssditemname_like = n_tssditemname_like;
        if(!ObjectUtils.isEmpty(this.n_tssditemname_like)){
            this.getSelectCond().like("tssditemname", n_tssditemname_like);
        }
    }
	private String n_monthdaytype_eq;//[月天]
	public void setN_monthdaytype_eq(String n_monthdaytype_eq) {
        this.n_monthdaytype_eq = n_monthdaytype_eq;
        if(!ObjectUtils.isEmpty(this.n_monthdaytype_eq)){
            this.getSelectCond().eq("monthdaytype", n_monthdaytype_eq);
        }
    }
	private String n_monthtype_eq;//[月份]
	public void setN_monthtype_eq(String n_monthtype_eq) {
        this.n_monthtype_eq = n_monthtype_eq;
        if(!ObjectUtils.isEmpty(this.n_monthtype_eq)){
            this.getSelectCond().eq("monthtype", n_monthtype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssditemname",query);
		 }
	}
}




