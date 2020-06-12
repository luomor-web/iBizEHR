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
import cn.ibizlab.ehr.core.pim.domain.PimFilebatvhupload;
/**
 * 关系型数据实体[PimFilebatvhupload] 查询条件对象
 */
@Slf4j
@Data
public class PimFilebatvhuploadSearchContext extends QueryWrapperContext<PimFilebatvhupload> {

	private String n_pimfilebatvhuploadname_like;//[附件批量上传名称]
	public void setN_pimfilebatvhuploadname_like(String n_pimfilebatvhuploadname_like) {
        this.n_pimfilebatvhuploadname_like = n_pimfilebatvhuploadname_like;
        if(!ObjectUtils.isEmpty(this.n_pimfilebatvhuploadname_like)){
            this.getSearchCond().like("pimfilebatvhuploadname", n_pimfilebatvhuploadname_like);
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
                     wrapper.like("pimfilebatvhuploadname", query)   
            );
		 }
	}
}




