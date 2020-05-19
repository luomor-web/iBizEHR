package cn.ibizlab.ehr.core.wf.filter;

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
import cn.ibizlab.ehr.core.wf.domain.WFCustomProcess;
/**
 * 关系型数据实体[WFCustomProcess] 查询条件对象
 */
@Slf4j
@Data
public class WFCustomProcessSearchContext extends QueryWrapperContext<WFCustomProcess> {

	private String n_wfcustomprocessname_like;//[工作流预定义处理名称]
	public void setN_wfcustomprocessname_like(String n_wfcustomprocessname_like) {
        this.n_wfcustomprocessname_like = n_wfcustomprocessname_like;
        if(!ObjectUtils.isEmpty(this.n_wfcustomprocessname_like)){
            this.getSelectCond().like("wfcustomprocessname", n_wfcustomprocessname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfcustomprocessname",query);
		 }
	}
}




