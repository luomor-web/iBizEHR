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
import cn.ibizlab.ehr.core.common.domain.PVPart;
/**
 * 关系型数据实体[PVPart] 查询条件对象
 */
@Slf4j
@Data
public class PVPartSearchContext extends QueryWrapperContext<PVPart> {

	private String n_pvparttype_eq;//[部件类型]
	public void setN_pvparttype_eq(String n_pvparttype_eq) {
        this.n_pvparttype_eq = n_pvparttype_eq;
        if(!ObjectUtils.isEmpty(this.n_pvparttype_eq)){
            this.getSelectCond().eq("pvparttype", n_pvparttype_eq);
        }
    }
	private String n_pvpartname_like;//[门户视图部件名称]
	public void setN_pvpartname_like(String n_pvpartname_like) {
        this.n_pvpartname_like = n_pvpartname_like;
        if(!ObjectUtils.isEmpty(this.n_pvpartname_like)){
            this.getSelectCond().like("pvpartname", n_pvpartname_like);
        }
    }
	private String n_portalpagename_eq;//[门户视图]
	public void setN_portalpagename_eq(String n_portalpagename_eq) {
        this.n_portalpagename_eq = n_portalpagename_eq;
        if(!ObjectUtils.isEmpty(this.n_portalpagename_eq)){
            this.getSelectCond().eq("portalpagename", n_portalpagename_eq);
        }
    }
	private String n_portalpagename_like;//[门户视图]
	public void setN_portalpagename_like(String n_portalpagename_like) {
        this.n_portalpagename_like = n_portalpagename_like;
        if(!ObjectUtils.isEmpty(this.n_portalpagename_like)){
            this.getSelectCond().like("portalpagename", n_portalpagename_like);
        }
    }
	private String n_portalpageid_eq;//[门户视图]
	public void setN_portalpageid_eq(String n_portalpageid_eq) {
        this.n_portalpageid_eq = n_portalpageid_eq;
        if(!ObjectUtils.isEmpty(this.n_portalpageid_eq)){
            this.getSelectCond().eq("portalpageid", n_portalpageid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pvpartname",query);
		 }
	}
}




