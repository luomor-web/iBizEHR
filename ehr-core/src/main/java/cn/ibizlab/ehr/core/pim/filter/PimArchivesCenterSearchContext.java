package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter;
/**
 * 关系型数据实体[PimArchivesCenter] 查询条件对象
 */
@Slf4j
@Data
public class PimArchivesCenterSearchContext extends QueryWrapperContext<PimArchivesCenter> {

	private String n_position_like;//[档案存放位置]
	public void setN_position_like(String n_position_like) {
        this.n_position_like = n_position_like;
        if(!ObjectUtils.isEmpty(this.n_position_like)){
            this.getSearchCond().like("position", n_position_like);
        }
    }
	private String n_archivescentername_like;//[档案室名称]
	public void setN_archivescentername_like(String n_archivescentername_like) {
        this.n_archivescentername_like = n_archivescentername_like;
        if(!ObjectUtils.isEmpty(this.n_archivescentername_like)){
            this.getSearchCond().like("archivescentername", n_archivescentername_like);
        }
    }
	private String n_layerno_eq;//[层号]
	public void setN_layerno_eq(String n_layerno_eq) {
        this.n_layerno_eq = n_layerno_eq;
        if(!ObjectUtils.isEmpty(this.n_layerno_eq)){
            this.getSearchCond().eq("layerno", n_layerno_eq);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("position", query)   
            );
		 }
	}
}




