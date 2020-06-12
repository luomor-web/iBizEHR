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
import cn.ibizlab.ehr.core.pcm.domain.PcmCertofreg;
/**
 * 关系型数据实体[PcmCertofreg] 查询条件对象
 */
@Slf4j
@Data
public class PcmCertofregSearchContext extends QueryWrapperContext<PcmCertofreg> {

	private String n_lx_eq;//[证书类型]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_pcmcertofregname_like;//[证书名称]
	public void setN_pcmcertofregname_like(String n_pcmcertofregname_like) {
        this.n_pcmcertofregname_like = n_pcmcertofregname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmcertofregname_like)){
            this.getSearchCond().like("pcmcertofregname", n_pcmcertofregname_like);
        }
    }
	private String n_zyzgzy_eq;//[证书名称]
	public void setN_zyzgzy_eq(String n_zyzgzy_eq) {
        this.n_zyzgzy_eq = n_zyzgzy_eq;
        if(!ObjectUtils.isEmpty(this.n_zyzgzy_eq)){
            this.getSearchCond().eq("zyzgzy", n_zyzgzy_eq);
        }
    }
	private String n_zyzgzy_like;//[证书名称]
	public void setN_zyzgzy_like(String n_zyzgzy_like) {
        this.n_zyzgzy_like = n_zyzgzy_like;
        if(!ObjectUtils.isEmpty(this.n_zyzgzy_like)){
            this.getSearchCond().like("zyzgzy", n_zyzgzy_like);
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
	private String n_pimqualmajorid_eq;//[执业资格专业编码]
	public void setN_pimqualmajorid_eq(String n_pimqualmajorid_eq) {
        this.n_pimqualmajorid_eq = n_pimqualmajorid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimqualmajorid_eq)){
            this.getSearchCond().eq("pimqualmajorid", n_pimqualmajorid_eq);
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
                     wrapper.like("pcmcertofregname", query)   
            );
		 }
	}
}




