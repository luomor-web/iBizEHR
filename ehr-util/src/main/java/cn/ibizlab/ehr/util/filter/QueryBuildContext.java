package cn.ibizlab.ehr.util.filter;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.QueryBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class QueryBuildContext extends SearchContextBase implements ISearchContext{

    @JsonIgnore
    @JSONField(serialize = false)
    private QueryBuilder selectCond=new QueryBuilder();

}
