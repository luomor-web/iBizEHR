package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
/**
 * 关系型数据实体[PIMVOCATIONAL] 查询条件对象
 */
@Slf4j
@Data
public class PIMVOCATIONALSearchContext extends QueryWrapperContext<PIMVOCATIONAL> {

	private String n_pimvocationalname_like;//[证书名称]
	public void setN_pimvocationalname_like(String n_pimvocationalname_like) {
        this.n_pimvocationalname_like = n_pimvocationalname_like;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalname_like)){
            this.getSelectCond().like("pimvocationalname", n_pimvocationalname_like);
        }
    }
	private String n_bcardnumber_like;//[一建配套B证编号]
	public void setN_bcardnumber_like(String n_bcardnumber_like) {
        this.n_bcardnumber_like = n_bcardnumber_like;
        if(!ObjectUtils.isEmpty(this.n_bcardnumber_like)){
            this.getSelectCond().like("bcardnumber", n_bcardnumber_like);
        }
    }
	private String n_jlczz_eq;//[记录操作者]
	public void setN_jlczz_eq(String n_jlczz_eq) {
        this.n_jlczz_eq = n_jlczz_eq;
        if(!ObjectUtils.isEmpty(this.n_jlczz_eq)){
            this.getSelectCond().eq("jlczz", n_jlczz_eq);
        }
    }
	private String n_zyfl_eq;//[专业分类]
	public void setN_zyfl_eq(String n_zyfl_eq) {
        this.n_zyfl_eq = n_zyfl_eq;
        if(!ObjectUtils.isEmpty(this.n_zyfl_eq)){
            this.getSelectCond().eq("zyfl", n_zyfl_eq);
        }
    }
	private String n_zsmc_like;//[证书名称]
	public void setN_zsmc_like(String n_zsmc_like) {
        this.n_zsmc_like = n_zsmc_like;
        if(!ObjectUtils.isEmpty(this.n_zsmc_like)){
            this.getSelectCond().like("zsmc", n_zsmc_like);
        }
    }
	private String n_zslx_eq;//[证书类型]
	public void setN_zslx_eq(String n_zslx_eq) {
        this.n_zslx_eq = n_zslx_eq;
        if(!ObjectUtils.isEmpty(this.n_zslx_eq)){
            this.getSelectCond().eq("zslx", n_zslx_eq);
        }
    }
	private String n_jlss_eq;//[记录所属]
	public void setN_jlss_eq(String n_jlss_eq) {
        this.n_jlss_eq = n_jlss_eq;
        if(!ObjectUtils.isEmpty(this.n_jlss_eq)){
            this.getSelectCond().eq("jlss", n_jlss_eq);
        }
    }
	private String n_jlspzt_eq;//[记录审批状态]
	public void setN_jlspzt_eq(String n_jlspzt_eq) {
        this.n_jlspzt_eq = n_jlspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jlspzt_eq)){
            this.getSelectCond().eq("jlspzt", n_jlspzt_eq);
        }
    }
	private String n_jbfl_eq;//[级别分类]
	public void setN_jbfl_eq(String n_jbfl_eq) {
        this.n_jbfl_eq = n_jbfl_eq;
        if(!ObjectUtils.isEmpty(this.n_jbfl_eq)){
            this.getSelectCond().eq("jbfl", n_jbfl_eq);
        }
    }
	private String n_zgzsbh_like;//[证书编号]
	public void setN_zgzsbh_like(String n_zgzsbh_like) {
        this.n_zgzsbh_like = n_zgzsbh_like;
        if(!ObjectUtils.isEmpty(this.n_zgzsbh_like)){
            this.getSelectCond().like("zgzsbh", n_zgzsbh_like);
        }
    }
	private String n_ormorgsectorname_eq;//[注册单位]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSelectCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[注册单位]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSelectCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_pimqualmajorname_eq;//[职业资格专业]
	public void setN_pimqualmajorname_eq(String n_pimqualmajorname_eq) {
        this.n_pimqualmajorname_eq = n_pimqualmajorname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorname_eq)){
            this.getSelectCond().eq("pimqualmajorname", n_pimqualmajorname_eq);
        }
    }
	private String n_pimqualmajorname_like;//[职业资格专业]
	public void setN_pimqualmajorname_like(String n_pimqualmajorname_like) {
        this.n_pimqualmajorname_like = n_pimqualmajorname_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorname_like)){
            this.getSelectCond().like("pimqualmajorname", n_pimqualmajorname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimvocationalcatalogname_eq;//[职（执）业资格证书]
	public void setN_pimvocationalcatalogname_eq(String n_pimvocationalcatalogname_eq) {
        this.n_pimvocationalcatalogname_eq = n_pimvocationalcatalogname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalcatalogname_eq)){
            this.getSelectCond().eq("pimvocationalcatalogname", n_pimvocationalcatalogname_eq);
        }
    }
	private String n_pimvocationalcatalogname_like;//[职（执）业资格证书]
	public void setN_pimvocationalcatalogname_like(String n_pimvocationalcatalogname_like) {
        this.n_pimvocationalcatalogname_like = n_pimvocationalcatalogname_like;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalcatalogname_like)){
            this.getSelectCond().like("pimvocationalcatalogname", n_pimvocationalcatalogname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormsignorgname_eq;//[注册单位]
	public void setN_ormsignorgname_eq(String n_ormsignorgname_eq) {
        this.n_ormsignorgname_eq = n_ormsignorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgname_eq)){
            this.getSelectCond().eq("ormsignorgname", n_ormsignorgname_eq);
        }
    }
	private String n_ormsignorgname_like;//[注册单位]
	public void setN_ormsignorgname_like(String n_ormsignorgname_like) {
        this.n_ormsignorgname_like = n_ormsignorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgname_like)){
            this.getSelectCond().like("ormsignorgname", n_ormsignorgname_like);
        }
    }
	private String n_ygzt_eq;//[员工状态]
	public void setN_ygzt_eq(String n_ygzt_eq) {
        this.n_ygzt_eq = n_ygzt_eq;
        if(!ObjectUtils.isEmpty(this.n_ygzt_eq)){
            this.getSelectCond().eq("ygzt", n_ygzt_eq);
        }
    }
	private String n_pimqualtypename_eq;//[岗位（技能）证书]
	public void setN_pimqualtypename_eq(String n_pimqualtypename_eq) {
        this.n_pimqualtypename_eq = n_pimqualtypename_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_eq)){
            this.getSelectCond().eq("pimqualtypename", n_pimqualtypename_eq);
        }
    }
	private String n_pimqualtypename_like;//[岗位（技能）证书]
	public void setN_pimqualtypename_like(String n_pimqualtypename_like) {
        this.n_pimqualtypename_like = n_pimqualtypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_like)){
            this.getSelectCond().like("pimqualtypename", n_pimqualtypename_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSelectCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimvocationalcatalogid_eq;//[职（执）业资格管理标识]
	public void setN_pimvocationalcatalogid_eq(String n_pimvocationalcatalogid_eq) {
        this.n_pimvocationalcatalogid_eq = n_pimvocationalcatalogid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalcatalogid_eq)){
            this.getSelectCond().eq("pimvocationalcatalogid", n_pimvocationalcatalogid_eq);
        }
    }
	private String n_ormsignorgid_eq;//[法人主体标识]
	public void setN_ormsignorgid_eq(String n_ormsignorgid_eq) {
        this.n_ormsignorgid_eq = n_ormsignorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgid_eq)){
            this.getSelectCond().eq("ormsignorgid", n_ormsignorgid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimqualmajorid_eq;//[执业资格专业编码]
	public void setN_pimqualmajorid_eq(String n_pimqualmajorid_eq) {
        this.n_pimqualmajorid_eq = n_pimqualmajorid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorid_eq)){
            this.getSelectCond().eq("pimqualmajorid", n_pimqualmajorid_eq);
        }
    }
	private String n_pimqualtypeid_eq;//[岗位（技能）证书ID]
	public void setN_pimqualtypeid_eq(String n_pimqualtypeid_eq) {
        this.n_pimqualtypeid_eq = n_pimqualtypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypeid_eq)){
            this.getSelectCond().eq("pimqualtypeid", n_pimqualtypeid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("zsmc",query);
			this.getSelectCond().or().like("pimpersonname",query);
			this.getSelectCond().or().like("ygbh",query);
		 }
	}
}



