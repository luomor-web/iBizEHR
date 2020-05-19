package cn.ibizlab.ehr.core.r7rt_dyna.filter;

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


import cn.ibizlab.ehr.util.filter.SearchContextBase;

/**
 * ServiceApi数据实体[DynaDashboard] 查询条件对象
 */
@Slf4j
@Data
public class DynaDashboardSearchContext extends SearchContextBase {
	private String n_dynadashboardname_like;//[实体名称]

}



