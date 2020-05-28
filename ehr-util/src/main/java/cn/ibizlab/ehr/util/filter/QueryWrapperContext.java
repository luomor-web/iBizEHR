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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
