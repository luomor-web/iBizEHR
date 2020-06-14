package cn.ibizlab.ehr.util.filter;

import cn.ibizlab.ehr.util.security.AuthenticationUser;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.util.ObjectUtils;
import java.util.*;

@Slf4j
@Data
public class SearchContextBase implements ISearchContext{

    /**
     * 自定义查询条件
     */
    @JsonProperty("customcond")
	public String customCond;
	/**
     * 自定义查询参数
     */
    @JsonProperty("customparams")
	public String customParams;
	/**
	 * 快速搜索
	 */
    @JsonProperty("query")
	public String query;
    /**
     * 条件表达式
     */
    @JsonProperty("filter")
    public QueryFilter filter;
    /**
     * 数据查询
     */
    public List dataQueryList;
    /**
     * 当前页数
     */
	public int page=0;
    /**
     * 每页显示条数
     */
    public int size=20;
    /**
     * 排序
     */
    public String sort;
    /**
     * 排序对象
     */
    @JsonIgnore
    public Sort pageSort;
    /**
     * 工作流步骤标识
     */
    public String userTaskId;
    /**
     * 工作流流程标识
     */
    public String processDefinitionKey;
    /**
     * 获取分页参数
     * @return
     */
    public Pageable getPageable() {
       if(ObjectUtils.isEmpty(pageSort))
         return PageRequest.of(page,size);
      else
         return PageRequest.of(page,size,pageSort);
    }

    /**
     * 设置排序值
     * @param strSort
     */
    public void setSort(String strSort) {
        this.sort=strSort;
        if(!StringUtils.isEmpty(strSort)){
            String sortArr[]=strSort.split(",");
            String sortField=sortArr[0];
            String sortDirection=sortArr[1];
            if(sortDirection.equalsIgnoreCase("asc")){
                this.pageSort=Sort.by(Sort.Direction.ASC,sortField);
            }
            else if(sortDirection.equalsIgnoreCase("desc")){
                this.pageSort=Sort.by(Sort.Direction.DESC,sortField);
            }
        }
    }

	/**
	 * 上下文参数
	 */
	Map<String,Object> params = new HashMap<String,Object>() ;

    /**
    * 获取数据上下文
    * @return
    */
    public Map<String,Object> getDatacontext() {
    	return params;
    }

    /**
    * 获取网页请求上下文
    * @return
    */
    public Map<String,Object> getWebcontext() {
    	return params;
    }

    /**
     * 获取用户上下文
     * @return
     */
    public Map<String,Object> getSessioncontext() {
        return AuthenticationUser.getAuthenticationUser().getSessionParams();
    }

    @JsonAnyGetter
    public Map<String , Object> any() {
        return params;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        params.put(name, value);
    }

}
