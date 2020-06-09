package cn.ibizlab.ehr.util.filter;

import cn.ibizlab.ehr.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.function.Consumer;

@Slf4j
@Data
public class QueryWrapperContext<T> extends SearchContextBase implements ISearchContext{

    @JsonIgnore
    @JSONField(serialize = false)
    private QueryWrapper<T> selectCond=new QueryWrapper<T>();

    /**
     * 解析查询上下文中的参数，构建mybatis-plus分页对象
     * @return
     */
    @JsonIgnore
    @JSONField(serialize = false)
    public Page getPages(){
        Page page;
        List<String> asc_fieldList = new ArrayList<>();
        List<String> desc_fieldList = new ArrayList<>();

        int currentPage=getPageable().getPageNumber();
        int pageSize=getPageable().getPageSize();

        //构造mybatis-plus分页
        if(StringUtils.isEmpty(currentPage) || StringUtils.isEmpty(pageSize))
            page=new Page(1,Short.MAX_VALUE);
        else
            page=new Page(currentPage+1,pageSize);

        //构造mybatis-plus排序
        Sort sort = getPageable().getSort();
        Iterator<Sort.Order> it_sort = sort.iterator();

        if(ObjectUtils.isEmpty(it_sort))
            return page;

        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>)parameterizedType.getActualTypeArguments()[0];
        while (it_sort.hasNext()) {
            Sort.Order sort_order = it_sort.next();
            if(sort_order.getDirection()== Sort.Direction.ASC){
                asc_fieldList.add(DEFieldCacheMap.getFieldColumnName(type,sort_order.getProperty()));
            }
            else if(sort_order.getDirection()== Sort.Direction.DESC){
                desc_fieldList.add(DEFieldCacheMap.getFieldColumnName(type,sort_order.getProperty()));
            }
        }

        if(asc_fieldList.size()>0){
            page.setAscs(asc_fieldList);
        }
        if(desc_fieldList.size()>0){
            page.setDescs(desc_fieldList);
        }

        return page;
    }

    public QueryWrapper<T> getSearchCond(){
        return this.selectCond;
    }

    /**
     * 填充自定义查询条件
     * @return
     */
    public QueryWrapper<T> getSelectCond() {
        if(!ObjectUtils.isEmpty(filter)){
            Consumer queryWrapper = parseQueryFilter(filter);
            if(!ObjectUtils.isEmpty(queryWrapper)){
                selectCond.and(queryWrapper);
            }
        }
        return selectCond;
    }

    /**
     * 解析自定义查询条件
     * @param queryFilter
     * @return
     */
    private Consumer<QueryWrapper<T>> parseQueryFilter(QueryFilter queryFilter){

        if(queryFilter.any().size()==0  && queryFilter.get$or()==null && queryFilter.get$and()==null)
             return null;
        Consumer<QueryWrapper<T>> consumer = queryWrapper -> {
            Consumer fieldConsumer=parseFieldMap(queryFilter.any());
            Consumer orConsumer=parseOrQueryFilter(queryFilter.get$or());
            Consumer andConsumer=parseAndQueryFilter(queryFilter.get$and());
            if(!ObjectUtils.isEmpty(fieldConsumer)){
                queryWrapper.and(fieldConsumer);
            }
            if(!ObjectUtils.isEmpty(orConsumer)){
                queryWrapper.and(orConsumer);
            }
            if(!ObjectUtils.isEmpty(andConsumer)){
                queryWrapper.and(andConsumer);
            }
        };
        return consumer;
    }

    /**
     * 解析自定义条件[or]
     * @param queryFilters
     * @return
     */
    private Consumer<QueryWrapper<T>> parseOrQueryFilter(List<QueryFilter> queryFilters) {

        if(queryFilters==null || queryFilters.size()==0)
            return null;
            Consumer<QueryWrapper<T>> consumer = queryWrapper -> {
            for(QueryFilter queryFilter: queryFilters){
                Consumer tempQueryWrapper=parseQueryFilter(queryFilter);
                queryWrapper.or(tempQueryWrapper);
            }
        };
        return consumer;
    }

    /**
     * 解析自定义条件[and]
     * @param queryFilters
     * @return
     */
    private Consumer<QueryWrapper<T>> parseAndQueryFilter(List<QueryFilter> queryFilters) {

        if(queryFilters==null || queryFilters.size()==0)
            return null;
            Consumer<QueryWrapper<T>> consumer = queryWrapper -> {
            for(QueryFilter queryFilter: queryFilters){
                Consumer tempQueryWrapper=parseQueryFilter(queryFilter);
                queryWrapper.and(tempQueryWrapper);
            }
        };
        return consumer;
    }

    /**
     * 解析自定义条件[字段条件]
     * @param fieldMap
     * @return
     */
    private Consumer<QueryWrapper<T>> parseFieldMap(Map<String , QueryFilter.SegmentCond> fieldMap) {

        if(fieldMap.size()==0)
            return null;
            Consumer<QueryWrapper<T>> consumer = queryWrapper -> {
        for(Map.Entry<String, QueryFilter.SegmentCond> field: fieldMap.entrySet()){
            String fieldName=field.getKey();
            QueryFilter.SegmentCond segmentCond=field.getValue();
            Map<String , Object> segmentCondMap =  segmentCond.any();
            for(Map.Entry<String , Object> fieldCond: segmentCondMap.entrySet()){
                Object value=fieldCond.getValue();
                switch (fieldCond.getKey()){
                    case "$eq":
                        queryWrapper.eq(fieldName,value);
                        break;
                    case "$ne":
                        queryWrapper.ne(fieldName,value);
                        break;
                    case "$gt":
                        queryWrapper.gt(fieldName,value);
                        break;
                    case "$gte":
                        queryWrapper.ge(fieldName,value);
                        break;
                    case "$lt":
                        queryWrapper.lt(fieldName,value);
                        break;
                    case "$lte":
                        queryWrapper.le(fieldName,value);
                        break;
                    case "$null":
                        queryWrapper.isNull(fieldName);
                        break;
                    case "$notNull":
                        queryWrapper.isNotNull(fieldName);
                        break;
                    case "$in":
                        queryWrapper.in(fieldName,(Collection)value);
                        break;
                    case "$notIn":
                        queryWrapper.notIn(fieldName,(Collection)value);
                        break;
                    case "$like":
                        queryWrapper.like(fieldName,value);
                        break;
                    case "$startsWith":
                        queryWrapper.likeRight(fieldName,value);
                        break;
                    case "$endsWith":
                        queryWrapper.likeLeft(fieldName,value);
                        break;
                    case "$exists":
                        break;
                    case "$notExists":
                        break;
                }
            }
        }
      };
        return consumer;
    }
}
