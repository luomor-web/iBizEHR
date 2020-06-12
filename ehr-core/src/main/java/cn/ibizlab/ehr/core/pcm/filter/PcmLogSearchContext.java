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
import cn.ibizlab.ehr.core.pcm.domain.PcmLog;
/**
 * 关系型数据实体[PcmLog] 查询条件对象
 */
@Slf4j
@Data
public class PcmLogSearchContext extends QueryWrapperContext<PcmLog> {

	private Integer n_sfsx_eq;//[是否生效]
	public void setN_sfsx_eq(Integer n_sfsx_eq) {
        this.n_sfsx_eq = n_sfsx_eq;
        if(!ObjectUtils.isEmpty(this.n_sfsx_eq)){
            this.getSearchCond().eq("sfsx", n_sfsx_eq);
        }
    }
	private String n_pcmlogname_like;//[配置变动日志名称]
	public void setN_pcmlogname_like(String n_pcmlogname_like) {
        this.n_pcmlogname_like = n_pcmlogname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmlogname_like)){
            this.getSearchCond().like("pcmlogname", n_pcmlogname_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sxrq_gtandeq;//[生效日期]
	public void setN_sxrq_gtandeq(Timestamp n_sxrq_gtandeq) {
        this.n_sxrq_gtandeq = n_sxrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_sxrq_gtandeq)){
            this.getSearchCond().ge("sxrq", n_sxrq_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sxrq_ltandeq;//[生效日期]
	public void setN_sxrq_ltandeq(Timestamp n_sxrq_ltandeq) {
        this.n_sxrq_ltandeq = n_sxrq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_sxrq_ltandeq)){
            this.getSearchCond().le("sxrq", n_sxrq_ltandeq);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
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
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pcmlogname", query)   
            );
		 }
	}
}




