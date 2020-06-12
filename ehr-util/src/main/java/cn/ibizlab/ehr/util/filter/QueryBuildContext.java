package cn.ibizlab.ehr.util.filter;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.QueryBuilder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
@Data
public class QueryBuildContext extends SearchContextBase implements ISearchContext{

    @JsonIgnore
    @JSONField(serialize = false)
    private QueryBuilder selectCond=new QueryBuilder();


    public QueryBuilder getSearchCond(){
        return this.selectCond;
    }

    /**
     * 填充自定义查询条件
     * @return
     */
    public QueryBuilder getSelectCond() {
        if(!ObjectUtils.isEmpty(filter)){
            QueryBuilder queryBuilder=parseQueryFilter(filter);
            if(!ObjectUtils.isEmpty(queryBuilder)){
                selectCond.and(queryBuilder.get());
            }
        }
        return selectCond;
    }

    /**
     * 解析自定义查询条件
     * @param queryFilter
     * @return
     */
    private QueryBuilder parseQueryFilter(QueryFilter queryFilter){

        if( ObjectUtils.isEmpty(queryFilter.get$and())  &&   ObjectUtils.isEmpty(queryFilter.get$or()) &&  ObjectUtils.isEmpty(queryFilter.any()))
            return null;

        QueryBuilder rsBuilder=QueryBuilder.start();
        QueryBuilder fieldBuilder=parseFieldMap(queryFilter.any());
        QueryBuilder orBuilder=parseOrQueryFilter(queryFilter.get$or());
        QueryBuilder andBuilder=parseAndQueryFilter(queryFilter.get$and());
        if(!ObjectUtils.isEmpty(fieldBuilder)){
            rsBuilder.and(fieldBuilder.get());
        }
        if(!ObjectUtils.isEmpty(orBuilder)){
            rsBuilder.and(orBuilder.get());
        }
        if(!ObjectUtils.isEmpty(andBuilder)){
            rsBuilder.and(andBuilder.get());
        }
        return rsBuilder;
    }

    /**
     * 解析自定义条件[or]
     * @param queryFilters
     * @return
     */
    private QueryBuilder parseOrQueryFilter(List<QueryFilter> queryFilters) {
        QueryBuilder orBuilder =new QueryBuilder();
        if(queryFilters==null || queryFilters.size()==0){
            return null;
        }
        for(QueryFilter queryFilter: queryFilters){
            QueryBuilder queryBuilder=parseQueryFilter(queryFilter);
            if(!ObjectUtils.isEmpty(queryBuilder)){
                orBuilder.or(queryBuilder.get());
            }
        }
        return orBuilder;
    }

    /**
     * 解析自定义条件[and]
     * @param queryFilters
     * @return
     */
    private QueryBuilder parseAndQueryFilter(List<QueryFilter> queryFilters) {
        QueryBuilder orBuilder =new QueryBuilder();
        if(queryFilters==null || queryFilters.size()==0){
            return null;
        }
        for(QueryFilter queryFilter: queryFilters){
            QueryBuilder queryBuilder=parseQueryFilter(queryFilter);
            if(!ObjectUtils.isEmpty(queryBuilder)){
                orBuilder.and(queryBuilder.get());
            }
        }
        return orBuilder;
    }

    /**
     * 解析自定义条件[字段条件]
     * @param fieldMap
     * @return
     */
    private QueryBuilder parseFieldMap(Map<String , QueryFilter.SegmentCond> fieldMap) {
        if(fieldMap.size()==0)
            return null;
        QueryBuilder fieldBuilders=QueryBuilder.start();
        for(Map.Entry<String, QueryFilter.SegmentCond> entry: fieldMap.entrySet()){
            getSegmentCondSql(entry.getKey(),entry.getValue(),fieldBuilders);
        }
        return fieldBuilders;
    }

    /**
     * 解析自定义条件[字段条件]
     * @param fieldName
     * @param segmentCond
     * @param fieldBuilder
     */
    private void getSegmentCondSql(String fieldName, QueryFilter.SegmentCond segmentCond,QueryBuilder fieldBuilder) {

        Map<String , Object> segmentCondMap =  segmentCond.any();
        for(Map.Entry<String , Object> entry: segmentCondMap.entrySet()){
            Object value=entry.getValue();
            switch (entry.getKey()){
                case "$eq":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).is(value).get());
                    break;
                case "$ne":
                    fieldBuilder.and(QueryBuilder.start().not().and(fieldName).is(value).get());
                    break;
                case "$gt":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).greaterThan(value).get());
                    break;
                case "$gte":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).greaterThanEquals(value).get());
                    break;
                case "$lt":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).lessThan(value).get());
                    break;
                case "$lte":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).lessThanEquals(value).get());
                    break;
                case "$null":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).exists(null).get());
                    break;
                case "$notNull":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).exists(true).and(fieldName).notEquals("").and(fieldName).notEquals(null).get());
                    break;
                case "$in":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).in(value).get());
                    break;
                case "$notIn":
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).not().in(value).get());
                    break;
                case "$like":
                    Pattern likePattern = Pattern.compile("^.*" + value + ".*$", Pattern.CASE_INSENSITIVE);
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).regex(likePattern).get());
                    break;
                case "$startsWith":
                    Pattern startsWithPattern = Pattern.compile(value + ".*$", Pattern.CASE_INSENSITIVE);
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).regex(startsWithPattern).get());
                    break;
                case "$endsWith":
                    Pattern endsWithPattern = Pattern.compile("^.*" + value + "$", Pattern.CASE_INSENSITIVE);
                    fieldBuilder.and(QueryBuilder.start().and(fieldName).regex(endsWithPattern).get());
                    break;
                case "$exists":
                    break;
                case "$notExists":
                    break;
            }
        }
    }
}
